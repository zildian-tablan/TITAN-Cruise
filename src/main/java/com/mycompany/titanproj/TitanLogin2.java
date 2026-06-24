
package com.mycompany.titanproj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import com.mycompany.titanproj.TitanBlock;


public class TitanLogin2 implements ActionListener {
    JTextField emailField;
    JPasswordField passwordField;
    JLabel lb12 = new JLabel("T.I.T.A.N.");
    JLabel passwordLabel = new JLabel("Password:");
    
 
  
    JLabel emailLabel = new JLabel("Email:");
    JButton cancelButton = new JButton("Cancel");
    JButton loginButton = new JButton("Login");
    JLabel lbbackground = new JLabel(new ImageIcon("titanimages/tbg.jfif"));
    ImageIcon tlogo = new ImageIcon("titanimages/newtitanlogo.jpg");
    JFrame tframe = new JFrame();
    JPanel tpanel = new JPanel();
    String pass;
    

    private int consecutiveTitanLogin2Failures = 0;
    private static final int MAX_CONSECUTIVE_FAILURES = 3;
    private static List<TitanBlock> blockedTitanUsers = new ArrayList<>();
    private TitanReviewM userReviewManager;
    private TitanAdmin adminMenu;

    public List<TitanBlock> getTitanBlocks() {
        return blockedTitanUsers;
    }
    public TitanLogin2(){
       
        tframe.setTitle("T.I.T.A.N. Login");
        tframe.setSize(980, 600);
        tframe.setResizable(false);
        tframe.setLayout(null);
        tframe.setIconImage(tlogo.getImage());

        lb12.setBounds(390, 10, 400, 200);
        Font TitanFont = new Font("Times New Roman", Font.BOLD, 50);
        lb12.setFont(TitanFont);
        
        tpanel.setBounds(325,55,360,300);
        tpanel.setBackground(Color.LIGHT_GRAY);
        

        emailLabel.setBounds(350, 200, 80, 25);
        emailField = new JTextField();
        emailField.setBounds(450, 200, 200, 25);

        passwordLabel.setBounds(350, 230, 80, 25);
        passwordField = new JPasswordField();
        passwordField.setBounds(450, 230, 200, 25);
        

        loginButton.setBounds(450, 315, 80, 25);
        loginButton.addActionListener(this);

        cancelButton.setBounds(550, 315, 80, 25);
        cancelButton.addActionListener(this);

        lbbackground.setBounds(0, 0, 980, 600);

        tframe.add(lb12);
        tframe.add(emailLabel);
        tframe.add(emailField);
        tframe.add(passwordLabel);
        tframe.add(passwordField);
       
        tframe.add(loginButton);
        tframe.add(cancelButton);
        tframe.add(tpanel);
        tframe.add(lbbackground);
        

        tframe.setLocationRelativeTo(null);
        tframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tframe.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Login")) {
            // Handle login logic here
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
           
            pass= new String(passwordField.getPassword());
            if (email.equals("Titanadmin@gmail.com") && password.equals("TITAN")) {
                JOptionPane.showMessageDialog(tframe, "Welcome Admin.", "Admin Logging In", JOptionPane.INFORMATION_MESSAGE);
                 tframe.dispose();
                adminMenu = new TitanAdmin(blockedTitanUsers, this, userReviewManager);//here
            }else if(email.isEmpty() || pass.isEmpty()){  
                JOptionPane.showMessageDialog(tframe, "Please fill in all the required fields.", "Error", JOptionPane.ERROR_MESSAGE);
                 return; // Exit the method without proceeding
            } else if (isTitanUserBlocked(email)) {
                JOptionPane.showMessageDialog(tframe, "This account is blocked. Please contact the administrator.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (isValidCredentials(email, password)) {
                // Handle successful login
                JOptionPane.showMessageDialog(tframe, "Login Successful!");

                TitanUser loggedInTitanUser = TitanUdata.login(email, password);
                TitanUserSession.setLoggedInTitanUser(loggedInTitanUser);
                tframe.dispose();
                new TitanProj(pass);
            } else {
                // Handle login failure
                consecutiveTitanLogin2Failures++;

                if (consecutiveTitanLogin2Failures >= MAX_CONSECUTIVE_FAILURES) {
                    blockTitanUser(email);  // Block the user
                    JOptionPane.showMessageDialog( tframe, "Too many consecutive login failures. Your account is now blocked.", "Error", JOptionPane.ERROR_MESSAGE);
                    tframe.dispose();
                    new TitanHome();
                } else {
                    JOptionPane.showMessageDialog( tframe, "Invalid email or password. Attempts left: " + (MAX_CONSECUTIVE_FAILURES - consecutiveTitanLogin2Failures), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (e.getActionCommand().equals("Cancel")) {
            // Back to the OpeningMain
            // new MainHere();
           tframe.dispose();
           new TitanHome();
        }
    }

    private void blockTitanUser(String email) {
        TitanBlock blockedTitanUser = new TitanBlock(email);
        blockedTitanUsers.add(blockedTitanUser);
    }

    private boolean isTitanUserBlocked(String email) {
        for (TitanBlock blockedTitanUser : blockedTitanUsers) {
            if (blockedTitanUser.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidCredentials(String email, String password) {
        // Your logic for checking valid credentials goes here
        // Placeholder, replace with actual logic
        return TitanUdata.login(email, password) != null && !isTitanUserBlocked(email);
    }
    public void unblockTitanUser(String email) {
        blockedTitanUsers.removeIf(blockedTitanUser -> blockedTitanUser.getEmail().equals(email));
        // Optionally, update the user interface or refresh the state
        // You may need to call this method from AdminMenu after unblocking a user
        tframe.setVisible(true);
    }
}