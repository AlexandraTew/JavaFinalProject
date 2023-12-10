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
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBackground(new Color(152, 164, 125)); // Sage green background for the header

        JLabel headerLabel1 = new JLabel("Discover Home", JLabel.CENTER);
        headerLabel1.setFont(new Font("Bookman Old Style", Font.PLAIN, 35)); //made this smaller to let intro text stand out more
        headerLabel1.setForeground(new Color(33, 50, 100)); // Navy font color
        headerLabel1.setBorder(BorderFactory.createEmptyBorder(20, 0, -6, 0)); //padding around title
        headerPanel.add(headerLabel1, BorderLayout.NORTH);

        JLabel introLabel = new JLabel("Based upon your selections and our calculations, the following locations represent your top 5 location matches:");
        introLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 25)); //made this larger to be more in focus
        introLabel.setForeground(new Color(33, 50, 100)); // Navy font color
        introLabel.setHorizontalAlignment(JLabel.CENTER); // Center the text
        introLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 16, 0)); //spacing/ padding around text
        headerPanel.add(introLabel, BorderLayout.CENTER);

        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // Add the result buttons
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new GridLayout(5, 1, 0, 10)); // 5 rows, 1 column
        resultPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding
        resultPanel.setBackground(new Color(188, 194, 155)); // Sage green background for the results panel
        mainPanel.add(resultPanel, BorderLayout.CENTER);

        // Add placeholder buttons for the top 5 results with percentage scores
        Font bookmanFont = new Font("Bookman Old Style", Font.PLAIN, 18); // Using Bookman Old Style font
        int[] percentageScores = {97, 95, 92, 89, 85}; // Placeholder scores
        String[] cityNames = {"Portland, Oregon", "Boulder, Colorado", "Madison, Wisconsin", "Seattle, Washington", "Ithaca, New York"};

        for (int i = 0; i < 5; i++) {
            JButton resultButton = new JButton(cityNames[i] + " - " + percentageScores[i] + "% Match");
            resultButton.setFont(bookmanFont);
            resultButton.setForeground(Color.WHITE); // White font color
            resultButton.setBackground(new Color(33, 50, 100)); // Navy button color
            resultButton.addActionListener(new ResultButtonListener(this, i + 1));
            resultPanel.add(resultButton);
        }

        // Add side images
        JLabel leftImage = new JLabel(new ImageIcon("images/borderimage1.jpg"));
        JLabel rightImage = new JLabel(new ImageIcon("images/borderimage2.jpg"));

        mainPanel.add(leftImage, BorderLayout.WEST);
        mainPanel.add(rightImage, BorderLayout.EAST);

        // Set background color for the main panel
        mainPanel.setBackground(new Color(188, 194, 155)); // Sage green background for the main panel

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