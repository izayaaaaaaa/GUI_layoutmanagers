import javax.swing.*;
import java.awt.*;

public class SpaceX {
  // JPanel flowPanel;
  // JPanel gridPanel;
  // JPanel borderPanel;

  private static void addComponentstoPane(Container pane) {
    // pane is the pane of the main frame or top level container 
    pane.add(createTopPanel());
    pane.add(createBottomPanel());
  }


  private static JPanel createTopPanel() {
    JPanel topPanel = new JPanel(new GridLayout(5, 1));

    JPanel row1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel row2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel row3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel row4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel row5 = new JPanel(new GridLayout(1, 3));

    JLabel satId = new JLabel("Satellite ID");
    JTextField satIdField = new JTextField(20);
    JButton findSat = new JButton("Find Satellite");
    // resize button 
    // findSat.setPreferredSize(new Dimension (250,20));
    JLabel satName = new JLabel("Satellite Name");
    JTextField satNameField = new JTextField(30);
    JLabel longi = new JLabel("Longitude"); 
    JTextField longiField = new JTextField(20);
    JLabel lati = new JLabel("Latitude");
    JTextField latiField = new JTextField(20);
    JLabel elev = new JLabel("Elevation"); 
    JTextField elevField = new JTextField(20); 
    JLabel healthStat = new JLabel("Health Status");
    JTextField healthStatField = new JTextField(20);
    JButton save = new JButton("Save");
    JButton update = new JButton("Update");
    JButton delete = new JButton("Delete");

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
    JPanel bottomPanel = new JPanel(new BorderLayout());

    JTextArea textarea = new JTextArea(5, 20);
    JButton bottomButton = new JButton("ClearAll");
    
    bottomPanel.add(textarea, BorderLayout.CENTER);
    bottomPanel.add(bottomButton, BorderLayout.SOUTH);

    return bottomPanel;
  }

  private static void createAndShowGUI() {
    JFrame mainFrame = new JFrame("SpaceX Starlink Project");
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainFrame.setLayout(new GridLayout(2, 1));

    addComponentstoPane(mainFrame.getContentPane());

    // mainFrame.setResizable(false);
    mainFrame.pack();
    

      
    mainFrame.setVisible(true);
    
  }
  
  public static void main(String[] args) {
    createAndShowGUI();
  }
}