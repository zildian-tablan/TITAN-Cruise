
package com.mycompany.titanproj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TitanHome implements ActionListener{
    JFrame tframe;
    JPanel tpanel = new JPanel();
    JPanel tpanel2, tpanel3, tpanel4, tpanel5, tpanel6;
    JButton homeButton;
    JLabel tlabel;
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
   // JLabel lb11 = new JLabel("Sail away to serenity as the gentle waves cradle your dreams on a cruise adorned with luxury and discovery.");
    JLabel lb12 = new JLabel("T.I.T.A.N.");
    ImageIcon tlogo = new ImageIcon("titanimages/newtitanlogo.jpg");
    JLabel bg = new JLabel(new ImageIcon("titanimages/tbg.jfif"));
    JLabel lb11 = new JLabel("Traveller's Interactive Ticketing and Accommodation Network.");
    JLabel bbg = new JLabel(new ImageIcon("titanimages/bookingnew.png"));
    JLabel bbg2= new JLabel(new ImageIcon("titanimages/booking2nd.jpeg"));
    JLabel bbg3= new JLabel(new ImageIcon("titanimages/booking3rd.jpg"));
    JLabel bbg4= new JLabel(new ImageIcon("titanimages/booking4th.png"));
    JLabel bbg5= new JLabel(new ImageIcon("titanimages/booking5th.jpg"));
    JLabel tp2 = new JLabel("<Celestyal Olympia>");
    JLabel tp3 = new JLabel("<Norwegian Encore>");
    JLabel tp4 = new JLabel("<Sapphire Princess>");
    JLabel tp5 = new JLabel("<Anthem of the Seas>");
    JLabel tp6 = new JLabel("<SuperStar Aquarius>");
    JLabel d1,d2,d3,d4,d5;
     JLabel lineLabel;
    Font dfont = new Font("Times New Roman",Font.PLAIN,14);
 String pass;

    public TitanHome() {
   
     
        // Create a JFrame with the specified background color
        tframe = new JFrame("T.I.T.A.N.");
        tframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tframe.setIconImage(tlogo.getImage()); // Set the icon of the JFrame
        tframe.setSize(975, 600); // Set the size to 980x600
        tframe.setResizable(false); // Set resizable to false
        tframe.getContentPane().setBackground(new Color(173, 216, 230)); // Set the background color
        tframe.setLocationRelativeTo(null);
        lb11.setBounds(270, 40, 1000, 300);
        lb11.setForeground(Color.black);
        Font qouteFont = new Font("Helvetica", Font.BOLD, 16);
        lb11.setFont(qouteFont);
        lb12.setBounds(390, 10, 300, 200);
        Font TitanFont = new Font("Times New Roman", Font.BOLD, 50);
        lb12.setFont(new Font("Times New Roman", Font.BOLD, 50));
        lb12.setForeground(Color.black);
        //lbbackground.setBounds(0, 0, 980, 600);
       // lb11.setBounds(50, 280, 1000, 300);
        //Font qouteFont = new Font("Helvetica", Font.BOLD, 16);
        //lb11.setFont(qouteFont);
        p2.add(lb12);
        p2.setPreferredSize(new Dimension(900, 600));
        p2.setBackground(new Color(135, 206, 235));

        // Create menu bar with right alignment
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
        tframe.setJMenuBar(menuBar);

        // Create "My Account" menu
        JMenu myAccountMenu = new JMenu("My Account");
        menuBar.add(myAccountMenu);

        // Add "Login" option
        JMenuItem loginMenuItem = new JMenuItem("Login");
        loginMenuItem.addActionListener(this);
        myAccountMenu.add(loginMenuItem);

        // Add "Create an Account" option
        JMenuItem createAccountMenuItem = new JMenuItem("Create an Account");
        createAccountMenuItem.addActionListener(this);
        myAccountMenu.add(createAccountMenuItem);

        // Create "Help" menu
       JMenu helpMenu = new JMenu("Help");
        menuBar.add(helpMenu);

        // Add "Help" option
       JMenuItem helpMenuItem = new JMenuItem("Help");
        helpMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 tframe.dispose();
                new TitanHAhome();
            }
        });
        helpMenu.add(helpMenuItem);  
        tp2.setFont(TitanFont);
        tp2.setBounds(250,290,500,55);
        tp3.setFont(TitanFont);
        tp3.setBounds(250,290,500,55);
        tp4.setFont(TitanFont);
        tp4.setBounds(250,290,450,55);
        tp5.setFont(TitanFont);
        tp5.setBounds(250,290,500,55);
        tp6.setFont(TitanFont);
        tp6.setBounds(250,290,500,55);
        
        bbg.setBounds(0,0,950,290); 
        bbg2.setBounds(0,0,950,290);
        bbg3.setBounds(0,0,950,290); 
        bbg4.setBounds(0,0,950,290);
        bbg5.setBounds(0,0,950,290);
        bg.setBounds(0,0,950,600);
        // Create tpanel2 to tpanel6
        
        tpanel = new JPanel(); 
        
        tpanel.setLayout(null);
        tpanel.setBackground(new Color(173, 216, 230));
        tpanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        tpanel.setPreferredSize(new Dimension(950, 500));
        
        tpanel2 = new JPanel();
        tpanel2.setLayout(null);
        tpanel2.add(tp2);
        
        tpanel2.setBackground(new Color(173, 216, 230));
        tpanel2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        tpanel2.setPreferredSize(new Dimension(950, 250));
       
        
        int label2Width = 400;  // Adjust the width as needed
        int label2Height = 440;  // Adjust the height as needed
        int label2X = (980 - label2Width) / 2;
        int label2Y = (250 - label2Height) / 2;
        int label3Width = 950;  // Adjust the width as needed
        int label3Height = 200;  // Adjust the height as needed
        int label3X = (980 - label3Width) / 2;
        int label3Y = label2Y + label2Height + 10; // Adjust the vertical spacing

