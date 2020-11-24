import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

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
