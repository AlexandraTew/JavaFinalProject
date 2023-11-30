import javax.swing.*;
import java.awt.*;

public class DashboardPage extends JFrame {

    public DashboardPage(String cityName, int percentageScore) {
        // Set up the main window
        setTitle("Dashboard");
        setSize(1500, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(0xE0F7FA)); // Light Blue background color
        setLayout(new BorderLayout());

        // Create and add components to the main window

        // Top section: Two charts of equal width and height
        JPanel topPanel = new JPanel(new GridLayout(1, 2));
        topPanel.setPreferredSize(new Dimension(getWidth(), getHeight() / 3));

        // Placeholder for chart 1
        JLabel chart1 = new JLabel("Chart 1 Placeholder");
        chart1.setHorizontalAlignment(JLabel.CENTER);
        topPanel.add(chart1);

        // Placeholder for chart 2
        JLabel chart2 = new JLabel("Chart 2 Placeholder");
        chart2.setHorizontalAlignment(JLabel.CENTER);
        topPanel.add(chart2);

        add(topPanel, BorderLayout.NORTH);

        // Middle section: Three smaller graphs
        JPanel middlePanel = new JPanel(new GridLayout(1, 3));
        middlePanel.setPreferredSize(new Dimension(getWidth(), getHeight() / 3));

        // Placeholder for graph 1
        JLabel graph1 = new JLabel("Graph 1 Placeholder");
        graph1.setHorizontalAlignment(JLabel.CENTER);
        middlePanel.add(graph1);

        // Placeholder for graph 2
        JLabel graph2 = new JLabel("Graph 2 Placeholder");
        graph2.setHorizontalAlignment(JLabel.CENTER);
        middlePanel.add(graph2);

        // Placeholder for graph 3
        JLabel graph3 = new JLabel("Graph 3 Placeholder");
        graph3.setHorizontalAlignment(JLabel.CENTER);
        middlePanel.add(graph3);

        add(middlePanel, BorderLayout.CENTER);

        // Bottom section: Two sections for text blocks
        JPanel bottomPanel = new JPanel(new GridLayout(2, 1));
        bottomPanel.setPreferredSize(new Dimension(getWidth(), getHeight() / 3));

        // Placeholder for text block 1
        JTextArea textBlock1 = new JTextArea("Text Block 1 Placeholder");
        textBlock1.setEditable(false);
        bottomPanel.add(new JScrollPane(textBlock1));

        // Placeholder for text block 2
        JTextArea textBlock2 = new JTextArea("Text Block 2 Placeholder");
        textBlock2.setEditable(false);
        bottomPanel.add(new JScrollPane(textBlock2));

        add(bottomPanel, BorderLayout.SOUTH);

        // Add a welcome message with the city name and percentage score
        JLabel welcomeLabel = new JLabel("Welcome to " + cityName + "! Your match score: " + percentageScore + "%", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Open Sans", Font.BOLD, 24)); // Using Open Sans font
        add(welcomeLabel, BorderLayout.CENTER);

        // Display the window
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DashboardPage("Sample City", 90)); // Example city and percentage score
    }
}
