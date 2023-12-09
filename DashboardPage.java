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
        mainPanel.setBackground(new Color(188, 194, 155)); // Sage green background for the main panel

        // Add a welcome message with the city name and percentage score at the top
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBackground(new Color(152, 164, 125)); // Sage green background for the header

        JLabel titleLabel = new JLabel("Welcome to " + cityName + "! Your match score: " + percentageScore + "%", JLabel.CENTER);
        titleLabel.setFont(new Font("Sylfaen", Font.BOLD, 40)); // Increase font size
        titleLabel.setForeground(new Color(33, 50, 100)); // Blue font color
        titleLabel.setBorder(BorderFactory.createEmptyBorder(13, 0, -8, 0)); //padding around title and spacing for text
        headerPanel.add(titleLabel, BorderLayout.NORTH);

        JLabel descriptionLabel = new JLabel("Explore the data to find out why " + cityName + " is your number one match.");
        descriptionLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 24)); // Set font to Bookman Old Style and size 24
        descriptionLabel.setForeground(new Color(33, 50, 100)); // Navy font color
        descriptionLabel.setHorizontalAlignment(JLabel.CENTER); // Center the text
        descriptionLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); //padding around text
        headerPanel.add(descriptionLabel, BorderLayout.CENTER);

        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // Middle section
        JPanel middlePanel = new JPanel(new GridLayout(1, 2));
        middlePanel.setPreferredSize(new Dimension(getWidth(), getHeight() / 2));
        middlePanel.setBackground(new Color(188, 194, 155)); // Sage green background for the middle panel

        // Image 1
        ImageIcon imageIcon1 = new ImageIcon("images/Figure_6.png");
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
        bottomPanel.setBackground(new Color(188, 194, 155)); // Sage green background for the bottom panel

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
        ImageIcon imageIcon5 = new ImageIcon("images/Figure_1.png");
        JLabel imageLabel5 = new JLabel(imageIcon5);
        imageLabel5.setHorizontalAlignment(JLabel.CENTER);
        bottomPanel.add(imageLabel5);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

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
