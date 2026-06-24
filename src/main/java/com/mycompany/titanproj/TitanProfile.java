
package com.mycompany.titanproj;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class TitanProfile  {
    public TitanUser user;
    JLabel bg = new JLabel(new ImageIcon("titanimages/tbg.jfif"));
     ImageIcon tlogo = new ImageIcon("titanimages/newtitanlogo.jpg");
    JFrame tframe = new JFrame();
    String pass;
    String ages;
        
    public TitanProfile(TitanUser user, String password) {
        pass = password;
      
        this.user = user;
        
        
        JLabel lbProfile = new JLabel("My Profile");
        JLabel nameLabel = new JLabel("Name: " + user.getFirstName() + " " + user.getMiddleName() + " " + user.getLastName());
        JLabel ageLabel = new JLabel("Age: " + user.getAge()); // Use the getAge() method
        JLabel birthdayLabel = new JLabel("Birthday: " + user.getBirthday());
        JLabel emailLabel = new JLabel("Email: " + user.getEmail());
        JLabel addressLabel = new JLabel("Address: " + user.getAddress());
        JButton updateBT = new JButton("Update");
        JButton backButton = new JButton("Back to Main");
       
        JPanel panel = new JPanel();
        tframe.setTitle("User Profile");
        tframe.setSize(980, 600);
        tframe.setLayout(null);
        tframe.setIconImage(tlogo.getImage());
        
      
        
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(280,60,420,430);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.setVisible(true);
        
            
        
   bg.setBounds(0, 0, 980, 600);
        
        lbProfile.setBounds(370,80,400,70);
        Font TitanFont = new Font("Helvetica", Font.BOLD, 50); 
        lbProfile.setFont(TitanFont);
        tframe.add(lbProfile);
        
        nameLabel.setBounds(340, 170, 400, 25);
        tframe.add(nameLabel);

        
        birthdayLabel.setBounds(340, 210, 200, 25);
        tframe.add(birthdayLabel);

       
        ageLabel.setBounds(340, 250, 200, 25);
        tframe.add(ageLabel);

        emailLabel.setBounds(340, 290, 400, 25);
        tframe.add(emailLabel);

       
        addressLabel.setBounds(340, 330, 400, 25);
        tframe.add(addressLabel);

        
      
        
        updateBT.setBounds(350, 370, 120, 30);
        updateBT.setBackground(Color.LIGHT_GRAY);
        updateBT.setFocusable(false);
        updateBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
            JPasswordField confirmation = new JPasswordField(JOptionPane.showInputDialog("Enter your Password: "));
            String night = pass;
            String light = new String(confirmation.getPassword()); // Use String constructor to convert char[] to String
            if (night.equals(light)) {
                new TitanuptProfile(user, pass);
                 // Close the UserProfile frame
              } else if(!night.equals(light)) {
                JOptionPane.showMessageDialog(tframe, "Authorization Failed:\nPlease Input Correct Password or Ensure you Input a Password", "Authorization", JOptionPane.ERROR_MESSAGE);
            }
            }
        });
        
        backButton.setBounds(510, 370, 120, 30);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setFocusable(false);
        backButton.addActionListener(e -> {
            tframe.dispose();
            new TitanProj(pass);
            // Close the UserProfile frame
         
        });
        bg.setBounds(0,0,980,600);
        tframe.add(updateBT);
        tframe.add(backButton);
        tframe.add(panel);
        tframe.add(bg);
        
        tframe.setLocationRelativeTo(null);
        tframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tframe.setVisible(true);
    }
        

}
