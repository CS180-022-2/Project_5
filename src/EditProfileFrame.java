import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.*;

public class EditProfileFrame extends JComponent implements Runnable {
    Socket socket;
    String userId;
    BufferedReader bufferedReader;
    PrintWriter printWriter;
    JFrame editProfileFrame;
    JLabel userPhoneNoLabel;
    JTextField userPhoneNoTextField;
    JLabel currentOccupationLabel;
    JTextField currentOccupationTextField;
<<<<<<< Updated upstream:src/CreateProfileFrame.java
    String[] genderChoose = {"Male", "Female", "I do not wish to identify"};
    JList<String> genderList = new JList<String>(genderChoose);
    String[] relationshipChoose = {"Yes", "No"};
    JList<String> relationshipList = new JList<String>(relationshipChoose);
    JLabel aboutMeLabel;
    JTextField aboutMeTextField;
=======
    JComboBox<String> genderList;
    JComboBox<String> relationshipList;
    JLabel aboutMeLabel;
    JTextField aboutMeTextField;
    JLabel genderLabel;
    JLabel relationshipLabel;
>>>>>>> Stashed changes:src/EditProfileFrame.java
    JLabel interestLabel;
    JTextField interestField;
    JButton editProfileButton;
    JButton backButton;

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == backButton) {
<<<<<<< Updated upstream:src/CreateProfileFrame.java
                SwingUtilities.invokeLater(new LoginFrame(socket));
                profileFrame.dispose();
=======
                SwingUtilities.invokeLater(new ProfileMenuFrame(socket,userId));
                editProfileFrame.dispose();
>>>>>>> Stashed changes:src/EditProfileFrame.java
            }
            if (e.getSource() == editProfileButton) {
                String userPhoneNo = userPhoneNoTextField.getText();
                String currentOccupation = currentOccupationTextField.getText();
                String aboutMe = aboutMeTextField.getText();
                String interest = interestField.getText();
                String gender = String.valueOf(genderList.getSelectedItem());
                String relationship = String.valueOf(relationshipList.getSelectedItem());
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
                    SwingUtilities.invokeLater(new ProfileMenuFrame(socket, userId));
                    editProfileFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Oops!" +
                                    "Unsuccessful creation./n Please retry.",
                            "Register Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    };

    public EditProfileFrame(Socket socket, String userId) {
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
                    "Unable to initialize in CreateProfile frame", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return;
        }
        editProfileFrame = new JFrame("Profile Frame");
        Container registerFrameContentPane = editProfileFrame.getContentPane();
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
<<<<<<< Updated upstream:src/CreateProfileFrame.java
        relationshipList = new JList<>(relationshipChoose);
        genderList = new JList<>(genderChoose);
        createProfileButton = new JButton("Create Profile");
        backButton = new JButton("Back to menu");
        //Set component location
        userPhoneNoLabel.setBounds(110, 30 , 80, 30);
        userPhoneNoTextField.setBounds(200, 30 , 100, 30);
        currentOccupationLabel.setBounds(110, 70 , 80, 30);
        currentOccupationTextField.setBounds(200, 70 , 100, 30);
        aboutMeLabel.setBounds(110, 110, 80, 30);
        aboutMeTextField.setBounds(200, 110 , 100, 30);
        interestLabel.setBounds(140, 150 , 50, 30);
        interestField.setBounds(200, 150 , 100, 30);
        createProfileButton.setBounds(140, 190 , 120, 30);
        backButton.setBounds(140,225, 120, 30);
=======
        relationshipLabel  = new JLabel("Relationship Status");
        relationshipList = new JComboBox<>(new String[] {"Single", "In relationship"});
        genderLabel = new JLabel("Gender");
        genderList = new JComboBox<>(new String[] {"Male", "Female", "I do not wish to identify"});
        editProfileButton = new JButton("Edit Profile");
        backButton = new JButton("Back to menu");
        //Set component location
        userPhoneNoLabel.setBounds(90, 10, 100, 30);
        userPhoneNoTextField.setBounds(220, 10 , 100, 30);
        currentOccupationLabel.setBounds(90, 50 , 120, 30);
        currentOccupationTextField.setBounds(220, 50 , 100, 30);
        aboutMeLabel.setBounds(90, 90, 80, 30);
        aboutMeTextField.setBounds(220, 90 , 100, 30);
        genderLabel.setBounds(90, 130, 100, 30);
        genderList.setBounds(220, 130, 100, 30);
        relationshipLabel.setBounds(90, 170, 120, 30);
        relationshipList.setBounds(220, 170, 100, 30);
        interestLabel.setBounds(90, 210 , 100, 30);
        interestField.setBounds(220, 210 , 100, 30);
        editProfileButton.setBounds(140, 270 , 120, 30);
        backButton.setBounds(140,310, 120, 30);
>>>>>>> Stashed changes:src/EditProfileFrame.java

        //Add actionLister
        editProfileButton.addActionListener(actionListener);
        backButton.addActionListener(actionListener);
        printWriter.println("GetProfileContent");
        printWriter.println(userId);
        String phoneNumber = "";
        String currentOccupation = "";
        String gender = "";
        String aboutMe = "";
        String interest = "";
        String relationship = "";
        try {
            phoneNumber = bufferedReader.readLine();
            currentOccupation = bufferedReader.readLine();
            gender = bufferedReader.readLine();
            aboutMe = bufferedReader.readLine();
            interest = bufferedReader.readLine();
            relationship = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Unable to get previous profile", "Error", JOptionPane.ERROR_MESSAGE);
        }
        userPhoneNoTextField.setText(phoneNumber);
        currentOccupationTextField.setText(currentOccupation);
        aboutMeTextField.setText(aboutMe);
        interestField.setText(interest);
        if (gender.equals("")) {
            genderList.setSelectedIndex(-1);
        } else {
            if (gender.equals("Male")) {
                genderList.setSelectedIndex(0);
            }
            if (gender.equals("Female")) {
                genderList.setSelectedIndex(1);
            }
            if (gender.equals("I do not wish to identify")) {
                genderList.setSelectedIndex(2);
            }
        }
        if (relationship.equals("")) {
            genderList.setSelectedIndex(-1);
        } else {
            if (relationship.equals("Single")) {
                genderList.setSelectedIndex(0);
            }
            if (relationship.equals("In relationship")) {
                genderList.setSelectedIndex(1);
            }
        }
        //Add all components into the Frame;
        registerFrameContentPane.add(userPhoneNoLabel);
        registerFrameContentPane.add(userPhoneNoTextField);
        registerFrameContentPane.add(currentOccupationLabel);
        registerFrameContentPane.add(currentOccupationTextField);
        registerFrameContentPane.add(aboutMeLabel);
        registerFrameContentPane.add(aboutMeTextField);
<<<<<<< Updated upstream:src/CreateProfileFrame.java
        registerFrameContentPane.add(relationshipList);
=======
        registerFrameContentPane.add(relationshipLabel);
        registerFrameContentPane.add(relationshipList);
        registerFrameContentPane.add(genderLabel);
>>>>>>> Stashed changes:src/EditProfileFrame.java
        registerFrameContentPane.add(genderList);
        registerFrameContentPane.add(interestLabel);
        registerFrameContentPane.add(interestField);
        registerFrameContentPane.add(editProfileButton);
        registerFrameContentPane.add(backButton);
        //Finalize the Frame
<<<<<<< Updated upstream:src/CreateProfileFrame.java
        profileFrame.setSize(400, 300);
        profileFrame.setLocationRelativeTo(null);
        profileFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        profileFrame.setVisible(true);
=======
        editProfileFrame.setSize(400, 400);
        editProfileFrame.setLocationRelativeTo(null);
        editProfileFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        editProfileFrame.setVisible(true);
>>>>>>> Stashed changes:src/EditProfileFrame.java
    }
}
