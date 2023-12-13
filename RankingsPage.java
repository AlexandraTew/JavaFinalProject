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

    private static class MyComboBox extends JComboBox<String> {

        //constructor for comboboxes that takes a our defaultComboBoxModel string as a param
        public MyComboBox(DefaultComboBoxModel<String> model) {
            super(model);
            setForeground(Color.WHITE); //white text
            setFont(new Font("Bookman Old Style", Font.PLAIN, 19));
            setRenderer(new MyRenderer());
            setBackground(new Color(33, 50, 100)); //navy color
        }
    }
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
        mainPanel.setBackground(new Color(188, 194, 155)); //pastel green

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;

        //setting specific constrains for top label so it psans entire window horizontally
        GridBagConstraints gbcTopPanel = new GridBagConstraints();
        gbcTopPanel.gridx = 0;
        gbcTopPanel.gridy = 0;
        gbcTopPanel.gridwidth = GridBagConstraints.REMAINDER;
        gbcTopPanel.weighty = 0;
        gbcTopPanel.weightx = 1;
        gbcTopPanel.fill = GridBagConstraints.HORIZONTAL;

        //top panel welcome label will sit on
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(152, 164, 125)); //sage green

        //welcome label - Discover Home
        JLabel welcomeLabel = new JLabel("Discover Home", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 50));
        welcomeLabel.setForeground(new Color(33, 50, 100)); //navy font
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); //centering title in panel and controlling panel size
        topPanel.add(welcomeLabel, BorderLayout.CENTER);

        mainPanel.add(topPanel, gbcTopPanel);

        //left side panel
        gbc.gridy++;
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBackground(new Color(188, 194, 155)); //pastel green

        //padding for left panel
        int leftPanelPadding = 20;
        leftPanel.setBorder(BorderFactory.createEmptyBorder(0, leftPanelPadding, 0, leftPanelPadding));

        //using html format to format header and paragraph together easily
        String firstParagraphText = "<html><div style='text-align: center;'>" +
        "<h2 style='font-family: Bookman Old Style; font-size: 26pt; font-weight: normal;'>Unleash the Power of Your Preferences</h2>" +
        "<p style='font-family: Bookman Old Style; font-size: 18pt;'>At Discover Home, we understand that the concept of an ideal living environment is as unique as you are. " +
        "Our intuitive GUI allows you to articulate your priorities by ranking criteria that matter most to you. " +
        "With user-friendly dropdown menus, you take control of the factors that shape your living experience. Place the most important criterion in the first dropdown and continue in order of priority.</p></div></html>";

        //adding first paragraph to panel
        JLabel firstParagraphLabel = new JLabel(firstParagraphText);
        firstParagraphLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        leftPanel.add(Box.createVerticalGlue()); //glue above to center
        leftPanel.add(firstParagraphLabel);
        leftPanel.add(Box.createVerticalGlue()); //glue below to center

        //image
        ImageIcon handImageIcon = resizeImage("images/hand.jpg", 300, 200);
        JLabel handImageLabel = new JLabel(handImageIcon);
        handImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        leftPanel.add(handImageLabel);
        leftPanel.add(Box.createVerticalGlue()); //glue below to center

        //using html format to format header and paragraph together easily
        String secondParagraphText = "<html><div style='text-align: center;'>" +
                "<h2 style='font-family: Bookman Old Style; font-size: 26pt; font-weight: normal;'>Tailored Recommendations, Just for You</h2>" +
                "<p style='font-family: Bookman Old Style; font-size: 18pt;'>Once you've ranked your preferences, just press submit and our recommender engine will take it from there. " +
                "We methodically process your input to provide you with a curated list of locations that align with your individual priorities. " +
                "Say goodbye to generic suggestions—welcome to a world of personalized recommendations tailored specifically to your lifestyle.</p></div></html>";

        //adding second paragraph to panel
        JLabel secondParagraphLabel = new JLabel(secondParagraphText);
        secondParagraphLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        leftPanel.add(secondParagraphLabel);
        leftPanel.add(Box.createVerticalGlue()); //glue below to center

        mainPanel.add(leftPanel, gbc);

        //right side panel
        gbc.gridx++; //moving to next column
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBackground(new Color(188, 194, 155)); //pastel green

        //small header
        GridBagConstraints gbcHeaderPanel = new GridBagConstraints();
        gbcHeaderPanel.insets = new Insets(0, 0, 0, 10); //moving everything to the left a bit
        JLabel rankingsHeaderLabel = new JLabel("Tell Us What Matters Most to You");
        rankingsHeaderLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
        rankingsHeaderLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        rankingsHeaderLabel.setHorizontalAlignment(JLabel.CENTER);

        //panel for rankings header
        JPanel rankingsHeaderPanel = new JPanel();
        rankingsHeaderPanel.setLayout(new BoxLayout(rankingsHeaderPanel, BoxLayout.X_AXIS));
        rankingsHeaderPanel.setBackground(new Color(188, 194, 155)); //pastel green

        //adding header to right panel
        rankingsHeaderPanel.add(Box.createHorizontalGlue()); //glue to center
        rankingsHeaderPanel.add(rankingsHeaderLabel);
        rankingsHeaderPanel.add(Box.createHorizontalGlue()); //glue to center
        rightPanel.add(rankingsHeaderPanel);

        

        //ranking options
        String[] rankingOptions = {
                "  Select Option",
                "  Fresh Local Produce",
                "  Proximity to Parks and Natural Spaces",
                "  Abundance of Schools and Hospitals",
                "  Availability of Clean Energy",
                "  Risk of Inclement Weather"
        };

        //creating array of dropdowns
        //iterating through each array and setting shown option to first text option and adding to right panel
        dropdowns = new JComboBox[5];
        for (int i = 0; i < 5; i++) {
            MyComboBox rankingDropdown = new MyComboBox(new DefaultComboBoxModel<>(rankingOptions));
            rankingDropdown.setSelectedIndex(0);
            rightPanel.add(rankingDropdown);
            dropdowns[i] = rankingDropdown;
        }

        //submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(new Color(33, 50, 100)); //navy color
        submitButton.setForeground(Color.WHITE); //white font

        //font
        Font buttonFont = new Font("Bookman Old Style", Font.PLAIN, 20);
        submitButton.setFont(buttonFont);

        //submit button panel
        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new BoxLayout(submitPanel, BoxLayout.X_AXIS));
        submitPanel.setBackground(new Color(188, 194, 155)); //pastel green
        submitPanel.add(Box.createHorizontalGlue()); //left side glue to center
        submitPanel.add(submitButton);
        submitPanel.add(Box.createHorizontalGlue()); //right side glue to center

        //paddign for button
        int padding = 7;
        EmptyBorder emptyBorder = new EmptyBorder(padding, padding, padding, padding);
        submitPanel.setBorder(emptyBorder);

        rightPanel.add(submitPanel);

        //if no error message then proceed to next page when submit button is clicked
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String errorMessage = checkForErrors();
                if (errorMessage != null) {
                    JOptionPane.showMessageDialog(RankingsPage.this, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    dispose();
                    SwingUtilities.invokeLater(() -> new ResultsPage());
                }
            }
        });

        //shrinking right panel side *slightly* and adding to main panel
        gbc.weightx = 0.4;
        mainPanel.add(rightPanel, gbc);

        //adding panel to frame and setting visible and centering in window
        add(mainPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    //method to resize image
    private ImageIcon resizeImage(String imagePath, int width, int height) {
        ImageIcon originalImageIcon = new ImageIcon(imagePath);
        Image originalImage = originalImageIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    //method to check for errors in selected ranking options
    private String checkForErrors() {
        //storing sleected options in hashset to check for duplicates and if all options were selected
        Set<String> selectedOptions = new HashSet<>();
        boolean selectOptionFound = false;

        for (JComboBox<String> dropdown : dropdowns) {
            String selectedOption = (String) dropdown.getSelectedItem();

            if (selectedOption.equals("  Select Option")) {
                selectOptionFound = true;
            }

            if (!selectedOptions.add(selectedOption)) {
                return "Error: Duplicate selection";
            }
        }

        if (selectOptionFound) {
            return "Error: Not all options selected";
        }

        return null; //if no errors found return null so submit button can proceed to next page
    }

    //renderer to make dropdowns colored - could not get actually colored dropdowns to work
    private static class MyRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object value,
                                                    int index, boolean isSelected, boolean cellHasFocus) {

        //superclass method to set default render options
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        list.setBackground(new Color(33, 50, 100)); //navy color
        list.setForeground(Color.WHITE); //making text white
        list.setOpaque(true); //tried making color opaque

        return this; // Returning "this" instead of the modified component
        }
    }
    
    //main method to launch rankings gui
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RankingsPage());
    }
}
