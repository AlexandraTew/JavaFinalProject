import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

public class RankingsPage extends JFrame {
    //declaration for dropdown array
    private JComboBox<String>[] dropdowns; 

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

        //main panel - gridbaglayout
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(188, 194, 155)); //pastel green color

        //setting GridBagConstraints for mainPanel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1; //handles vertical space distribution when window is resized
        gbc.weightx = 1;  //handles horizontal space distribution when window is resized
        gbc.fill = GridBagConstraints.BOTH;  //handles expansion of components when window is resized

        
        //setting specific GridBagConstraints for top label so label spans entire window horizontally
        GridBagConstraints gbcTopPanel = new GridBagConstraints();
        gbcTopPanel.gridx = 0;
        gbcTopPanel.gridy = 0;
        gbcTopPanel.gridwidth = GridBagConstraints.REMAINDER; //making topPanel span entire width
        gbcTopPanel.weighty = 0; //setting weighty to 0 bc it doesnt need to expand vertically
        gbcTopPanel.weightx = 1; //setting weightx to 1 to allow topPanel to span the entire width
        gbcTopPanel.fill = GridBagConstraints.HORIZONTAL; //letting topPanel stretch horizontally
        
        
        //top panel welcome label will sit on
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(152, 164, 125)); //sage green color

        //changing height of topPanel so the welcome label isnt so dwarfed by the size of the panel
        //welcome is set at 60 but this one is set at 80, idk why they had to be different to visually appear the same - im guessing some of the other spacing components are responsible for the difference
        topPanel.setPreferredSize(new Dimension(topPanel.getPreferredSize().width, 80));

        //welcome label - 'Discover Home'
        JLabel welcomeLabel = new JLabel("Discover Home", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Sylfaen", Font.BOLD,50));
        welcomeLabel.setForeground(new Color(33, 50, 100)); //blue font color
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(25, 0, 0, 0)); //spacing around title
        topPanel.add(welcomeLabel, BorderLayout.CENTER);

        //adding topPanel to mainPAnel with custom gbc constraints
        mainPanel.add(topPanel, gbcTopPanel);



        //leftPanel - image and direction text - boxlayout
        gbc.gridy++; //incrementing y so leftPanel is below topPanel
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBackground(new Color(188, 194, 155)); //pastel green color


        //empty border for whole left panel to give it some breathing room
        int leftPanelPadding = 20; //we can change this later ut i think 20 is nice
        leftPanel.setBorder(BorderFactory.createEmptyBorder(0, leftPanelPadding, 0, leftPanelPadding));


        /*first paragraph above the image - using html to format text bc I wanted a header and paragraph and this is the easiest
        way to change font and size of text in a JLabel like that (as far as i know)*/
        String firstParagraphText = "<html><div style='text-align: center;'>" +
        "<h2 style='font-family: Arial; font-size: 24pt; font-weight: bold;'>Unleash the Power of Your Preferences</h2>" +
        "<p style='font-family: Arial; font-size: 18pt;'>At Discover Home, we understand that the concept of an ideal living environment is as unique as you are. " +
        "Our intuitive GUI allows you to articulate your priorities by ranking criteria that matter most to you. " +
        "With user-friendly dropdown menus, you take control of the factors that shape your living experience. Place the most important criterion in the first dropdown and continue in order of priority.</p></div></html>";

        JLabel firstParagraphLabel = new JLabel(firstParagraphText);
        firstParagraphLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        leftPanel.add(Box.createVerticalGlue()); //glue above text to center it
        leftPanel.add(firstParagraphLabel);
        leftPanel.add(Box.createVerticalGlue()); //glue below text to sep from the image

        //image
        ImageIcon handImageIcon = resizeImage("images/hand.jpg", 300, 200); //may adjust later
        JLabel handImageLabel = new JLabel(handImageIcon);
        handImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        leftPanel.add(handImageLabel);
        leftPanel.add(Box.createVerticalGlue()); //glue to seperate image from text

        //second paragraph above the image - using html to format text again
        String secondParagraphText = "<html><div style='text-align: center;'>" +
        "<h2 style='font-family: Arial; font-size: 24pt; font-weight: bold;'>Tailored Recommendations, Just for You</h2>" +
        "<p style='font-family: Arial; font-size: 18pt;'>Once you've ranked your preferences, just press submit and our recommender engine will take it from there. " +
        "We methodically process your input to provide you with a curated list of locations that align with your individual priorities. " +
        "Say goodbye to generic suggestions—welcome to a world of personalized recommendations tailored specifically to your lifestyle.</p></div></html>";

        JLabel secondParagraphLabel = new JLabel(secondParagraphText);
        secondParagraphLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        leftPanel.add(secondParagraphLabel);
        leftPanel.add(Box.createVerticalGlue()); //glue below text to center it

        //adding leftPanel to mainPanel
        mainPanel.add(leftPanel, gbc);

        
        //rightPanel - Dropdown menus for rankings and Submit button - BoxLayout
        gbc.gridx++;
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBackground(new Color(188, 194, 155)); //pastel green color

        //small header for dropdowns
        gbc.insets = new Insets(0, 0, 0, 10); //moving everything to the left a bit
        JLabel rankingsHeaderLabel = new JLabel("Tell Us What Matters Most to You");
        rankingsHeaderLabel.setFont(new Font("Open Sans", Font.BOLD, 17));
        rankingsHeaderLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); //spacing around header
        rankingsHeaderLabel.setHorizontalAlignment(JLabel.CENTER);

        //panel to hold header label and glue to center it bc it being off center wa driving me nuts
        JPanel rankingsHeaderPanel = new JPanel();
        rankingsHeaderPanel.setLayout(new BoxLayout(rankingsHeaderPanel, BoxLayout.X_AXIS));
        rankingsHeaderPanel.setBackground(new Color(188, 194, 155)); //pastel green color
        
        rankingsHeaderPanel.add(Box.createHorizontalGlue()); //glue on the left of header
        rankingsHeaderPanel.add(rankingsHeaderLabel);
        rankingsHeaderPanel.add(Box.createHorizontalGlue()); //glue on the right of header     

        //adding header panel to right panel
        rightPanel.add(rankingsHeaderPanel);


        //custom font for dropdowns
        Font customFont = new Font("Arial", Font.PLAIN, 19); //may adjust font at some point we'll see
        //ranking options
        String[] rankingOptions = {
                //added spaces to beginning of text to give it breathing room
                "  Select Option",
                "  Fresh Local Produce",
                "  Proximity to Parks and Natural Spaces",
                "  Abundance of Schools and Hospitals",
                "  Availability of Clean Energy",
                "  Risk of Inclement Weather"
        };

        //Initializing dropdown array
        dropdowns = new JComboBox[5]; 

        //looping through and adding text to dropdowns and dropdowns to rightPanel
        for (int i = 0; i < 5; i++) {
            JComboBox<String> rankingDropdown = new JComboBox<>(rankingOptions);
            rankingDropdown.setFont(customFont); //setting font and text size for dropdown text
            rankingDropdown.setSelectedIndex(0); //making all boxes display "Select Option" to start with
            rightPanel.add(rankingDropdown);
            dropdowns[i] = rankingDropdown; //assigning the JComboBox to the array
        }

        //submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(new Color(152, 164, 125)); //button color ****** needs to be adjusted - maybe also the dropdowns??

        //font/size for text
        Font buttonFont = new Font("Arial", Font.PLAIN, 20); //same font as in WelcomePage.java - diff size
        submitButton.setFont(buttonFont);

        //making submit panel to center submit button properly
        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new BoxLayout(submitPanel, BoxLayout.X_AXIS));
        submitPanel.setBackground(new Color(188, 194, 155)); //pastel green color
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
                String errorMessage = checkForErrors();
                if (errorMessage != null) {
                    JOptionPane.showMessageDialog(RankingsPage.this, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Close the current RankingsPage
                    dispose();  // This will close the current JFrame

                    // Open the ResultsPage
                    SwingUtilities.invokeLater(() -> {
                        new ResultsPage();
                    });
                }
            }
        });

        //adjusting weightx for rightPanel to take up less space horizontally
        gbc.weightx = 0.4;
        mainPanel.add(rightPanel, gbc);

        //adding panel to JFrame, making visible and centering in window
        add(mainPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    //helper method to resize images
    private ImageIcon resizeImage(String imagePath, int width, int height) {
        ImageIcon originalImageIcon = new ImageIcon(imagePath);
        Image originalImage = originalImageIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    //helper method to check for duplicate selections and ensure "Select Option" is not selected in dropdowns
    private String checkForErrors() {
        Set<String> selectedOptions = new HashSet<>();
        boolean selectOptionFound = false;

        for (JComboBox<String> dropdown : dropdowns) {
            String selectedOption = (String) dropdown.getSelectedItem();

            //checking for "Select Option"
            if (selectedOption.equals("Select Option")) {
                selectOptionFound = true;
            }

            //checking for duplicate selections and throwing error message if found
            if (!selectedOptions.add(selectedOption)) {
                return "Error: Duplicate selection";
            }
        }

        //if selectOptionFound then throwing specific error message
        if (selectOptionFound) {
            return "Error: Not all options selected";
        }

        return null; //no errors :)
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RankingsPage());
    }
}
