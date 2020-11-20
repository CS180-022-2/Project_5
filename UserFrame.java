import java.net.Socket;
import javax.swing.JComponent;

public class UserFrame extends JComponent implements Runnable {
	Socket socket;

	public UserFrame(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {

	}
}
