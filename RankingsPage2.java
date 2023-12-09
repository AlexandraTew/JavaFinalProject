import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RankingsPage2 extends JFrame {
    private JComboBox<String>[] dropdowns;
    private static final Color COMBO_COLOR = new Color(71, 81, 93);

    private static class MyComboBox extends JComboBox  {

        public MyComboBox(DefaultComboBoxModel model) {
            super(model);
            setForeground(Color.WHITE);
            setFont(new Font("Arial", Font.PLAIN, 30));
            setPreferredSize(new Dimension(350, 50));
            setRenderer(new MyRenderer());
        }

    }

    private static class MyRenderer extends DefaultListCellRenderer {
        
        // Remove @Override annotation
        public Component getListCellRendererComponent(JList list, Object value,
                            int index, boolean isSelected, boolean cellHasFocus) {

            JComponent comp = (JComponent) super.getListCellRendererComponent(list,
                    value, index, isSelected, cellHasFocus);

            list.setBackground(COMBO_COLOR);
            list.setForeground(Color.WHITE);
            list.setOpaque(false);
            
            return comp;
        }
    }

    public RankingsPage2() {
        // try {
        //     UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        setTitle("Rankings Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1515, 800));

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(188, 194, 155));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;

        GridBagConstraints gbcTopPanel = new GridBagConstraints();
        gbcTopPanel.gridx = 0;
        gbcTopPanel.gridy = 0;
        gbcTopPanel.gridwidth = GridBagConstraints.REMAINDER;
        gbcTopPanel.weighty = 0;
        gbcTopPanel.weightx = 1;
        gbcTopPanel.fill = GridBagConstraints.HORIZONTAL;

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(152, 164, 125));

        JLabel welcomeLabel = new JLabel("Discover Home", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Sylfaen", Font.BOLD, 50));
        welcomeLabel.setForeground(new Color(33, 50, 100));
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, -5, 0));
        topPanel.add(welcomeLabel, BorderLayout.CENTER);

        mainPanel.add(topPanel, gbcTopPanel);

        gbc.gridy++;
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBackground(new Color(188, 194, 155));

        int leftPanelPadding = 20;
        leftPanel.setBorder(BorderFactory.createEmptyBorder(0, leftPanelPadding, 0, leftPanelPadding));

        String firstParagraphText = "<html><div style='text-align: center;'>" +
                "<h2 style='font-family: Sylfaen; font-size: 26pt; font-weight: bold;'>Unleash the Power of Your Preferences</h2>" +
                "<p style='font-family: Bookman Old Style; font-size: 19pt;'>At Discover Home, we understand that the concept of an ideal living environment is as unique as you are. " +
                "Our intuitive GUI allows you to articulate your priorities by ranking criteria that matter most to you. " +
                "With user-friendly dropdown menus, you take control of the factors that shape your living experience. Place the most important criterion in the first dropdown and continue in order of priority.</p></div></html>";

        JLabel firstParagraphLabel = new JLabel(firstParagraphText);
        firstParagraphLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        leftPanel.add(Box.createVerticalGlue());
        leftPanel.add(firstParagraphLabel);
        leftPanel.add(Box.createVerticalGlue());

        ImageIcon handImageIcon = resizeImage("images/hand.jpg", 300, 200);
        JLabel handImageLabel = new JLabel(handImageIcon);
        handImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        leftPanel.add(handImageLabel);
        leftPanel.add(Box.createVerticalGlue());

        String secondParagraphText = "<html><div style='text-align: center;'>" +
                "<h2 style='font-family: Sylfaen; font-size: 26pt; font-weight: bold;'>Tailored Recommendations, Just for You</h2>" +
                "<p style='font-family: Bookman Old Style; font-size: 19pt;'>Once you've ranked your preferences, just press submit and our recommender engine will take it from there. " +
                "We methodically process your input to provide you with a curated list of locations that align with your individual priorities. " +
                "Say goodbye to generic suggestions—welcome to a world of personalized recommendations tailored specifically to your lifestyle.</p></div></html>";

        JLabel secondParagraphLabel = new JLabel(secondParagraphText);
        secondParagraphLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        leftPanel.add(secondParagraphLabel);
        leftPanel.add(Box.createVerticalGlue());

        mainPanel.add(leftPanel, gbc);

        gbc.gridx++;
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBackground(new Color(188, 194, 155));

        GridBagConstraints gbcHeaderPanel = new GridBagConstraints();
        gbcHeaderPanel.insets = new Insets(0, 0, 0, 10);
        JLabel rankingsHeaderLabel = new JLabel("Tell Us What Matters Most to You");
        rankingsHeaderLabel.setFont(new Font("Sylfaen", Font.BOLD, 20));
        rankingsHeaderLabel.setBorder(BorderFactory.createEmptyBorder(25, 0, 10, 0));
        rankingsHeaderLabel.setHorizontalAlignment(JLabel.CENTER);

        JPanel rankingsHeaderPanel = new JPanel();
        rankingsHeaderPanel.setLayout(new BoxLayout(rankingsHeaderPanel, BoxLayout.X_AXIS));
        rankingsHeaderPanel.setBackground(new Color(188, 194, 155));

        rankingsHeaderPanel.add(Box.createHorizontalGlue());
        rankingsHeaderPanel.add(rankingsHeaderLabel);
        rankingsHeaderPanel.add(Box.createHorizontalGlue());

        rightPanel.add(rankingsHeaderPanel);

        Font customFont = new Font("Arial", Font.PLAIN, 19);
        String[] rankingOptions = {
                "  Select Option",
                "  Fresh Local Produce",
                "  Proximity to Parks and Natural Spaces",
                "  Abundance of Schools and Hospitals",
                "  Availability of Clean Energy",
                "  Risk of Inclement Weather"
        };

        dropdowns = new JComboBox[5];
        for (int i = 0; i < 5; i++) {
            MyComboBox rankingDropdown = new MyComboBox(new DefaultComboBoxModel<>(rankingOptions));
            rankingDropdown.setSelectedIndex(0);
            rightPanel.add(rankingDropdown);
            dropdowns[i] = rankingDropdown;
        }

        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(new Color(33, 50, 100)); //navy button
        submitButton.setForeground(Color.WHITE);

        Font buttonFont = new Font("Arial", Font.PLAIN, 20);
        submitButton.setFont(buttonFont);

        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new BoxLayout(submitPanel, BoxLayout.X_AXIS));
        submitPanel.setBackground(new Color(188, 194, 155));
        submitPanel.add(Box.createHorizontalGlue());
        submitPanel.add(submitButton);
        submitPanel.add(Box.createHorizontalGlue());

        int padding = 7;
        EmptyBorder emptyBorder = new EmptyBorder(padding, padding, padding, padding);
        submitPanel.setBorder(emptyBorder);

        rightPanel.add(submitPanel);

        gbc.weightx = 0.4;
        mainPanel.add(rightPanel, gbc);

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

    private String checkForErrors() {
        Set<String> selectedOptions = new HashSet<>();
        boolean selectOptionFound = false;

        for (JComboBox<String> dropdown : dropdowns) {
            String selectedOption = (String) dropdown.getSelectedItem();

            if (selectedOption.equals("Select Option")) {
                selectOptionFound = true;
            }

            if (!selectedOptions.add(selectedOption)) {
                return "Error: Duplicate selection";
            }
        }

        if (selectOptionFound) {
            return "Error: Not all options selected";
        }

        return null;
    }


public static void main(String[] args) {
    try {
        String nimbus = Arrays.asList(UIManager.getInstalledLookAndFeels())
                .stream()
                .filter(i -> i.getName().equals("Nimbus"))
                .findFirst()
                .orElseThrow(() -> new UnsupportedLookAndFeelException("Nimbus Look and Feel not found"))
                .getClassName();

        UIManager.setLookAndFeel(nimbus);

        UIManager.put("ComboBox.forceOpaque", false);
        SwingUtilities.invokeLater(() -> new RankingsPage2());
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        e.printStackTrace();
        }
    }
}