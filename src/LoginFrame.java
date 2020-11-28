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
    String userId;
    JFrame loginFrame;
    JLabel userIdLabel;
    JTextField userIdField;
    JLabel passwordLabel;
    JPasswordField passwordField;
    JButton loginButton;
    JButton registerButton;
    JButton myAccountButton;
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
                userId = userIdField.getText();
                char[] rawPassword = passwordField.getPassword();
                StringBuilder actualPassword = new StringBuilder();
                actualPassword.append(rawPassword);
                try {
                    printWriter.println("Login");
                    printWriter.println(userId);
                    printWriter.println(actualPassword.toString());
                    printWriter.flush();
                    String result = bufferedReader.readLine();
                    if (result.equals("Success")) {
                        JOptionPane.showMessageDialog(null,
                                "Login Successful!", "Login Success",
                                JOptionPane.INFORMATION_MESSAGE);
                        SwingUtilities.invokeLater(new ProfileMenuFrame(socket, userId));
                        loginFrame.dispose();
                    } else {
                        if (result.equals("Invalid")) {
                            JOptionPane.showMessageDialog(null,
                                    "Invalid username/password", "Login Failure",
                                    JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        else if (result.equals("DualLogin")) {
                            JOptionPane.showMessageDialog(null,
                                    "Your account has already logged in ", "Login Failure",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            if (e.getSource() == registerButton) {
                SwingUtilities.invokeLater(new RegisterFrame(socket));
                loginFrame.dispose();
            }
            if (e.getSource() == myAccountButton) {
                SwingUtilities.invokeLater(new AccountMenuFrame(socket, userId));
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
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Unable to initialize in Login Frame", "Error", JOptionPane.ERROR_MESSAGE);
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
        loginButton.setBounds(180, 140, 100 ,30);
        loginButton.addActionListener(actionListener);
        registerButton = new JButton("Register");
        registerButton.setBounds(290, 140, 100 ,30);
        registerButton.addActionListener(actionListener);
        myAccountButton = new JButton("My Account");
        myAccountButton.setBounds(225, 190, 120, 30);
        myAccountButton.addActionListener(actionListener);

        loginFrameContentPane.add(registerButton);
        loginFrameContentPane.add(loginButton);
        loginFrameContentPane.add(myAccountButton);
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