// Split the text into separate lines
      String[] lines1 = {
        "The Celestyal Olympia, operated by Celestyal Cruises, is a mid-sized cruise ship specializing in Eastern Mediterranean itineraries.",
          "Offering diverse accommodations, including interior, ocean-view, and balcony cabins, the ship prioritizes a comfortable and immersive",
          "cruise experience Multiple dining options feature a mix of international and regional dishes.",
          "Entertainment includes live performances, themed events, and socializing spaces like bars and lounges.",
          "Onboard activities range from fitness facilities to spa services.Itineraries typically cover destinations like the Greek Islands and Turkey",
          "allowing passengers to explore historical sites and cultural landmarks. For the latest details, check Celestyal Cruises' official website."
      };

// Create separate JLabels for each line
      for (int i = 0; i < lines1.length; i++) {
      d1 = new JLabel(lines1[i]);
      d1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
      d1.setForeground(Color.BLACK);
      d1.setBounds(69, label3Y + i * 21, label3Width, 15);  // Adjust the vertical spacing
       tpanel2.add(d1);
      }
      
       // tpanel2.add(select1, BorderLayout.SOUTH);

        tpanel3 = new JPanel();
        tpanel3.setLayout(null);
        tpanel3.add(tp3);
        tpanel3.setBackground(new Color(173, 216, 230));
        tpanel3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        tpanel3.setPreferredSize(new Dimension(950, 290));
        
          String[] lines2 = {
              "The Norwegian Encore, part of Norwegian Cruise Line's Breakaway Plus class, offers a modern and innovative cruise experience.",
                  " With diverse accommodations including staterooms and suites, the ship embraces Freestyle Dining for flexible dining options.",
                  " Entertainment features Broadway-style shows, live music, and unique attractions like a race track and laser tag.",
                  " Onboard activities include pools, fitness centers, and dedicated spaces for different age groups.",
                  " Itineraries typically cover destinations such as the Caribbean and the Bahamas.",
                  " The ship also includes signature features like the Waterfront and the Haven. ",
                  " For the latest details, check Norwegian Cruise Line's official website."
         
      };

// Create separate JLabels for each line
      for (int i = 0; i < lines2.length; i++) {
      d2 = new JLabel(lines2[i]);
      d2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
      d2.setForeground(Color.BLACK);
      d2.setBounds(69, label3Y + i * 21, label3Width, 15);  // Adjust the vertical spacing
       tpanel3.add(d2);
      }
      
      
    
       // tpanel3.add(select2, BorderLayout.SOUTH);

        tpanel4 = new JPanel();
        tpanel4.setLayout(null);
        tpanel4.add(tp4);
        tpanel4.setBackground(new Color(173, 216, 230));
        tpanel4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        tpanel4.setPreferredSize(new Dimension(950, 290));
       
                  String[] lines3 = {
              
                          "The Sapphire Princess, part of Princess Cruises, offers an elegant cruise experience with a variety of accommodations,",
                          "including staterooms and suites.Dining options range from traditional to specialty restaurants, featuring international",
                          "cuisines. Entertainment includes Broadway-style shows, live music, and themed events.",
                          "Onboard activities encompass pools, fitness centers, and enrichment programs.",
                          "The ship sails diverse itineraries worldwide, covering destinations like Alaska, Asia, Europe, and the Caribbean.",
                          "Passengers can also experience the comfort of the Princess Luxury Bed.",
                          "For the latest details, check Princess Cruises' official website."
                
         
      };

