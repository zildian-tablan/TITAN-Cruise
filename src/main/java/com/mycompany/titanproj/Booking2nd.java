
package com.mycompany.titanproj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Booking2nd implements ActionListener {
     JFrame tframe;
     JPanel tpanel;
     JLabel tlabel;
     JButton homeButton;
     JButton bookButton;
     JComboBox<String> genderComboBox, portCombobox,dest,dept,dept1,cabintype,cabinnum;
     JTextField ageField,tpayment;
    ImageIcon tlogo = new ImageIcon("titanimages/newtitanlogo.jpg");
     String payment;
     JTextField bname,bemail;
     String name,email;
     String pass;

    public Booking2nd(String password) {
        
        pass=password;
        
        // Create the main frame
        tframe = new JFrame("T.I.T.A.N. Booking");
        tframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tframe.setIconImage(tlogo.getImage()); // Set the icon of the JFrame
        tframe.setSize(980, 600);
        tframe.setResizable(false);
        tframe.getContentPane().setBackground(new Color(173, 216, 230));
        tframe.setLocationRelativeTo(null);

        // Create a top panel
        tpanel = new JPanel();
        tpanel.setBackground(Color.LIGHT_GRAY); // Set the background color to light gray
        tpanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        tpanel.setLayout(new BorderLayout());
        tframe.add(tpanel, BorderLayout.NORTH);

        // Create a label for the title
        tlabel = new JLabel("T.I.T.A.N. <Norwegian Encore>");
        tlabel.setFont(new Font("Times New Roman", Font.BOLD, 25));

        // Create a panel for the label to center it
        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        labelPanel.setBackground(Color.LIGHT_GRAY);
        labelPanel.add(tlabel);
        tpanel.add(labelPanel, BorderLayout.CENTER);

        // Create a "Home" button and add it to the top panel on the right side
        homeButton = new JButton("Home");
        homeButton.setFont(new Font("Arial", Font.PLAIN, 10));
        homeButton.setPreferredSize(new Dimension(80, 20));
        homeButton.addActionListener(this);
        homeButton.setBackground(Color.LIGHT_GRAY);
        tpanel.add(homeButton, BorderLayout.EAST);

        // Create input fields for user information
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(10, 1, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        //port
        inputPanel.add(new JLabel("Port:"));
        String[] ports= {"Cebu(PHCEB)"};
        portCombobox = new JComboBox<>(ports);
        inputPanel.add(portCombobox);
        
        // Destination
        inputPanel.add(new JLabel("Destination:"));
        String[] destin={"Malaysia(MYPGU)","Thailand(THLCH)", "Australia(AUMEL)"};
        dest = new JComboBox<>(destin);
        inputPanel.add(dest);
        
        inputPanel.add(new JLabel("Departure Date:"));
        String[] ddate ={"December 12, 2023","January 18, 2024","February 4, 2024"};
        dept = new JComboBox<>(ddate);
        inputPanel.add(dept);
        
        inputPanel.add(new JLabel("Name:"));
        bname = new JTextField();
        bname.setText(name);
        bname.setBackground(Color.WHITE);
        bname.setVisible(true);
        inputPanel.add(bname);

        inputPanel.add(new JLabel("Email:"));
        bemail = new JTextField();
        bemail.setText(email);
        bemail.setBackground(Color.WHITE);
        bemail.setVisible(true);
        inputPanel.add(bemail);
        
        inputPanel.add(new JLabel("Cabin Place:"));
        String[] cabplace = {"Regular","OceanView"};
        cabintype = new JComboBox<>(cabplace);
        inputPanel.add(cabintype);
        
        inputPanel.add(new JLabel("Number of Passenger:"));
        String[] cabnum = {"1-2","3-5","6-12"};
        cabinnum = new JComboBox<>(cabnum);
        inputPanel.add(cabinnum);
        
     
        inputPanel.add(new JLabel("Price:"));
        tpayment = new JTextField();
        tpayment.setText(payment);
        tpayment.setEditable(false);
        inputPanel.add(tpayment);
        
        ActionListener comboListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePayment();
            }
        };
        dest.addActionListener(comboListener);
        cabinnum.addActionListener(comboListener);

        // Initialize payment based on the default selected values
         updatePayment();

        tframe.add(inputPanel, BorderLayout.CENTER);

        // Create a "Book Now" button and add it to the bottom of the frame
        bookButton = new JButton("Submit");
        bookButton.setFont(new Font("Arial", Font.PLAIN, 15));
        bookButton.setPreferredSize(new Dimension(120, 40));
        bookButton.addActionListener(this);
        tframe.add(bookButton, BorderLayout.SOUTH);
        
     /*   JPanel createMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.LIGHT_GRAY);

        mainPanel.add(tpanel2);
        
        return mainPanel;
    }*/
        
        // Set the frame visible
        tframe.setVisible(true);
       
    }
    private void updatePayment() {
        // Get the selected items from both JComboBoxes
        String selectedDestination = (String) dest.getSelectedItem();
        String selectedCabin = (String) cabinnum.getSelectedItem();
        String selectedCabin2 = (String) cabinnum.getSelectedItem();
        String selectedCabin3 = (String) cabinnum.getSelectedItem();
        

        // Update payment based on both the selected destination and number of passengers
        if ("Malaysia(MYPGU)".equals(selectedDestination)) {
            switch (selectedCabin) {
                case "1-2":
                    tpayment.setText("74,340");
                    break;
                case "3-5":
                    tpayment.setText("157,450");
                    break;
                case "6-12":
                    tpayment.setText("269,000");
                    break;
                default:
                    // Handle unknown selection
                    tpayment.setText("0");
            }
        } else if ("Thailand(THLCH)".equals(selectedDestination)) {
            switch (selectedCabin2) {
                case "1-2":
                    tpayment.setText("80,000");
                    break;
                case "3-5":
                    tpayment.setText("196,900");
                    break;
                case "6-12":
                    tpayment.setText("349,560");
                    break;
                default:
                    // Handle unknown selection
                    tpayment.setText("0");
            }
           
        } else if ("Australia(AUMEL)".equals(selectedDestination)) {
            switch (selectedCabin3) {
                case "1-2":
                    tpayment.setText("134,000");
                    break;
                case "3-5":
                    tpayment.setText("292,465");
                    break;
                case "6-12":
                    tpayment.setText("432,000");
                    break;
                default:
                    // Handle unknown selection
                    tpayment.setText("0");
            }
        }
    }

    @Override
