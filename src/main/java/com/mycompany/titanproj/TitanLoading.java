
package com.mycompany.titanproj;

import javax.swing.*;
import java.awt.*;

public class TitanLoading extends JFrame {
    private JProgressBar progressBar;
    private JLabel loadingLabel;
    private CruiseEmoji cruiseEmoji;
    private RotatingCruise rotatingCruise; // Add RotatingCruise reference
    JLabel lbbackground = new JLabel(new ImageIcon("titanimages/tbg.jfif"));
    ImageIcon tlogo = new ImageIcon("titanimages/newtitanlogo.jpg");
    JFrame tframe = new JFrame();
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    String ages;

    public TitanLoading() {
        initializeUI();
        simulateLoading();
    }

    private void initializeUI() {
        setTitle("Titan Cruise - Loading");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(980, 600);
        setLayout(new BorderLayout());
        setResizable(false);

        // Set the background image at the bottom center
        lbbackground.setLayout(new BorderLayout());
        add(lbbackground, BorderLayout.CENTER);

        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);

        loadingLabel = new JLabel("Loading...");

        cruiseEmoji = new CruiseEmoji();
        rotatingCruise = new RotatingCruise(); // Initialize RotatingCruise

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.add(progressBar);
        panel.add(loadingLabel);
        panel.add(cruiseEmoji);

        // Add the panel at the bottom center
        lbbackground.add(panel, BorderLayout.SOUTH);

        // Add RotatingCruise to lbbackground
        lbbackground.add(rotatingCruise, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void simulateLoading() {
        Timer timer = new Timer(50, e -> {
            progressBar.setValue(progressBar.getValue() + 1);
            loadingLabel.setText("Loading... " + progressBar.getValue() + "%");
            cruiseEmoji.updateLocation(progressBar.getPercentComplete());
            repaint();
            if (progressBar.getValue() == 100) {
                ((Timer) e.getSource()).stop();
                dispose();
                 new TitanHome();
            }
        });

        timer.start(); // Start the timer
    }


class CruiseEmoji extends JComponent {
    private int xPosition = 0;

    public void updateLocation(double percentComplete) {
        int progressBarWidth = getParent().getWidth();
        xPosition = (int) (progressBarWidth * percentComplete);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();
        int size = 50; // Adjust the size of the cruise emoji
        int y = 100 / 2 - size / 2;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(new Color(0, 0, 255)); // Blue color

        
        g2d.translate(xPosition, y);

        double angle = Math.toRadians(0);
        g2d.rotate(angle);
        g2d.setFont(new Font(null, Font.PLAIN, 50));
        g2d.drawString("🚢", 0, 0);
        g2d.dispose();
    }
}
class RotatingCruise extends JComponent {
    private int cruiseAngle = 0;
    private int pathAngle = 0;

    public RotatingCruise() {
        Timer cruiseTimer = new Timer(50, e -> {
            cruiseAngle = (cruiseAngle + 5) % 360;
            repaint();
        });
        cruiseTimer.start();

        Timer pathTimer = new Timer(50, e -> {
            pathAngle = (pathAngle + 1) % 360;
            repaint();
        });
        pathTimer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();
        int size = Math.min(getWidth(), getHeight()) - 100;
        int x = (getWidth() - size) / 2;
        int y = (getHeight() - size) / 2;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.black); 

        // circular path
        int pathX = x + size / 2;
        int pathY = y + size / 2;
        int pathRadius = size / 2 - size / 10;
        g2d.drawOval(pathX - pathRadius, pathY - pathRadius, 2 * pathRadius, 2 * pathRadius);

        // Calculate the position of the cruise emoji with rotation
        int cruiseX = pathX + (int) (pathRadius * Math.cos(Math.toRadians(cruiseAngle)));
        int cruiseY = pathY + (int) (pathRadius * Math.sin(Math.toRadians(cruiseAngle)));

        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, size / 5);
        g2d.setFont(font);

        
        g2d.drawString("🚢", cruiseX, cruiseY);

        g2d.dispose();
    }
}
}
