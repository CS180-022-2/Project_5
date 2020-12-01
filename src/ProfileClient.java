import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
/**
 * Project 05 - Social Network "Profile" Application
 *
 * A class representing the client-side of our application.
 *
 * This class includes the main method and invokes the Login frame of our application when begin.
 *
 * @author Group 022-2
 * @version November 30, 2020
 */

public class ProfileClient {
    public static void main(String[] args) {
        Socket socket;
        try {
            socket = new Socket("localhost", 1112);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Unable to connect to the server", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        SwingUtilities.invokeLater(new LoginFrame(socket));
    }
}
