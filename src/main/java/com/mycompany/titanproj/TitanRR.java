
package com.mycompany.titanproj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class TitanRR extends JFrame implements ActionListener {
    private JFrame rframe;
    private JButton submitButton;
    private JTextArea reviewTextArea;
    private JComboBox<Integer> ratingComboBox;
    private JPanel starPanel;
    private TitanReviewM userReviewManager;  // Reference to TitanReviewM

    public TitanRR(TitanReviewM userReviewManager) {
        this.userReviewManager = TitanReviewM.getInstance();

        rframe = new JFrame("Review & Rating");
        rframe.setSize(400, 300);
        rframe.setLayout(null);
 
        JLabel questionLabel = new JLabel("How's your sail in our Website?");
        questionLabel.setBounds(20, 0, 300, 20);
        
        JLabel reviewLabel = new JLabel("Write your review:");
        reviewLabel.setBounds(20, 30, 150, 20);

        reviewTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(reviewTextArea);
        scrollPane.setBounds(20, 60, 350, 120);

        JLabel ratingLabel = new JLabel("Select rating:");
        ratingLabel.setBounds(20, 190, 100, 20);

        Integer[] ratingOptions = {1, 2, 3, 4, 5};
        ratingComboBox = new JComboBox<>(ratingOptions);
        ratingComboBox.setBounds(120, 190, 50, 20);

        starPanel = new JPanel();
        starPanel.setBounds(180, 180, 150, 40); // Increase both width and adjust x-coordinate
        starPanel.setVisible(true);

        // Add an ItemListener to ratingComboBox
        ratingComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    updateStarPanel((Integer) ratingComboBox.getSelectedItem());
                }
            }
        });

        submitButton = new JButton("Submit Review");
        submitButton.setBounds(150, 220, 150, 30);
        submitButton.addActionListener(this);
        submitButton.setEnabled(true);
         
        rframe.add(questionLabel);
        rframe.add(reviewLabel);
        rframe.add(scrollPane);
        rframe.add(ratingLabel);
        rframe.add(ratingComboBox);
        rframe.add(starPanel);
        rframe.add(submitButton);

        rframe.setVisible(true);
        rframe.setLocationRelativeTo(null);
        rframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String reviewText = reviewTextArea.getText();
            int selectedRating = Integer.parseInt(ratingComboBox.getSelectedItem().toString());

            // Use TitanReviewM to add the review
            userReviewManager.addTitanUReview(reviewText, selectedRating);
            System.out.println("Review added. Number of reviews: " + userReviewManager.getAllReviews().size());
            JOptionPane.showMessageDialog(rframe, "Review submitted!\nText: " + reviewText + "\nRating: " + selectedRating);

            // Close the review frame after submission
            rframe.dispose();
        }
    }

    private void updateStarPanel(int rating) {
        starPanel.removeAll();
        for (int i = 0; i < rating; i++) {
            JLabel starLabel = new JLabel("🚢");
            starLabel.setForeground(Color.BLUE);
            starLabel.setFont(new Font(null, Font.PLAIN, 20)); 
            starPanel.add(starLabel);
        }

        starPanel.revalidate();
        starPanel.repaint();
        starPanel.setVisible(true);
    }

    
}
