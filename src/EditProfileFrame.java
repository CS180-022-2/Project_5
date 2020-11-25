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
    JComboBox<String> genderList;
    JComboBox<String> relationshipList;
    JLabel aboutMeLabel;
    JTextField aboutMeTextField;
    JLabel genderLabel;
    JLabel relationshipLabel;
    JLabel interestLabel;
    JTextField interestField;
    JButton editProfileButton;
    JButton backButton;

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == backButton) {
                SwingUtilities.invokeLater(new ProfileMenuFrame(socket, userId));
                editProfileFrame.dispose();
            }
            if (e.getSource() == editProfileButton) {
                String userPhoneNo = userPhoneNoTextField.getText();
                String currentOccupation = currentOccupationTextField.getText();
                String aboutMe = aboutMeTextField.getText();
                String interest = interestField.getText();
                String gender = String.valueOf(genderList.getSelectedItem());
                String relationship = String.valueOf(relationshipList.getSelectedItem());
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
                printWriter.println("EditOwnProfile");
                printWriter.printf("%s, %s, %s, %s, %s, %s\n", userPhoneNo, relationship, gender, currentOccupation,
                        interest, aboutMe);
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
                            "EditProfile Error", JOptionPane.ERROR_MESSAGE);
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
                    "Unable to initialize in EditProfile frame", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return;
        }
        editProfileFrame = new JFrame("Profile Frame");
        Container editProfileFrameContentPane = editProfileFrame.getContentPane();
        editProfileFrameContentPane.setLayout(null);
        //Initialize components
        userPhoneNoLabel = new JLabel("Phone Number");
        userPhoneNoTextField = new JTextField();
        currentOccupationLabel = new JLabel("Current Occupation");
        currentOccupationTextField = new JTextField();
        aboutMeLabel = new JLabel("About Me");
        aboutMeTextField = new JTextField();
        interestLabel = new JLabel("Interests");
        interestField = new JTextField();
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

        //Add actionLister
        editProfileButton.addActionListener(actionListener);
        backButton.addActionListener(actionListener);
        printWriter.println("GetProfileContent");
        printWriter.println(userId);
        printWriter.flush();
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
            relationshipList.setSelectedIndex(-1);
        } else {
            if (relationship.equals("Single")) {
                relationshipList.setSelectedIndex(0);
            }
            if (relationship.equals("In relationship")) {
                relationshipList.setSelectedIndex(1);
            }
        }

        //Add all components into the Frame;
        editProfileFrameContentPane.add(userPhoneNoLabel);
        editProfileFrameContentPane.add(userPhoneNoTextField);
        editProfileFrameContentPane.add(currentOccupationLabel);
        editProfileFrameContentPane.add(currentOccupationTextField);
        editProfileFrameContentPane.add(aboutMeLabel);
        editProfileFrameContentPane.add(aboutMeTextField);
        editProfileFrameContentPane.add(relationshipLabel);
        editProfileFrameContentPane.add(relationshipList);
        editProfileFrameContentPane.add(genderLabel);
        editProfileFrameContentPane.add(genderList);
        editProfileFrameContentPane.add(interestLabel);
        editProfileFrameContentPane.add(interestField);
        editProfileFrameContentPane.add(editProfileButton);
        editProfileFrameContentPane.add(backButton);

        //Finalize the Frame
        editProfileFrame.setSize(400, 400);
        editProfileFrame.setLocationRelativeTo(null);
        editProfileFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        editProfileFrame.setVisible(true);
    }
}
