import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

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

    synchronized boolean dualLoginCheck(String username) {
        return false;
    }

    synchronized boolean login(String username, String password) {
        return false;
    }

    synchronized boolean register(String username, String password, String name, String email) {
        return false;
    }

    synchronized boolean setUserProfile(Profile profile, String userName) {
        return false;
    }

    synchronized Profile viewProfile(String username) {
        return null;
    }

    synchronized boolean addFriend(String username) {
        return false;
    }

    synchronized boolean checkFriendRequest() {
        return false;
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
                    case "Login" : {
                        break;
                    }
                    case "Register" : {
                        break;
                    }
                    case "ShowOwnInfo" : {
                        break;
                    }
                    case "AddFriend" : {
                        break;
                    }
                    case "DeleteFriend" : {
                        break;
                    }
                    case "ShowFriendList" : {
                        break;
                    }
                    case "EditOwnAccount" : {
                        break;
                    }
                    case "DeleteOwnAccount" : {
                        break;
                    }
                    case "ShowAllUser" : {
                        break;
                    }
                    case "ViewOwnProfile" : {
                        break;
                    }
                    case "EditOwnProfile" : {
                        break;
                    }
                    case "ViewOtherProfile" : {
                        break;
                    }
                    case "ShowFriendRequestList" : {
                        break;
                    }
                    case "ShowPendingList" : {
                        break;
                    }
                    case "ResendFriendRequest" : {
                        break;
                    }
                    case "AcceptFriendRequest" : {
                        break;
                    }
                    case "DenyFriendRequest" : {
                        break;
                    }
                }
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
}
