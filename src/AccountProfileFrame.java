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
 * A class representing the frame that serves as an intermediary for creation, edition, and deletion of
 * both user account and profile.
 * <p>
 * When the user wants to edit or delete their account, they can click "Account" button
 * and vice versa for their profile.
 *
 * @author Group 022-2
 * @version November 30, 2020
 */
public class AccountProfileFrame extends JOptionPane implements Runnable {
    Socket socket;
    String userId;
    BufferedReader bufferedReader;
    PrintWriter printWriter;
    JFrame accountProfileFrame;
    JButton profileButton;
    JButton accountButton;
    JButton backButton;

    ActionListener actionListener = new ActionListener() {
        /**
         *
         *
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == backButton) {
                SwingUtilities.invokeLater(new UserFrame(socket, userId));
                accountProfileFrame.dispose();
            }
            if (e.getSource() == profileButton) {
                SwingUtilities.invokeLater(new ProfileMenuFrame(socket, userId));
                accountProfileFrame.dispose();
            }
            if (e.getSource() == accountButton) {
                SwingUtilities.invokeLater(new AccountMenuFrame(socket, userId));
                accountProfileFrame.dispose();
            }
        }
    };

    /**
     *
     *
     * @param socket
     * @param userId
     */
    public AccountProfileFrame(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    /**
     *
     */
    @Override
    public void run() {
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Unable to initialize in the frame", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return;
        }
        accountProfileFrame = new JFrame("Menu Frame");
        Container AccountProfileContentPane = accountProfileFrame.getContentPane();
        AccountProfileContentPane.setLayout(null);
        accountButton = new JButton("Account");
        profileButton = new JButton("Profile");
        backButton = new JButton("Back to User Frame");
        //Set component location
        accountButton.setBounds(120, 50, 150, 30);
        profileButton.setBounds(120, 100, 150, 30);
        backButton.setBounds(120, 150, 150, 30);

        //Add actionLister
        accountButton.addActionListener(actionListener);
        profileButton.addActionListener(actionListener);
        backButton.addActionListener(actionListener);

        //Add all components into the Frame;
        AccountProfileContentPane.add(accountButton);
        AccountProfileContentPane.add(profileButton);
        AccountProfileContentPane.add(backButton);
        //Finalize the Frame
        accountProfileFrame.setSize(400, 300);
        accountProfileFrame.setLocationRelativeTo(null);
        accountProfileFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        accountProfileFrame.addWindowListener(new WindowAdapter() {
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
                    accountProfileFrame.dispose();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        accountProfileFrame.setVisible(true);
    }
}