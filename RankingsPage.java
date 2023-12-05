import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RankingsPage extends JFrame {

    public RankingsPage() {
        // Set up the main window
        setTitle("Rankings Page");
        setSize(1500, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Main panel with sage green background
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(152, 164, 125)); // Sage Green background color
        mainPanel.setLayout(new BorderLayout());

        // Add the banner/header with adjusted font color
        JLabel headerLabel = new JLabel("Discover Home", JLabel.CENTER);
        headerLabel.setFont(new Font("Sylfaen", Font.BOLD, 40));
        headerLabel.setForeground(new Color(33, 50, 100)); // Blue font color
        mainPanel.add(headerLabel, BorderLayout.NORTH);

        // Left section: Image and User Instructions
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setPreferredSize(new Dimension(getWidth() / 2, getHeight()));

        // Placeholder for the image
        ImageIcon handImageIcon = resizeImage("images/hand.jpg", 300, 200); // Set width and height as needed
        JLabel handImageLabel = new JLabel(handImageIcon);
        handImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        leftPanel.add(Box.createVerticalGlue()); // Add vertical glue to center the image
        leftPanel.add(handImageLabel);
        leftPanel.add(Box.createVerticalGlue()); // Add vertical glue to center the image

        // Right section: Dropdown menus for rankings and Submit button
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setPreferredSize(new Dimension(getWidth() / 2, getHeight()));

        // Header for the rankings
        JLabel rankingsHeaderLabel = new JLabel("Rank these in order of importance");
        rankingsHeaderLabel.setFont(new Font("Open Sans", Font.BOLD, 16));
        rankingsHeaderLabel.setHorizontalAlignment(JLabel.CENTER);
        rightPanel.add(rankingsHeaderLabel);

        // Dropdown menus for rankings
        String[] rankingOptions = {
                "Fresh Local Produce",
                "Proximity to Parks and Natural Spaces",
                "Abundance of Schools and Hospitals",
                "Availability of Clean Energy",
                "Risk of Inclement Weather"
        };

        for (int i = 1; i <= 5; i++) {
            JComboBox<String> rankingDropdown = new JComboBox<>(rankingOptions);
            rankingDropdown.setSelectedIndex(i - 1); // Select default value
            // Set a larger preferred width to ensure the entire component is visible
            rankingDropdown.setPreferredSize(new Dimension(350, 30));
            rightPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Adjust vertical spacing
            rightPanel.add(rankingDropdown);
        }

        // Submit button with sage green background
        JButton submitButton = new JButton("Submit");
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.setBackground(new Color(152, 164, 125)); // Sage Green background color
        rightPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Adjust vertical spacing
        rightPanel.add(submitButton);

        // Action listener for the Submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the current RankingsPage
                dispose();  // This will close the current JFrame

                // Open the ResultsPage
                SwingUtilities.invokeLater(() -> {
                    new ResultsPage();
                });
            }
        });

        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(rightPanel, BorderLayout.EAST);

        add(mainPanel);

        // Display the window
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    private ImageIcon resizeImage(String imagePath, int width, int height) {
        ImageIcon originalImageIcon = new ImageIcon(imagePath);
        Image originalImage = originalImageIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RankingsPage());
    }
}