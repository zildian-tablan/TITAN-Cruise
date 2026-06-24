
package com.mycompany.titanproj;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import static com.mycompany.titanproj.TitanCInfo.arrivalDates;
import static com.mycompany.titanproj.TitanCInfo.departureDates;
import static com.mycompany.titanproj.TitanCInfo.destinations;
import static com.mycompany.titanproj.TitanCInfo.ports;
import java.util.ArrayList;

public class TitanAdminIt extends JFrame implements ActionListener{
    private JComboBox<String> cruiseComboBox;
    private JTable itineraryTable;
    private Map<String, Object[][]> cruiseDetails;
     private TitanLogin2 loginReference;
     JButton homeButton;
    JLabel tlabel;
     JPanel tpanel = new JPanel();
ImageIcon tlogo = new ImageIcon("titanimages/newtitanlogo.jpg");
     JButton editButton;
     JButton backButton = new JButton("Back");
     
     
    private int consecutiveTitanLogin2Failures = 0;
    private static final int MAX_CONSECUTIVE_FAILURES = 3;
    private static java.util.List<TitanBlock> blockedTitanUsers = new ArrayList<>();
      private TitanReviewM userReviewManager;
    private TitanAdmin adminMenu;

    public java.util.List<TitanBlock> getTitanBlocks() {
        return blockedTitanUsers;
    }
    String pass;

