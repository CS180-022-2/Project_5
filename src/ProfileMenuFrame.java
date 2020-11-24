import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.*;

public class ProfileMenuFrame extends JComponent implements Runnable {
    Socket socket;
    String userId;
    BufferedReader bufferedReader;
    PrintWriter printWriter;
    JFrame MenuFrame;
    JButton createProfileButton;
    JButton editProfileButton;
    JButton deleteProfileButton;
    JButton backButton;

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == backButton) {
                SwingUtilities.invokeLater(new LoginFrame(socket));
                MenuFrame.dispose();
            }
            if (e.getSource() == editProfileButton) {
                SwingUtilities.invokeLater(new EditProfileFrame(socket,userId));
                MenuFrame.dispose();
            }
            if (e.getSource() == deleteProfileButton) {

            }
        }
    };

    public ProfileMenuFrame(Socket socket, String userId) {
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
                    "Unable to initialize in Menu frame", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return;
        }
        MenuFrame = new JFrame("Menu Frame");
        Container MenuFrameContentPane = MenuFrame.getContentPane();
        MenuFrameContentPane.setLayout(null);
        deleteProfileButton = new JButton("Delete Profile");
        editProfileButton = new JButton("Edit Profile");
        createProfileButton = new JButton("Create Profile");
        backButton = new JButton("Back to Login");
        //Set component location
        createProfileButton.setBounds(140, 30 , 120, 30);
        deleteProfileButton.setBounds(140, 80 , 120, 30);
        editProfileButton.setBounds(140, 130 , 120, 30);
        backButton.setBounds(140,180, 120, 30);

        //Add actionLister
        createProfileButton.addActionListener(actionListener);
        deleteProfileButton.addActionListener(actionListener);
        editProfileButton.addActionListener(actionListener);
        backButton.addActionListener(actionListener);

        //Add all components into the Frame;
        MenuFrameContentPane.add(createProfileButton);
        MenuFrameContentPane.add(editProfileButton);
        MenuFrameContentPane.add(deleteProfileButton);
        MenuFrameContentPane.add(backButton);
        //Finalize the Frame
        MenuFrame.setSize(400, 300);
        MenuFrame.setLocationRelativeTo(null);
        MenuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        MenuFrame.setVisible(true);
    }
}
