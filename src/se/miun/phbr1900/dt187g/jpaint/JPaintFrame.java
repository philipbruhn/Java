package se.miun.phbr1900.dt187g.jpaint;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

/**
* <h1>JPaintFrame</h1>
* This inplements the UI for the paint application. 
* Creates the UI on startup. Contains listeners for basic operations. 
* 
* @author  phbr1900
* @version 1.1
*/

public class JPaintFrame extends JFrame implements ActionListener, MouseInputListener{

    //MenyBar
    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenuItem menuItemNew;
    private JMenuItem menuItemSave;
    private JMenuItem menuItemLoad;
    private JMenuItem menuItemExit;
    private JMenu menuEdit;
    private JMenuItem menuItemUndo;
    private JMenuItem menuItemName;
    private JMenuItem menuItemAuthor;

    //ToolBar
    private JPanel toolBar;
    private JPanel colorsPanel;
    private JPanel colorPanel1;
    private JPanel colorPanel2;
    private JPanel colorPanel3;
    private JPanel colorPanel4;
    private JPanel colorPanel5;
    private JComboBox<String> shapesCB;

    //Draw area
    private JPanel drawArea;

    //StatusBar
    private JPanel statusBar;
    private JPanel coordinatesPanel;
    private JLabel coordinatesLbl;
    private JPanel selectedColor;
    private JLabel colorLbl;
    private JPanel color;

    //Variables
    private String name;
    private String author;


    public JPaintFrame() {
        // Set the title of this JFrame (window)
		setTitle("JPaint");

        setIconImage(new ImageIcon("src/se/miun/phbr1900/dt187g/jpaint/Assets/drawIcon.png").getImage());

		// What should happen when the user closes the window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Using null centers the window on the screen
		setLocationRelativeTo(null);


		// Initialize all components
		initComponents();

		// The size of the window
        setPreferredSize(new Dimension(800, 640));
		pack(); // sizes this window to fit the preferred size and layouts of its subcomponents

        // Using null centers the window on the screen
		setLocationRelativeTo(null);

		// Make the window visible
		setVisible(true);
	}

    private void initComponents(){
        
        //MenuBar
        menuBar = new JMenuBar();
        
        //File
        menuFile = new JMenu("File");
        menuItemNew = new JMenuItem("New...");
        menuItemNew.addActionListener(this);
        menuFile.add(menuItemNew);
        menuItemSave = new JMenuItem("Save as...");
        menuItemSave.addActionListener(this);
        menuFile.add(menuItemSave);
        menuItemLoad = new JMenuItem("Load...");
        menuItemLoad.addActionListener(this);
        menuFile.add(menuItemLoad);
        menuFile.addSeparator();
        menuItemExit = new JMenuItem("Exit");
        menuItemExit.addActionListener(this);
        menuFile.add(menuItemExit);
        menuBar.add(menuFile);

        //Edit
        menuEdit = new JMenu("Edit");
        menuItemUndo = new JMenuItem("Undo");
        menuItemUndo.addActionListener(this);
        menuEdit.add(menuItemUndo);
        menuItemName = new JMenuItem("Name...");
        menuItemName.addActionListener(this);
        menuEdit.add(menuItemName);
        menuItemAuthor = new JMenuItem("Author...");
        menuItemAuthor.addActionListener(this);
        menuEdit.add(menuItemAuthor);

        menuBar.add(menuEdit);
        this.setJMenuBar(menuBar);

        //ToolBar
        toolBar = new JPanel();
        toolBar.setLayout(new BorderLayout());

        colorsPanel = new JPanel();
        colorsPanel.setLayout(new GridLayout(1,5));
        colorPanel1 = new JPanel();
        colorPanel1.setBackground(Color.BLACK);
        colorPanel1.addMouseListener(this);
        colorsPanel.add(colorPanel1);
        colorPanel2 = new JPanel();
        colorPanel2.setBackground(Color.GREEN);
        colorPanel2.addMouseListener(this);
        colorsPanel.add(colorPanel2);
        colorPanel3 = new JPanel();
        colorPanel3.setBackground(Color.RED);
        colorPanel3.addMouseListener(this);
        colorsPanel.add(colorPanel3);
        colorPanel4 = new JPanel();
        colorPanel4.setBackground(Color.BLUE);
        colorPanel4.addMouseListener(this);
        colorsPanel.add(colorPanel4);
        colorPanel5 = new JPanel();
        colorPanel5.setBackground(Color.YELLOW);
        colorPanel5.addMouseListener(this);
        colorsPanel.add(colorPanel5);
        toolBar.add(colorsPanel, BorderLayout.CENTER);

        shapesCB = new JComboBox<String>(new String[]{"Rectangle", "Circle"});
        toolBar.add(shapesCB, BorderLayout.LINE_END);

        this.add(toolBar, BorderLayout.PAGE_START);

        //Draw Area
        drawArea = new JPanel();
        drawArea.setBackground(Color.WHITE);
        drawArea.addMouseMotionListener(this);
        this.add(drawArea, BorderLayout.CENTER);

        //StatusBar
        statusBar = new JPanel();

        statusBar.setLayout(new BorderLayout());

        coordinatesPanel = new JPanel();
        coordinatesLbl = new JLabel("Coordinates: 0,0");
        coordinatesPanel.add(coordinatesLbl);
        statusBar.add(coordinatesPanel, BorderLayout.LINE_START);

        selectedColor = new JPanel();
        colorLbl = new JLabel("Selected color:");
        selectedColor.add(colorLbl);
        color = new JPanel();
        color.setBackground(Color.BLACK);
        selectedColor.add(color);
        statusBar.add(selectedColor, BorderLayout.LINE_END);

        this.add(statusBar, BorderLayout.PAGE_END);



    }