    public TitanAdminIt() {
    // Initializations
    String[] cruiseNames = TitanCInfo.cruiseNames;
    String[][] destinations = TitanCInfo.destinations;
    String[] departures = TitanCInfo.departureDates;
    String[][] arrivals = TitanCInfo.arrivalDates;
    
    String[] ports = TitanCInfo.ports;

    // Initialization of components
    setTitle("T.I.T.A.N  Admin");
    setSize(980, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setIconImage(tlogo.getImage());
    setResizable(false);
    setLocationRelativeTo(null);
    setVisible(true);
    JButton editbttn = new JButton("Edit");
    
    tpanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        tpanel.setLayout(new BorderLayout());
        tpanel.setBackground(Color.LIGHT_GRAY);
        //tframe.add(tpanel, BorderLayout.NORTH);

        // Create a label for the title
        tlabel = new JLabel("T.I.T.A.N. <Itinerary>");
        tlabel.setFont(new Font("Times New Roman", Font.BOLD, 25));

        // Create a panel for the label to center it
        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        labelPanel.setBackground(Color.LIGHT_GRAY);
        labelPanel.add(tlabel);
       // tpanel.add(labelPanel, BorderLayout.CENTER);

        // Create a "Home" button and add it to the top panel on the right side
        homeButton = new JButton("Home");
        homeButton.setFont(new Font("Arial", Font.PLAIN, 10));
        homeButton.setPreferredSize(new Dimension(80, 20));
        homeButton.addActionListener( this);
        homeButton.setFocusable(false);
        homeButton.setBackground(Color.LIGHT_GRAY);
    
        
    JPanel mpanel = new JPanel(new BorderLayout());
    mpanel.setBorder(BorderFactory.createEmptyBorder(65, 65, 65, 65));
    mpanel.setBackground(Color.decode("#f0f8ff"));

    JPanel slpanel = new JPanel();
    JLabel selectLabel = new JLabel("Select Cruise: ");
    cruiseComboBox = new JComboBox<>(cruiseNames);

    JPanel npanel = new JPanel(new BorderLayout());
    npanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

    cruiseDetails = new HashMap<>();
    for (int i = 0; i < cruiseNames.length; i++) {
        cruiseDetails.put(cruiseNames[i], generateData(i));
    }

    //String[] columnNames = {"Port", "Destination", "Departure", "Arrival", "Days", "Date"};
    //DefaultTableModel model = new DefaultTableModel(cruiseDetails.get("Cruise 1"), columnNames);
       String[] columnNames = {"Port", "Destination", "Departure Date", "Arrival Date"};
    DefaultTableModel model = new DefaultTableModel(new Object[][]{}, columnNames);
    itineraryTable = new JTable(model);

    itineraryTable.setFont(new Font("Arial", Font.PLAIN, 14));
    itineraryTable.setRowHeight(30);

    for (int i = 0; i < columnNames.length; i++) {
        itineraryTable.getColumnModel().getColumn(i).setPreferredWidth(120);
    }

    JScrollPane scrlpane = new JScrollPane(itineraryTable);
    scrlpane.setPreferredSize(new Dimension(700, 300));

    // Adding components
    add(tpanel, BorderLayout.NORTH);
        tpanel.add(labelPanel, BorderLayout.CENTER);
        tpanel.add(homeButton, BorderLayout.EAST);
    npanel.add(scrlpane, BorderLayout.CENTER);
    slpanel.add(selectLabel);
    slpanel.add(cruiseComboBox);
    slpanel.add(editbttn);
    mpanel.add(slpanel, BorderLayout.NORTH);
    mpanel.add(npanel, BorderLayout.CENTER);
    
    add(mpanel);
    
 
    cruiseComboBox.addActionListener(e -> cruiseComboBoxActionPerformed());
    editbttn.addActionListener(e -> editButtonActionPerformed());
}

// Action performed methods
private void backButtonActionPerformed() {
    dispose();
    new TitanAdmin(blockedTitanUsers, loginReference,  userReviewManager);
    
}

private void cruiseComboBoxActionPerformed() {
    displaySelectedCruise();
   
}

private void editButtonActionPerformed() {
    editDetails();
  
}
    

   private static Object[][] generateData(int cruiseIndex) {
         SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
        Object[][] data = new Object[destinations[cruiseIndex].length][4];
        try {
            for (int i = 0; i < destinations[cruiseIndex].length; i++) {
                data[i][0] = ports[cruiseIndex];
                data[i][1] = destinations[cruiseIndex][i];
                data[i][2] = departureDates[cruiseIndex];
                data[i][3] = arrivalDates[cruiseIndex][i];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

   /* private void displaySelectedCruise() {
        String selectedCruise = (String) cruiseComboBox.getSelectedItem();
        DefaultTableModel model = new DefaultTableModel(cruiseDetails.get(selectedCruise), new String[]{"Port", "Destination", "Departure", "Arrival", "Days", "Date"});
        itineraryTable.setModel(model);
    }*/
    private void displaySelectedCruise() {
    String selectedCruise = (String) cruiseComboBox.getSelectedItem();
    Object[][] updatedData = TitanCInfo.getTitanCInfo(selectedCruise);
    DefaultTableModel model = new DefaultTableModel(updatedData, new String[]{"Port", "Destination", "Departure Date", "Arrival Date"});
    itineraryTable.setModel(model);
}

    // Modify the editDetails method in TitanAdmin
private void editDetails() {
    int selectedRow = itineraryTable.getSelectedRow();
    if (selectedRow != -1) {
        String selectedCruise = (String) cruiseComboBox.getSelectedItem();
        Object[][] data = cruiseDetails.get(selectedCruise);

        // Pass the selected row index and cruise name to the EditDialog
        openEditDialog(selectedRow, selectedCruise);
    } else {
        JOptionPane.showMessageDialog(this, "Please select a row to edit.");
    }
}

// Add a method to open the EditDialog with updated data
private void openEditDialog(int rowIndex, String cruiseName) {
    Object[][] updatedData = TitanCInfo.getTitanCInfo(cruiseName);

    // Pass the current row data to the EditDialog
    EditDialog editDialog = new EditDialog(this, updatedData[rowIndex]);
    editDialog.setVisible(true);
}

    @Override
    public void actionPerformed(ActionEvent ae) {
       String Bookcommand = ae.getActionCommand();
         
         switch(Bookcommand){
             case "Home":
                 dispose();
                 new TitanAdmin(blockedTitanUsers,loginReference,userReviewManager);
                 break;
         }
    }

    class EditDialog extends JDialog {
        private JTextField[] fields;
        private JButton saveButton, cancelButton;
        /* public void updateFields(Object[] updatedRowData) {
        for (int i = 0; i < fields.length; i++) {
            fields[i].setText(updatedRowData[i].toString());
        }
    }*/

        public EditDialog(JFrame parent, Object[] rowData) {
            super(parent, "Edit Details", true);
            setSize(400, 300);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setLocationRelativeTo(parent);
            setLayout(new GridLayout(7, 2, 10, 10));

              String[] labels = {"Port", "Destination", "Departure Date", "Arrival Date"};
            fields = new JTextField[labels.length];

            for (int i = 0; i < labels.length; i++) {
                add(new JLabel(labels[i]));
                fields[i] = new JTextField(rowData[i].toString());
                add(fields[i]);
            }

            saveButton = new JButton("Save");
         saveButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        int selectedRow = itineraryTable.getSelectedRow();
        if (selectedRow != -1) {
            for (int i = 0; i < fields.length; i++) {
                rowData[i] = fields[i].getText();
            }

            // Update the cruiseData directly with modified data
            String selectedCruise = (String) cruiseComboBox.getSelectedItem();
            Object[][] cruiseData = TitanCInfo.getTitanCInfo(selectedCruise);
            cruiseData[selectedRow] = Arrays.copyOf(rowData, rowData.length);
            TitanCInfo.updateTitanCInfo(selectedCruise, cruiseData);

            // Refresh the table with the updated data
            displaySelectedCruise();
            dispose(); // Close the dialog after saving
        }
    }
});
            cancelButton = new JButton("Cancel");
            cancelButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose(); // Close the dialog without saving
                }
            });

            add(saveButton);
            add(cancelButton);
        }
    }
}
