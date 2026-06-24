
package com.mycompany.titanproj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.Timer;

public class TitanSignup implements ActionListener {
    JButton cancelButton = new JButton("Cancel");
    JButton signUpButton = new JButton("Sign Up");
    JLabel lb12 = new JLabel("T.I.T.A.N.");
    JPanel panel = new JPanel();
    JTextField firstNameField, lastNameField, middleNameField, emailField, addressField, ageField;
    JPasswordField passwordField;
    JComboBox<String> monthComboBox, dayComboBox, yearComboBox;
    JCheckBox showPasswordCheckbox;
    JLabel lbbackground = new JLabel(new ImageIcon("titanimages/tbg.jfif"));
    ImageIcon tlogo = new ImageIcon("titanimages/newtitanlogo.jpg");
    JFrame tframe = new JFrame();
    String ages;
    public TitanSignup() {
        tframe.setTitle("T.I.T.A.N Sign Up");
        tframe.setSize(980, 600);
        tframe.setIconImage(tlogo.getImage());
        tframe.setLayout(null);
        tframe.setResizable(false);
        
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(280,40,420,480);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.setVisible(true);
        cancelButton.setBounds(570, 470, 80, 25);
        cancelButton.addActionListener(this);
        signUpButton.setBounds(355, 470, 80, 25);
        signUpButton.addActionListener(this);
        
        lb12.setBounds(400, 10,270,200);
        Font TitanFont = new Font("Helvetica", Font.BOLD, 50); 
        lb12.setFont(TitanFont);
        lbbackground.setBounds(0, 0, 980, 600);
        
        // Labels
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setBounds(340, 170, 80, 25);
        tframe.add(firstNameLabel);

        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setBounds(340, 200, 80, 25);
        tframe.add(lastNameLabel);

        JLabel middleNameLabel = new JLabel("Middle Name:");
        middleNameLabel.setBounds(340, 230, 80, 25);
        tframe.add(middleNameLabel);

        JLabel birthdayLabel = new JLabel("Birthday:");
        birthdayLabel.setBounds(340,260, 80, 25);
        tframe.add(birthdayLabel);
        
        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(340, 290, 80, 25);
        tframe.add(ageLabel);
        
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(340, 320, 80, 25);
        tframe.add(emailLabel);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(340, 350, 80, 25);
        tframe.add(addressLabel);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(340, 380, 80, 25);
        tframe.add(passwordLabel);

        // Text Fields
        firstNameField = new JTextField();
        firstNameField.setBounds(440, 170, 200, 25);

        lastNameField = new JTextField();
        lastNameField.setBounds(440, 200, 200, 25);
      

        middleNameField = new JTextField();
        middleNameField.setBounds(440, 230, 200, 25);
       

        // Birthday ComboBoxes
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        monthComboBox = new JComboBox<>(months);
        monthComboBox.setBounds(400, 260, 80, 25);

        dayComboBox = new JComboBox<>();
        dayComboBox.setBounds(500, 260, 80, 25);
        

        yearComboBox = new JComboBox<>();
        yearComboBox.setBounds(600, 260, 80, 25);
      

        monthComboBox.addActionListener(this);
        // Age Field
        ageField = new JTextField();
        ageField.setBounds(440, 290, 50, 25);
        ageField.setEditable(false);
        
        // Email, Address, and Password Fields
        emailField = new JTextField();
        emailField.setBounds(440, 320, 200, 25);

        addressField = new JTextField();
        addressField.setBounds(440, 350, 200, 25);

        passwordField = new JPasswordField();
        passwordField.setBounds(440, 380, 200, 25);

        // Show Password Checkbox
        showPasswordCheckbox = new JCheckBox("Show Password");
        showPasswordCheckbox.setBackground(Color.LIGHT_GRAY);
        showPasswordCheckbox.setBounds(450, 420, 150, 25);
        showPasswordCheckbox.addActionListener(this);
       
        ages=ageField.getText();

        tframe.add(lb12);
        tframe.add(firstNameField);
        tframe.add(lastNameField);
        tframe.add(middleNameField);
        tframe.add(monthComboBox);
        tframe.add(dayComboBox);
        tframe.add(yearComboBox);
        tframe.add(emailField);
        tframe.add(addressField);
        tframe.add(passwordField);
        tframe.add(showPasswordCheckbox);
        tframe.add(ageField);
        tframe.add(signUpButton);
        tframe.add(cancelButton);
        tframe.add(panel);
        tframe.add(lbbackground);
        
        // Populate Year ComboBox
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = currentYear; i >= currentYear - 100; i--) {
            yearComboBox.addItem(String.valueOf(i));
        }


