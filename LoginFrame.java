import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JComponent implements Runnable {
	ArrayList<User> userList;
	JFrame loginFrame;
	JLabel userIdLabel;
	JTextField userIdField;
	JLabel passwordLabel;
	JPasswordField passwordField;
	JButton loginButton;
	JButton registerButton;

	ActionListener actionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == loginButton ) {
				String userName = userIdField.getText();
				char[] password = passwordField.getPassword();

			}
			if (e.getSource() == registerButton) {
				loginFrame.dispose();

			}
		}
	};

	@Override
	public void run() {
		try {
			Socket socket = new Socket("localhost", 4242);
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
				"Unable to connect to the server", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		loginFrame = new JFrame("Easy Chat");
		Container loginFrameContentPane = loginFrame.getContentPane();
		loginFrameContentPane.setLayout(null);
		userIdLabel = new JLabel("User ID");
		userIdLabel.setBounds(150, 30 , 100, 30);
		userIdField = new JTextField();
		userIdField.setBounds(300, 30, 150, 30);
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(150, 80 , 100, 30);
		passwordField = new JPasswordField();
		passwordField.setBounds(300, 80, 150, 30);
		loginButton = new JButton("Login");
		loginButton.setBounds(250, 140, 100 ,30);
		loginButton.addActionListener(actionListener);
		registerButton = new JButton("Register");
		registerButton.setBounds(250, 180, 100 ,30);
		registerButton.addActionListener(actionListener);
		loginFrameContentPane.add(registerButton);
		loginFrameContentPane.add(loginButton);
		loginFrameContentPane.add(userIdLabel);
		loginFrameContentPane.add(userIdField);
		loginFrameContentPane.add(passwordLabel);
		loginFrameContentPane.add(passwordField);
		loginFrame.setSize(600, 300);
		loginFrame.setLocationRelativeTo(null);
		loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		loginFrame.setVisible(true);
	}
}
