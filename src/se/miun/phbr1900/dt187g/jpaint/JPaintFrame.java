package se.miun.phbr1900.dt187g.jpaint;

import javax.swing.*;
import java.awt.*;

/**
* <h1>JPaintFrame</h1>
* This in the UI for the paint application. 
* Creates the UI on startup. 
* 
* @author  phbr1900
* @version 1.0
*/

public class JPaintFrame extends JFrame {

    //MenyBar
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem;

    //ToolBar
    private JPanel toolBar;
    private JPanel colorsPanel;
    private JPanel colorPanel;
    private JComboBox shapesCB;

    //Draw area
    private JPanel drawArea;

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

		// Using null centers the window on the screen
		setLocationRelativeTo(null);


		// Initialize all components
		initComponents();

		// The size of the window
        setPreferredSize(new Dimension(800, 640));
		pack(); // sizes this window to fit the preferred size and layouts of its subcomponents

		// Make the window visible
		setVisible(true);
	}

    private void initComponents(){
        
        //MenuBar
        menuBar = new JMenuBar();
        
        //File
        menu = new JMenu("File");
        menuItem = new JMenuItem("New...");
        menu.add(menuItem);
        menuItem = new JMenuItem("Save as...");
        menu.add(menuItem);
        menuItem = new JMenuItem("Load...");
        menu.add(menuItem);
        menu.addSeparator();
        menuItem = new JMenuItem("Exit");
        menu.add(menuItem);
        menuBar.add(menu);

        //Edit
        menu = new JMenu("Edit");
        menuItem = new JMenuItem("Undo");
        menu.add(menuItem);
        menuItem = new JMenuItem("Name...");
        menu.add(menuItem);
        menuItem = new JMenuItem("Author...");
        menu.add(menuItem);

        menuBar.add(menu);
        this.setJMenuBar(menuBar);

        //ToolBar
        toolBar = new JPanel();
        toolBar.setLayout(new BorderLayout());

        colorsPanel = new JPanel();
        colorsPanel.setLayout(new GridLayout(1,5));
        colorPanel = new JPanel();
        colorPanel.setBackground(Color.BLACK);
        colorsPanel.add(colorPanel);
        colorPanel = new JPanel();
        colorPanel.setBackground(Color.GREEN);
        colorsPanel.add(colorPanel);
        colorPanel = new JPanel();
        colorPanel.setBackground(Color.RED);
        colorsPanel.add(colorPanel);
        colorPanel = new JPanel();
        colorPanel.setBackground(Color.BLUE);
        colorsPanel.add(colorPanel);
        colorPanel = new JPanel();
        colorPanel.setBackground(Color.YELLOW);
        colorsPanel.add(colorPanel);
        toolBar.add(colorsPanel, BorderLayout.CENTER);

        shapesCB = new JComboBox();
        shapesCB.addItem("Rectangle");
        shapesCB.addItem("Circle");
        toolBar.add(shapesCB, BorderLayout.LINE_END);

        this.add(toolBar, BorderLayout.PAGE_START);

        //Draw Area
        drawArea = new JPanel();
        drawArea.setBackground(Color.WHITE);
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



}
