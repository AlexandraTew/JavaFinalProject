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
        welcomeLabel.setFont(new Font("Sylfaen", Font.BOLD, 24)); // Using Open Sans font
        welcomeLabel.setForeground(new Color(33, 50, 100)); // Blue font color
        mainPanel.add(welcomeLabel, BorderLayout.NORTH);

        // Middle section: Two charts of equal width and height
        JPanel middlePanel = new JPanel(new GridLayout(1, 2));
        middlePanel.setPreferredSize(new Dimension(getWidth(), getHeight() / 2));

        // Placeholder for chart 1
        JLabel chart1 = new JLabel("Chart 1 Placeholder");
        chart1.setHorizontalAlignment(JLabel.CENTER);
        middlePanel.add(chart1);

        // Placeholder for chart 2
        JLabel chart2 = new JLabel("Chart 2 Placeholder");
        chart2.setHorizontalAlignment(JLabel.CENTER);
        middlePanel.add(chart2);

        mainPanel.add(middlePanel, BorderLayout.CENTER);

        // Bottom section: Three smaller graphs
        JPanel bottomPanel = new JPanel(new GridLayout(1, 3));
        bottomPanel.setPreferredSize(new Dimension(getWidth(), getHeight() / 3));

        // Placeholder for graph 1
        JLabel graph1 = new JLabel("Graph 1 Placeholder");
        graph1.setHorizontalAlignment(JLabel.CENTER);
        bottomPanel.add(graph1);

        // Placeholder for graph 2
        JLabel graph2 = new JLabel("Graph 2 Placeholder");
        graph2.setHorizontalAlignment(JLabel.CENTER);
        bottomPanel.add(graph2);

        // Placeholder for graph 3
        JLabel graph3 = new JLabel("Graph 3 Placeholder");
        graph3.setHorizontalAlignment(JLabel.CENTER);
        bottomPanel.add(graph3);

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