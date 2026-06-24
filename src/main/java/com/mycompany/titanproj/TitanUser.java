
package com.mycompany.titanproj;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.SwingUtilities;

public class TitanUser {
    private String name,sname;
    private String firstName;
    private String lastName;
    private String middleName;
    private String birthday;
    private String email,semail;
    private String address;
    private String password;
    String port,destination,traveldate,payments,cabt,cabn,id;
    private int age; // New field for storing age
   

    // Constructor
    private static List<Object[]> dataList = new ArrayList<>();
    
    public TitanUser(String firstName, String lastName, String middleName, String birthday,
                String email, String address, String password,int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthday = birthday;
        this.email = email;
        this.address = address;
        this.password = password;
        this.age = calculateAge();
        
        
        
    // Set visibility to false
        // Calculate age during object creation
        
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
        this.age = calculateAge(); // Recalculate age when birthday is updated
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   
    
      // Calculate age method
    private int calculateAge() {
        // Extract birth year from birthday
        int birthYear = Integer.parseInt(birthday.substring(birthday.lastIndexOf(" ") + 1));

        // Calculate age
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return currentYear - birthYear;
    }
  
}
