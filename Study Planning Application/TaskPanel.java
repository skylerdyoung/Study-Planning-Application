import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JButton;

import java.util.HashSet;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 *
 * @author Skyler Young
 * @version 1.0
 */
public class TaskPanel extends JPanel
{
    /**
     * Fields for the TaskPanel Class
     */
    private Dimension panDim;
    
    private Color colorObject;

    private HashSet<String> taskSet;
    
    
    /**
     * Constructor for the TaskPanel class
     */
    public TaskPanel(){
        panDim = new Dimension(700, 485);
        setPreferredSize(panDim);
        
        colorObject = new Color(255, 255, 230);
        setBackground(Color.white);
        
        taskSet = new HashSet<>();
        taskSet.add("a");
        taskSet.add("b");
        taskSet.add("c");
        
    }
    
    /**
     * retrieves the taskSet
     */
    public HashSet getSet(){
        return taskSet;
    }
    
    /**
     * clears the taskSet
     */
    public void clearSet(){
        taskSet.clear();
    }
   
    /**
     * prints the taskSet
     */
     public void printSet(){
        for(String task: taskSet){
            System.out.println(task);
        }
    }
    
 
}
