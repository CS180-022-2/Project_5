import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Project 05 - Social Network "Profile" Application
 * <p>
 * A class representing the profile details of the user in a separate frame.
 * <p>
 * Profile details include: Phone Number, Current Occupation, About Me, Interests, Gender, and Relationship Status
 *
 * @author Group 022-2
 * @version November 30, 2020
 */
public class ProfileDisplayFrame extends JComponent implements Runnable {
    Socket socket;
    String viewerId;
    String profileOwnerId;
    String tracker;
    BufferedReader bufferedReader;
    PrintWriter printWriter;
    JFrame profileDisplayFrame;
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
    JButton backButton;

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == backButton) {
                if (tracker.equals("UserFrame")) {
                    SwingUtilities.invokeLater(new UserFrame(socket, viewerId));
                    profileDisplayFrame.dispose();
                } else if (tracker.equals("AddFriendFrame")) {
                    SwingUtilities.invokeLater(new AddFriendFrame(socket, viewerId));
                    profileDisplayFrame.dispose();
                }
            }
        }
    };

    public ProfileDisplayFrame(Socket socket, String viewerId, String profileOwnerId, String tracker) {
        this.socket = socket;
        this.viewerId = viewerId;
        this.profileOwnerId = profileOwnerId;
        this.tracker = tracker;
    }

    @Override
    public void run() {
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Unable to initialize in Profile Display frame", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return;
        }
        profileDisplayFrame = new JFrame("Profile Display Frame");
        Container profileDisplayFrameContentPane = profileDisplayFrame.getContentPane();
        profileDisplayFrameContentPane.setLayout(null);
        userPhoneNoLabel = new JLabel("Phone Number");
        userPhoneNoTextField = new JTextField();
        currentOccupationLabel = new JLabel("Current Occupation");
        currentOccupationTextField = new JTextField();
        aboutMeLabel = new JLabel("About Me");
        aboutMeTextField = new JTextField();
        interestLabel = new JLabel("Interests");
        interestField = new JTextField();
        relationshipLabel = new JLabel("Relationship Status");
        relationshipList = new JComboBox<>(new String[]{"Single", "In relationship"});
        genderLabel = new JLabel("Gender");
        genderList = new JComboBox<>(new String[]{"Male", "Female", "I do not wish to identify"});
        backButton = new JButton("Back");

        //Locate all components
        userPhoneNoLabel.setBounds(90, 10, 100, 30);
        userPhoneNoTextField.setBounds(220, 10, 100, 30);
        currentOccupationLabel.setBounds(90, 50, 120, 30);
        currentOccupationTextField.setBounds(220, 50, 100, 30);
        aboutMeLabel.setBounds(90, 90, 80, 30);
        aboutMeTextField.setBounds(220, 90, 100, 30);
        genderLabel.setBounds(90, 130, 100, 30);
        genderList.setBounds(220, 130, 100, 30);
        relationshipLabel.setBounds(90, 170, 120, 30);
        relationshipList.setBounds(220, 170, 100, 30);
        interestLabel.setBounds(90, 210, 100, 30);
        interestField.setBounds(220, 210, 100, 30);
        backButton.setBounds(140, 310, 120, 30);
        backButton.addActionListener(actionListener);

        printWriter.println("GetProfileContent");
        printWriter.println(profileOwnerId);
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
        userPhoneNoTextField.setEditable(false);
        currentOccupationTextField.setEditable(false);
        aboutMeTextField.setEditable(false);
        interestField.setEditable(false);
        genderList.setEditable(false);
        relationshipList.setEditable(false);

        //Add all components into the Frame;
        profileDisplayFrameContentPane.add(userPhoneNoLabel);
        profileDisplayFrameContentPane.add(userPhoneNoTextField);
        profileDisplayFrameContentPane.add(currentOccupationLabel);
        profileDisplayFrameContentPane.add(currentOccupationTextField);
        profileDisplayFrameContentPane.add(aboutMeLabel);
        profileDisplayFrameContentPane.add(aboutMeTextField);
        profileDisplayFrameContentPane.add(relationshipLabel);
        profileDisplayFrameContentPane.add(relationshipList);
        profileDisplayFrameContentPane.add(genderLabel);
        profileDisplayFrameContentPane.add(genderList);
        profileDisplayFrameContentPane.add(interestLabel);
        profileDisplayFrameContentPane.add(interestField);
        profileDisplayFrameContentPane.add(backButton);

        //Finalize the Frame
        profileDisplayFrame.setSize(400, 400);
        profileDisplayFrame.setLocationRelativeTo(null);
        profileDisplayFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        profileDisplayFrame.addWindowListener(new WindowAdapter() {
            /**
             * Invoked when a window is in the process of being closed.
             * The close operation can be overridden at this point.
             *
             * @param e
             */
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    bufferedReader.close();
                    printWriter.close();
                    socket.close();
                    profileDisplayFrame.dispose();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        profileDisplayFrame.setVisible(true);

    }
}
