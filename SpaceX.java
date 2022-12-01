// check if i can add margin for the main content pane
// check if i can use negative specific gaps??? (health status)
// font color
// use ratio instead of fixed sizes ???? possible 

// what is plaf? possible explanation for grey text area default?
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class SpaceX {
  private static void addComponentstoPane(Container pane) {
    // top level frame is a 2-row-grid with two panels 
    pane.add(createTopPanel());
    pane.add(createBottomPanel());

    // change font of every text
    Font font = new Font("Arial Nova", Font.BOLD, 15);
    changeFont(pane, font);
  }

  private static JPanel createTopPanel() {
    // top panel is a 5-row-grid with flow-layout for the first four rows and a fifth grid-layout

    JPanel topPanel = new JPanel(new GridLayout(5, 1));
    JPanel row1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel row2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel row3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel row4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel row5 = new JPanel(new GridLayout(1, 3, 5, 0));

    JLabel satId = new JLabel("Satellite ID");
    JTextField satIdField = new JTextField(20);
    JButton findSat = new JButton("Find Satellite");
    JLabel satName = new JLabel("Satellite Name");
    JTextField satNameField = new JTextField(40);
    JLabel longi = new JLabel("Longitude");
    JTextField longiField = new JTextField(20);
    JLabel lati = new JLabel("Latitude");
    JTextField latiField = new JTextField(15);
    JLabel elev = new JLabel("Elevation"); 
    JTextField elevField = new JTextField(20); 
    JLabel healthStat = new JLabel("Health Status");
    JTextField healthStatField = new JTextField(15);
    JButton save = new JButton("Save"); 
    JButton update = new JButton("Update");
    JButton delete = new JButton("Delete");

    // Modification of Components

    findSat.setPreferredSize(new Dimension (275,23));
    save.setPreferredSize(new Dimension (225,20));
    update.setPreferredSize(new Dimension (225,20));
    delete.setPreferredSize(new Dimension (225,20));

    topPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 0, 10));

    satId.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 40));
    // satIdField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 30)); NOT WORKING WHY?
    satName.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
    longi.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 45));
    elev.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 50));
    // elev.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

    findSat.setBorder(new LineBorder(new Color(202,202,202), 1));

    satIdField.setBorder(BorderFactory.createLineBorder(new Color(191,191,191), 2));
    satNameField.setBorder(BorderFactory.createLineBorder(new Color(191,191,191), 2));
    longiField.setBorder(BorderFactory.createLineBorder(new Color(191,191,191), 2));
    latiField.setBorder(BorderFactory.createLineBorder(new Color(191,191,191), 2));
    elevField.setBorder(BorderFactory.createLineBorder(new Color(191,191,191), 2));
    healthStatField.setBorder(BorderFactory.createLineBorder(new Color(191,191,191), 2));

    row1.add(satId); 
    row1.add(satIdField);
    row1.add(findSat);
    row2.add(satName);
    row2.add(satNameField);
    row3.add(longi);
    row3.add(longiField);
    row3.add(lati);
    row3.add(latiField); 
    row4.add(elev);
    row4.add(elevField);
    row4.add(healthStat);
    row4.add(healthStatField);
    row5.add(save);
    row5.add(update);
    row5.add(delete);
    topPanel.add(row1);
    topPanel.add(row2);
    topPanel.add(row3);
    topPanel.add(row4);
    topPanel.add(row5);

    return topPanel;

  }

  private static JPanel createBottomPanel() {
    // bottom border-layout panel with the center text area and a south clearall button
    // border-layout is best used when attempting maximize space coupled with a south component according to oracle java docs

    JPanel bottomPanel = new JPanel(new BorderLayout());

    JTextArea textarea = new JTextArea(5, 20);
    JButton bottomButton = new JButton("ClearAll");
    
    textarea.setBorder(new LineBorder(new Color(108,108,108), 3));
    textarea.setBackground(new Color(145,145,145));

    bottomPanel.add(textarea, BorderLayout.CENTER);
    bottomPanel.add(bottomButton, BorderLayout.SOUTH);

    return bottomPanel;
  }

  private static void changeFont (Component component, Font font) {
    component.setFont(font);
    if (component instanceof Container) {
      for (Component child:((Container) component).getComponents()) {
        changeFont(child, font);
      }
    }
  }
 
  // create a function for changing border of a component automatically? RESUME HERE
  
  private static void createAndShowGUI() {
    JFrame mainFrame = new JFrame("SpaceX Starlink Project");
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ImageIcon icon = new ImageIcon("./SpaceX_Icon.png");
    mainFrame.setIconImage(icon.getImage());
    mainFrame.setLayout(new GridLayout(2, 1, 0, 15));
  
    addComponentstoPane(mainFrame.getContentPane()); 

    mainFrame.setResizable(false);
    mainFrame.pack();
    mainFrame.setVisible(true);
    
  }
  
  public static void main(String[] args) {
    createAndShowGUI();
  }
}