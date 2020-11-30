import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.io.*;

public class ProfileServer implements Runnable {
    Socket socket;
     public static  ArrayList<User> userArrayList;
     public static File f;

    public ProfileServer(Socket socket) {
        this.socket = socket;
    }

    public static void main(String[] args) {
        userArrayList = new ArrayList<>();
        f = new File("MainData.dat");
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(f))) {
                Object readObject = objectInputStream.readObject();
                while (readObject != null) {
                    userArrayList.add((User) readObject);
                    readObject = objectInputStream.readObject();
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        try {
            ServerSocket serverSocket = new ServerSocket(1112);
            while (true) {
                Socket socket = serverSocket.accept();
                ProfileServer server = new ProfileServer(socket);
                new Thread(server).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    synchronized boolean dualLoginCheck(String userId) {
        return true;
    }

    synchronized boolean login(String username, String password) {
        boolean hasAccount = false;
        if (userArrayList.isEmpty()) {
            return false;
        } else {
            for (User user : userArrayList) {
                if (user.getUserId().equals(username)
                        && user.getPassword().equals(password)) {
                    hasAccount = true;
                    break;
                }
            }
            return hasAccount;
        }
    }

    synchronized Profile getProfile(String userId) {
        Profile profile = null;
        for (User user : userArrayList) {
            if (user.getUserId().equals(userId)) {
                profile = user.getUserProfile();
            }
        }
        return profile;
    }

    synchronized boolean setUserProfile(Profile userProfile, String userId) {
        boolean success = false;
        for (User user : userArrayList) {
            if (user.getUserId().equals(userId)) {
                user.setUserProfile(userProfile);
                success = true;
            }
        }
        return success;
    }

    synchronized String requestFriend(String ownId, String friendId) {
        User own = null;
        User friend = null;
        for (User user:userArrayList) {
            if (user.getUserId().equals(ownId)) {
                own = user;
            } else if (user.getUserId().equals(friendId)) {
                friend = user;
            }
            if (own != null && friend != null) {
                break;
            }
        }
        if (own != null && friend != null) {
            if (own.getFriendList().contains(friend) && friend.getFriendList().contains(own)) {
                return "Already friend!";
            } else if (own.getRequestList().contains(friend) && friend.getPendingList().contains(own)) {
                return "Already requested!";
            } else if (own.getPendingList().contains(friend) && friend.getRequestList().contains(own)) {
                return "Already being requested!";
            } else {
                own.getRequestList().add(friend);
                friend.getPendingList().add(own);
                return "RequestSuccess";
            }
        } else {
            return "UserNotFound";
        }
    }

    synchronized boolean deleteFriend(String ownId, String friendId) {
        User ownUser = null;
        User friendUser = null;
        for (User user:userArrayList) {
            if (user.getUserId().equals(ownId)) {
                ownUser = user;
            }
            if (user.getUserId().equals(friendId)) {
                friendUser = user;
            }
            if (ownUser != null && friendUser != null ) {
                break;
            }
        }
        if (ownUser == null || friendUser == null) {
            return false;
        }
        boolean existInOwn = ownUser.getFriendList().removeIf(user -> user.getUserId().equals(friendId));
        boolean existInFriend = friendUser.getFriendList().removeIf(user -> user.getUserId().equals(ownId));
        return (existInOwn && existInFriend);
    }

    synchronized boolean uniquePhoneNoCheck(String phoneNumber) {
        if (userArrayList.isEmpty()) {
            return true;
        }
        boolean unique = true;
        for (User user : userArrayList) {
            if (user.getUserProfile().getPhoneNumber().equals(phoneNumber)) {
                unique = false;
                break;
            }
        }
        return unique;
    }

    synchronized boolean uniqueIdCheck(String userId) {
        if (userArrayList.isEmpty()) {
            return true;
        }
        boolean unique = true;
        for (User user : userArrayList) {
            if (user.getUserId().equals(userId)) {
                unique = false;
                break;
            }
        }
        return unique;
    }
    synchronized String acceptFriend(String ownId, String friendId) {
        User own = null;
        User friend = null;
        for (User user:userArrayList) {
            if (user.getUserId().equals(ownId)) {
                own = user;
            } else if (user.getUserId().equals(friendId)) {
                friend = user;
            }
            if (own != null && friend != null) {
                break;
            }
        }
        if (own != null && friend != null) {
            if (own.getPendingList().contains(friend) && friend.getRequestList().contains(own)) {
                own.getFriendList().add(friend);
                friend.getFriendList().add(own);
                own.getPendingList().remove(friend);
                friend.getRequestList().remove(own);
                return "AcceptSuccess";
            } else {
                return "No request found.";
            }
        } else {
            return "No such user found.";
        }
    }
    synchronized String denyFriend(String ownId, String friendId) {
        User own = null;
        User friend = null;
        for (User user:userArrayList) {
            if (user.getUserId().equals(ownId)) {
                own = user;
            } else if (user.getUserId().equals(friendId)) {
                friend = user;
            }
            if (own != null && friend != null) {
                break;
            }
        }
        if (own != null && friend != null) {
            if (own.getPendingList().contains(friend) && friend.getRequestList().contains(own)) {
                own.getPendingList().remove(friend);
                friend.getRequestList().remove(own);
                return "DenySuccess";
            } else {
                return "No request found";
            }
        } else {
            return "No such user found.";
        }
    }
    synchronized String resendRequest(String ownId, String friendId) {
        User own = null;
        User friend = null;
        for (User user:userArrayList) {
            if (user.getUserId().equals(ownId)) {
                own = user;
            } else if (user.getUserId().equals(friendId)) {
                friend = user;
            }
            if (own != null && friend != null) {
                break;
            }
        }
        if (own != null && friend != null) {
            if (friend.getPendingList().contains(own) && own.getRequestList().contains(friend)) {
                return "RequestExisted";
            } else {
                if (friend.getPendingList().contains(own)) {
                    own.getRequestList().add(friend);
                } else if (own.getRequestList().contains(friend)){
                    friend.getPendingList().add(own);
                }
                return "ResendSuccess";
            }
        } else {
            return "No such user found.";
        }
    }

    @Override
    public void run() {
        try {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                String command = bufferedReader.readLine();
                if (command == null) {
                    printWriter.close();
                    bufferedReader.close();
                    socket.close();
                    return;
                }
                switch (command) {
                    case "Login" -> {
                        String loginUser  = bufferedReader.readLine();
                        String password = bufferedReader.readLine();
                        boolean hasAccount = login(loginUser, password);
                        /*
                            DualLoginCheck can prevent the login of several accounts.
                            Not implemented yet, wait until the whole project is finished.
                         */
                        if (hasAccount && dualLoginCheck(loginUser)) {
                            printWriter.println("Success");
                        } else if (hasAccount) {
                            printWriter.println("DualLogin");
                        }else {
                            printWriter.println("Invalid");
                        }
                        printWriter.flush();
                    }
                    case "Register" -> {
                        //The User would send the user account info in a string
                        String newUser  = bufferedReader.readLine();
                        String[] splitNewUser = newUser.split(", ");
                        userArrayList.add(new User(splitNewUser[0], splitNewUser[1],
                                splitNewUser[2], splitNewUser[3]));
                        printWriter.println("Success");
                        printWriter.flush();
                    }
                    case "AcceptFriend" -> {
                        String ownId = bufferedReader.readLine();
                        String friendId = bufferedReader.readLine();
                        String result = acceptFriend(ownId, friendId);
                        printWriter.println(result);
                        printWriter.flush();
                    }
                    case "DenyFriend" -> {
                        String ownId = bufferedReader.readLine();
                        String friendId = bufferedReader.readLine();
                        String result = denyFriend(ownId, friendId);
                        printWriter.println(result);
                        printWriter.flush();
                    }
                    case "RequestFriend" -> {
                        String ownId = bufferedReader.readLine();
                        String friendId = bufferedReader.readLine();
                        String result = requestFriend(ownId, friendId);
                        printWriter.println(result);
                        printWriter.flush();
                    }
                    case "ResendRequest" -> {
                        String ownId = bufferedReader.readLine();
                        String friendId = bufferedReader.readLine();
                        String result = resendRequest(ownId, friendId);
                        printWriter.println(result);
                        printWriter.flush();
                    }
                    case "DeleteFriend" -> {
                        String ownId = bufferedReader.readLine();
                        String friendId = bufferedReader.readLine();
                        boolean success = deleteFriend(ownId, friendId);
                        if (success) {
                            printWriter.println("Success");
                        } else {
                            printWriter.println("Failure");
                        }
                        printWriter.flush();
                    }
                    case "GetFriendList" -> {
                       String userId = bufferedReader.readLine();
                       ArrayList<User> currentFriendList = null;
                       boolean found = false;
                       for (User user : userArrayList) {
                           if (user.getUserId().equals(userId)) {
                               currentFriendList = user.getFriendList();
                               found = true;
                               break;
                           }
                       }
                       if (found) {
                           if (!currentFriendList.isEmpty()) {
                               printWriter.println(currentFriendList.size());
                               for (User user : currentFriendList) {
                                   printWriter.println(user.getName());
                                   printWriter.println(user.getUserId());
                                   printWriter.println(user.getUserProfile().getAboutMe());
                               }
                           } else {
                               printWriter.println("Empty");
                           }
                       } else {
                           printWriter.println("NotFound");
                       }
                       printWriter.flush();
                    }
                    case "EditOwnAccount" -> {
                        String userEdit  = bufferedReader.readLine();
                        String[] splitUserEdit = userEdit.split(", ");
                        userArrayList.removeIf(user -> user.getUserId().equals(splitUserEdit[0]));
                        userArrayList.add(new User(splitUserEdit[0], splitUserEdit[1],
                                splitUserEdit[2], splitUserEdit[3]));
                        printWriter.println("Success");
                        printWriter.flush();
                    }
                    case "DeleteOwnAccount" -> {
                        boolean flag = false;
                        String userId = bufferedReader.readLine();
                        for (User user : userArrayList) {
                            if (user.getUserId().equals(userId)) {
                                flag = true;
                                userArrayList.remove(user);
                                break;
                            }
                        }
                        if (!flag) {
                            printWriter.println("Failure");
                        } else {
                            printWriter.println("Success");
                        }
                        printWriter.flush();
                    }
                    case "GetUserList" -> {
                        String userId = bufferedReader.readLine();
                        if (userArrayList.size() > 1) {
                            printWriter.println(userArrayList.size() - 1);
                            for (User user: userArrayList) {
                                if (!user.getUserId().equals(userId)) {
                                    printWriter.println(user.getName());
                                    printWriter.println(user.getUserId());
                                    printWriter.println(user.getUserProfile().getAboutMe());
                                }
                            }
                        } else {
                            printWriter.println("Empty");
                        }
                        printWriter.flush();
                    }
                    case "GetPendingList" -> {
                        String userId = bufferedReader.readLine();
                        boolean found = false;
                        User ownUser = null;
                        for (User user:userArrayList) {
                            if (user.getUserId().equals(userId)) {
                                ownUser = user;
                                found = true;
                                break;
                            }
                        }
                        if (found) {
                            if (!ownUser.getPendingList().isEmpty()) {
                                printWriter.println(ownUser.getPendingList().size());
                                for (User user: ownUser.getPendingList()) {
                                    printWriter.println(user.getName());
                                    printWriter.println(user.getUserId());
                                    printWriter.println(user.getUserProfile().getAboutMe());
                                }
                            } else {
                                printWriter.println("Empty");
                            }
                        } else {
                            printWriter.println("NotFound");
                        }
                        printWriter.flush();
                    }
                    case "GetRequestList" -> {
                        String userId = bufferedReader.readLine();
                        boolean found = false;
                        User ownUser = null;
                        for (User user:userArrayList) {
                            if (user.getUserId().equals(userId)) {
                                ownUser = user;
                                found = true;
                                break;
                            }
                        }
                        if (found) {
                            if (!ownUser.getRequestList().isEmpty()) {
                                printWriter.println(ownUser.getRequestList().size());
                                for (User user: ownUser.getRequestList()) {
                                    printWriter.println(user.getName());
                                    printWriter.println(user.getUserId());
                                    printWriter.println(user.getUserProfile().getAboutMe());
                                }
                            } else {
                                printWriter.println("Empty");
                            }
                        } else {
                            printWriter.println("NotFound");
                        }
                        printWriter.flush();
                    }
                    case "EditOwnProfile" -> {
                        String userId = bufferedReader.readLine();
                        String[] splitProfile = bufferedReader.readLine().split(", ");
                        Profile userProfile = new Profile(splitProfile[0], splitProfile[1], splitProfile[2],
                                splitProfile[3], splitProfile[4], splitProfile[5]);
                        boolean success = setUserProfile(userProfile,userId);
                        if (success) {
                            printWriter.println("Success");
                        } else {
                            printWriter.println("Failure");
                        }
                        printWriter.flush();
                    }
                    case "DeleteOwnProfile" -> {
                        String userId = bufferedReader.readLine();
                        if (getProfile(userId).getPhoneNumber().equals("") && getProfile(userId).getAboutMe().equals("")
                        && getProfile(userId).getCurrentOccupation().equals("") && getProfile(userId).getInterest().equals("")) {
                            printWriter.println("No Profile");
                            printWriter.flush();
                            break;
                        }
                        boolean success = setUserProfile(
                                new Profile("", "", "", "","",
                                        ""), userId);
                        if (success) {
                            printWriter.println("Success");
                        } else {
                            printWriter.println("Failure");
                        }
                        printWriter.flush();
                    }
                    case "UniquePhoneNoCheck" -> {
                        String phoneNo = bufferedReader.readLine();
                        boolean unique = uniquePhoneNoCheck(phoneNo);
                        if (unique) {
                            printWriter.println("Unique");
                        } else {
                            printWriter.println("Exists");
                        }
                        printWriter.flush();
                    }
                    case "UniqueIdCheck" -> {
                        String userId = bufferedReader.readLine();
                        boolean unique = uniqueIdCheck(userId);
                        if (unique) {
                            printWriter.println("Unique");
                        } else {
                            printWriter.println("Exists");
                        }
                        printWriter.flush();
                    }
                    case "GetProfileContent" -> {
                        String userId = bufferedReader.readLine();
                        Profile profile = getProfile(userId);
                        printWriter.println(profile.getPhoneNumber());
                        printWriter.println(profile.getCurrentOccupation());
                        printWriter.println(profile.getGender());
                        printWriter.println(profile.getAboutMe());
                        printWriter.println(profile.getInterest());
                        printWriter.println(profile.getRelationship());
                        printWriter.flush();
                    }
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(f))) {
                for (User user : userArrayList) {
                    objectOutputStream.writeObject(user);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}