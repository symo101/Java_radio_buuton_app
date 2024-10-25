import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButtonDemo extends JFrame {

    private JRadioButton birdButton, catButton, dogButton, rabbitButton, pigButton;
    private JLabel imageLabel;
    private ButtonGroup group;

    public RadioButtonDemo() {
        setTitle("Pet Selector");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create radio buttons
        birdButton = new JRadioButton("Bird");
        catButton = new JRadioButton("Cat");
        dogButton = new JRadioButton("Dog");
        rabbitButton = new JRadioButton("Rabbit");
        pigButton = new JRadioButton("Pig");

        // Group the radio buttons
        group = new ButtonGroup();
        group.add(birdButton);
        group.add(catButton);
        group.add(dogButton);
        group.add(rabbitButton);
        group.add(pigButton);

        // Create a panel for radio buttons
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new FlowLayout());
        radioPanel.add(birdButton);
        radioPanel.add(catButton);
        radioPanel.add(dogButton);
        radioPanel.add(rabbitButton);
        radioPanel.add(pigButton);

        // Add action listeners for each radio button
        birdButton.addActionListener(new PetListener("src/images/bird.png"));
        catButton.addActionListener(new PetListener("src/images/cat.png"));
        dogButton.addActionListener(new PetListener("src/images/dog.png"));
        rabbitButton.addActionListener(new PetListener("src/images/rabbit.png"));
        pigButton.addActionListener(new PetListener("src/images/pig.png"));

        // Label to display the image
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        
        // Add components to frame
        add(radioPanel, BorderLayout.NORTH);
        add(imageLabel, BorderLayout.CENTER);

        setVisible(true);
    }

    // ActionListener class to handle image changes
    private class PetListener implements ActionListener {
        private String imageFile;

        public PetListener(String imageFile) {
            this.imageFile = imageFile;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Try loading the image
            ImageIcon imageIcon = new ImageIcon(imageFile);
            
            // Check if image was loaded successfully
            if (imageIcon.getIconWidth() == -1) {
                // If image not found, show an error message
                JOptionPane.showMessageDialog(null, "Image not found: " + imageFile);
                imageLabel.setIcon(null);  // Clear the image label
            } else {
                // Set the image in the label
                imageLabel.setIcon(imageIcon);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RadioButtonDemo::new);  // To ensure GUI is created on Event Dispatch Thread
    }
}
