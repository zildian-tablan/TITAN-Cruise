
package com.mycompany.titanproj;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TitanCruiseIt extends JFrame implements ActionListener{
    private JComboBox<String> cruiseComboBox;
    private JTable itineraryTable;
    ImageIcon tlogo = new ImageIcon("titanimages/newtitanlogo.jpg");
     JButton homeButton;
    JLabel tlabel;
     JPanel tpanel = new JPanel();

    String pass;
    String ages;

  public TitanCruiseIt(String password) {
      
      pass=password;
    // Initializations
    String[] cruiseNames = TitanCInfo.cruiseNames;
    String[][] destinations = TitanCInfo.destinations;
    String[] departures = TitanCInfo.departureDates;
    String[][]arrivals = TitanCInfo.arrivalDates;
    
    String[] ports = TitanCInfo.ports;

    // Initialization of components
    setTitle("TITAN");
    setSize(980, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setIconImage(tlogo.getImage());
    setResizable(false);
    
    // Creating main panel
    JPanel mainp = new JPanel(new BorderLayout());
    mainp.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
    mainp.setBackground(Color.decode("#f0f8ff"));

    // Back button setup
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
    
    
    // Creating and setting up selection panel
    JPanel scrollp = new JPanel();
    JLabel selectLabel = new JLabel("Select Cruise: ");
    cruiseComboBox = new JComboBox<>(cruiseNames);
   
    // Creating nested panel
    JPanel npanel = new JPanel(new BorderLayout());
    npanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

    // Table setup
   String[] columnNames = {"Port", "Destination", "Departure Date", "Arrival Date"};
    DefaultTableModel model = new DefaultTableModel(new Object[][]{}, columnNames);
    itineraryTable = new JTable(model);

    itineraryTable.setFont(new Font("Arial", Font.PLAIN, 14));
    itineraryTable.setRowHeight(30);

    for (int i = 0; i < columnNames.length; i++) {
        itineraryTable.getColumnModel().getColumn(i).setPreferredWidth(120);
    }

    JScrollPane Pane = new JScrollPane(itineraryTable);
    Pane.setPreferredSize(new Dimension(700, 300));
    
    add(tpanel, BorderLayout.NORTH);
        tpanel.add(labelPanel, BorderLayout.CENTER);
        tpanel.add(homeButton, BorderLayout.EAST);
    scrollp.add(selectLabel);
    scrollp.add(cruiseComboBox);
    npanel.add(Pane, BorderLayout.CENTER);
    mainp.add(scrollp, BorderLayout.NORTH);
    mainp.add(npanel, BorderLayout.CENTER);
   
    add(mainp);
    setVisible(true);

    
    cruiseComboBox.addActionListener(e -> cruiseComboBoxActionPerformed());
    
}

// Action performed methods
private void backButtonActionPerformed() {
    dispose();
    new TitanProj(pass);
}

private void cruiseComboBoxActionPerformed() {
    displaySelectedCruise();
}



    private void displaySelectedCruise() {
        String selectedCruise = (String) cruiseComboBox.getSelectedItem();
        Object[][] updatedData = TitanCInfo.getTitanCInfo(selectedCruise);
        DefaultTableModel model = new DefaultTableModel(updatedData, new String[]{"Port", "Destination", "Departure Date", "Arrival Date"});
        itineraryTable.setModel(model);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
       String Bookcommand = ae.getActionCommand();
         
         switch(Bookcommand){
             case "Home":
                 dispose();
                 new TitanProj(pass);
                 break;
         }
    }
}

