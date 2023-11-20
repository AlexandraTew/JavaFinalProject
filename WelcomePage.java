//getting all the bits
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage extends JFrame {

    public WelcomePage() 
    {
        //setting look to nimbus to make it less 2005
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //setting window title to Homebound Application ***ADJUST IF WE CHANGE NAME!!!***
        setTitle("Homebound Application");
        setSize(1500, 800);  // ***MAY NEED TO ADJUST***
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //major panel everything goes on
        JPanel panel = new JPanel();
        //picked slightly off white color to make it less BRIGHT
        panel.setBackground(new Color(243, 243, 243));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        //method to add all my other bits later
        placeComponents(panel);

        getContentPane().add(panel);
        setVisible(true);
    }

    //all the components
    private void placeComponents(JPanel panel) {
        //main label = Homebound
        JLabel welcomeLabel = new JLabel("Discover Home"); //***ADJUST IF WE CHANGE NAME!!!***
        welcomeLabel.setFont(new Font("Sylfaen", Font.BOLD, 40));
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(welcomeLabel);
        //spacing
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        //explanation text
        //setting font for all explanationTexts
        Font labelFont = new Font("Arial", Font.PLAIN, 14);
        //array to hold all text per label
        String[] explanationTexts = {
                "Welcome to Discover Home, the platform dedicated to fostering a sustainable and connected future. We leverage big data to empower ",
                "those seeking to connect with like-minded individuals across the United States. Whether you are looking to find your people ",
                "within your current community or are seeking to relocate to find where you fit, Discover Home will offer you the tools to find the region, ",
                "city, and community that best aligns with your values. We go beyond traditional social networks, real estate tools, and eco-conscious ",
                "apps to offer a holistic solution that prioritizes long-term well-being, community building, and ecological sustainability. Only when we are ",
                "connected can we build a healthier, happier world.",
        };

        //looping through all explanationTexts and assigning to label and then centering
        for (String text : explanationTexts) {
            JLabel label = new JLabel(text);
            label.setFont(labelFont);
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(label);
            //spacing
            panel.add(Box.createRigidArea(new Dimension(0, 7)));
        }

        //additional spacing
        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        //adding image bc pretty welcome page
        ImageIcon originalImageIcon = new ImageIcon("C:/Users/slphe/Desktop/project/wp_img.jpg"); //need to figure out a way to make this not specific to my comp
        //resizing image to make it slightly longer and shorter than original image
        //keeping variables for easy adjustment
        int newWidth = 500;
        int newHeight = 200;
        //actually scaling the image
        ImageIcon scaledImageIcon = new ImageIcon(originalImageIcon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH));
        
        //adding image to panel and centering and spacing slightly
        JLabel imageLabel = new JLabel(scaledImageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(imageLabel);
        //spacing
        panel.add(Box.createRigidArea(new Dimension(0, 135)));

        //button
        JButton button = new JButton("Explore");
        button.setFont(new Font("Arial", Font.PLAIN, 18));

        //picked a nice blue color, could be adjusted later but I thought it was pretty while being subtle
        button.setBackground(new Color(70, 130, 180));
        //making text white to contrast with blue
        button.setForeground(Color.WHITE);

        //adjusting button size and centering
        button.setPreferredSize(new Dimension(200, 50));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(button);
        //spacing
        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        //tagline - centering and making it pretty
        JLabel decorativeText = new JLabel("Find Your Community");
        decorativeText.setFont(new Font("Monotype Corsiva", Font.PLAIN, 26));
        decorativeText.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(decorativeText);

        //adding action listener to button - links to second page
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the current WelcomePage
                dispose();  // This will close the current JFrame
        
                // Open the RankingsPage
                SwingUtilities.invokeLater(() -> {
                    new RankingsPage();
                });
            }
        });
    }

    //main method - invoking the welcome page and running swing on EDT thread
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new WelcomePage();
        });
    }
}