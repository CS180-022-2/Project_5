import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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


public class AddFriendFrame extends JPanel implements Runnable {

    private  final String[] columnName = {"Name", "ID", "About Me"};

    JFrame addFriendFrame;
    JButton back;
    JScrollPane jScrollPane;
    JScrollPane jScrollPane2;
    JScrollPane jScrollPane3;

    JPanel panel;

    JMenuItem accept;
    JMenuItem deny;

    DefaultTableModel allUserModel;
    DefaultTableModel requestModel;
    DefaultTableModel pendingModel;

    JTable jTable;
    JTable jTable2;
    JTable jTable3;
    TableRowSorter<TableModel> rowSorter;
    JTextField jtfFilter;
    JMenuItem sendFriendRequest;
    JMenuItem viewProfile;

    JMenuItem resendRequest;

    Socket socket;
    BufferedReader bufferedReader;
    PrintWriter printWriter;
    String userId;

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == back) {
                SwingUtilities.invokeLater(new UserFrame(socket, userId));
                addFriendFrame.dispose();
            }
            if (e.getSource() == viewProfile) {
                int selectedRow = jTable.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null,
                            "You must first select a line! ", "No selection", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                String profileOwnerId = String.valueOf(jTable.getValueAt(selectedRow, 1));
                SwingUtilities.invokeLater(new ProfileDisplayFrame(socket, userId,
                        profileOwnerId, "AddFriendFrame"));
                addFriendFrame.dispose();
            }
            if (e.getSource() == sendFriendRequest) {
                int selectedRow = jTable.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null,
                            "You must first select a line! ", "No selection", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                String friendId = String.valueOf(jTable.getValueAt(selectedRow, 1));
                printWriter.println("RequestFriend");
                printWriter.println(userId);
                printWriter.println(friendId);
                printWriter.flush();
                String result = null;
                try {
                    result = bufferedReader.readLine();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    JOptionPane.showMessageDialog(null,
                            "Buffer reader error in request Friend",
                            "Request Friend Error", JOptionPane.ERROR_MESSAGE);
                }
                if (result != null) {
                    if (result.equals("RequestSuccess")) {
                        JOptionPane.showMessageDialog(null,
                                "You have successfully request a friend",
                                "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                result, "Wrong Function", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
            if (e.getSource() == accept) {
                int selectedRow = jTable3.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null,
                            "You must first select a line! ", "No selection", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                String friendId = String.valueOf(jTable3.getValueAt(selectedRow, 1));
                printWriter.println("AcceptFriend");
                printWriter.println(userId);
                printWriter.println(friendId);
                printWriter.flush();
                String result = null;
                try {
                    result = bufferedReader.readLine();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    JOptionPane.showMessageDialog(null,
                            "Buffer reader error in accept Friend request",
                            "Accept Friend Error", JOptionPane.ERROR_MESSAGE);
                }
                if (result.equals("AcceptSuccess")) {
                    JOptionPane.showMessageDialog(null,
                            "You have successfully accept a request",
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null,
                            result, "Wrong Function", JOptionPane.WARNING_MESSAGE);
                }
            }
            if (e.getSource() == deny) {
                int selectedRow = jTable3.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null,
                            "You must first select a line! ", "No selection", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                String friendId = String.valueOf(jTable3.getValueAt(selectedRow, 1));
                printWriter.println("DenyFriend");
                printWriter.println(userId);
                printWriter.println(friendId);
                printWriter.flush();
                String result = null;
                try {
                    result = bufferedReader.readLine();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    JOptionPane.showMessageDialog(null,
                            "Buffer reader error in deny Friend request",
                            "Accept Friend Error", JOptionPane.ERROR_MESSAGE);
                }
                assert result != null;
                if (result.equals("DenySuccess")) {
                    JOptionPane.showMessageDialog(null,
                            "You have successfully deny a request",
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null,
                            result, "Wrong Function", JOptionPane.WARNING_MESSAGE);
                }
            }
            if (e.getSource() == resendRequest) {
                int selectedRow = jTable2.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null,
                            "You must first select a line! ", "No selection", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                String friendId = String.valueOf(jTable2.getValueAt(selectedRow, 1));
                printWriter.println("ResendRequest");
                printWriter.println(userId);
                printWriter.println(friendId);
                printWriter.flush();
                String result = null;
                try {
                    result = bufferedReader.readLine();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    JOptionPane.showMessageDialog(null,
                            "Buffer reader error in deny Friend request",
                            "Accept Friend Error", JOptionPane.ERROR_MESSAGE);
                }
                assert result != null;
                if (result.equals("ResendSuccess")) {
                    JOptionPane.showMessageDialog(null,
                            "You have successfully resend a request",
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                } else if (result.equals("RequestExisted")) {
                    JOptionPane.showMessageDialog(null,
                            "Be patient, you request is received",
                            "Request Existed", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null,
                            result, "Wrong Function", JOptionPane.WARNING_MESSAGE);
                }
            }
            updateAll();
        }
    };
    public AddFriendFrame(Socket socket, String userId) {
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
        allUserModel = updateAllUserModel();
        requestModel = updateRequestModel();
        pendingModel = updatePendingModel();

        jTable = new JTable(allUserModel);
        jTable2 = new JTable(requestModel);
        jTable3 = new JTable(pendingModel);

        rowSorter = new TableRowSorter<>(jTable.getModel());
        jtfFilter = new JTextField(10);

        addFriendFrame = new JFrame("Add Friend");
        jTable.setRowSorter(rowSorter);

        jScrollPane = new JScrollPane(jTable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2 = new JScrollPane(jTable2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane3 = new JScrollPane(jTable3,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        //JPopupMenu on user list
        JPopupMenu popupMenu = new JPopupMenu();
        sendFriendRequest = new JMenuItem("Send Friend Request");
        viewProfile = new JMenuItem("View Profile");
        popupMenu.add(viewProfile);
        popupMenu.add(sendFriendRequest);
        jTable.setComponentPopupMenu(popupMenu);

        //JPopupMenu on pending list
        JPopupMenu popupMenu2 = new JPopupMenu();
        accept = new JMenuItem("Accept");
        deny = new JMenuItem("Deny");
        popupMenu2.add(accept);
        popupMenu2.add(deny);
        jTable2.setComponentPopupMenu(popupMenu2);

        JPopupMenu popupMenu3 = new JPopupMenu();
        resendRequest = new JMenuItem("Resend request");
        popupMenu3.add(resendRequest);
        jTable3.setComponentPopupMenu(popupMenu3);

        JLabel friend = new JLabel("Requested Friend", SwingConstants.CENTER);
        JLabel sentRequest = new JLabel("Pending List", SwingConstants.CENTER);

        //JFrame Design
        addFriendFrame.setLayout(new BorderLayout());
        JPanel top = new JPanel(new FlowLayout());
        back = new JButton("Back");
        top.add(new JLabel("Find a specific friend"));
        top.add(jtfFilter);
        top.add(back);

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
        addFriendFrame.add(panel, BorderLayout.CENTER);

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

        addFriendFrame.pack();
        addFriendFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addFriendFrame.setLocationRelativeTo(null);
        addFriendFrame.setVisible(true);
    }

    public DefaultTableModel updateAllUserModel () {
        String[][] rowData = new String[0][0];
        printWriter.println("GetUserList");
        printWriter.println(userId);
        printWriter.flush();
        String result = null;
        try {
            result = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert result != null;
        if (result.equals("Empty")) {
            rowData = null;
        } else {
            try {
                int i = Integer.parseInt(result);
                rowData = new String[i][3];
                for (int j = 0; j < i; j++) {
                    String name = bufferedReader.readLine();
                    String id = bufferedReader.readLine();
                    String aboutMe = bufferedReader.readLine();
                    rowData[j][0] = name;
                    rowData[j][1] = id;
                    rowData[j][2] = aboutMe;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new DefaultTableModel(rowData, columnName) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }
    public DefaultTableModel updatePendingModel () {
        String[][] rowData = new String[0][0];
        printWriter.println("GetPendingList");
        printWriter.println(userId);
        printWriter.flush();
        String result = null;
        try {
            result = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert result != null;
        if (result.equals("Empty")) {
            rowData = null;

        } else if (result.equals("NotFound")) {
            rowData = null;
            JOptionPane.showMessageDialog(null,
                    "Unable to find Id", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                int i = Integer.parseInt(result);
                rowData = new String[i][3];
                for (int j = 0; j < i; j++) {
                    String name = bufferedReader.readLine();
                    String id = bufferedReader.readLine();
                    String aboutMe = bufferedReader.readLine();
                    rowData[j][0] = name;
                    rowData[j][1] = id;
                    rowData[j][2] = aboutMe;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new DefaultTableModel(rowData, columnName) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }
    public DefaultTableModel updateRequestModel () {
        String[][] rowData = new String[0][0];
        printWriter.println("GetRequestList");
        printWriter.println(userId);
        printWriter.flush();
        String result = null;
        try {
            result = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert result != null;
        if (result.equals("Empty")) {
            rowData = null;

        } else if (result.equals("NotFound")) {
            rowData = null;
            JOptionPane.showMessageDialog(null,
                    "Unable to find Id", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                int i = Integer.parseInt(result);
                rowData = new String[i][3];
                for (int j = 0; j < i; j++) {
                    String name = bufferedReader.readLine();
                    String id = bufferedReader.readLine();
                    String aboutMe = bufferedReader.readLine();
                    rowData[j][0] = name;
                    rowData[j][1] = id;
                    rowData[j][2] = aboutMe;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new DefaultTableModel(rowData, columnName){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }
    public void updateAll() {
        jTable.setModel(updateAllUserModel());
        jTable2.setModel(updateRequestModel());
        jTable3.setModel(updatePendingModel());
        addFriendFrame.repaint();
    }
}