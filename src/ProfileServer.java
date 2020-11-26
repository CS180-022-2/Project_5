
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.io.*;

public class ProfileServer implements Runnable {
    Socket socket;
    public static ArrayList<User> userArrayList;

    public ProfileServer(Socket socket) {
        this.socket = socket;
    }

    public static void main(String[] args) {
        userArrayList = new ArrayList<>();
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
        for (int i = 0; i < userArrayList.size(); i++) {
            if (userArrayList.get(i).getUserId().equals(userId)) {
                profile = userArrayList.get(i).getUserProfile();
            }
        }
        return  profile;
    }

    synchronized boolean setUserProfile(Profile userProfile, String userId) {
        boolean success = false;
        for (int i = 0; i < userArrayList.size(); i++) {
            if (userArrayList.get(i).getUserId().equals(userId)) {
                userArrayList.get(i).setUserProfile(userProfile);
                success = true;
            }
        }
        return success;
    }

    synchronized boolean addFriend(String userId) {
        return false;
    }

    synchronized boolean checkFriendRequest() {
        return false;
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
                        break;
                    }
                    case "Register" -> {
                        //The User would send the user account info in a string
                        String newUser  = bufferedReader.readLine();
                        String[] splitNewUser = newUser.split(", ");
                        userArrayList.add(new User(splitNewUser[0], splitNewUser[1],
                                splitNewUser[2], splitNewUser[3]));
                        printWriter.println("Success");
                        printWriter.flush();
                        break;
                    }
                    case "ShowOwnInfo" -> {
                        break;
                    }
                    case "AddFriend" -> {
                        break;
                    }
                    case "DeleteFriend" -> {
                        break;
                    }
                    case "ShowFriendList" -> {
                        break;
                    }
                    case "EditOwnAccount" -> {
                        break;
                    }
                    case "DeleteOwnAccount" -> {
                        break;
                    }
                    case "ShowAllUser" -> {
                        break;
                    }
                    case "ViewOwnProfile" -> {
                        break;
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
                        break;
                    }
                    case "ViewOtherProfile" -> {
                        break;

                    }
                    case "DeleteOwnProfile" -> {
                        String userId = bufferedReader.readLine();
                        boolean success = setUserProfile(
                                new Profile("", "", "", "","",
                                        ""), userId);
                        if (success) {
                            printWriter.println("Success");
                        } else {
                            printWriter.println("Failure");
                        }
                        printWriter.flush();
                        break;
                    }
                    case "ShowFriendRequestList" -> {

                    }
                    case "ShowPendingList" -> {

                    }
                    case "ResendFriendRequest" -> {

                    }
                    case "AcceptFriendRequest" -> {

                    }
                    case "DenyFriendRequest" -> {

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
                        break;
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
                        break;
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
                        break;
                    }
                }
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
}