import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultsPage extends JFrame {

    public ResultsPage() {
        // Set up the main frame
        setTitle("Ranking Results");
        setSize(1500, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Create a panel to hold components
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Add the banner/header
        JLabel headerLabel = new JLabel("Discover Home", JLabel.CENTER);
        headerLabel.setFont(new Font("Open Sans", Font.BOLD, 24)); // Using Open Sans font
        mainPanel.add(headerLabel, BorderLayout.NORTH);

        // Add the result buttons
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new GridLayout(5, 1, 0, 10)); // 5 rows, 1 column
        resultPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding
        mainPanel.add(resultPanel, BorderLayout.CENTER);

        // Add placeholder buttons for the top 5 results
        Font openSansFont = new Font("Open Sans", Font.PLAIN, 18); // Using Open Sans font
        for (int i = 1; i <= 5; i++) {
            JButton resultButton = new JButton("Result " + i);
            resultButton.setFont(openSansFont);
            resultButton.addActionListener(new ResultButtonListener(this, i));
            resultPanel.add(resultButton);
        }

        // Add side images
        JLabel leftImage = new JLabel(new ImageIcon("left_image_placeholder.jpg"));
        JLabel rightImage = new JLabel(new ImageIcon("right_image_placeholder.jpg"));

        mainPanel.add(leftImage, BorderLayout.WEST);
        mainPanel.add(rightImage, BorderLayout.EAST);

        // Set background color
        mainPanel.setBackground(new Color(0xE0F7FA)); // Light blue background

        // Add the main panel to the frame
        add(mainPanel);

        // Make the frame visible
        setVisible(true);
    }

    private class ResultButtonListener implements ActionListener {
        private JFrame parentFrame;
        private int resultNumber;

        public ResultButtonListener(JFrame parentFrame, int resultNumber) {
            this.parentFrame = parentFrame;
            this.resultNumber = resultNumber;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Handle result button click events
            JButton source = (JButton) e.getSource();
            String resultText = source.getText();

            // Check if the clicked button is "Result 1"
            if (resultText.equals("Result 1")) {
                // Close the current window
                parentFrame.dispose();

                // Open the DashboardPage window
                SwingUtilities.invokeLater(() -> new DashboardPage());
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