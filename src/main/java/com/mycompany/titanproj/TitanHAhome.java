
package com.mycompany.titanproj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitanHAhome extends JFrame implements ActionListener {
    private JTextArea helpTextArea;
    private JTextArea aboutTextArea;
    private JTabbedPane tabbedPane;
    private JButton backButton;
    private JLabel lbWelcome;
    private JPanel whitePanel;
    ImageIcon tlogo = new ImageIcon("titanimages/newtitanlogo.jpg");
    String pass;
    public TitanHAhome() {
      
        setTitle("User Help and About");
        setSize(980, 600);
        setLayout(new BorderLayout());
        setIconImage(tlogo.getImage());

        // Create white panel for "Help" and "About"
        whitePanel = new JPanel(new BorderLayout());
        whitePanel.setBackground(Color.WHITE);

        // Create tabbed pane
        tabbedPane = new JTabbedPane();

        // Create a JTextArea for the help content
        helpTextArea = new JTextArea();
        helpTextArea.setEditable(false);
        helpTextArea.setLineWrap(true);
        helpTextArea.setWrapStyleWord(true);
        JScrollPane helpScrollPane = new JScrollPane(helpTextArea);
        helpScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        tabbedPane.addTab("Help", helpScrollPane);

        // Create a JTextArea for the about content
        aboutTextArea = new JTextArea();
        aboutTextArea.setEditable(false);
        aboutTextArea.setLineWrap(true);
        aboutTextArea.setWrapStyleWord(true);
        JScrollPane aboutScrollPane = new JScrollPane(aboutTextArea);
        aboutScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        tabbedPane.addTab("About", aboutScrollPane);

        // Set up the back button
        backButton = new JButton("Back");
        backButton.addActionListener(this);

        // Add components to the white panel
        whitePanel.add(createWelcomePanel(), BorderLayout.NORTH);
        whitePanel.add(tabbedPane, BorderLayout.CENTER);

        // Add the white panel and back button to the frame
        add(whitePanel, BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Load help and about content
        loadHelpContent();
        loadAboutContent();
    }

    private JPanel createWelcomePanel() {
        JPanel welcomePanel = new JPanel();
        welcomePanel.setBackground(Color.WHITE);

        // Create a JLabel with the welcome message and background image
        lbWelcome = new JLabel("WELCOME TO TITAN Help");
        lbWelcome.setFont(new Font("Helvetica", Font.BOLD, 25));

        // Load the background image
        ImageIcon backgroundImage = new ImageIcon("titanimages/TITAN.jpg");

        // Set up the background image label
        JLabel lbbackground = new JLabel(backgroundImage);
        lbbackground.setBounds(0, 0, 980, 100);

        welcomePanel.setLayout(null);
        welcomePanel.add(lbbackground);
        welcomePanel.add(lbWelcome);

        lbWelcome.setBounds(90, 10, 1000, 100);

        return welcomePanel;
    }

    private void loadHelpContent() {
        // Placeholder help content
        String helpContent = "Welcome to T.I.T.A.N Help!\n\n" +
                "                  Whether you're a first-time visitor or a returning user, our platform goes beyond the conventional booking process, providing a truly seamless experience that elevates\n" +
                "                  your journey planning.\n\n" +
                "                  If you're new to T.I.T.A.N, we invite you to take a moment to sign up and open the door to the full spectrum of features that our platform has to offer. For our esteemed\n" +
                "                  users with existing accounts, a simple log-in is all it takes to embark on your next adventure.\n\n"+
                "                  Navigate through our thoughtfully designed and user-friendly interface with the utmost ease, using the cursor as your guide. Effortlessly interact with various buttons\n"+
                "                  that have been strategically placed to empower you in tailoring your booking experience. The power is literally at your fingertips, allowing you to schedule your next\n"+
                "                  adventure with a mere click of a button.\n\n"+
                "                  In the unpredictable seas of changing plans, our system acts as a reliable compass, granting you the ability to gracefully abort a scheduled booking or conveniently rebook\n"+
                "                  with just a few clicks.  We understand that life is dynamic, and plans can evolve; hence, we've designed our system to make it as simple as possible for you to modify your\n"+
                "                  arrangements seamlessly.\n\n"+
                "                  Remember, the booking feature is a versatile tool—view it as your artistic palette to craft the perfect itinerary for your future sails. Our ultimate goal is not only to\n"+
                "                  make your experience with T.I.T.A.N efficient but also thoroughly enjoyable.\n\n"+
                "                  So, navigate through the array of options, harness the power of our platform, and embark on your journey with confidence. May your future sails be filled with excitement\n"+
                "                  and smooth sailing. \"Bon Voyage\" for a delightful voyage ahead!.\n\n\n"+
                "                  USE IT WISELY AND ENJOY YOUR FUTURE SAILS! ";
        
        

        helpTextArea.setText(helpContent);
    }

    private void loadAboutContent() {
        // Placeholder about content
        String aboutContent = "About T.I.T.A.N:\n\n" +
                "Traveller's Interactive Ticketing and Accommodation Network(TITAN) \n\n"+
    
                "       IT IS DEVELOPED BY STUDENTS FROM BULACAN STATES UNIVETSITY HAGONOY CAMPUS\n"+
                "       BACHELOR OF SCIENCE IN INFORMATION TECHNOLOGY SECTION 2A - G1.\n"+
                "       THIS IS A PROJECT AT OBJECT-ORIENTED PROGRAMMING 1.\n\n"+
                "       This Remarkable System is Crafted and Brought to Life by the Talented Minds at Bulacan State University Hagonoy Campus. As part of their academic journey in the\n"+
                "       Bachelor of Science in Information Technology, Section 2A - G1, these aspiring technologists have joined forces to tackle the challenges presented in their Object-\n"+
                "       Oriented Programming 1 course. Through their collaborative efforts and innovative thinking, they proudly present to you the result of their hard work and dedication.\n\n"+
                "                          Meet the Brilliant Minds Behind T.I.T.A.N:\n"+                            
                "                              Justfer F. Carabuena\n"+
                "                              Vincent Aaron B. Vicente\n"+
                "                              Zildian Benedict Tablan\n" +
                "                              Joshua Miziel Reyes\n" +
                "                              Miguel Andre L. Nicolas\n" +
                "                              Mary Rose Bionat\n\n"+       
                "       This dynamic team of budding IT professionals has poured their passion into every line of code, every design element, and every feature of the TITAN system. Their\n"+
                "       commitment to excellence shines through, and this project serves as a testament to their skills, creativity, and dedication to advancing their knowledge in the field\n"+
                "       of Information Technology. As they celebrate the completion of this project, they look forward to contributing even more to the world of technology and innovation.\n"+
                "       Kudos to the TITAN team for a job well done!";
        aboutTextArea.setText(aboutContent);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        switch (actionCommand) {
            case "Back":
                dispose();
                new TitanHome();
                break;
        }
    }

    
}
