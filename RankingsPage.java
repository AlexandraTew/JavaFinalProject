import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RankingsPage extends JFrame {

    public RankingsPage() {
        //setting look to nimbus to make it less 2005
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //window title, close operation, and min default size
        setTitle("Rankings Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1515, 800));

        //main panel - changed to gridbaglayout so components resize dynamically and equally - will use for all panels except topPanel
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1; //handles vertical space distribution when window is resized
        gbc.weightx = 1;  //handles horizontal space distribution when window is resized
        gbc.fill = GridBagConstraints.BOTH;  //handles expansion of components when window is resized
 
        
        //top panel welcome label will sit on
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(152, 164, 125)); //sage green
         
        //changing height of topPanel so the welcome label isnt so dwarfed by the size of the panel
        //welcome is set at 60 but this one is set at 80, idk why they had to be different to visually appear the same - im guessing some of the other spacing components are responsible for the difference
        topPanel.setPreferredSize(new Dimension(topPanel.getPreferredSize().width, 80)); 
 
        //welcome label - 'Discover Home'
        JLabel welcomeLabel = new JLabel("Discover Home", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Sylfaen", Font.BOLD,50));
        welcomeLabel.setForeground(new Color(33, 50, 100)); //blue font color
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(25, 0, 0, 0)); //spacing around title
        topPanel.add(welcomeLabel, BorderLayout.CENTER);

        //setting specific GridBagConstraints for top label so label spans entire window horizontally
        GridBagConstraints gbcTopPanel = new GridBagConstraints();
        gbcTopPanel.gridx = 0;
        gbcTopPanel.gridy = 0;
        gbcTopPanel.gridwidth = GridBagConstraints.REMAINDER; //making topPanel span entire width
        gbcTopPanel.weighty = 0; //setting weighty to 0 bc it doesnt need to expand vertically 
        gbcTopPanel.weightx = 1; //setting weightx to 1 to allow topPanel to span the entire width
        gbcTopPanel.fill = GridBagConstraints.HORIZONTAL; //letting topPanel stretch horizontally

        //adding topPanel to mainPAnel with custom gbc constraints
        mainPanel.add(topPanel, gbcTopPanel); 


        //leftPanel - boxlayout
        gbc.gridy++;
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        //image
        ImageIcon handImageIcon = resizeImage("images/hand.jpg", 300, 200); // Set width and height as needed
        JLabel handImageLabel = new JLabel(handImageIcon);
        handImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        leftPanel.add(Box.createVerticalGlue()); // Add vertical glue to center the image
        leftPanel.add(handImageLabel);
        leftPanel.add(Box.createVerticalGlue()); // Add vertical glue to center the image

        //adding leftPanel to mainPanel
        mainPanel.add(leftPanel, gbc);

        //rightPanel - Dropdown menus for rankings and Submit button
        gbc.gridx++;
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        //small header for dropdowns
        gbc.insets = new Insets(0, 0, 0, 10); //moving everything to the right a bit
        JLabel rankingsHeaderLabel = new JLabel("Rank these in order of importance");
        rankingsHeaderLabel.setFont(new Font("Open Sans", Font.BOLD, 16));
        rankingsHeaderLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); //spacing around header
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
            //increasing width to make sure entire thing is visible
            //rankingDropdown.setPreferredSize(new Dimension(350, 30));
            rightPanel.add(rankingDropdown);
        }

        //submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(new Color(152, 164, 125)); //pastel Green background color

        //font/size for text
        Font buttonFont = new Font("Arial", Font.PLAIN, 18); //same font as in WelcomePage.java - diff size
        submitButton.setFont(buttonFont);
        
        //making submit panel to center submit button properly
        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new BoxLayout(submitPanel, BoxLayout.X_AXIS));
        submitPanel.add(Box.createHorizontalGlue()); //glue on the left of button
        submitPanel.add(submitButton);
        submitPanel.add(Box.createHorizontalGlue()); //glue on the right of button

        //adding border to submit panel so button isnt right up against the edge of the panel
        int padding = 7; //variable to toggle padding around button easily bc ive changed it a million times at this point
        EmptyBorder emptyBorder = new EmptyBorder(padding, padding, padding, padding);
        submitPanel.setBorder(emptyBorder);

        //adding submit panel to right panel
        rightPanel.add(submitPanel);

        //action listener for the Submit button
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

        //adding rightPanel to mainPanel
        mainPanel.add(rightPanel, gbc);

        //adding panel to JFrame, making visible and centering in window
        add(mainPanel);
        setLocationRelativeTo(null);
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
