//getting all the bits
import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class DashboardPage extends JFrame {

    public DashboardPage(String cityName, int percentageScore) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Set up the main window
        setTitle("Dashboard");
        setSize(1515, 850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a panel to hold components
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(188, 194, 155)); // Sage green background for the main panel

        //header panel - holds title and description - borderlayout
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBackground(new Color(152, 164, 125)); // Sage green background for the header

        JLabel titleLabel = new JLabel("Welcome to " + cityName + "! Your match score: " + percentageScore + "%", JLabel.CENTER);
        titleLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 26)); // Increase font size
        titleLabel.setForeground(new Color(33, 50, 100)); // Blue font color
        titleLabel.setBorder(BorderFactory.createEmptyBorder(8, 0, 5, 0)); //padding around title and spacing for text
        headerPanel.add(titleLabel, BorderLayout.NORTH);

        JLabel descriptionLabel = new JLabel("Explore the data to find out why " + cityName + " is your number one match.");
        descriptionLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 24)); // Set font to Bookman Old Style and size 24
        descriptionLabel.setForeground(new Color(33, 50, 100)); // Navy font color
        descriptionLabel.setHorizontalAlignment(JLabel.CENTER); // Center the text
        descriptionLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 8, 0)); //padding around text
        headerPanel.add(descriptionLabel, BorderLayout.CENTER);

        mainPanel.add(headerPanel, BorderLayout.NORTH);

        //middle panel - GridBagLayout and an empty border
        JPanel middlePanel = new JPanel(new GridBagLayout());
        middlePanel.setBorder(new EmptyBorder(20, 10, 10, 10)); //padding around outermost image edg
        middlePanel.setBackground(new Color(188, 194, 155)); // Sage green background for the middle panel


        //setting max heights for the two image rows so that the images can't exceed this height
        int maxFirstRowHeight = 410; //first row - 2 big images
        int maxLastRowHeight = 280; //second row - 3 baby imgs

        GridBagConstraints firstRowGBC = new GridBagConstraints();
        firstRowGBC.weightx = 1; // spreads images out evenly
        firstRowGBC.gridx = 0;
        
        // Image 1
        ImageIcon imageIcon1 = new ImageIcon("images/Figure_A2.png");
        Image image1 = imageIcon1.getImage().getScaledInstance(-1, maxFirstRowHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(image1);
        JLabel imageLabel1 = new JLabel(scaledIcon1);
        middlePanel.add(imageLabel1, firstRowGBC);
        
        // Adjust the position of Image 1 slightly to the right
        firstRowGBC.insets = new Insets(0, 0, 0, 0); // Adjust right margin of Image 1
        firstRowGBC.gridx++;
        
        //Image 2
        firstRowGBC.insets = new Insets(0, -20, 0, 0); // Adjust left margin of Image 2
        ImageIcon imageIcon2 = new ImageIcon("images/Figure_B3.png");
        Image image2 = imageIcon2.getImage().getScaledInstance(-1, maxFirstRowHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(image2);
        JLabel imageLabel2 = new JLabel(scaledIcon2);
        middlePanel.add(imageLabel2, firstRowGBC);

        mainPanel.add(middlePanel, BorderLayout.CENTER);

        //Bottom panel - GridBagLayout and an empty border
        JPanel bottomPanel = new JPanel(new GridBagLayout());
        bottomPanel.setBorder(new EmptyBorder(10, 10, 15, 10)); //padding around outermost image edges
        bottomPanel.setBackground(new Color(188, 194, 155)); // Sage green background for the bottom panel

        //gbc for last 3 images
        GridBagConstraints lastRowGBC = new GridBagConstraints();
        lastRowGBC.weightx = 1; //again spacing the images evenly (horizontally) - still not sure why but it still works lol
        lastRowGBC.gridx = 0;

        //Image 3
        ImageIcon imageIcon3 = new ImageIcon("images/Figure_C1.png");
        Image image3 = imageIcon3.getImage().getScaledInstance(-1, maxLastRowHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon3 = new ImageIcon(image3);
        JLabel imageLabel3 = new JLabel(scaledIcon3);
        bottomPanel.add(imageLabel3, lastRowGBC);
        lastRowGBC.gridx++;

        // Image 4
        ImageIcon imageIcon4 = new ImageIcon("images/Figure_D.png");
        Image image4 = imageIcon4.getImage().getScaledInstance(-1, maxLastRowHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon4 = new ImageIcon(image4);
        JLabel imageLabel4 = new JLabel(scaledIcon4);
        bottomPanel.add(imageLabel4, lastRowGBC);
        lastRowGBC.gridx++;

        // Image 5
        ImageIcon imageIcon5 = new ImageIcon("images/Figure_1e.png");
        Image image5 = imageIcon5.getImage().getScaledInstance(-1, maxLastRowHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon5 = new ImageIcon(image5);
        JLabel imageLabel5 = new JLabel(scaledIcon5);
        bottomPanel.add(imageLabel5, lastRowGBC);
        lastRowGBC.gridx++;
        
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
