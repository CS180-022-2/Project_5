import javax.swing.*;
import java.net.Socket;

public class AddFriendFrame extends JComponent implements Runnable {
    Socket socket;
    String userId;

    public AddFriendFrame(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    @Override
    public void run() {


    }
}
