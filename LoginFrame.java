import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class LoginFrame extends JComponent implements Runnable {
	JFrame loginFrame;
	JLabel userIdLabel;
	JTextField userIdField;
	JLabel passwordLabel;
	JPasswordField passwordField;
	JButton loginButton;
	JButton registerButton;
	Socket socket;
	BufferedReader bufferedReader;
	PrintWriter printWriter;


	public LoginFrame(Socket socket) {
		this.socket = socket;
	}

	ActionListener actionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == loginButton ) {
				String userName = userIdField.getText();
				char[] rawPassword = passwordField.getPassword();
				StringBuilder actualPassword = new StringBuilder();
				actualPassword.append(rawPassword);
				try {
					printWriter.println("Login");
					printWriter.println(userName);
					printWriter.println(actualPassword.toString());
					String result = bufferedReader.readLine();
					if (result.equals("Success")) {
						SwingUtilities.invokeLater(new RegisterFrame(socket));
						bufferedReader.close();
						printWriter.close();
						loginFrame.dispose();
					} else {
						JOptionPane.showMessageDialog(null,
							"Invalid username/ password", "Login Failure",
							JOptionPane.INFORMATION_MESSAGE);
						return;
					}
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}
			}
			if (e.getSource() == registerButton) {
				SwingUtilities.invokeLater(new RegisterFrame(socket));
				try{
					bufferedReader.close();
					printWriter.close();
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}
				loginFrame.dispose();
			}
		}
	};

	@Override
	public void run() {
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			printWriter = new PrintWriter(socket.getOutputStream());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
				"Unable to initialize", "Error", JOptionPane.ERROR_MESSAGE);
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
