
package com.mycompany.titanproj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class TitanuptProfile extends JFrame {
    private TitanUser user;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField middleNameField;
    private JTextField emailField;
    private JTextField addressField;
    private JTextField passwordField;
    ImageIcon tlogo = new ImageIcon("titanimages/newtitanlogo.jpg");
    String pass;
   

    public TitanuptProfile(TitanUser user,String password) {
        this.user = user;
      
       

        setTitle("Update Profile");
        setSize(500, 400);
        setLayout(new GridLayout(7, 2));
        setIconImage(tlogo.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("First Name:"));
        firstNameField = new JTextField(user.getFirstName());
        add(firstNameField);

        add(new JLabel("Last Name:"));
        lastNameField = new JTextField(user.getLastName());
        add(lastNameField);

        add(new JLabel("Middle Name:"));
        middleNameField = new JTextField(user.getMiddleName());
        add(middleNameField);

        add(new JLabel("Email:"));
        emailField = new JTextField(user.getEmail());
        add(emailField);

        add(new JLabel("Address:"));
        addressField = new JTextField(user.getAddress());
        add(addressField);
        
        add(new JLabel("Password:"));
        passwordField = new JTextField(user.getPassword());
        add(passwordField);
        
       

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
                
                updateUserDetails();
            }
        });
        add(updateButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new TitanProfile(user,password);
            }
        });
        add(cancelButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void updateUserDetails() {
        // Update the user details with the values from the text fields
        user.setFirstName(firstNameField.getText());
        user.setLastName(lastNameField.getText());
        user.setMiddleName(middleNameField.getText());
        user.setEmail(emailField.getText());
        user.setAddress(addressField.getText());
        user.setPassword(passwordField.getText());
        // You may want to add more validation or checks before updating the user details

        // Show a message indicating that the update was successful
        JOptionPane.showMessageDialog(this, "Profile updated successfully!");

        // Close the TitanuptProfile frame
        dispose();
        pass=passwordField.getText();
        // Optionally, you can reopen the TitanProfile frame with the updated details
        new TitanProfile(user,pass);
    }

   
}

