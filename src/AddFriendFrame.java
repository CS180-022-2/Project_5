import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class AddFriendFrame extends JComponent implements Runnable {
    Socket socket;
    String userId;
    BufferedReader bufferedReader;
    PrintWriter printWriter;
    JFrame addFriendFrame;
    JTable pendingTable;
    JTable requestTable;
    JTable allUserTable;
    JLabel requestLabel;
    JLabel pendingLabel;
    JLabel allUserLabel;
    TableRowSorter<TableModel> allUserRowSorter;
    JTextField jtfFilter = new JTextField(10);
    JScrollPane requestPane;
    JScrollPane allUserPane;
    JScrollPane pendingPane;
    JButton backButton;
    JPopupMenu allUserPopupMenu;
    JPopupMenu requestPopupMenu;
    JPopupMenu pendingPopupMenu;
    JMenuItem resendRequest;
    JMenuItem acceptRequest;
    JMenuItem declineRequest;
    JMenuItem addFriend;
    JMenuItem viewProfileInRequest;
    JMenuItem viewProfileInPending;
    JMenuItem viewProfileInAllUser;
    final String[] allTableColumnName = {"Name", "ID", "About me"};


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
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Unable to initialize in AddFriendFrame", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        addFriendFrame = new JFrame("Add Friend Frame");
        //Initialize popup menu
        allUserPopupMenu = new JPopupMenu();
        requestPopupMenu = new JPopupMenu();
        pendingPopupMenu = new JPopupMenu();
        //Initialize selection
        resendRequest = new JMenuItem();
        acceptRequest = new JMenuItem();
        declineRequest = new JMenuItem();
        addFriend = new JMenuItem();
        viewProfileInRequest = new JMenuItem();
        viewProfileInPending = new JMenuItem();
        viewProfileInAllUser = new JMenuItem();
        //add options to popup menu
        allUserPopupMenu.add(addFriend);
        allUserPopupMenu.add(viewProfileInAllUser);
        pendingPopupMenu.add(acceptRequest);
        pendingPopupMenu.add(declineRequest);
        requestPopupMenu.add(resendRequest);
        requestPopupMenu.add(viewProfileInRequest);
        //Initialize JTable and add set popup menu
        allUserTable = new JTable(updateAllUserModel(userId));
        allUserTable.setComponentPopupMenu(allUserPopupMenu);
        requestTable = new JTable(updateRequestModel(userId));
        requestTable.setComponentPopupMenu(requestPopupMenu);
        pendingTable = new JTable(updatePendingModel(userId));
        pendingTable.setComponentPopupMenu(pendingPopupMenu);
        allUserRowSorter = new TableRowSorter<>(allUserTable.getModel());

        allUserTable.setRowSorter(allUserRowSorter);


        addFriendFrame.pack();
        addFriendFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addFriendFrame.setLocationRelativeTo(null);
        addFriendFrame.setVisible(true);






    }
    public DefaultTableModel updateAllUserModel (String viewerId) {
        String[][] rowData = null;


        return new DefaultTableModel(rowData, allTableColumnName);
    }
    public DefaultTableModel updatePendingModel (String viewerId) {
        String[][] rowData = null;


        return new DefaultTableModel(rowData, allTableColumnName);
    }
    public DefaultTableModel updateRequestModel (String viewerId) {
        String[][] rowData = null;


        return new DefaultTableModel(rowData, allTableColumnName);
    }
}
