import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.*;

public class CreateProfileFrame extends JComponent implements Runnable {
    Socket socket;
    BufferedReader bufferedReader;
    PrintWriter printWriter;
    JFrame profileFrame;
    JLabel userPhoneNoLabel;
    JTextField userPhoneNoTextField;
    JLabel currentOccupationLabel;
    JTextField currentOccupationTextField;
    String[] genderChoose = {"Male", "Female", "I do not wish to identify"};
    JList<String> genderList = new JList<String>(genderChoose);
    String[] relationshipChoose = {"Single", "In relationship"};
    JList<String> relationshipList = new JList<String>(relationshipChoose);
    JLabel aboutMeLabel;
    JTextField aboutMeTextField;
    JLabel gender;
    JLabel relationship;
    JLabel interestLabel;
    JTextField interestField;
    JButton createProfileButton;
    JButton editProfileButton;
    JButton deleteProfileButton;
    JButton backButton;

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == backButton) {
                SwingUtilities.invokeLater(new MenuFrame(socket));
                profileFrame.dispose();
            }
            if (e.getSource() == createProfileButton) {
                String userPhoneNo = userPhoneNoTextField.getText();
                String currentOccupation = currentOccupationTextField.getText();
                String aboutMe = aboutMeTextField.getText();
                String interest = interestField.getText();
                String gender = genderList.getSelectedValue();
                String relationship = relationshipList.getSelectedValue();
                /*if (!contentCheck(userId, rawPassword.toString(), realName, email)){
                    return;
                }*/
                printWriter.println("UniquePhoneNoCheck");
                printWriter.println(userPhoneNo);
                printWriter.flush();
                String result = "";
                try {
                    result = bufferedReader.readLine();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                if (!result.equals("Unique")) {
                    JOptionPane.showMessageDialog(null, "User Phone Number exists",
                            "User Phone Number Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                //Pass the data to server
                printWriter.println("Profile");
                printWriter.printf("%s, %s, %s, %s, %s, %s\n", userPhoneNo, currentOccupation, aboutMe, interest,
                        gender, relationship);
                printWriter.flush();
                String success = "";
                try {
                    success = bufferedReader.readLine();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                if (success.equals("Success")) {
                    JOptionPane.showMessageDialog(null, "Congratulations! " +
                                    "You have successfully created your profile!",
                            "Profile Creation Successful", JOptionPane.INFORMATION_MESSAGE);
                    SwingUtilities.invokeLater(new CreateProfileFrame(socket));
                    profileFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Oops!" +
                                    "Unsuccessful creation./n Please retry.",
                            "Register Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            if (e.getSource() == editProfileButton) {

            }
            if (e.getSource() == deleteProfileButton) {

            }
        }
    };

    public CreateProfileFrame(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Unable to initialize in Profile frame", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return;
        }
        profileFrame = new JFrame("Profile Frame");
        Container registerFrameContentPane = profileFrame.getContentPane();
        registerFrameContentPane.setLayout(null);
        //Initialize components
        userPhoneNoLabel = new JLabel("Phone Number");
        userPhoneNoTextField = new JTextField();
        currentOccupationLabel = new JLabel("Current Occupation");
        currentOccupationTextField = new JPasswordField();
        aboutMeLabel = new JLabel("About Me");
        aboutMeTextField = new JTextField();
        interestLabel = new JLabel("Interests");
        interestField = new JTextField();
        relationship = new JLabel("Relationship Status");
        relationshipList = new JList<>(relationshipChoose);
        gender = new JLabel("Gender");
        genderList = new JList<>(genderChoose);
        createProfileButton = new JButton("Create Profile");
        backButton = new JButton("Back to menu");
        //Set component location
        userPhoneNoLabel.setBounds(90, 10, 100, 30);
        userPhoneNoTextField.setBounds(220, 10 , 100, 30);
        currentOccupationLabel.setBounds(90, 50 , 120, 30);
        currentOccupationTextField.setBounds(220, 50 , 100, 30);
        aboutMeLabel.setBounds(90, 90, 80, 30);
        aboutMeTextField.setBounds(220, 90 , 100, 30);
        gender.setBounds(90, 130, 100, 30);
        genderList.setBounds(220, 130, 100, 30);
        relationship.setBounds(90, 170, 120, 30);
        relationshipList.setBounds(220, 170, 100, 30);
        interestLabel.setBounds(90, 210 , 100, 30);
        interestField.setBounds(220, 210 , 100, 30);
        createProfileButton.setBounds(140, 270 , 120, 30);
        backButton.setBounds(140,310, 120, 30);

        //Add actionLister
        createProfileButton.addActionListener(actionListener);
        backButton.addActionListener(actionListener);

        //Add all components into the Frame;
        registerFrameContentPane.add(userPhoneNoLabel);
        registerFrameContentPane.add(userPhoneNoTextField);
        registerFrameContentPane.add(currentOccupationLabel);
        registerFrameContentPane.add(currentOccupationTextField);
        registerFrameContentPane.add(aboutMeLabel);
        registerFrameContentPane.add(aboutMeTextField);
        registerFrameContentPane.add(relationship);
        registerFrameContentPane.add(relationshipList);
        registerFrameContentPane.add(gender);
        registerFrameContentPane.add(genderList);
        registerFrameContentPane.add(interestLabel);
        registerFrameContentPane.add(interestField);
        registerFrameContentPane.add(createProfileButton);
        registerFrameContentPane.add(backButton);
        //Finalize the Frame
        profileFrame.setSize(400, 400);
        profileFrame.setLocationRelativeTo(null);
        profileFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        profileFrame.setVisible(true);
    }
}
