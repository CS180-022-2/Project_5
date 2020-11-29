import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class AddFriendFrame2 extends JPanel implements Runnable, ActionListener{

    //Below is example user,friend list
    String[] columnName = {"Name", "ID"};
    Object[][] user = {
            {"Joshua Paik", "josh1234"},
            {"Nathan Choi", "ilovepizza"},
            {"Sehun Kim", "rogerfederer"},
            {"Eric Nam", "singer34"},
            {"Henry Lau", "musicgenius32"},
            {"Sam Hammington", "realman49"},
            {"Minju Kim", "izone20"},
    };

    String[] column2 = {"Name", "ID", "About Me"};
    Object[][] sentFriendList= {
            {"Wendy", "redvelvet34", "singer"},
            {"Bruno Fernandes", "trueplayer20", "soccer player"}
    };

    String[] column3 = {"Name", "ID", "About Me"};
    Object[][] receivedFriend= {
            {"Irene", "redvelvet49", "visual"},
            {"Paul Pogba", "dancingking", "soccer player"},
            {"Swings", "donkatsu", "rapper"}
    };

    JFrame AddFriendFrame;
    JButton back;
    JScrollPane jScrollPane;
    JScrollPane jScrollPane2;
    JScrollPane jScrollPane3;

    JPanel panel;

    JMenuItem accept;
    JMenuItem deny;

    DefaultTableModel model = new DefaultTableModel(user, columnName);
    DefaultTableModel model2 = new DefaultTableModel(sentFriendList, column2);
    DefaultTableModel model3 = new DefaultTableModel(receivedFriend, column3);
    JTable jTable = new JTable(model);
    JTable jTable2 = new JTable(model2);
    JTable jTable3 = new JTable(model3);
    TableRowSorter<TableModel> rowSorter
            = new TableRowSorter<>(jTable.getModel());
    JTextField jtfFilter = new JTextField(10);
    JMenuItem sendFriendRequest;
    JMenuItem removeFriend;
    JMenuItem viewProfile;

    Socket socket;
    BufferedReader bufferedReader;
    PrintWriter printWriter;
    String userId;

    public AddFriendFrame2(Socket socket, String userId) {
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
                    "Unable to initialize", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        AddFriendFrame = new JFrame("Add Friend");
        jTable.setRowSorter(rowSorter);

        jScrollPane = new JScrollPane(jTable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2 = new JScrollPane(jTable2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane3 = new JScrollPane(jTable3,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        //JPopupMenu on user list
        JPopupMenu popupMenu = new JPopupMenu();
        sendFriendRequest = new JMenuItem("Send Friend Request");
        removeFriend = new JMenuItem("Remove From Friend List");
        viewProfile = new JMenuItem("View Profile");
        popupMenu.add(viewProfile);
        popupMenu.add(sendFriendRequest);
        popupMenu.add(removeFriend);
        jTable.setComponentPopupMenu(popupMenu);
        jTable.addMouseListener(new TableMouseLister(jTable));

        //JPopupMenu on pending list
        JPopupMenu popupMenu2 = new JPopupMenu();
        accept = new JMenuItem("Accept");
        deny = new JMenuItem("Deny");
        popupMenu2.add(accept);
        popupMenu2.add(deny);
        jTable2.setComponentPopupMenu(popupMenu2);

        JLabel friend =
                new JLabel("Requested Friend", SwingConstants.CENTER);


        JLabel sentRequest =
                new JLabel("Pending List", SwingConstants.CENTER);

        //JFrame Design
        AddFriendFrame.setLayout(new BorderLayout());
        JPanel top = new JPanel(new FlowLayout());
        back = new JButton("Back");
        top.add(new JLabel("Find a specific friend"));
        top.add(jtfFilter);
        top.add(back);
        //top.add(sentRequest);
        top.setVisible(true);
        panel = new JPanel(new FlowLayout());
        jScrollPane.setPreferredSize(new Dimension(300, 400));
        jScrollPane2.setPreferredSize(new Dimension(300, 400));
        jScrollPane3.setPreferredSize(new Dimension(300, 400));
        JPanel left = new JPanel(new BorderLayout());
        left.add(friend,BorderLayout.NORTH);
        left.add(jScrollPane3, BorderLayout.CENTER);
        left.setVisible(true);
        JPanel center = new JPanel(new BorderLayout());
        center.add(top,BorderLayout.NORTH);
        center.add(jScrollPane, BorderLayout.CENTER);
        center.setVisible(true);
        JPanel right = new JPanel(new BorderLayout());
        right.add(sentRequest, BorderLayout.NORTH);
        right.add(jScrollPane2, BorderLayout.CENTER);
        right.setVisible(true);
        panel.setVisible(true);
        panel.add(left);
        panel.add(center);
        panel.add(right);
        AddFriendFrame.add(panel, BorderLayout.CENTER);

        jtfFilter.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });

        //ActionListener
        back.addActionListener(actionListener);
        accept.addActionListener(actionListener);
        deny.addActionListener(actionListener);
        viewProfile.addActionListener(actionListener);
        sendFriendRequest.addActionListener(actionListener);
        removeFriend.addActionListener(actionListener);

        AddFriendFrame.pack();
        AddFriendFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AddFriendFrame.setLocationRelativeTo(null);
        AddFriendFrame.setVisible(true);
    }
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //JTable table = (JTable)e.getSource();
            if (e.getSource() == back) {
                SwingUtilities.invokeLater(new UserFrame(socket, userId));
                AddFriendFrame.dispose();
            }
            if (e.getSource() == viewProfile) {

            }
            if (e.getSource() == sendFriendRequest) {

            }
            if (e.getSource() == removeFriend) {

            }
            if (e.getSource() == accept) {

            }
            if (e.getSource() == deny) {

            }
        }
    };

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