    private String getDrawingTitle(){
        if((author == null || author.length() == 0 ) && (name == null || name.length() == 0 )){
            return "";
        }
        if(author == null || author.length() == 0 ){
            return name;
        }
        if(name == null || name.length() == 0 ){
            return author;
        }
        return name + " by " + author;
    }

    private String getWindowTitle(){
        return "JPaint" + (getDrawingTitle() != "" ? " - " + getDrawingTitle() : "");
    }
    private String getFilename(){
        return getDrawingTitle() + ".shape" ;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuItemNew){
            name = JOptionPane.showInputDialog(this, "Please enter a name for the drawing");
            author = JOptionPane.showInputDialog(this, "Please enter your name");
            this.setTitle(getWindowTitle());
        }
        if (e.getSource() == menuItemSave){
            JOptionPane.showInputDialog(this, "Save drawing to:", getFilename());
            this.setTitle(getWindowTitle());
        }
        if (e.getSource() == menuItemLoad){
            JOptionPane.showInputDialog(this, "Load drawing from:");
            this.setTitle(getWindowTitle());
        }
        if (e.getSource() == menuItemExit){
            this.dispose();
        }
        if (e.getSource() == menuItemUndo){

        }
        if (e.getSource() == menuItemName){
            name = JOptionPane.showInputDialog(this, "Please enter a name for the drawing");
            this.setTitle(getWindowTitle());
        }
        if (e.getSource() == menuItemAuthor){
            author = JOptionPane.showInputDialog(this, "Please enter your name");
            this.setTitle(getWindowTitle());
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == colorPanel1){
            color.setBackground(colorPanel1.getBackground());
        }
        if (e.getSource() == colorPanel2){
            color.setBackground(colorPanel2.getBackground());
        }
        if (e.getSource() == colorPanel3){
            color.setBackground(colorPanel3.getBackground());
        }
        if (e.getSource() == colorPanel4){
            color.setBackground(colorPanel4.getBackground());
        }
        if (e.getSource() == colorPanel5){
            color.setBackground(colorPanel5.getBackground());
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {

        
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        
    }

    @Override
    public void mouseEntered(MouseEvent e) {

        
    }

    @Override
    public void mouseExited(MouseEvent e) {

        
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if(e.getSource() == drawArea){
            coordinatesLbl.setText("Coordinates: " + e.getX() + "," + e.getY());;
        }
    }


}
