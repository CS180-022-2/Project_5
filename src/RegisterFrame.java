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

public class RegisterFrame extends JComponent implements Runnable{
    Socket socket;
    BufferedReader bufferedReader;
    PrintWriter printWriter;
    JFrame registerFrame;
    JLabel userIdLabel;
    JTextField userIdTextField;
    JLabel passwordLabel;
    JPasswordField passwordField;
    JLabel realNameLabel;
    JTextField realNameTextField;
    JLabel emailLabel;
    JTextField emailTextField;
    JButton registerButton;
    JButton backButton;

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == backButton) {
                SwingUtilities.invokeLater(new LoginFrame(socket));
                registerFrame.dispose();
            }
            if (e.getSource() == registerButton) {
                String userId = userIdTextField.getText();
                StringBuilder rawPassword = new StringBuilder();
                rawPassword.append(passwordField.getPassword());
                String realName = realNameTextField.getText();
                String email = emailTextField.getText();
                if (!contentCheck(userId, rawPassword.toString(), realName, email)){
                    return;
                }
            }
        }
    };

    public RegisterFrame(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Unable to initialize in Register frame", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return;
        }
        registerFrame = new JFrame("Register Frame");
        Container registerFrameContentPane = registerFrame.getContentPane();
        registerFrameContentPane.setLayout(null);
        //Initialize components
        userIdLabel = new JLabel("UserId");
        userIdTextField = new JTextField();
        passwordLabel = new JLabel("Password");
        passwordField = new JPasswordField();
        realNameLabel = new JLabel("Real Name");
        realNameTextField = new JTextField();
        emailLabel = new JLabel("Email");
        emailTextField = new JTextField();
        registerButton = new JButton("Register");
        backButton = new JButton("Back to login");
        //Set component location
        userIdLabel.setBounds(110, 30 , 80, 30);
        userIdTextField.setBounds(200, 30 , 100, 30);
        passwordLabel.setBounds(110, 70 , 80, 30);
        passwordField.setBounds(200, 70 , 100, 30);
        realNameLabel.setBounds(110, 110, 80, 30);
        realNameTextField.setBounds(200, 110 , 100, 30);
        emailLabel.setBounds(140, 150 , 50, 30);
        emailTextField.setBounds(200, 150 , 100, 30);
        registerButton.setBounds(140, 190 , 120, 30);
        backButton.setBounds(140,225, 120, 30);

        //Add actionLister
        registerButton.addActionListener(actionListener);
        backButton.addActionListener(actionListener);

        //Add all components into the Frame;
        registerFrameContentPane.add(userIdLabel);
        registerFrameContentPane.add(userIdTextField);
        registerFrameContentPane.add(passwordLabel);
        registerFrameContentPane.add(passwordField);
        registerFrameContentPane.add(realNameLabel);
        registerFrameContentPane.add(realNameTextField);
        registerFrameContentPane.add(emailLabel);
        registerFrameContentPane.add(emailTextField);
        registerFrameContentPane.add(registerButton);
        registerFrameContentPane.add(backButton);
        //Finalize the Frame
        registerFrame.setSize(400, 300);
        registerFrame.setLocationRelativeTo(null);
        registerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        registerFrame.setVisible(true);
    }
    public boolean contentCheck(String userId, String password, String realName, String email) {
        boolean correct = true;
        if (!userId.matches("")) {
            JOptionPane.showMessageDialog(null, "",
                    "UserId Error", JOptionPane.WARNING_MESSAGE);
            correct = false;
        }
        if (!password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,18}$")) {
            JOptionPane.showMessageDialog(null, "Password must have a length"
                            + "between 6 to 18 and contain an uppercase, a lower case, and a number",
                    "Password Error", JOptionPane.WARNING_MESSAGE);
            correct = false;
        }
        if (!realName.matches("[A-Za-z]+ [A-Za-z]+ ?[A-Za-z]+")) {
            JOptionPane.showMessageDialog(null, "Real Name must have a first"
                            + "name and a lastName. A space needs to appear between the first name and next"
                            + "name. Middle name can be included ",
                    "Real Name Error", JOptionPane.WARNING_MESSAGE);
            correct = false;
        }
        if (!email.matches("\\w+@\\w+.\\w+")) {
            JOptionPane.showMessageDialog(null, "The email"
                            + " must have one '@' sign and one '.', no other special sign allowed",
                    "Email", JOptionPane.WARNING_MESSAGE);
            correct = false;
        }
        return correct;
    }
}
