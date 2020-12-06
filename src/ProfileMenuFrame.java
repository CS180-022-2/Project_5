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
import javax.swing.*;
/**
 * Project 05 - Social Network "Profile" Application
 * <p>
 * A class representing the frame that gives users the option to either create, edit, or delete their profiles.
 * <p>
 * Note that this only provides an option by displaying buttons. Details of creation, edition, or deletion
 * happens in a separate frame when the user clicks the respective button to function.
 *
 * @author Group 022-2
 * @version November 30, 2020
 */

public class ProfileMenuFrame extends JComponent implements Runnable {
    Socket socket;
    String userId;
    BufferedReader bufferedReader;
    PrintWriter printWriter;
    JFrame profileMenuFrame;
    JButton editProfileButton;
    JButton deleteProfileButton;
    JButton backButton;

    ActionListener actionListener = new ActionListener() {
        /**
         *@param e Invoked when any of the button in the frame is selected.
         *         There are three button choices: Back, Edit Profile, and Delete Profile
         *         Back button will lead to the AccountProfileFrame while Edit Profile button
         *         will lead to the EditProfileFrame. Delete Profile button would happen within the
         *         ProfileMenuFrame by sending "DeleteOwnProfile" to the server and the server
         *         initializes all the text fields to blank state.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == backButton) {
                SwingUtilities.invokeLater(new AccountProfileFrame(socket, userId));
                profileMenuFrame.dispose();
            }
            if (e.getSource() == editProfileButton) {
                SwingUtilities.invokeLater(new EditProfileFrame(socket, userId));
                profileMenuFrame.dispose();
            }
            if (e.getSource() == deleteProfileButton) {
                int isDelete = JOptionPane.showConfirmDialog(null,
                        "All you sure to delete all your profile?", "Profile delete",
                        JOptionPane.YES_NO_OPTION);
                if (isDelete == JOptionPane.YES_OPTION) {
                    printWriter.println("DeleteOwnProfile");
                    printWriter.println(userId);
                    printWriter.flush();
                    String success = "";
                    try {
                        success = bufferedReader.readLine();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    switch (success) {
                        case "No Profile" -> JOptionPane.showMessageDialog(null,
                                "No profile to delete.\nPlease fill the profile first.",
                                "Delete Profile Error", JOptionPane.ERROR_MESSAGE);
                        case "Success" -> JOptionPane.showMessageDialog(null, "Congratulations! " +
                                        "You have successfully delete your profile!",
                                "Profile deletion Successful", JOptionPane.INFORMATION_MESSAGE);
                        case "Failure" -> JOptionPane.showMessageDialog(null, "Oops!" +
                                        "Unsuccessful deletion.\nPlease retry.",
                                "Delete Profile Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    };

    /**
     * The constructor of EditProfileFrame which uses two parameters : socket and userId
     *
     * @param socket The socket that connects this local machine with the server
     * @param userId The userId of the login user
     */
    public ProfileMenuFrame(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    /**
     * Sets up the appearance of the Profile Menu Frame by initializing GUIs.
     * BufferedReader and PrintWriter is created with the socket that is being transferred from other frame.
     */
    @Override
    public void run() {
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Unable to initialize in Menu frame", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return;
        }
        profileMenuFrame = new JFrame("Profile Menu Frame");
        Container profileMenuFrameContentPane = profileMenuFrame.getContentPane();
        profileMenuFrameContentPane.setLayout(null);
        deleteProfileButton = new JButton("Delete Profile");
        editProfileButton = new JButton("Create / Edit Profile");
        backButton = new JButton("Back to Menu Frame");
        //Set component location
        editProfileButton.setBounds(120, 50, 160, 30);
        deleteProfileButton.setBounds(120, 100, 160, 30);
        backButton.setBounds(120, 150, 160, 30);

        //Add actionLister
        deleteProfileButton.addActionListener(actionListener);
        editProfileButton.addActionListener(actionListener);
        backButton.addActionListener(actionListener);

        //Add all components into the Frame;
        profileMenuFrameContentPane.add(editProfileButton);
        profileMenuFrameContentPane.add(deleteProfileButton);
        profileMenuFrameContentPane.add(backButton);
        //Finalize the Frame
        profileMenuFrame.setSize(400, 300);
        profileMenuFrame.setLocationRelativeTo(null);
        profileMenuFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        profileMenuFrame.addWindowListener(new WindowAdapter() {
            /**
             * @param e Invoked when a window is in the process of being closed.
             *          The close operation can be overridden at this point.
             */
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    bufferedReader.close();
                    printWriter.close();
                    socket.close();
                    profileMenuFrame.dispose();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        profileMenuFrame.setVisible(true);
    }
}
