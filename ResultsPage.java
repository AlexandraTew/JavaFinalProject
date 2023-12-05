import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultsPage extends JFrame {

    public ResultsPage() {
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            } catch (Exception e) {
                e.printStackTrace();
            }
        // Set up the main frame
        setTitle("Ranking Results");
        setSize(1500, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Create a panel to hold components
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Add the banner/header with adjusted font color
        JLabel headerLabel = new JLabel("Discover Home", JLabel.CENTER);
        headerLabel.setFont(new Font("Sylfaen", Font.BOLD, 40));
        headerLabel.setForeground(new Color(33, 50, 100)); // Blue font color
        mainPanel.add(headerLabel, BorderLayout.NORTH);

        // Add the result buttons
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new GridLayout(5, 1, 0, 10)); // 5 rows, 1 column
        resultPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding
        mainPanel.add(resultPanel, BorderLayout.CENTER);

        // Add placeholder buttons for the top 5 results with percentage scores
        Font openSansFont = new Font("Open Sans", Font.PLAIN, 18); // Using Open Sans font
        int[] percentageScores = {97, 95, 92, 89, 85}; // Placeholder scores
        String[] cityNames = {"Portland, Oregon", "Boulder, Colorado", "Madison, Wisconsin", "Seattle, Washington", "Ithaca, New York"};

        for (int i = 0; i < 5; i++) {
            JButton resultButton = new JButton(cityNames[i] + " - " + percentageScores[i] + "% Match");
            resultButton.setFont(openSansFont);
            resultButton.addActionListener(new ResultButtonListener(this, i + 1));
            resultPanel.add(resultButton);
        }

        // Set background color for the buttons section
        resultPanel.setBackground(new Color(188, 194, 155)); // sage green background

        // Add side images
        JLabel leftImage = new JLabel(new ImageIcon("images/borderimage1.jpg"));
        JLabel rightImage = new JLabel(new ImageIcon("images/borderimage2.jpg"));

        mainPanel.add(leftImage, BorderLayout.WEST);
        mainPanel.add(rightImage, BorderLayout.EAST);

        // Set background color for the main panel
        mainPanel.setBackground(new Color(152, 164, 125)); // pastel sage green background

        // Add the main panel to the frame
        add(mainPanel);

        // Make the frame visible
        setVisible(true);
    }

    private class ResultButtonListener implements ActionListener {
        private JFrame parentFrame;

        public ResultButtonListener(JFrame parentFrame, int resultNumber) {
            this.parentFrame = parentFrame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Handle result button click events
            JButton source = (JButton) e.getSource();
            String resultText = source.getText();

            // Extract city name and percentage score from the button text
            String cityName = resultText.split(" - ")[0];
            int percentageScore = Integer.parseInt(resultText.split(" - ")[1].replace("% Match", ""));

            // Check if the clicked button is the top result
            if (percentageScore == 97) { // Replace with the actual top score
                // Close the current window
                parentFrame.dispose();

                // Open the DashboardPage window
                SwingUtilities.invokeLater(() -> new DashboardPage(cityName, percentageScore));
            } else {
                // For other result buttons, show a message
                JOptionPane.showMessageDialog(parentFrame, "You clicked: " + resultText);
                // Add more functionality as needed
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ResultsPage());
    }
}