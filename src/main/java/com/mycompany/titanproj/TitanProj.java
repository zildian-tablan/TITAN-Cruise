package com.mycompany.titanproj;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TitanProj implements ActionListener{
    JFrame tframe = new JFrame();
    JLabel tlabel = new JLabel();
    JLabel tlabel2 = new JLabel();
    JLabel tlabel2a = new JLabel();
    JLabel tlabel3 = new JLabel();
    JLabel tlabel4 = new JLabel();
    JPanel tpanel = new JPanel();
    JButton tbutton = new JButton("Booking");
    JTextField tfield = new JTextField();
    JPasswordField tpass = new JPasswordField();
    JButton Booking = new JButton("Booking");
    JButton CInfo = new JButton("Cruise Itinerary");
    JButton RRbutton = new JButton("Review & Rating");
    JButton HAbutton = new JButton("Help/About");
    JButton profile,logout;
    Font font = new Font("Times New Roman", Font.BOLD, 15);
    ImageIcon tlogo = new ImageIcon("titanimages/newtitanlogo.jpg"); // Change the path to your Titan logo image
        JLabel bg = new JLabel(new ImageIcon("titanimages/tbg.jfif"));
    JLayeredPane layeredPane = new JLayeredPane();
    TitanbRecord titanbRecordInstance = null;
    String passs;
    String ages;
    private TitanReviewM userReviewManager;

    
    
    public TitanProj(String password) {
        passs = password;
       
        int buttonWidth = 980 / 4;
        int frameh =980;
        int framew=600;
        
        System.out.println(passs);
        // frame1
        tframe.setTitle("T.I.T.A.N. Cruise");
        tframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tframe.setSize(frameh, framew);
        tframe.setIconImage(tlogo.getImage()); // Set the icon of the JFrame
        tframe.setVisible(true);
        tframe.setLayout(null);
        tframe.setResizable(false);
        tframe.getContentPane().setBackground(new Color(173, 216, 230));
        tframe.setLocationRelativeTo(null);
      

        // panel1
        tpanel.setBackground(Color.LIGHT_GRAY);
        tpanel.setBounds(0, 0, 980, 40);
        tpanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        profile = new JButton("Profile");
        profile.setBounds(0, 0, buttonWidth, 40);
        profile.addActionListener(this); // Add ActionListener for My Profile button
        profile.setBackground(Color.LIGHT_GRAY);
        profile.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        profile.setFont(font);
        profile.setFocusable(false);
        
        logout = new JButton("Logout");
        logout.setBounds(3 * buttonWidth, 0, buttonWidth, 40);
        logout.addActionListener(this); // Add ActionListener for My Profile button
        logout.setBackground(Color.LIGHT_GRAY);
        logout.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        logout.setFont(font);
        logout.setFocusable(false);
        // label1
        tlabel.setText("T.I.T.A.N. <CRUISE>");
        tlabel.setFont(new Font("Times New Roman", Font.BOLD, 25));

        //label2
        tlabel2.setText("T.I.T.A.N.");
        tlabel2.setFont(new Font("Times New Roman", Font.BOLD, 50));
        tlabel2.setBounds(401, 100, 350, 50);
        tlabel2.setForeground(Color.black);
        tlabel2a.setText("Traveller's Interactive Ticketing and Accomodation Network");
        tlabel2a.setFont(new Font("Times New Roman", Font.BOLD, 20));
        tlabel2a.setBounds(230, 150, 700, 25);
        tlabel2a.setForeground(Color.black);
        
        int label2Width = 500;  // Adjust the width as needed
        int label2Height = 90;  // Adjust the height as needed
        int label2X = (980 - label2Width) / 2;
        int label2Y = (250 - label2Height) / 2;
        

        
        //label3
        // label3
      tlabel3.setFont(new Font("Times New Roman", Font.ITALIC, 20));
      tlabel3.setForeground(Color.blue);
      int label3Width = 900;  // Adjust the width as needed
      int label3Height = 150;  // Adjust the height as needed
      int label3X = (980 - label3Width) / 2;
      int label3Y = label2Y + label2Height + 10; // Adjust the vertical spacing

// Split the text into separate lines
      String[] lines = {
       "\"Embark on the voyage of a lifetime; where dreams set sail, and every booking",
       "is a chapter in your own seafaring story. Navigate the seas of adventure with",
       "a cruise reservation – where the journey begins long before you board\"."
      };

// Create separate JLabels for each line
      for (int i = 0; i < lines.length; i++) {
      JLabel lineLabel = new JLabel(lines[i]);
      lineLabel.setFont(new Font("Times New Roman", Font.ITALIC, 15));
      lineLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
      lineLabel.setForeground(Color.BLACK);
      lineLabel.setBounds(250, label3Y + i * 28, label3Width, 27);  // Adjust the vertical spacing
      tframe.add(lineLabel);
      }
        /*tframe.setContentPane(new JLabel(resizedBgImageIcon));
        
        layeredPane.setBounds(0, 0, 980, 600);

        // Add components to the layeredPane
        layeredPane.add(bg, JLayeredPane.DEFAULT_LAYER); // Background image
        layeredPane.add(tpanel, JLayeredPane.PALETTE_LAYER); // Your panel
        layeredPane.add(Booking, JLayeredPane.PALETTE_LAYER); // Your button
        // Add other components similarly
       
        tframe.setLayout(null);*/
        
        //buttons
        Booking.setBounds(0, 41, buttonWidth, 30);
        Booking.addActionListener(this);
        Booking.setBackground(Color.LIGHT_GRAY);
        Booking.setFont(font);
        Booking.setFocusable(false);

        CInfo.setBounds(buttonWidth, 41, buttonWidth, 30);
        CInfo.addActionListener(this);
        CInfo.setBackground(Color.LIGHT_GRAY);
        CInfo.setFont(font);
        CInfo.setFocusable(false);

        RRbutton.setBounds(2 * buttonWidth, 41, buttonWidth, 30);
        RRbutton.addActionListener(this);
        RRbutton.setBackground(Color.LIGHT_GRAY);
        RRbutton.setFont(font);
        RRbutton.setFocusable(false);

        HAbutton.setBounds(3 * buttonWidth, 41, buttonWidth, 30);
        HAbutton.addActionListener(this);
        HAbutton.setBackground(Color.LIGHT_GRAY);
        HAbutton.setFont(font);
        HAbutton.setFocusable(false);
         
       
        bg.setBounds(0, 0,frameh , framew);
        
        
        // addsect
      //  tframe.add(bg);
        tframe.add(profile);
        tframe.add(logout);
        tframe.add(tlabel4);
        tframe.add(tlabel3);
        tframe.add(tpanel);
        tframe.add(Booking);
        tframe.add(CInfo);
        tframe.add(RRbutton);
        tframe.add(HAbutton);
        tframe.add(tlabel2);
        tframe.add(tlabel2a);
        tframe.add(tlabel3);
        tpanel.add(tlabel);
        tframe.add(tlabel4);
        tframe.add(bg);
        //tframe.add(layeredPane);
       
      
        
    }

    public static void main(String[] args) {
     // TitanLogin2 titanlog = new TitanLogin2();
     
     new TitanLoading2();
     //new TitanProj();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String homecommand = ae.getActionCommand();
        
        switch (homecommand) {
            case "Profile":
               
                 TitanUser loggedInUser = TitanUserSession.getLoggedInTitanUser();
                if (loggedInUser != null) {
                    tframe.dispose();
                    new TitanProfile(loggedInUser,passs);
                    
                } 
                break;
            case "Logout":
                showLogoutConfirmation();
                break;
            case "Booking":
                String[] options = { "Book a Cruise","Booking Records"};
                int selection = JOptionPane.showOptionDialog(tframe, "Choose what you want to do", "T.I.T.A.N. Booking", 
                                                      JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                 
              
                if (selection == 0) {
                    tframe.dispose();
                    new TitanBooking(passs);
                 }
                else if (selection == 1) {
                    tframe.dispose();
                   titanbRecordInstance = new TitanbRecord(passs);
                 }
               break;
            case "Cruise Itinerary":
                tframe.dispose();
                new TitanCruiseIt(passs);
                break;
            case "Review & Rating":

                new TitanRR(userReviewManager);
                break;
            case "Help/About":
                tframe.dispose();
                new TitanHA(passs);
                break;
                
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
        new TitanProj(passs);
       
    }
    }
}
