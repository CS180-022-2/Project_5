import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
/**
 * Project 05 - Social Network "Profile" Application
 * <p>
 * A class representing the client-side of our application.
 * <p>
 * This class includes the main method and invokes the Login frame of our application when begin.
 * The process should be loginFrame -> (<-Register) userFrame -> accountProfileFrame OR addFriendFrame
 * A socket is created and pass as parameters in all other frames to maintain connection with the server
 *
 * @author Group 022-2
 * @version November 30, 2020
 */

public class ProfileClient {

    /**
     * The main method of our program.
     * Initializes the hostname with "localhost" and port number with 1112.
     * Starts by invoking a LoginFrame in the Event Dispatch Thread.
     */
    public static void main(String[] args) {
        Socket socket;
        try {
            socket = new Socket("localhost", 1112);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Unable to connect to the server", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Invoke LoginFrame in the Event Dispatch Thread
        SwingUtilities.invokeLater(new LoginFrame(socket));
    }
}
