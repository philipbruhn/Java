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
* @drawingdrawingPanel.getDrawing().getAuthor()  phbr1900
* @version 1.1
*/

public class JPaintFrame extends JFrame implements ActionListener, MouseInputListener{

    //MenyBar
    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenuItem menuItemNew;
    private JMenuItem menuItemSave;
    private JMenuItem menuItemLoad;
    private JMenuItem menuItemInfo;
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
    private DrawingPanel drawingPanel;

    //StatusBar
    private JPanel statusBar;
    private JPanel coordinatesPanel;
    private JLabel coordinatesLbl;
    private JPanel selectedColor;
    private JLabel colorLbl;
    private JPanel color;




    public JPaintFrame() {
        // Set the title of this JFrame (window)
		setTitle("JPaint");

        setIconImage(new ImageIcon("src/se/miun/phbr1900/dt187g/jpaint/Assets/drawIcon.png").getImage());

		// What should happen when the user closes the window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


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
        menuItemInfo = new JMenuItem("Info");
        menuItemInfo.addActionListener(this);
        menuFile.add(menuItemInfo);
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
        drawingPanel = new DrawingPanel(new Drawing());
        drawingPanel.addMouseMotionListener(this);
        drawingPanel.addMouseListener(this);
        this.add(drawingPanel, BorderLayout.CENTER);

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
        if((drawingPanel.getDrawing().getAuthor() == null ||drawingPanel.getDrawing().getAuthor().length() == 0 ) 
            && (drawingPanel.getDrawing().getName() == null ||drawingPanel.getDrawing().getName().length() == 0 )){
            return "";
        }
        if(drawingPanel.getDrawing().getAuthor() == null ||drawingPanel.getDrawing().getAuthor().length() == 0 ){
            return drawingPanel.getDrawing().getName();
        }
        if(drawingPanel.getDrawing().getName() == null ||drawingPanel.getDrawing().getName().length() == 0 ){
            return drawingPanel.getDrawing().getAuthor();
        }
        return drawingPanel.getDrawing().getName() + " by " +drawingPanel.getDrawing().getAuthor();
    }

    private String getWindowTitle(){
        return "JPaint" + (getDrawingTitle() != "" ? " - " + getDrawingTitle() : "");
    }

    private String getFilename(){
        return getDrawingTitle() + ".shape" ;
    }

    private String[] getDrawingInfo(){
        String[] info = {getDrawingTitle(),"Number of shapes: " + drawingPanel.getDrawing().shapes.size(), 
                         "Total area: " + drawingPanel.getDrawing().getTotalArea(),
                         "Total circumference: " + drawingPanel.getDrawing().getTotalCircumference()};
        return info;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuItemNew){
            drawingPanel.setDrawing(new Drawing());
            drawingPanel.getDrawing().setName( JOptionPane.showInputDialog(this, "Please enter a name for the drawing"));
            drawingPanel.getDrawing().setAuthor(JOptionPane.showInputDialog(this, "Please enter your name"));
            
            this.setTitle(getWindowTitle());
        }
        if (e.getSource() == menuItemSave){
            JOptionPane.showInputDialog(this, "Save drawing to:", getFilename());
            this.setTitle(getWindowTitle());
        }
        if (e.getSource() == menuItemLoad){
            JOptionPane.showInputDialog(this, "Load drawing from:");
            Drawing monaLisa = new Drawing();
		
            monaLisa.setName("Mona Lisa");
            monaLisa.setAuthor("L. da Vincis");
            
            
            Shape face = new Circle(100,100, "#ffe0bd"); // RGB(255,224,189)
            Shape leftEye = new Circle(75, 75, "#0000ff"); // RGB(0, 0, 255)
            Shape rightEye = new Circle(125, 75, "#0000ff"); // RGB(0, 0, 255)
            Shape nose = new Rectangle(95, 100, "#000000"); // RGB(0, 0, 0)
            Shape mouth = new Rectangle(55, 130, "#ff0000"); // RGB(255, 0, 0)
            
            monaLisa.addShape(face);
            monaLisa.addShape(leftEye);
            monaLisa.addShape(rightEye);
            monaLisa.addShape(nose);
            monaLisa.addShape(mouth);
            face.addPoint(175, 100);
            leftEye.addPoint(85, 75);
            rightEye.addPoint(135, 75);
            nose.addPoint(105, 115);
            mouth.addPoint(145, 140);
            drawingPanel.setDrawing(monaLisa);
            this.setTitle(getWindowTitle());
        }
        if (e.getSource() == menuItemInfo){
            JOptionPane.showMessageDialog(this, getDrawingInfo());
        }
        if (e.getSource() == menuItemExit){
            this.dispose();
        }
        if (e.getSource() == menuItemUndo){
            drawingPanel.removeLastShapeFromList();
        }
        if (e.getSource() == menuItemName){
            drawingPanel.getDrawing().setName(JOptionPane.showInputDialog(this, "Please enter a name for the drawing"));
            this.setTitle(getWindowTitle());
        }
        if (e.getSource() == menuItemAuthor){
            drawingPanel.getDrawing().setAuthor(JOptionPane.showInputDialog(this, "Please enter your name"));
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
        if(e.getSource() == drawingPanel){
            String colorHex = String.format("#%02X%02X%02X", color.getBackground().getRed(), color.getBackground().getGreen(),color.getBackground().getBlue());
            if(shapesCB.getSelectedItem().toString() == "Rectangle"){
                Rectangle rect = new Rectangle(e.getX(),e.getY(),colorHex);
                drawingPanel.getDrawing().addShape(rect);
            }
            if(shapesCB.getSelectedItem().toString() == "Circle"){
                Circle circle = new Circle(e.getX(),e.getY(),colorHex);
                drawingPanel.getDrawing().addShape(circle);
            }
        }
        
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
        if(e.getSource() == drawingPanel){
            coordinatesLbl.setText("Coordinates: " + e.getX() + "," + e.getY());
            drawingPanel.getDrawing().shapes.get(drawingPanel.getDrawing().shapes.size()-1).addPoint(new Point(e.getX(),e.getY()));
        }
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if(e.getSource() == drawingPanel){
            coordinatesLbl.setText("Coordinates: " + e.getX() + "," + e.getY());
        }
    }


}
