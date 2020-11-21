import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class profileClient {
	private static Socket socket;



	public static void main(String[] args) {
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
