import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class UserFrame extends JComponent implements Runnable {
    Socket socket;
    BufferedReader bufferedReader;
    PrintWriter printWriter;
    String userId;

<<<<<<< Updated upstream
=======
    String[] columnName = {"Name", "ID", "About me "};
    String[][] rowData;

    DefaultTableModel model;
    JTable jTable = new JTable(model);
    JFrame userFrame;
    TableRowSorter<TableModel> rowSorter;
    JTextField jtfFilter;
    JScrollPane jScrollPane;
    JButton add;
    JButton account;
    JButton back;

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == back) {
                SwingUtilities.invokeLater(new LoginFrame(socket));
                userFrame.dispose();
            }
            if (e.getSource() == add) {}
        }
    };

>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
=======
        //Initialize the 
        printWriter.println("GetFriendList");
        printWriter.println(userId);
        printWriter.flush();
        try {
            int i = Integer.parseInt(bufferedReader.readLine());
            rowData = new String[i][3];
            for (int j = 0; j < i; j++ ) {
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
        model = new DefaultTableModel(rowData, columnName);
        rowSorter = new TableRowSorter<>(jTable.getModel());
        jtfFilter = new JTextField(10);
        userFrame = new JFrame("User Frame");
        userFrame.setLayout(new BorderLayout());
        jTable.setRowSorter(rowSorter);
        JPanel panel = new JPanel();
        JPanel panel3 = new JPanel();
        add = new JButton("Add Friend");
        account = new JButton("Edit Profile and Account");
        back = new JButton("Back to Menu");
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
        back.addActionListener(actionListener);

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
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userFrame.setLocationRelativeTo(null);
        userFrame.setVisible(true);
>>>>>>> Stashed changes
    }
}