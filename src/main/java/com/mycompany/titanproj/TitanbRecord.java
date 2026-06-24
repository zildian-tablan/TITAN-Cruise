
package com.mycompany.titanproj;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TitanbRecord implements ActionListener {
    JFrame tframe;
    JPanel tpanel;
    JButton homeButton;
    JButton cancelButton;
    JLabel tlabel;
    JLabel messageLabel = new JLabel("Select the row you want to cancel before clicking the Cancel button");
    ImageIcon tlogo = new ImageIcon("titanimages/newtitanlogo.jpg");
    JTable table;
    DefaultTableModel tableModel;
    String rname, tdate, rid;
    String status = "Booked";
    String pass;
    String admin;
    String ages;
    private static java.util.List<TitanBlock> blockedTitanUsers = new ArrayList<>();
      private TitanReviewM userReviewManager;
      private TitanLogin2 loginReference;
    // Static list to store data
    private static List<Object[]> dataList = new ArrayList<>();

    public TitanbRecord(String password) {
        
        pass=password;
        System.out.println(pass);
        tframe = new JFrame("T.I.T.A.N. Records");
        tframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tframe.setIconImage(tlogo.getImage());
        tframe.setSize(980, 600);
        tframe.setResizable(false);
        tframe.getContentPane().setBackground(new Color(173, 216, 230));
        tframe.setLocationRelativeTo(null);

        tpanel = new JPanel();
        tpanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        tpanel.setLayout(new BorderLayout());
        tpanel.setBackground(Color.LIGHT_GRAY);

        tlabel = new JLabel("T.I.T.A.N. <RECORDS>");
        tlabel.setFont(new Font("Times New Roman", Font.BOLD, 25));

        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        labelPanel.setBackground(Color.LIGHT_GRAY);
        labelPanel.add(tlabel);
        
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setForeground(Color.RED);

        homeButton = new JButton("Home");
        homeButton.setFont(new Font("Arial", Font.PLAIN, 10));
        homeButton.setPreferredSize(new Dimension(80, 20));
        homeButton.addActionListener(this);
        homeButton.setFocusable(false);
        homeButton.setBackground(Color.LIGHT_GRAY);
        
        cancelButton = new JButton("Cancel Booking");
        cancelButton.setFont(new Font("Arial", Font.PLAIN, 10));
        cancelButton.setPreferredSize(new Dimension(120, 20));
        cancelButton.addActionListener(this);
        cancelButton.setFocusable(false);
        cancelButton.setBackground(Color.LIGHT_GRAY);
        

        tpanel.add(labelPanel, BorderLayout.CENTER);
        tpanel.add(homeButton, BorderLayout.EAST);
        tpanel.add(cancelButton,BorderLayout.WEST);
        tframe.add(tpanel, BorderLayout.NORTH);

        // Create a table model with column names
        String[] columnNames = {"Booking ID", "Name", "Travel Date", "Status"};
        tableModel = new DefaultTableModel(columnNames, 0);
        

        // Load data from the list on initialization
        for (Object[] rowData : dataList) {
            tableModel.addRow(rowData);
        }

        // Create a JTable with the created table model
        table = new JTable(tableModel);

        // Create a JScrollPane to contain the table
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the frame
        tframe.add(scrollPane, BorderLayout.CENTER);

        tframe.setVisible(true);
    }

    public void recordholder(String name, String traveldate, String bookid,String password) {
        rname = name;
        tdate = traveldate;
        rid = bookid;
        pass=password;

        SwingUtilities.invokeLater(() -> {
            Object[] rowData = {rid, rname, tdate, status};
            tableModel.addRow(rowData);
            dataList.add(rowData); // Add data to the static list
        });
    }
    public void arecordholder(String adminhome) {
        admin = adminhome;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String homec = ae.getActionCommand();
        
        if(admin!="12345")
        {
             if (ae.getSource() == homeButton) {
            tframe.dispose();
            TitanProj titanProj = new TitanProj(pass); // You should handle this based on your application's structure
        } else if (ae.getSource() == cancelButton) {
            // Check if a row is selected
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                // Show a confirmation dialog
                int dialogResult = JOptionPane.showConfirmDialog(tframe, "Are you sure you want to cancel this booking?", "Confirmation", JOptionPane.YES_NO_OPTION);

                if (dialogResult == JOptionPane.YES_OPTION) {
                    // User confirmed the cancellation
                    // Remove the selected row from the table
                    tableModel.removeRow(selectedRow);
                    // Remove the corresponding data from the data list
                    dataList.remove(selectedRow);
                    // Clear the message label
                    messageLabel.setText("Booking canceled successfully.");
                }
            } else {
                // Display an error message
                messageLabel.setText("Select the row you want to cancel before clicking the Cancel button");
                JOptionPane.showMessageDialog(tframe, "Please select a booking to cancel.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
        
        else if(admin.equals("12345")){
             if (ae.getSource() == homeButton) {
            tframe.dispose();
           new TitanAdmin(blockedTitanUsers,loginReference,userReviewManager); // You should handle this based on your application's structure
        } else if (ae.getSource() == cancelButton) {
            // Check if a row is selected
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                // Show a confirmation dialog
                int dialogResult = JOptionPane.showConfirmDialog(tframe, "Are you sure you want to cancel this booking?", "Confirmation", JOptionPane.YES_NO_OPTION);

                if (dialogResult == JOptionPane.YES_OPTION) {
                    // User confirmed the cancellation
                    // Remove the selected row from the table
                    tableModel.removeRow(selectedRow);
                    // Remove the corresponding data from the data list
                    dataList.remove(selectedRow);
                    // Clear the message label
                    messageLabel.setText("Booking canceled successfully.");
                }
            } else {
                // Display an error message
                messageLabel.setText("Select the row you want to cancel before clicking the Cancel button");
                JOptionPane.showMessageDialog(tframe, "Please select a booking to cancel.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
            
        
    }

}
