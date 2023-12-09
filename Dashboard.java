//getting all the bits
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.border.EmptyBorder;

public class Dashboard extends JFrame {

    public Dashboard() {
        //title and size all tht jazz
        setTitle("Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1515, 800); // same size as our windows

        //main - borderlayout
        JPanel mainPanel = new JPanel(new BorderLayout());

        //header - borderlayout, just place holder obvi not as nice as the real one
        JLabel headerLabel = new JLabel("Dashboard Header");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 40));
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(headerLabel, BorderLayout.NORTH);

        //image panel - GridBagLayout and an empty border
        JPanel imagePanel = new JPanel(new GridBagLayout());
        imagePanel.setBorder(new EmptyBorder(10, 10, 10, 10)); //padding around outermost image edges

        //image paths
        String[] imagePaths = {
                "images/Figure_5.5.png", //this one is diff from the real project bc the original version of it was better quality i did edit it a little
                "images/Figure_3.png",
                "images/Figure_2.5.1.png",
                "images/Figure_4.png",
                "images/Figure_1.png"
        };

        //setting max heights for the two image rows so that the images can't exceed this height
        int maxFirstRowHeight = 400; //first row - 2 big images
        int maxLastRowHeight = 268; //second row - 3 baby imgs

        //gbc for the first row of images
        GridBagConstraints firstRowGBC = new GridBagConstraints();
        firstRowGBC.weightx = 1; //spreads images out evenly - nt entirely sure why but it works so who cares
        firstRowGBC.gridx = 0;

        //adding first 2 images (resized using the max height I set fo rthe first row - I just thought even if their widths varied having the same height looked clean)
        for (int i = 0; i < 2; i++) {
            //getting image path and creating resized image icon
            String imagePath = imagePaths[i];
            ImageIcon icon = createResizedImageIcon(imagePath, maxFirstRowHeight);
            JLabel imageLabel = new JLabel(icon);
            //adding image to imagePanel with firstRowGBC
            imagePanel.add(imageLabel, firstRowGBC);
            firstRowGBC.gridx++;
        }

        //adding imagePanel to center of mainPanel
        mainPanel.add(imagePanel, BorderLayout.CENTER);

        //panel for the last 3 images - GridBagLayout and an empty border again
        JPanel lastThreeImagesPanel = new JPanel(new GridBagLayout());
        lastThreeImagesPanel.setBorder(new EmptyBorder(10, 10, 30, 10)); //padding around outermost image edges

        // GridBagConstraints for the last three images
        GridBagConstraints lastRowGBC = new GridBagConstraints();
        lastRowGBC.weightx = 1; //again spacing the images evenly (horizontally) - still not sure why but it still works lol
        lastRowGBC.gridx = 0;

        //adding last 3 imgs (resized with max height I set for the last row - tiny bit smaller bc they are tiny pics)
        for (int i = 2; i < 5; i++) {
            //getting image path and creating resized image icon
            String imagePath = imagePaths[i];
            ImageIcon icon = createResizedImageIcon(imagePath, maxLastRowHeight);
            JLabel imageLabel = new JLabel(icon);
            //adding image to lastThreeImagesPanel with lastRowGBC
            lastThreeImagesPanel.add(imageLabel, lastRowGBC);
            lastRowGBC.gridx++;
        }

        //adding lastThreeImagesPanel to the south portion of mainPanel
        mainPanel.add(lastThreeImagesPanel, BorderLayout.SOUTH);

        //adding mainPanel to frame
        add(mainPanel);

        //centering frame on the screen
        setLocationRelativeTo(null);
    }

    //method to create an ImageIcon from a path
    private ImageIcon createImageIcon(String path) {
        try {
            return new ImageIcon(new File(path).getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //method to create a resized ImageIcon from path and chosen max height
    private ImageIcon createResizedImageIcon(String path, int maxHeight) {
        try {
            //reading in original image and getting its type
            BufferedImage originalImage = ImageIO.read(new File(path));
            int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

            //getting original width and height to maintain aspect ratio
            double originalWidth = originalImage.getWidth();
            double originalHeight = originalImage.getHeight();

            //calculating scale factor using chosen max height to resize image while maintaining aspect ratio
            double scaleFactor = maxHeight / originalHeight; //again max height changes pending which row of images we are on

            //calculating new width and height
            int newWidth = (int) (originalWidth * scaleFactor);
            int newHeight = (int) (originalHeight * scaleFactor);

            //resizing image with new values
            Image resizedImage = originalImage.getScaledInstance(newWidth, newHeight, type);

            return new ImageIcon(resizedImage);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Dashboard dashboard = new Dashboard();
            dashboard.setVisible(true);
        });
    }
}
