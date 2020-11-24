import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.io.*;

public class ProfileServer implements Runnable {
    Socket socket;
    public static ArrayList<User> userArrayList;
    public static ArrayList<Profile> profileArrayList;

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

    synchronized boolean register(String username, String password, String name, String email) {
        if (userArrayList.isEmpty()) {
            return true;
        }
        for (User user : userArrayList) {
            if (user.getUserId().equals(username)) {
                return false;
            }
        }
        return true;
    }

    synchronized boolean setUserProfile(Profile profile, String userId) {
        return false;
    }

    synchronized Profile viewProfile(String userId) {
        return null;
    }

    synchronized boolean addFriend(String userId) {
        return false;
    }

    synchronized boolean checkFriendRequest() {
        return false;
    }

    synchronized boolean uniquePhoneNoCheck(String phoneNumber) {
        if (profileArrayList.isEmpty()) {
            return true;
        }
        boolean unique = false;
        for (Profile profile : profileArrayList) {
            if (profile.getPhoneNumber().equals(phoneNumber)) {
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
                    case "CreateProfile" -> {
                        String newProfile = bufferedReader.readLine();
                        String[] splitNewProfile = newProfile.split(", ");
                        profileArrayList.add(new Profile(splitNewProfile[0], splitNewProfile[1],
                                splitNewProfile[2], splitNewProfile[3], splitNewProfile[4], splitNewProfile[5]));
                        printWriter.println("Success");
                        printWriter.flush();
                    }
                    case "ShowOwnInfo" -> {

                    }
                    case "AddFriend" -> {

                    }
                    case "DeleteFriend" -> {

                    }
                    case "ShowFriendList" -> {

                    }
                    case "EditOwnAccount" -> {

                    }
                    case "DeleteOwnAccount" -> {

                    }
                    case "ShowAllUser" -> {

                    }
                    case "ViewOwnProfile" -> {

                    }
                    case "EditOwnProfile" -> {

                    }
                    case "ViewOtherProfile" -> {

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
                }
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
}
