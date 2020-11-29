import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class UserFrame extends JComponent implements Runnable {
    Socket socket;
    BufferedReader bufferedReader;
    PrintWriter printWriter;
    String userId;

    String[] columnName = {"Name", "ID", "About me"};
    String[][] rowData = new String[3][3];

    DefaultTableModel model;
    JTable jTable;
    JFrame userFrame;
    TableRowSorter<TableModel> rowSorter;
    JTextField jtfFilter = new JTextField(10);
    JScrollPane jScrollPane;
    JButton add;
    JButton account;
    JButton back;
    JPopupMenu popupMenu;
    JMenuItem viewProfile;
    JMenuItem deleteFriend;

    ActionListener popupItemListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JMenuItem menuChoice = (JMenuItem) e.getSource();
            if (menuChoice == viewProfile) {
                int selectedRow = jTable.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null,
                            "You must first select a line! ", "No selection", JOptionPane.WARNING_MESSAGE);
                    return;
                } else {
                    String profileOwnerId = String.valueOf(jTable.getValueAt(selectedRow, 1));
                    SwingUtilities.invokeLater(new ProfileDisplayFrame(socket, userId, profileOwnerId, "UserFrame"));
                    userFrame.dispose();
                }
            }
            if (menuChoice == deleteFriend) {
                int selectedRow = jTable.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null,
                            "You must first select a line! ", "No selection", JOptionPane.WARNING_MESSAGE);
                } else {
                    String deleteFriendId = String.valueOf(jTable.getValueAt(selectedRow, 1));
                    printWriter.println("DeleteFriend");
                    printWriter.println(userId);
                    printWriter.println(deleteFriendId);
                    printWriter.flush();
                    String success = null;
                    try {
                        success = bufferedReader.readLine();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    assert success != null;
                    if (success.equals("Success")) {
                        JOptionPane.showMessageDialog(null,
                                "You have successfully deleted a friend",
                                "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                    JOptionPane.showMessageDialog(null,
                            "Unable to deleteFriend", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    model = updateModel(userId);
                    jTable.setModel(model);
                    jTable.repaint();
                }
            }
        }
    };

    ActionListener buttonActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == back) {
                SwingUtilities.invokeLater(new LoginFrame(socket));
                userFrame.dispose();
            }
            if (e.getSource() == add) {
                SwingUtilities.invokeLater(new AddFriendFrame(socket, userId));
                userFrame.dispose();
            }
            if (e.getSource() == account) {
                SwingUtilities.invokeLater(new AccountMenuFrame(socket, userId));
                userFrame.dispose();
            }
        }
    };

    public UserFrame(Socket socket, String userId) {
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
        //Initialize GUI
        popupMenu = new JPopupMenu();
        viewProfile = new JMenuItem("View profile");
        deleteFriend = new JMenuItem("Delete Friend");

        viewProfile.addActionListener(popupItemListener);
        deleteFriend.addActionListener(popupItemListener);
        popupMenu.add(viewProfile);
        popupMenu.add(deleteFriend);

        model = updateModel(userId);
        jTable = new JTable(model);
        jTable.setComponentPopupMenu(popupMenu);
        rowSorter = new TableRowSorter<>(jTable.getModel());
        userFrame = new JFrame("User Frame");
        userFrame.setLayout(new BorderLayout());
        jTable.setRowSorter(rowSorter);
        JPanel panel = new JPanel();
        JPanel panel3 = new JPanel();
        add = new JButton("Add Friend");
        account = new JButton("Edit Profile and Account");
        back = new JButton("Log Out");
        back.addActionListener(buttonActionListener);
        add.addActionListener(buttonActionListener);
        account.addActionListener(buttonActionListener);

        panel.add(add);
        panel.add(new JLabel("Find a specific friend"));
        panel.add(jtfFilter);
        panel.add(account);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.setVisible(true);
        userFrame.add(panel, BorderLayout.NORTH);
        panel3.add(back);
        userFrame.add(panel3, BorderLayout.SOUTH);
        jScrollPane = new JScrollPane(jTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.add(jScrollPane, BorderLayout.CENTER);
        panel2.setVisible(true);
        userFrame.add(panel2, BorderLayout.CENTER);

        jtfFilter.getDocument().addDocumentListener(new DocumentListener() {
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
        userFrame.pack();
        userFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        userFrame.setLocationRelativeTo(null);
        userFrame.setVisible(true);
    }

    public DefaultTableModel updateModel(String userId) {
        printWriter.println("GetFriendList");
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
}