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

    String[] columnName = {"Name", "ID", "About me "};
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
    JPopupMenu actionMenu;

    ActionListener buttonActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == back) {
                SwingUtilities.invokeLater(new LoginFrame(socket));
                userFrame.dispose();
            }
            if (e.getSource() == add) {

            }
        }
    };

    public UserFrame(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    @Override
    public void run() {
        /*
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Unable to initialize", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //Initialize the
        printWriter.println("GetFriendList");
        printWriter.println(userId);
        printWriter.flush();
        String result = null;
        try {
            result = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (result.equals("Empty")) {
            rowData = new String[0][0];

        } else if (result.equals("NotFound")) {
            rowData = new String[0][0];
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
         */
        rowData[0][0] = "Name1";
        rowData[0][1] = "Id1";
        rowData[0][2] = "AboutMe1";
        rowData[1][0] = "Name2";
        rowData[1][1] = "Id2";
        rowData[1][2] = "AboutMe2";
        rowData[2][0] = "Name3";
        rowData[2][1] = "Id3";
        rowData[2][2] = "AboutMe3";
        actionMenu = new JPopupMenu();
        JMenuItem viewProfile = new JMenuItem("View profile");
        JMenuItem deleteFriend = new JMenuItem("Delete Friend");

        model = new DefaultTableModel(rowData, columnName) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTable = new JTable(model);
        rowSorter = new TableRowSorter<>(jTable.getModel());
        userFrame = new JFrame("User Frame");
        userFrame.setLayout(new BorderLayout());
        jTable.setRowSorter(rowSorter);
        JPanel panel = new JPanel();
        JPanel panel3 = new JPanel();
        add = new JButton("Add Friend");
        account = new JButton("Edit Profile and Account");
        back = new JButton("Log Out");
        panel.add(add);
        panel.add(new JLabel("Find a specific friend"));
        panel.add(jtfFilter);
        panel.add(account);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.setVisible(true);


        setLayout(new BorderLayout());
        userFrame.add(panel, BorderLayout.NORTH);
        panel3.add(back);
        userFrame.add(panel3, BorderLayout.SOUTH);
        jScrollPane = new JScrollPane(jTable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.add(jScrollPane, BorderLayout.CENTER);
        panel2.setVisible(true);
        userFrame.add(panel2, BorderLayout.CENTER);
        back.addActionListener(buttonActionListener);

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
        userFrame.pack();
        userFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        userFrame.setLocationRelativeTo(null);
        userFrame.setVisible(true);
    }
}