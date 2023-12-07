//getting all the bits
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//119,210,198 - possible color change - tealish
public class WelcomePage extends JFrame {

    public WelcomePage() {
        
        //setting look to nimbus to make it less 2005
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //window title, close operation, and min default size
        setTitle("Discover Home Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1515, 800));

        
        //main panel - changed to gridbaglayout so components resize dynamically and equally
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1; //handles vertical space distribution when window is resized
        gbc.weightx = 1;  //handles horizontal space distribution when window is resized
        gbc.fill = GridBagConstraints.BOTH;  //handles expansion of components when window is resized

        //top panel welcome label will sit on
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(152, 164, 125));
        
        //changing height of topPanel so the welcome label isnt so dwarfed by the size of the panel
        topPanel.setPreferredSize(new Dimension(topPanel.getPreferredSize().width, 60)); 

        
        //welcome label - 'Discover Home'
        JLabel welcomeLabel = new JLabel("Discover Home", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Sylfaen", Font.BOLD,50));
        welcomeLabel.setForeground(new Color(33, 50, 100)); //blue font color
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(25, 0, 0, 0)); //spacing around title
        topPanel.add(welcomeLabel, BorderLayout.CENTER);
        mainPanel.add(topPanel, gbc); //adding to main panel for current grid row and column

        //panel for explanation text - BoxLayout
        gbc.gridy++; //incrementing gridy to move to next row for new components
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setBackground(new Color(188, 194, 155));
        textPanel.setBorder(BorderFactory.createEmptyBorder(65, 0, 0, 0));
        mainPanel.add(textPanel, gbc); //adding to main panel for current grid row and column

        //explanation text
        Font labelFont = new Font("Bookman Old Style", Font.PLAIN, 18);
        String[] explanationText = {
                "Welcome to Discover Home, the platform dedicated to fostering a sustainable and connected future. We leverage big data to empower those seeking to connect with",
                "like-minded individuals across the United States. Whether you are looking to find your people within your current community or are seeking to relocate to find where",
                "you fit Discover Home will offer you the tools to find the region city and community that best aligns with your values. We go beyond traditional social networks, real",
                "estate tools, and eco-conscious apps to offer a holistic solution that prioritizes long-term well-being, community building, and ecological sustainability.",
                " ", 
                "Only when we are connected can we build a healthier happier, world."

        };

        //looping through explanation string array to add labels with consistent formatting to text panel
        for (String text : explanationText) {
            JLabel label = new JLabel(text);
            label.setFont(labelFont);
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            textPanel.add(label);
            textPanel.add(Box.createRigidArea(new Dimension(0, 7)));
        }

        //panel to hold image and button and tagline- BoxLayout
        gbc.gridy++; //incrementing gridy to move to next row for new components
        JPanel imageButtonPanel = new JPanel();
        imageButtonPanel.setBackground(new Color(188, 194, 155));
        imageButtonPanel.setLayout(new BoxLayout(imageButtonPanel, BoxLayout.Y_AXIS));
        mainPanel.add(imageButtonPanel, gbc); //adding to main panel for current grid row and column


        //adding image
        ImageIcon originalImageIcon = new ImageIcon("images/world.jpg");
        //variable to easily scale image
        int newWidth = 500;
        int newHeight = 200;
        //smooth scaling image to maintain quality as much as possible
        ImageIcon scaledImageIcon = new ImageIcon(originalImageIcon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH));
        JLabel imageLabel = new JLabel(scaledImageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageButtonPanel.add(Box.createRigidArea(new Dimension(0, 5))); //spacing between image and explanation text
        imageButtonPanel.add(imageLabel);
        imageButtonPanel.add(Box.createRigidArea(new Dimension(0, 75))); //spacing between image and tagline

        //tagline label 
        //using html formatting to add decorative double quotes
        JLabel tagLineLabel = new JLabel("<html><center>&ldquo;Find your people. Find your place.&rdquo;</center></html>", JLabel.CENTER);
        tagLineLabel.setFont(new Font("Bookman Old Style", Font.ITALIC, 26));
        tagLineLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageButtonPanel.add(tagLineLabel);
        imageButtonPanel.add(Box.createRigidArea(new Dimension(0, 20))); //spacing between tagline and button

        //adding button
        JButton button = new JButton("Explore");
        button.setFont(new Font("Arial", Font.PLAIN, 20)); //considering Cambria for this font instead bc it feels boring rn
        button.setBackground(new Color(70, 130, 180)); //button color
        button.setForeground(Color.WHITE); //button text color
        button.setPreferredSize(new Dimension(200, 50));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageButtonPanel.add(button);
        imageButtonPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        //adding action listener to button - links to second page
        button.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                // Close the current WelcomePage
                dispose();  // This will close the current JFrame
        
                // Open the RankingsPage
                SwingUtilities.invokeLater(() -> 
                {
                    new RankingsPage();
                });
            }
        });
        //adding main panel to JFrame and making visible
        add(mainPanel);
        pack();  //ensures all components are at or above preferred size
        setLocationRelativeTo(null);  //centers frame on screen when launched
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WelcomePage());
    }
}
