
package com.mycompany.titanproj;
//import javax.swing.*;
//import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TitanBooking implements ActionListener{
    JFrame tframe;
    JPanel tpanel = new JPanel();
    JPanel tpanel2, tpanel3, tpanel4, tpanel5, tpanel6;
    JButton homeButton;
    JLabel tlabel;
    ImageIcon tlogo = new ImageIcon("titanimages/newtitanlogo.jpg");
    JLabel bbg = new JLabel(new ImageIcon("titanimages/bookingnew.png"));
    JLabel bbg2= new JLabel(new ImageIcon("titanimages/booking2nd.jpeg"));
    JLabel bbg3= new JLabel(new ImageIcon("titanimages/booking3rd.jpg"));
    JLabel bbg4= new JLabel(new ImageIcon("titanimages/booking4th.png"));
    JLabel bbg5= new JLabel(new ImageIcon("titanimages/booking5th.jpg"));
 String pass;
 String ages;
    public TitanBooking(String password) {
        
     pass=password;
        System.out.println(pass);
        // Create a JFrame with the specified background color
        tframe = new JFrame("T.I.T.A.N. Booking");
        tframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tframe.setIconImage(tlogo.getImage()); // Set the icon of the JFrame
        tframe.setSize(980, 600); // Set the size to 980x600
        tframe.setResizable(false); // Set resizable to false
        tframe.getContentPane().setBackground(new Color(173, 216, 230)); // Set the background color
        tframe.setLocationRelativeTo(null);

        // Create a top panel
        
        
        tpanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        tpanel.setLayout(new BorderLayout());
        tpanel.setBackground(Color.LIGHT_GRAY);
        //tframe.add(tpanel, BorderLayout.NORTH);

        // Create a label for the title
        tlabel = new JLabel("T.I.T.A.N. <BOOKING>");
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
        homeButton.addActionListener(this);
        homeButton.setFocusable(false);
        homeButton.setBackground(Color.LIGHT_GRAY);
       // tpanel.add(homeButton, BorderLayout.EAST);

        bbg.setBounds(0,0,950,290); 
        bbg2.setBounds(0,0,950,290);
        bbg3.setBounds(0,0,950,290); 
        bbg4.setBounds(0,0,950,290);
        bbg5.setBounds(0,0,950,290);
        // Create tpanel2 to tpanel6
        tpanel2 = new JPanel(new BorderLayout());
        tpanel2.setBackground(Color.LIGHT_GRAY);
        tpanel2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        tpanel2.setPreferredSize(new Dimension(950, 290));
        JButton select1 = createSelectButton("<Celestyal Olympia>");
        select1.setFocusable(false);
        select1.addActionListener(this);
       // tpanel2.add(select1, BorderLayout.SOUTH);

        tpanel3 = new JPanel(new BorderLayout());
        tpanel3.setBackground(Color.LIGHT_GRAY);
        tpanel3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        tpanel3.setPreferredSize(new Dimension(950, 290));
        JButton select2 = createSelectButton("<Norwegian Encore>");
        select2.setFocusable(false);
        select2.addActionListener(this);
       // tpanel3.add(select2, BorderLayout.SOUTH);

        tpanel4 = new JPanel(new BorderLayout());
        tpanel4.setBackground(Color.LIGHT_GRAY);
        tpanel4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        tpanel4.setPreferredSize(new Dimension(950, 290));
        JButton select3 = createSelectButton("<Sapphire Princess>");
        select3.setFocusable(false);
        select3.addActionListener(this);
       // tpanel4.add(select3, BorderLayout.SOUTH);

        tpanel5 = new JPanel(new BorderLayout());
        tpanel5.setBackground(Color.LIGHT_GRAY);
        tpanel5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        tpanel5.setPreferredSize(new Dimension(950, 290));
        JButton select4 = createSelectButton("<Anthem of the Seas>");
        select4.setFocusable(false);
        select4.addActionListener(this);
       // tpanel5.add(select4, BorderLayout.SOUTH);

        tpanel6 = new JPanel(new BorderLayout());
        tpanel6.setBackground(Color.LIGHT_GRAY);
        tpanel6.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        tpanel6.setPreferredSize(new Dimension(950, 290));
        JButton select5 = createSelectButton("<SuperStar Aquarius>");
        select5.setFocusable(false);
        select5.addActionListener(this);
       // tpanel6.add(select5, BorderLayout.SOUTH);
        
      
        // Create a JScrollPane and add the panels to it
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(createMainPanel());
        

        // Add the JScrollPane to the frame
        tframe.add(tpanel, BorderLayout.NORTH);
        tpanel.add(labelPanel, BorderLayout.CENTER);
        tpanel.add(homeButton, BorderLayout.EAST);
        tpanel2.add(select1, BorderLayout.SOUTH);
        tpanel2.add(bbg);
        tpanel3.add(select2, BorderLayout.SOUTH);
        tpanel3.add(bbg2);
        tpanel4.add(select3, BorderLayout.SOUTH);
        tpanel4.add(bbg3);
        tpanel5.add(select4, BorderLayout.SOUTH);
        tpanel5.add(bbg4);
        tpanel6.add(select5, BorderLayout.SOUTH);
        tpanel6.add(bbg5);
        tframe.add(scrollPane, BorderLayout.CENTER);

        // Center the frame on the screen
       
        tframe.setLocationRelativeTo(null);

        // Make the frame visible
        tframe.setVisible(true);
    }

    JPanel createMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 1));
        mainPanel.setBackground(Color.LIGHT_GRAY);

        mainPanel.add(tpanel2);
        mainPanel.add(tpanel3);
        mainPanel.add(tpanel4);
        mainPanel.add(tpanel5);
        mainPanel.add(tpanel6);

        return mainPanel;
    }

    JButton createSelectButton(String text) {
        JButton selectButton = new JButton(text);
        selectButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        selectButton.setFont(new Font("Arial", Font.PLAIN, 10));
        return selectButton;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
         String Bookcommand = ae.getActionCommand();
         
         switch(Bookcommand){
             case "Home":
                 tframe.dispose();
                 new TitanProj(pass);
                 break;
             case "<Celestyal Olympia>":
                tframe.dispose();
                new Booking1st(pass);
                 break;
             case "<Norwegian Encore>":
                 tframe.dispose();
                 new Booking2nd(pass);
                 break;
             case "<Sapphire Princess>":
                 tframe.dispose();
                 new Booking3rd(pass);
                 break;
             case "<Anthem of the Seas>":
                 JOptionPane.showMessageDialog(tframe, "4th Cruise Unavailable :(\n\t\t(Fully Book)","4th Cruise",JOptionPane.ERROR_MESSAGE);
                 break;
             case "<SuperStar Aquarius>":
                 JOptionPane.showMessageDialog(tframe,"5th Cruise Unavailable :(\n\t\t(Fully Book)", "5th Cruise",JOptionPane.ERROR_MESSAGE);
                 break;
         }
    }
}
