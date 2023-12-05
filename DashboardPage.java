import javax.swing.*;
import java.awt.*;

public class DashboardPage extends JFrame {

    public DashboardPage(String cityName, int percentageScore) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Set up the main window
        setTitle("Dashboard");
        setSize(1500, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a panel to hold components
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Add a welcome message with the city name and percentage score at the top
        JLabel welcomeLabel = new JLabel("Welcome to " + cityName + "! Your match score: " + percentageScore + "%", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Sylfaen", Font.BOLD, 24)); 
        welcomeLabel.setForeground(new Color(33, 50, 100)); // Blue font color
        mainPanel.add(welcomeLabel, BorderLayout.NORTH);

        // Middle section
        JPanel middlePanel = new JPanel(new GridLayout(1, 2));
        middlePanel.setPreferredSize(new Dimension(getWidth(), getHeight() / 2));

        // Image 1
        ImageIcon imageIcon1 = new ImageIcon("images/Figure_1.png");
        JLabel imageLabel1 = new JLabel(imageIcon1);
        imageLabel1.setHorizontalAlignment(JLabel.CENTER);
        middlePanel.add(imageLabel1);

        // Image 2
        ImageIcon imageIcon2 = new ImageIcon("images/Figure_3.png");
        JLabel imageLabel2 = new JLabel(imageIcon2);
        imageLabel2.setHorizontalAlignment(JLabel.CENTER);
        middlePanel.add(imageLabel2);

        mainPanel.add(middlePanel, BorderLayout.CENTER);

        // Bottom section
        JPanel bottomPanel = new JPanel(new GridLayout(1, 3));
        bottomPanel.setPreferredSize(new Dimension(getWidth(), getHeight() / 3));

        // Image 3
        ImageIcon imageIcon3 = new ImageIcon("images/Figure_2.5.png"); 
        JLabel imageLabel3 = new JLabel(imageIcon3);
        imageLabel3.setHorizontalAlignment(JLabel.CENTER);
        bottomPanel.add(imageLabel3);

        // Image 4
        ImageIcon imageIcon4 = new ImageIcon("images/Figure_4.png"); 
        JLabel imageLabel4 = new JLabel(imageIcon4);
        imageLabel4.setHorizontalAlignment(JLabel.CENTER);
        bottomPanel.add(imageLabel4);

        // Image 5
        ImageIcon imageIcon5 = new ImageIcon("images/Figure_2.5.png"); 
        JLabel imageLabel5 = new JLabel(imageIcon5);
        imageLabel5.setHorizontalAlignment(JLabel.CENTER);
        bottomPanel.add(imageLabel5);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Set background color for the main panel
        mainPanel.setBackground(new Color(152, 164, 125)); // pastel sage green background

        // Add the main panel to the frame
        add(mainPanel);

        // Display the window
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DashboardPage("Sample City", 90)); // Example city and percentage score
    }
}