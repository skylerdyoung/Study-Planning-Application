import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Dimension;

import java.awt.Color;

import java.awt.Font;

import java.util.ArrayList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.ArrayList;

/**
 * The MainPanel Class
 *
 * @author Skyler Young
 * @version 1.0
 */
public class MainPanel extends JPanel
{
    /**
     * The fields for the MainPanel class.
     */
    
    private HeaderPanel headPanel;
    private ControlPanel controlPanel;
    private TaskPanel taskPanel;
    
    private Color colorObject;
    
    private Dimension panelSize;
    
    private ArrayList<TaskPanel> taskList;
        
    
    /**
     * The Constructor for the MainPanel class.
     */
    public MainPanel(){
        super();
        
        taskList = new ArrayList<>();
        
        panelSize = new Dimension(725,750);
        setPreferredSize(panelSize);
        
        colorObject = new Color(255, 255, 230);
        setBackground(Color.white);
        
        headPanel = new HeaderPanel();
        controlPanel = new ControlPanel();
        taskPanel = new TaskPanel();
        
        add(headPanel);
        add(controlPanel);
        add(taskPanel);
    }
    
    /**
     * retrieves the addbutton from controlPanel
     */
    public JButton getAddButton(){
        return controlPanel.getAddButton();
    }
    
    /**
     * retrieves the removebutton from controlPanel
     */
    public JButton getRemoveButton(){
        return controlPanel.getRemoveButton();
    }
    
    /**
     * retrieves the headPanel
     */
    public HeaderPanel getHeadPanel(){
        return headPanel ;
    }
    
    /**
     * retrieves the taskPanel
     */
    public TaskPanel getTaskPanel(){
        return taskPanel ;
    }
    
    /*
     * retrieves the controlPanel
     */
    public ControlPanel getControlPanel(){
        return controlPanel ;
    }
    
    
}