        tframe.setLocationRelativeTo(null);
        tframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tframe.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == monthComboBox) {
            updateDays();
        } else if (e.getSource() == showPasswordCheckbox) {
            showPassword();
        } else if (e.getActionCommand().equals("Sign Up")) {
            signUp();
        }else if (e.getActionCommand().equals("Cancel")) {
            // Close the Login frame and open the MainHere frame
            tframe.dispose();
            new TitanHome();
            
        }
    }

    private void updateDays() {
        int selectedMonth = monthComboBox.getSelectedIndex() + 1;
        int daysInMonth;

        switch (selectedMonth) {
            case 4:
            case 6:
            case 9:
            case 11:
                daysInMonth = 30;
                break;
            case 2:
                int selectedYear = Integer.parseInt(yearComboBox.getSelectedItem().toString());
                daysInMonth = (selectedYear % 4 == 0 && (selectedYear % 100 != 0 || selectedYear % 400 == 0)) ? 29 : 28;
                break;
            default:
                daysInMonth = 31;
                break;
        }

        dayComboBox.removeAllItems();
        for (int i = 1; i <= daysInMonth; i++) {
            dayComboBox.addItem(String.valueOf(i));
        }
    }

    private void showPassword() {
        passwordField.setEchoChar(showPasswordCheckbox.isSelected() ? 0 : '*');
    }

    private void signUp() {
        // Implement your sign-up logic here
    String firstName = firstNameField.getText();
    String lastName = lastNameField.getText();
    String middleName = middleNameField.getText();
    String selectedMonth = (String) monthComboBox.getSelectedItem();
    String selectedDay = (String) dayComboBox.getSelectedItem();
    String selectedYear = (String) yearComboBox.getSelectedItem();
    String birthday = selectedMonth + " " + selectedDay + ", " + selectedYear; 
    String email = emailField.getText();
    String address = addressField.getText();
    String password = new String(passwordField.getPassword());
   
    // Validate that all required fields are filled
    if (firstName.isEmpty() || lastName.isEmpty() || middleName.isEmpty() ||
            selectedMonth == null || selectedDay == null || selectedYear == null ||
            email.isEmpty() || address.isEmpty() || password.isEmpty()) {
        JOptionPane.showMessageDialog(tframe, "Please fill in all the required fields.", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Exit the method without proceeding
    }
   
    // Calculate age
    int birthYear = Integer.parseInt(selectedYear);
    int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    int age = currentYear - birthYear;

    // Set age field
    ageField.setText(String.valueOf(age));
    if (age < 18) {
        JOptionPane.showMessageDialog(tframe, "Invalid user - under 18 years old", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
     TitanUser newTitanUser = new TitanUser(firstName, lastName, middleName, birthday, email, address, password,age);

    // Add the user to TitanUserData
    TitanUdata.addTitanUser(newTitanUser);

    // Perform any necessary validation or backend processing
    // For now, just print the values to the console
    System.out.println("First Name: " + firstName);
    System.out.println("Last Name: " + lastName);
    System.out.println("Middle Name: " + middleName);
    System.out.println("Birthday: " + selectedMonth + " " + selectedDay + ", " + selectedYear);
    System.out.println("Email: " + email);
    System.out.println("Address: " + address);
    System.out.println("Password: " + password);
    System.out.println("Age: " + age);

    // Display "Login Successfully" message
    JFrame successFrame = new JFrame("Success");
    JLabel successLabel = new JLabel("Sign Up Successful!");
    successLabel.setHorizontalAlignment(JLabel.CENTER);
    successFrame.getContentPane().add(successLabel);
    successFrame.setSize(300, 100);
    successFrame.setLocationRelativeTo(null);
    successFrame.setVisible(true);

    // Close the success frame after 3 seconds and return to MainHere frame
    Timer timer = new Timer(1500, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            successFrame.dispose();
            tframe.dispose();
            new TitanHome(); 
             // Close the TitanSignup frame
        }
    });
    timer.setRepeats(false); // Only run once
    timer.start();
    }

}
