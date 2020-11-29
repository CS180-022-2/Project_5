import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.*;

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

    public AccountProfileFrame(Socket socket, String userId) {
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
        profileButton.setBounds(120, 100 , 150, 30);
        backButton.setBounds(120,150, 150, 30);

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
        accountProfileFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        accountProfileFrame.setVisible(true);
    }
}