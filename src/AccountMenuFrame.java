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
 * A class representing the frame that gives users the option to either edit, or delete their accounts.
 * <p>
 * Note that this only provides an option by displaying buttons. Details of edition, or deletion
 * happens in a separate frame when the user clicks the respective button to function.
 *
 * @author Group 022-2
 * @version November 30, 2020
 */

public class AccountMenuFrame extends JOptionPane implements Runnable {
    Socket socket;
    String userId;
    BufferedReader bufferedReader;
    PrintWriter printWriter;
    JFrame accountMenuFrame;
    JButton editAccountButton;
    JButton deleteAccountButton;
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
                SwingUtilities.invokeLater(new AccountProfileFrame(socket, userId));
                accountMenuFrame.dispose();
            }
            if (e.getSource() == editAccountButton) {
                SwingUtilities.invokeLater(new EditAccountFrame(socket, userId));
                accountMenuFrame.dispose();
            }
            if (e.getSource() == deleteAccountButton) {
                int isDelete = JOptionPane.showConfirmDialog(null,
                        "All you sure to delete your account?", "Account delete",
                        JOptionPane.YES_NO_OPTION);
                if (isDelete == JOptionPane.YES_OPTION) {
                    printWriter.println("DeleteOwnAccount");
                    printWriter.println(userId);
                    printWriter.flush();
                    String success = "";
                    try {
                        success = bufferedReader.readLine();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    switch (success) {
                        case "Success" -> {
                            JOptionPane.showMessageDialog(null, "Congratulations! " +
                                            "You have successfully deleted your account!\n" +
                                            "You will be redirected to Login Page.",
                                    "Account deletion Successful", JOptionPane.INFORMATION_MESSAGE);
                            SwingUtilities.invokeLater(new LoginFrame(socket));
                            accountMenuFrame.dispose();
                        }
                        case "Failure" -> JOptionPane.showMessageDialog(null, "Oops!" +
                                        " Unsuccessful deletion. Please check if the userID is valid.",
                                "Delete Account Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    };

    /**
     *
     *
     * @param socket
     * @param userId
     */
    public AccountMenuFrame(Socket socket, String userId) {
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
                    "Unable to initialize in Menu frame", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return;
        }
        accountMenuFrame = new JFrame("Account Menu Frame");
        Container AccountMenuFrameContentPane = accountMenuFrame.getContentPane();
        AccountMenuFrameContentPane.setLayout(null);
        editAccountButton = new JButton("Edit Account");
        deleteAccountButton = new JButton("Delete Account");
        backButton = new JButton("Back to Menu Frame");
        //Set component location
        editAccountButton.setBounds(120, 50, 160, 30);
        deleteAccountButton.setBounds(120, 100, 160, 30);
        backButton.setBounds(120, 150, 160, 30);

        //Add actionLister
        editAccountButton.addActionListener(actionListener);
        deleteAccountButton.addActionListener(actionListener);
        backButton.addActionListener(actionListener);

        //Add all components into the Frame;
        AccountMenuFrameContentPane.add(editAccountButton);
        AccountMenuFrameContentPane.add(deleteAccountButton);
        AccountMenuFrameContentPane.add(backButton);
        //Finalize the Frame
        accountMenuFrame.setSize(400, 300);
        accountMenuFrame.setLocationRelativeTo(null);
        accountMenuFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        accountMenuFrame.addWindowListener(new WindowAdapter() {
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
                    accountMenuFrame.dispose();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        accountMenuFrame.setVisible(true);
    }
}
