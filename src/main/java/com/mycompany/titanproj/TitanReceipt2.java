
package com.mycompany.titanproj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitanReceipt2 implements ActionListener {
     JFrame tframe;
     JPanel tpanel = new JPanel();
     JPanel tpanel2,tpanel3,tpanel4,tpanel5,tpanel6,tpanel7;
     JPanel pairPanel;
     JButton record;
     JLabel tlabel,tlabel2,tlabel3,tlabel4,tlabel5;
     JTextArea receipt = new JTextArea();
     JTextArea bookingid = new JTextArea();
    JLabel bg = new JLabel(new ImageIcon("titanimages/tbg.jfif"));
    JLabel rbg = new JLabel(new ImageIcon("titanimages/recim2.jpg"));
        ImageIcon tlogo = new ImageIcon("titanimages/newtitanlogo.jpg");
     String pass;
     
     Font font = new Font("Times New Roman", Font.BOLD, 12);
     String rname;
        String rtraveldate;
        String rbookid;
        String ages;

    public TitanReceipt2(String name,String email,String age,String destination, String traveldate,String payment,String cabintype,String number,String bookid,String password){
        tframe = new JFrame("T.I.T.A.N. Receipt");
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
        tlabel = new JLabel("T.I.T.A.N. Receipt <Norwegian Encore>");
        tlabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
        
      /*  tlabel2 = new JLabel("T.I.T.A.N. <RECEIPT>");
        tlabel2.setFont(new Font("Times New Roman", Font.BOLD, 25));*/

        
        // Create a panel for the label to center it
        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        labelPanel.setBackground(Color.LIGHT_GRAY);
        labelPanel.add(tlabel);
        
       
       // tpanel.add(labelPanel, BorderLayout.CENTER);

        // Create a "Home" button and add it to the top panel on the right side
        
        record = new JButton("Record");
        record.setFont(new Font("Arial", Font.PLAIN, 10));
        record.setPreferredSize(new Dimension(80, 20));
        record.addActionListener(this);
        record.setFocusable(false);
        record.setBackground(Color.LIGHT_GRAY);
        
        tpanel6 = new JPanel();
        tpanel6.setBounds(0,0,280,260);
        tpanel6.setBorder(BorderFactory.createDashedBorder(Color.WHITE));
        tpanel6.setBackground(new Color(173, 216, 230));
        tpanel6.setLayout(new GridLayout(0,1));
        //tpanel6.setLayout(new BoxLayout(tpanel6, BoxLayout.Y_AXIS));
        
        String[] labels = {"Passenger", "Email", "Port", "Travel Date", "Destination", "Cabin Type", "Number of Passenger", "Total Price"};

        for (String label : labels) {
        pairPanel = new JPanel(new GridLayout(2,1));
        pairPanel.setBackground(new Color(173, 216, 230));
       // pairPanel.setLayout(new BoxLayout(pairPanel, BoxLayout.X_AXIS));
        tlabel5 = new JLabel(label + ":");
        tlabel5.setFont(new Font("Times New Roman", Font.BOLD, 12));
        tlabel5.setForeground(Color.BLACK);
        pairPanel.add(tlabel5);
        
        receipt = new JTextArea();
        receipt.append(getValue(label.toLowerCase(), name, email, age, traveldate, destination, cabintype, number, payment));
        receipt.setBackground(Color.WHITE);
        receipt.setEditable(false);
        receipt.setFont(font);
        pairPanel.add(receipt);
        
       tpanel6.add(pairPanel);
        }
        
        bookingid.append("<Booking ID>:"+bookid);
        bookingid.setFont(new Font("Calibri",Font.BOLD,25));
        bookingid.setBackground(Color.WHITE);
        
        tpanel2 = new JPanel();
        tpanel2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        tpanel2.setBounds(50,130,880,300);
        tpanel2.setBackground(Color.CYAN);
        tpanel2.setLayout(null);
       
        tpanel3 = new JPanel(new BorderLayout());
        tpanel3.setBorder(BorderFactory.createDashedBorder(Color.WHITE));
        tpanel3.setBackground(Color.LIGHT_GRAY);
        tpanel3.setBounds(600,0,280,300);
        
        tpanel4 = new JPanel();
        tpanel4.setPreferredSize(new Dimension(280,40));
        //tpanel4.setBounds(600,0,280,40);
        tpanel4.setBorder(BorderFactory.createDashedBorder(Color.WHITE));
        tpanel4.setLayout(new BorderLayout());
        tpanel4.setBackground(new Color(173, 216, 230));
      
        tpanel5 = new JPanel();
        tpanel5.setBounds(0,0,50,300);
        tpanel5.setBorder(BorderFactory.createDashedBorder(Color.WHITE));
        tpanel5.setBackground(new Color(173, 216, 230));
        tpanel5.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        tpanel7 = new JPanel();
        tpanel7.setBounds(50,260,610,40);
        tpanel7.setBackground(Color.white);
        tpanel7.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
        tpanel7.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        tlabel3 = new JLabel();
        tlabel3.setText("<html><br>B<br>O<br>A<br>R<br>D<br>I<br>N<br>G<br><br>P<br>A<br>S<br>S</html>");
        tlabel3.setFont(new Font("Times New Roman",Font.BOLD,17));
        tlabel3.setForeground(Color.BLACK);
        
        tlabel4 = new JLabel();
        tlabel4.setText("              << BOARDING PASS >>");
        tlabel4.setFont(new Font("Times New Roman",Font.BOLD,15));
        tlabel4.setForeground(Color.BLACK);
       
        //Image tlogo2 = tlogo.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        //ImageIcon tlogo3 = new ImageIcon(tlogo2);
        //tlabel4 = new JLabel(tlogo3);
        //tlabel4.setPreferredSize(new Dimension(30, 30));
        
        bg.setBounds(0, 0, 980, 600);
        rbg.setBounds(50,0,610,310);
        rbg.setBorder(BorderFactory.createDashedBorder(Color.WHITE));
       
        
        tframe.add(tpanel, BorderLayout.NORTH);
        tframe.add(tpanel2);
        tpanel.add(labelPanel, BorderLayout.CENTER);
        tpanel.add(record, BorderLayout.EAST);
        tpanel2.add(tpanel3);
        tpanel2.add(tpanel5);
        tpanel2.add(tpanel7);
        tpanel7.add(bookingid);
        //tpanel4.add(tlabel4,BorderLayout.WEST);
       // tpanel4.add(labelPanel2, BorderLayout.CENTER);  
        tpanel2.add(rbg);
        tpanel3.add(tpanel4,BorderLayout.NORTH);
        tpanel3.add(tpanel6);
        tpanel4.add(tlabel4,BorderLayout.CENTER);
        tpanel5.add(tlabel3);
        
        //tpanel6.add(tlabel5);
        //tpanel6.add(receipt);
        tframe.add(bg);
        tframe.setLocationRelativeTo(null);

        tframe.setVisible(true);
        
        this.rname=name;
        this.rtraveldate=traveldate;
        this.rbookid=bookid;
        this.pass = password;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
      String reccommand = ae.getActionCommand();
      
      switch(reccommand){
            case "Home":
                 tframe.dispose();
                 new TitanProj(pass);
                 break;
            case "Record":
              tframe.dispose();
              TitanbRecord trecord = new TitanbRecord(pass);
              trecord.recordholder(rname, rtraveldate, rbookid,pass);
      }
    }
   private String getValue(String field, String name, String email, String age, String traveldate, String destination, String cabintype, String number, String payment) {
    switch (field) {
        case "passenger":
            return name;
        case "email":
            return email;
        case "age":
            return age;
        case "travel date":
            return traveldate;
        case "destination":
            return destination;
        case "cabin type":
            return cabintype;
         case "number of passenger":
            return number;
        case "total price":
            return payment;
        default:
            return "";
        }
   }
}