// Create separate JLabels for each line
      for (int i = 0; i < lines3.length; i++) {
      d3 = new JLabel(lines3[i]);
      d3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
      d3.setForeground(Color.BLACK);
      d3.setBounds(69, label3Y + i * 21, label3Width, 15);  // Adjust the vertical spacing
       tpanel4.add(d3);
      }
       // tpanel4.add(select3, BorderLayout.SOUTH);

        tpanel5 = new JPanel();
        tpanel5.setLayout(null);
        tpanel5.add(tp5);
        tpanel5.setBackground(new Color(173, 216, 230));
        tpanel5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        tpanel5.setPreferredSize(new Dimension(950, 290));
   
                      String[] lines4 = {
                     " The Anthem of the Seas, a part of Royal Caribbean's Quantum-class ships, offers a modern and innovative cruise experience.",
                     " Accommodations range from staterooms to suites, featuring various amenities.",
                     " Dining options include diverse cuisines in both traditional and specialty restaurants. ",
                     " Entertainment features Broadway-style shows, live music, and unique attractions like the North Star observation capsule ",
                     " and the RipCord by iFLY skydiving simulator.",
                     " Onboard activities encompass pools, fitness centers, spas, and the SeaPlex with bumper cars and roller skating.",
                     " The ship sails diverse itineraries, covering destinations such as the Caribbean, Europe, and the Bahamas.",
                     " For the latest details, check Royal Caribbean International's official website."
                          
                
         
      };

// Create separate JLabels for each line
      for (int i = 0; i < lines4.length; i++) {
      d4 = new JLabel(lines4[i]);
      d4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
      d4.setForeground(Color.BLACK);
      d4.setBounds(69, label3Y + i * 21, label3Width, 15);  // Adjust the vertical spacing
       tpanel5.add(d4);
      }
       // tpanel5.add(select4, BorderLayout.SOUTH);

        tpanel6 = new JPanel();
        tpanel6.setLayout(null);
        tpanel6.add(tp6);
        tpanel6.setBackground(new Color(173, 216, 230));
        tpanel6.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        tpanel6.setPreferredSize(new Dimension(950, 290));
        
                       String[] lines5 = {
                     " The SuperStar Aquarius, operated by Star Cruises, is a cruise ship known for offering diverse accommodations,",
                     " dining options with international and regional cuisines, and a range of entertainment including live performances.",
                     " Onboard activities likely include pools, fitness centers, and spas. ",
                     " The ship typically sails in the Asia-Pacific region, with itineraries covering destinations such as Malaysia and Taiwan.",
                     " For the latest details, it's advisable to check Star Cruises' official website or contact them directly."
                          
                
         
      };

// Create separate JLabels for each line
      for (int i = 0; i < lines5.length; i++) {
      d5 = new JLabel(lines5[i]);
      d5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
      d5.setForeground(Color.BLACK);
      d5.setBounds(69, label3Y + i * 21, label3Width, 15);  // Adjust the vertical spacing
       tpanel6.add(d5);
      }
       
       // tpanel6.add(select5, BorderLayout.SOUTH);
        
      
        // Create a JScrollPane and add the panels to it
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(createMainPanel());
        

        // Add the JScrollPane to the frame
        tpanel.add(lb12);
        tpanel.add(lb11);
        tpanel.add(p2);
        tpanel.add(bg);
        tpanel2.add(bbg);
        tpanel3.add(bbg2);
        tpanel4.add(bbg3);
        tpanel5.add(bbg4);
        tpanel6.add(bbg5);
        tframe.add(scrollPane, BorderLayout.CENTER);

        // Center the frame on the screen
       
        tframe.setLocationRelativeTo(null);

        // Make the frame visible
        tframe.setVisible(true);
    }

    JPanel createMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(6, 1));
        mainPanel.setBackground(new Color(173, 216, 230));
        
      
        mainPanel.add(tpanel);
   
        mainPanel.add(tpanel2);
      
        mainPanel.add(tpanel3);
  
        mainPanel.add(tpanel4);
     
        mainPanel.add(tpanel5);
        
        mainPanel.add(tpanel6);

        return mainPanel;
    }

    
    @Override
    public void actionPerformed(ActionEvent ae) {
         String Bookcommand = ae.getActionCommand();
         
         switch(Bookcommand){
            
             case "1st Cruise":
                
                JOptionPane.showMessageDialog(tframe, "1st Cruise Description :)\n\t\t","1st Cruise",JOptionPane.INFORMATION_MESSAGE);
                 break;
             case "2nd Cruise":
                 
                  JOptionPane.showMessageDialog(tframe, "2nd Cruise Description :)\n\t\t","2nd Cruise",JOptionPane.INFORMATION_MESSAGE);
                 break;
             case "3rd Cruise":
                
                 JOptionPane.showMessageDialog(tframe, "3rd Cruise Description :)\n\t\t","3rd Cruise",JOptionPane.INFORMATION_MESSAGE);
                 
                 break;
             case "4th Cruise":
                 JOptionPane.showMessageDialog(tframe, "4th Cruise Description :)\n\t\t","4th Cruise",JOptionPane.INFORMATION_MESSAGE);
                 break;
             case "5th Cruise":
                 JOptionPane.showMessageDialog(tframe,"5th Cruise Description :)\n\t\t", "5th Cruise",JOptionPane.INFORMATION_MESSAGE);
                 break;
             case "Login":
                  tframe.dispose();
                  new TitanLogin2();
                  break;
             case "Create an Account":
                  tframe.dispose();
                    new TitanSignup();
                    break;
                 
    
        }    
    }
}

