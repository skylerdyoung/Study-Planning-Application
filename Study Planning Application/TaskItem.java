import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JButton;

/**
 * The TaskItem class.
 *
 * @author Skyler Young
 * @version 1.0
 */
public class TaskItem extends JPanel
{
    /**
     * The fields for the TaskItem class
     */
    private Dimension panDim;
    private Color colorObject;
    private TextPanel taskName;
    private NumberButtonPanel numButton;
    
    private int taskButtonValue;
    
    private int counter;
    
    /**
     * The constructor for the TaskItem class
     */
    public TaskItem(){
        panDim = new Dimension(210, 55);
        setPreferredSize(panDim);
        
        numButton = new NumberButtonPanel();
        add(numButton);
        
        taskName = new TextPanel(1);
        add(taskName);
        
        colorObject = new Color(255, 255, 230);
        setBackground(Color.white);
        
        taskButtonValue = numButton.getButtonValue();

    }
    
    /**
     * retrieves the numButton from NumberButtonPanel
     */
    public JButton getNumButton(){
        return numButton.getButton();
    }
    
    /**
     * retrieves the buttonValue of numButton
     */
    public int getButtonValue(){
        return numButton.getButtonValue();
    }
    
    public NumberButtonPanel getButtonPanel(){
     
        return numButton;
        
    }
    
    public TextPanel getTextPanel(){
        return taskName;
    }
    
    public void setTaskName(String name){
        taskName.getTextArea().setText(name);
    }
    
}
