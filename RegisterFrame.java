import java.net.Socket;
import javax.swing.JComponent;

public class RegisterFrame extends JComponent implements Runnable{
	Socket socket;

	public RegisterFrame(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {

	}
}
