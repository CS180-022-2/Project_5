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
                /*printWriter.println("UniqueIdCheck");
                printWriter.println(userId);
                printWriter.flush();
                String result = "";
                try {
                    result = bufferedReader.readLine();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                if (!result.equals("Unique")) {
                    JOptionPane.showMessageDialog(null, "UserId existed",
                            "UserID Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }*/
                //Pass the data to server
                printWriter.println("Register");
                printWriter.printf("%s, %s, %s, %s\n", userId, rawPassword.toString(), realName, email);
                printWriter.flush();
                String success = "";
                try {
                    success = bufferedReader.readLine();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                if (success.equals("Success")) {
                    JOptionPane.showMessageDialog(null, "Congratulation! " +
                                    "You have successfully registered",
                            "Register Successfully", JOptionPane.INFORMATION_MESSAGE);
                    SwingUtilities.invokeLater(new LoginFrame(socket));
                    registerFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Oops!" +
                                    "Unsuccessful register./n Please retry.",
                            "Register Error", JOptionPane.ERROR_MESSAGE);
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
        userIdLabel = new JLabel("User ID");
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
        userIdLabel.setBounds(110, 20 , 80, 30);
        userIdTextField.setBounds(200, 20 , 100, 30);
        passwordLabel.setBounds(110, 60 , 80, 30);
        passwordField.setBounds(200, 60 , 100, 30);
        realNameLabel.setBounds(110, 100, 80, 30);
        realNameTextField.setBounds(200, 100 , 100, 30);
        emailLabel.setBounds(110, 140 , 50, 30);
        emailTextField.setBounds(200, 140 , 100, 30);
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
        if (!userId.matches("^[a-zA-Z0-9_-][^%+\\\\/#@*:;`~<>?!.,'\"]+$")) {
            JOptionPane.showMessageDialog(null, "UserID should at least contain" +
                            " two characters and only contain alphabets and numbers.",
                    "UserID Error", JOptionPane.WARNING_MESSAGE);
            correct = false;
        }

        /*
        Regex used for password validation:
        ^                 # start-of-string
        (?=.*[0-9])       # a digit must occur at least once
        (?=.*[a-z])       # a lower case letter must occur at least once
        (?=.*[A-Z])       # an upper case letter must occur at least once
        (?=.*[@#$%^&+=])  # a special character must occur at least once
        (?=\S+$)          # no whitespace allowed in the entire string
        .{8,}             # anything, at least eight places though
        $                 # end-of-string
         */
        if (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")) {
            JOptionPane.showMessageDialog(null, "Password must have a length"
                            + " greater than 8 and contain at least one uppercase, one lower case, one digit" +
                            " and one special character.",
                    "Password Error", JOptionPane.WARNING_MESSAGE);
            correct = false;
        }
        if (!realName.matches("[A-Za-z]+ [A-Za-z]+ ?[A-Za-z]+")) {
            JOptionPane.showMessageDialog(null, "Real Name must have a first"
                            + "Name and a lastName. A space needs to appear between the first name and next"
                            + "Name. Middle name can be included ",
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
