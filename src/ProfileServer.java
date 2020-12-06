import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.io.*;
/**
 * Project 05 - Social Network "Profile" Application
 * <p>
 * A class representing the backend server-side of our application.
 * <p>
 * All the processing of data, connecting to the client, and including the file I/O happens here.
 *
 * @author Group 022-2
 * @version November 30, 2020
 */

public class ProfileServer implements Runnable {
    Socket socket;
    public static ArrayList<User> userArrayList;
    public static File f;

    /**
     * The constructor of ProfileServer which uses one parameter : socket
     *
     * @param socket The socket that connect this computer connect with the server
     */
    public ProfileServer(Socket socket) {
        this.socket = socket;
    }

    public static void main(String[] args) {
        //Initialize an arraylist to store all user data.
        userArrayList = new ArrayList<>();
        f = new File("MainData.dat");
        /*
         * If there is no such date file, a file would be created
         * else, would lead user objectInputStream to read user object inside the file.
         */
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
                /* Catch EOF exception which indicates that the objectInputStream has reached an end.
                 * This is for special case when there is no object inside the data file but the file is created.
                 */
            } catch (EOFException eofException) {

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        try {
            ServerSocket serverSocket = new ServerSocket(1112);
            /*
             * Use a while loop to accept all socket receives with multithreading
             * A thread would be start whenever the a socket is accepted
             * The socket would be pass to a thread to interacting with the client.
             */
            while (true) {
                Socket socket = serverSocket.accept();
                ProfileServer server = new ProfileServer(socket);
                new Thread(server).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * login method
     * Check the username and password to see if the user logs in.
     *
     * @param username the username of the login user
     * @param password the password of the login user
     * @return true if the username and password are correct
     *         false if otherwise
     */
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

    /**
     * getProfile method
     * Gets the Profile that matches with the given userId parameter
     *
     * @param userId the user ID to search for
     * @return Profile if found, null if not found
     */
    synchronized Profile getProfile(String userId) {
        Profile profile = null;
        for (User user : userArrayList) {
            if (user.getUserId().equals(userId)) {
                profile = user.getUserProfile();
            }
        }
        return profile;
    }

    /**
     * setUserProfile method
     * Sets the userProfile up with the inserted userId
     *
     * @param userProfile the profile to set up
     * @param userId the Id to connect the profile to 
     * @return true if success, false if userId is not found
     */
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

    /**
     * requestFriend method
     * Sends out a friend request to the receiver using userId as a guide
     *
     * @param ownId id of the requester
     * @param friendId id of the user that the requester want to request
     * @return "RequestSuccess" if the success;
     *         "Already friend!" if in each other 's friendList;
     *         "Already requested!" if requested user in requester 's requested list;
     *         "Already being requested!" if the requested user has already sent a request to requester;
     */
    synchronized String requestFriend(String ownId, String friendId) {
        User own = null;
        User friend = null;
        for (User user : userArrayList) {
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

    /**
     * deleteFriend method
     * Delete the friend in user's friendList and vice versa for the friend who got deleted.
     *
     * @param ownId the id of the deleter
     * @param friendId the id of the friend that deleter want to delete
     * @return True if the deletion is success; False if no existence
     */
    synchronized boolean deleteFriend(String ownId, String friendId) {
        User ownUser = null;
        User friendUser = null;
        for (User user : userArrayList) {
            if (user.getUserId().equals(ownId)) {
                ownUser = user;
            }
            if (user.getUserId().equals(friendId)) {
                friendUser = user;
            }
            if (ownUser != null && friendUser != null) {
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

    /**
     * uniquePhoneNoCheck method
     * Check to make sure every phone number registered is unique.
     *
     * @param phoneNumber  Phone Number of the user
     * @return True if the phone number is unique; False if it has been used.
     */
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

    /**
     * uniqueIdCheck method
     * checks if the given parameter userId is unique in the database
     *
     * @param userId the userId to check
     * @return true if userId is unique, false otherwise
     */
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

    /**
     * acceptFriend method
     * accept the request in pending list
     * add to each other's friendList
     * delete history in pending and requested list
     *
     * @param ownId the id of the user who accept the request
     * @param friendId the id of the user who sent the request
     * @return "AcceptSuccess" if there is an request and are accepted successfully
     *         "No request found" if there are no request
     *         "No such user found" if can not find the user of either ownId or friendId
     */
    synchronized String acceptFriend(String ownId, String friendId) {
        User own = null;
        User friend = null;
        for (User user : userArrayList) {
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

    /**
     * denyFriend method
     * deny the request in pending list
     * delete history in pending and requested list
     *
     * @param ownId the id of the user who deny the request
     * @param friendId the id of the user who sent the request
     * @return "DenySuccess" if there is an request and deny successfully
     *         "No request found" if there are no request
     *         "No such user found" if can not find the user of either ownId or friendId
     */
    synchronized String denyFriend(String ownId, String friendId) {
        User own = null;
        User friend = null;
        for (User user : userArrayList) {
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

    /**
     * resendRequest method
     * check if the request has been sent
     * if not resend request, if sent, ask the user to be more patient
     *
     * @param ownId the login user
     * @param friendId the user who have been requested
     * @return "RequestExisted" if the request is in the user's pending list
     *         "ResendSuccess" if there is no request and the request is resend
     *         "No such user found" if can not find user of either ownId or friendId
     */
    synchronized String resendRequest(String ownId, String friendId) {
        User own = null;
        User friend = null;
        for (User user : userArrayList) {
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
                } else if (own.getRequestList().contains(friend)) {
                    friend.getPendingList().add(own);
                }
                return "ResendSuccess";
            }
        } else {
            return "No such user found.";
        }
    }

    /**
     * run method
     * Start whenever a new socket is accepted
     * create a printWriter and a bufferedReader
     * Use a switch to perform different tasks required by the clients
     */
    @Override
    public void run() {
        try {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                String command = bufferedReader.readLine();
                //To stop this thread when the user close the software.
                if (command == null) {
                    printWriter.close();
                    bufferedReader.close();
                    socket.close();
                    // Save the data into the data file if userArrayList is not empty
                    if (!userArrayList.isEmpty()) {
                        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(f))) {
                            for (User user : userArrayList) {
                                objectOutputStream.writeObject(user);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    return;
                }
                switch (command) {
                    case "Login" -> {
                        String loginUser = bufferedReader.readLine();
                        String password = bufferedReader.readLine();
                        boolean hasAccount = login(loginUser, password);
                        if (hasAccount) {
                            printWriter.println("Success");
                        } else if (hasAccount) {
                            printWriter.println("DualLogin");
                        } else {
                            printWriter.println("Invalid");
                        }
                        printWriter.flush();
                    }
                    case "Register" -> {
                        //The User would send the user account info in a string
                        String newUser = bufferedReader.readLine();
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
                        String userEdit = bufferedReader.readLine();
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
                        User deletedUser = null;
                        for (User user : userArrayList) {
                            if (user.getUserId().equals(userId)) {
                                flag = true;
                                deletedUser = user;
                                userArrayList.remove(user);
                                break;
                            }
                        }
                        if (!flag) {
                            printWriter.println("Failure");
                        } else {
                            for (User user : userArrayList) {
                                user.getRequestList().remove(deletedUser);
                                user.getPendingList().remove(deletedUser);
                                user.getFriendList().remove(deletedUser);
                            }
                            printWriter.println("Success");
                        }
                        printWriter.flush();
                    }
                    case "GetUserList" -> {
                        String userId = bufferedReader.readLine();
                        if (userArrayList.size() > 1) {
                            printWriter.println(userArrayList.size() - 1);
                            for (User user : userArrayList) {
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
                        for (User user : userArrayList) {
                            if (user.getUserId().equals(userId)) {
                                ownUser = user;
                                found = true;
                                break;
                            }
                        }
                        if (found) {
                            if (!ownUser.getPendingList().isEmpty()) {
                                printWriter.println(ownUser.getPendingList().size());
                                for (User user : ownUser.getPendingList()) {
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
                        for (User user : userArrayList) {
                            if (user.getUserId().equals(userId)) {
                                ownUser = user;
                                found = true;
                                break;
                            }
                        }
                        if (found) {
                            if (!ownUser.getRequestList().isEmpty()) {
                                printWriter.println(ownUser.getRequestList().size());
                                for (User user : ownUser.getRequestList()) {
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
                        boolean success = setUserProfile(userProfile, userId);
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
                                new Profile("", "", "", "", "",
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
        }
    }
}
