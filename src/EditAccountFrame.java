import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.*;

public class EditAccountFrame extends JOptionPane implements Runnable{
    Socket socket;
    String userId;
    BufferedReader bufferedReader;
    PrintWriter printWriter;
    JLabel userIdLabel;
    JLabel userIdTextField;
    JLabel passwordLabel;
    JPasswordField passwordField;
    JLabel realNameLabel;
    JTextField realNameTextField;
    JLabel emailLabel;
    JTextField emailTextField;
    JButton editAccountButton;
    JButton backButton;
    JFrame editAccountFrame;

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == backButton) {
                SwingUtilities.invokeLater(new AccountMenuFrame(socket, userId));
                editAccountFrame.dispose();
            }
            if (e.getSource() == editAccountButton) {
                StringBuilder rawPassword = new StringBuilder();
                rawPassword.append(passwordField.getPassword());
                String realName = realNameTextField.getText();
                String email = emailTextField.getText();;
                if (!contentCheck(rawPassword.toString(), realName, email)){
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
                    JOptionPane.showMessageDialog(null, "UserID exists",
                            "UserID Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }*/
                //Pass the data to server
                printWriter.println("EditOwnAccount");
                printWriter.printf("%s, %s, %s, %s\n", userId, rawPassword.toString(), realName, email);
                printWriter.flush();
                String success = "";
                try {
                    success = bufferedReader.readLine();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                if (success.equals("Success")) {
                    JOptionPane.showMessageDialog(null, "Congratulation!\n" +
                                    "You have successfully edited your account details.",
                            "Edit Account Successful", JOptionPane.INFORMATION_MESSAGE);
                    SwingUtilities.invokeLater(new LoginFrame(socket));
                    editAccountFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Oops! " +
                                    "Unsuccessful attempt.\nPlease retry.",
                            "Edit Account Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    };

    public EditAccountFrame(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    @Override
    public void run() {
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Unable to initialize in Edit Account frame", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return;
        }
        editAccountFrame = new JFrame("Edit Account Frame");
        Container editAccountFrameContentPane = editAccountFrame.getContentPane();
        editAccountFrameContentPane.setLayout(null);
        //Initialize components
        userIdLabel = new JLabel("User ID");
        userIdTextField = new JLabel(userId);
        passwordLabel = new JLabel("Password");
        passwordField = new JPasswordField();
        realNameLabel = new JLabel("Real Name");
        realNameTextField = new JTextField();
        emailLabel = new JLabel("Email");
        emailTextField = new JTextField();
        editAccountButton = new JButton("Edit");
        backButton = new JButton("Back to Menu");
        //Set component location
        userIdLabel.setBounds(110, 20 , 80, 30);
        userIdTextField.setBounds(200, 20 , 100, 30);
        passwordLabel.setBounds(110, 60 , 80, 30);
        passwordField.setBounds(200, 60 , 100, 30);
        realNameLabel.setBounds(110, 100, 80, 30);
        realNameTextField.setBounds(200, 100 , 100, 30);
        emailLabel.setBounds(110, 140 , 50, 30);
        emailTextField.setBounds(200, 140 , 100, 30);
        editAccountButton.setBounds(140, 190 , 120, 30);
        backButton.setBounds(140,225, 120, 30);

        //Add actionLister
        editAccountButton.addActionListener(actionListener);
        backButton.addActionListener(actionListener);

        //Add all components into the Frame;
        editAccountFrameContentPane.add(userIdLabel);
        editAccountFrameContentPane.add(userIdTextField);
        editAccountFrameContentPane.add(passwordLabel);
        editAccountFrameContentPane.add(passwordField);
        editAccountFrameContentPane.add(realNameLabel);
        editAccountFrameContentPane.add(realNameTextField);
        editAccountFrameContentPane.add(emailLabel);
        editAccountFrameContentPane.add(emailTextField);
        editAccountFrameContentPane.add(editAccountButton);
        editAccountFrameContentPane.add(backButton);
        //Finalize the Frame
        editAccountFrame.setSize(400, 300);
        editAccountFrame.setLocationRelativeTo(null);
        editAccountFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        editAccountFrame.setVisible(true);
    }

    public boolean contentCheck(String password, String realName, String email) {
        boolean correct = true;

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
        if (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$!?%^&+=])(?=\\S+$).{8,}$")) {
            JOptionPane.showMessageDialog(null, "Password must have a length"
                            + " greater than 8 and contain\nat least one uppercase, one lower case, one digit" +
                            " and one special character.",
                    "Password Error", JOptionPane.WARNING_MESSAGE);
            correct = false;
        }
        if (!realName.matches("[A-Za-z]+?[\\-]+?[A-Za-z]+ ?[A-Za-z]+") &&
            !realName.matches("[A-Za-z]+ [A-Za-z]+ ?[A-Za-z]+")) {
            JOptionPane.showMessageDialog(null, "Real Name must have a first"
                            + " name and a last name.\nA space needs to appear between the first name and next"
                            + " name.\nMiddle name can be included.",
                    "Real Name Error", JOptionPane.WARNING_MESSAGE);
            correct = false;
        }
        if (!email.matches("\\w+@\\w+.\\w+")) {
            JOptionPane.showMessageDialog(null, "The email"
                            + " must have one '@' sign and one '.', no other special sign allowed.",
                    "Email", JOptionPane.WARNING_MESSAGE);
            correct = false;
        }
        return correct;
    }
}
