// what is plaf? possible explanation for grey text area default? (OPTIONAL)
import javax.swing.*;
import javax.swing.border.LineBorder;
// import javax.swing.plaf.DimensionUIResource;

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
    JPanel row5_save = new JPanel();
    JPanel row5_update = new JPanel();
    JPanel row5_delete = new JPanel();
    // place findSat inside a button to add empty border or "gaps"
    JPanel findSatPanel = new JPanel();

    JLabel satId = new JLabel("Satellite ID");
    JTextField satIdField = new JTextField(20);
    JButton findSat = new JButton("Find Satellite");
    JLabel satName = new JLabel("Satellite Name");
    JTextField satNameField = new JTextField(45);
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

    // components sizes 
    findSat.setPreferredSize(new Dimension (280,23));
    save.setPreferredSize(new Dimension (225,23));
    update.setPreferredSize(new Dimension (225,23));
    delete.setPreferredSize(new Dimension (225,23));

    // gaps 
    topPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 0, 10));

    satId.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 40));
    satName.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
    findSatPanel.setBorder(BorderFactory.createEmptyBorder(0, 9, 0, 0));
    longi.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 45));
    elev.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 50));

    // border line 
    findSat.setBorder(new LineBorder(new Color(202,202,202), 2));
    save.setBorder(new LineBorder(new Color(202,202,202), 2));
    update.setBorder(new LineBorder(new Color(202,202,202), 2));
    delete.setBorder(new LineBorder(new Color(202,202,202), 2));

    
    satIdField.setBorder(BorderFactory.createLineBorder(new Color(191,191,191), 2));
    satNameField.setBorder(BorderFactory.createLineBorder(new Color(191,191,191), 2));
    longiField.setBorder(BorderFactory.createLineBorder(new Color(191,191,191), 2));
    latiField.setBorder(BorderFactory.createLineBorder(new Color(191,191,191), 2));
    elevField.setBorder(BorderFactory.createLineBorder(new Color(191,191,191), 2));
    healthStatField.setBorder(BorderFactory.createLineBorder(new Color(191,191,191), 2));

    // component background
    findSat.setBackground(new Color(223,223,223));
    save.setBackground(new Color(223,223,223));
    update.setBackground(new Color(223,223,223));
    delete.setBackground(new Color(223,223,223));

    // font color
    satId.setForeground(new Color(97,160,255));
    satName.setForeground(new Color(97,160,255));
    longi.setForeground(new Color(97,160,255));
    lati.setForeground(new Color(97,160,255));
    elev.setForeground(new Color(97,160,255));
    healthStat.setForeground(new Color(97,160,255)); 
    // turn into a combo box ^^^

    row1.add(satId); 
    row1.add(satIdField);
    findSatPanel.add(findSat);
    row1.add(findSatPanel);
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
    row5_save.add(save);
    row5_update.add(update);
    row5_delete.add(delete);
    row5.add(row5_save);
    row5.add(row5_update);
    row5.add(row5_delete);
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
    JPanel bottomButtonPanel = new JPanel();
    // add gap between center and south

    JTextArea textarea = new JTextArea(5, 20);
    JButton bottomButton = new JButton("ClearAll");

    // components sizes
    bottomButton.setPreferredSize(new Dimension (200,23));
    
    // gaps
    bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

    // border line
    textarea.setBorder(new LineBorder(new Color(108,108,108), 3));
    bottomButton.setBorder(new LineBorder(new Color(202,202,202), 2));

    // component background
    textarea.setBackground(new Color(145,145,145));
    bottomButton.setBackground(new Color(223,223,223));

    bottomButtonPanel.add(bottomButton);
    bottomPanel.add(textarea, BorderLayout.CENTER);
    bottomPanel.add(bottomButtonPanel, BorderLayout.SOUTH);

    return bottomPanel;
  }

  private static void changeFont (Component component, Font font) {
    component.setFont(font);
    
    if (component instanceof Container) {
      for (Component child:((Container) component).getComponents()) {
        changeFont(child, font);
      }
    }
    // automate changing font color?
  }
   
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