public void actionPerformed(ActionEvent e) {

    String command = e.getActionCommand();
    switch (command) {

        case "Home":
            tframe.dispose();
            TitanProj titanProj = new TitanProj(pass);
            break;

        case "Submit":
            if (validateInput()) {
            JPasswordField confirmation = new JPasswordField(JOptionPane.showInputDialog("Enter your Password: "));
            String night = pass;
            String light = new String(confirmation.getPassword()); // Use String constructor to convert char[] to String
            if (night.equals(light)) {
                tframe.dispose();
                String rname = (bname != null) ? bname.getText() : "";
                String remail = (bemail != null) ? bemail.getText() : "";
                String port = (portCombobox != null) ? (String) portCombobox.getSelectedItem() : "";
                String traveldate = (dept != null) ? (String) dept.getSelectedItem() : "";
                String destination = (dest != null) ? (String) dest.getSelectedItem() : "";
                String cabt = (cabintype != null) ? (String) cabintype.getSelectedItem() : "";
                String cabn = (cabinnum != null) ? (String) cabinnum.getSelectedItem() : "";
                String payments = (tpayment != null) ? tpayment.getText() : "";
                String password = pass;

                String cruiseid = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
                Random randid = new Random();
                StringBuilder random2 = new StringBuilder(10);
                for (int i = 0; i < 10; i++) {
                    random2.append(cruiseid.charAt(randid.nextInt(cruiseid.length())));
                }
                String id = random2.toString();
                new TitanReceipt2(rname, remail, port, destination, traveldate, payments, cabt, cabn, id,password);
            } else if(!night.equals(light)) {
                JOptionPane.showMessageDialog(tframe, "Authorization Failed:\nPlease Input Correct Password or Ensure you Input a Password", "Authorization", JOptionPane.ERROR_MESSAGE);
            }
            }else {
                JOptionPane.showMessageDialog(tframe, "Please fill out all fields before submitting.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            }
            break;
    }
}
private boolean validateInput() {
    // Check if all required fields are filled
    return !bname.getText().isEmpty() &&
            !bemail.getText().isEmpty() &&
            !((String) portCombobox.getSelectedItem()).isEmpty() &&
            !((String) dept.getSelectedItem()).isEmpty() &&
            !((String) dest.getSelectedItem()).isEmpty() &&
            !((String) cabintype.getSelectedItem()).isEmpty() &&
            !((String) cabinnum.getSelectedItem()).isEmpty();
}

    
}
    