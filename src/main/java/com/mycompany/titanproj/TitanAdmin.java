
package com.mycompany.titanproj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TitanAdmin implements ActionListener {
    JLabel tlabel = new JLabel();
    JLabel lb11 = new JLabel("Traveller's Interactive Ticketing and Accommodation Network.");
    JButton cruiseItineraryButton = new JButton("Cruise Itinerary");
    JLabel tlbl = new JLabel("T.I.T.A.N.");
    JButton paymentButton = new JButton("Review & Ratings");
    JButton bookingDetailsButton = new JButton("Booking Records");
 //   JButton helpButton = new JButton("Help");
    JButton exitButton = new JButton("Exit");
    JButton blockedAccountButton = new JButton("Blocked Account");
    JLabel lbbackground = new JLabel(new ImageIcon("titanimages/tbg.jfif"));
        ImageIcon tlogo = new ImageIcon("titanimages/newtitanlogo.jpg");
    JFrame tframe = new JFrame();
    JPanel tpanel = new JPanel();
    String adminhome="12345";
    String pass;
    String admin;
    String ages;

    private List<TitanBlock> blockedUsers;
    private TitanLogin2 loginReference;
    private TitanReviewM userReviewManager;
    //private TitanAdminRec record;

    public TitanAdmin(List<TitanBlock> blockedUsers, TitanLogin2 loginReference, TitanReviewM userReviewManager ) {
        this.blockedUsers = blockedUsers;
        this.loginReference = loginReference;
        this.userReviewManager = TitanReviewM.getInstance();
        int buttonWidth = 980 / 4;

       tframe = new JFrame("T.I.T.A.N. Admin");
        
        tframe.setIconImage(tlogo.getImage()); // Set the icon of the JFrame
        tframe.setSize(980, 600); // Set the size to 980x600
        tframe.setResizable(false); // Set resizable to false
        tframe.getContentPane().setBackground(new Color(173, 216, 230)); // Set the background color
    
        tlbl.setBounds(390, 150, 1000, 50);
        tlbl.setForeground(Color.black);
   
        tlbl.setFont(new Font("Helvetica",Font.BOLD,50));
        
        lb11.setBounds(290, 100, 1000, 300);
        lb11.setForeground(Color.black);
        Font qouteFont = new Font("Helvetica", Font.BOLD, 16);
        lb11.setFont(qouteFont);
        // Create a top panel
        
        
        tpanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        tpanel.setLayout(new BorderLayout());
        tpanel.setBackground(Color.LIGHT_GRAY);
        //tframe.add(tpanel, BorderLayout.NORTH);

        // Create a label for the title
        // Create a panel for the label to center it
        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        labelPanel.setBackground(Color.LIGHT_GRAY);
        labelPanel.add(tlabel);
       // tpanel.add(labelPanel, BorderLayout.CENTER);

        // Create a "Home" button and add it to the top panel on the right side
        exitButton = new JButton("Log Out");
        exitButton.setFont(new Font("Arial", Font.PLAIN, 10));
        exitButton.setPreferredSize(new Dimension(80, 20));
        exitButton.addActionListener(this);
        exitButton.setFocusable(false);
        exitButton.setBackground(Color.LIGHT_GRAY);
        
        tpanel.setBackground(Color.LIGHT_GRAY);
        tpanel.setBounds(0, 0, 980, 40);
        tpanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        tlabel.setText("T.I.T.A.N. <ADMIN>");
        tlabel.setFont(new Font("Times New Roman", Font.BOLD, 25));

        cruiseItineraryButton.setBounds(0, 41, buttonWidth, 30);
        cruiseItineraryButton.setBackground(Color.LIGHT_GRAY);
        cruiseItineraryButton.setFocusable(false);
        cruiseItineraryButton.addActionListener(this);

        paymentButton.setBounds(buttonWidth, 41, buttonWidth, 30);
        paymentButton.setBackground(Color.LIGHT_GRAY);
        paymentButton.addActionListener(this);

        bookingDetailsButton.setBounds(2*buttonWidth, 41, buttonWidth, 30);
        bookingDetailsButton.setBackground(Color.LIGHT_GRAY);
        bookingDetailsButton.addActionListener(this);

       // helpButton.setBounds(400, 300, 150, 30);
       // helpButton.addActionListener(this);

        blockedAccountButton.setBounds(3*buttonWidth, 41, buttonWidth, 30);
        blockedAccountButton.setBackground(Color.LIGHT_GRAY);
        blockedAccountButton.addActionListener(this);


        lbbackground.setBounds(0, 0, 980, 600);

        
        tframe.add(tpanel, BorderLayout.NORTH);
        tframe.add(tlbl);
       tframe.add(lb11, BorderLayout. CENTER);
        tpanel.add(labelPanel, BorderLayout.CENTER);
        tpanel.add(exitButton, BorderLayout.EAST);
        tframe.add(cruiseItineraryButton);
        tframe.add(paymentButton);
        tframe.add(bookingDetailsButton);
       // tframe.add(helpButton);
        tframe.add(blockedAccountButton);
        tframe.add(lbbackground);

        tframe.setLocationRelativeTo(null);
        tframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tframe.setVisible(true);
        this.admin=adminhome;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        switch (actionCommand) {
            case "Cruise Itinerary":
                tframe.dispose();
                new TitanAdminIt();
                break;
            case "Review & Ratings":
                showReviewAndRating();
                break;
            case "Booking Records":
                tframe.dispose();
             TitanbRecord trecord = new TitanbRecord(pass);
             trecord.arecordholder(admin);
                break;
            case "Blocked Account":
                manageBlockedAccounts();
                break;
            case "Log Out":
                showLogoutConfirmation();
                break;
        }
    }
    private void showReviewAndRating() {
    System.out.println("Show Review and Rating Clicked");

    JTextArea reviewTextArea = new JTextArea();
    reviewTextArea.setEditable(false);

    List<TitanUReview> reviews = userReviewManager.getAllReviews();
    System.out.println("Number of reviews: " + reviews.size());

    for (TitanUReview review : reviews) {
        System.out.println("Review: " + review.getReviewText() + ", Rating: " + review.getRating());
        reviewTextArea.append("Review Text: " + review.getReviewText() + "\n");
        reviewTextArea.append("Rating: " + review.getRating() + " Cruise: " + getStarRating(review.getRating()) + "\n");
        reviewTextArea.append("------\n");
    }

    JOptionPane.showMessageDialog(tframe, new JScrollPane(reviewTextArea), "Review and Rating", JOptionPane.PLAIN_MESSAGE);
    
    
}
    private String getStarRating(int rating) {
    StringBuilder stars = new StringBuilder();
    for (int i = 0; i < rating; i++) {
        stars.append("🚢");
    }
    return stars.toString();
    }


    private void manageBlockedAccounts() {
    // Show a dialog with a list of blocked users and checkboxes for unblocking
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    for (TitanBlock blockedUser : blockedUsers) {
        JCheckBox checkBox = new JCheckBox(blockedUser.getEmail());
        panel.add(checkBox);
    }

    int result = JOptionPane.showConfirmDialog(null, panel, "Blocked Account Management", JOptionPane.OK_CANCEL_OPTION);

    if (result == JOptionPane.OK_OPTION) {
        // Update the list of blocked users based on the checkbox state
        Component[] components = panel.getComponents();
        for (Component component : components) {
            if (component instanceof JCheckBox) {
                JCheckBox checkBox = (JCheckBox) component;
                String userEmail = checkBox.getText();
                if (checkBox.isSelected()) {
                    // Unblock the user
                   
                    loginReference.unblockTitanUser(userEmail);
                    // Display a success message in TitanAdmin
                     
                    JOptionPane.showMessageDialog(tframe, "The account with email " + userEmail + " has been unblocked.", "Success", JOptionPane.INFORMATION_MESSAGE);
                   
                }
            }
        }
        // Update the reference to blockedUsers in TitanLogin2 class
        blockedUsers = loginReference.getTitanBlocks();
        tframe.dispose();
        new TitanAdmin(blockedUsers, null, userReviewManager);
    }
}
    private void showLogoutConfirmation() {
    int result = JOptionPane.showConfirmDialog(
            null,
            "Are you sure you want to logout?",
            "Logout Confirmation",
            JOptionPane.YES_NO_OPTION
    );
    if (result == JOptionPane.YES_OPTION) {
        // Perform logout actions
        tframe.dispose();
       new TitanHome();
      
    } else {
        tframe.dispose();
        new TitanAdmin(blockedUsers, loginReference, userReviewManager);
       
    }
    }
}
