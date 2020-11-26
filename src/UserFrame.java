import java.awt.*;
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

    //example data
    String[] columnName = {"Name", "ID", "About me "};
    String[][] rowData =
            {
                    {"Joshua Paik", "joshuatree", "20"},
                    {"Youngjun Yoo", "joon916", "18"},
                    {"Leo Li", "lileo98", "18"},
                    {"Jason Hung", "jasonH12", "18"},
                    {"Derek Sun", "tsunderek", "18"},
                    {"Junwon Choi", "roger22", "17"}
            };

    DefaultTableModel model = new DefaultTableModel(rowData, columnName);
    JTable jTable = new JTable(model);
    TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(jTable.getModel());
    JTextField jtfFilter = new JTextField(10);
    JScrollPane jScrollPane;
    JButton add;
    JButton main;

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
        JFrame userFrame = new JFrame("EasyChat");
        userFrame.setLayout(new BorderLayout());
        jTable.setRowSorter(rowSorter);
        JPanel panel = new JPanel();
        add = new JButton("Add Friend");
        main = new JButton("Main Page");
        panel.add(add);
        panel.add(new JLabel("Find a specific friend"));
        panel.add(jtfFilter);
        panel.add(main);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.setVisible(true);

        setLayout(new BorderLayout());
        userFrame.add(panel, BorderLayout.NORTH);
        jScrollPane = new JScrollPane(jTable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.add(jScrollPane, BorderLayout.CENTER);
        panel2.setVisible(true);
        userFrame.add(panel2, BorderLayout.CENTER);

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
    }
}