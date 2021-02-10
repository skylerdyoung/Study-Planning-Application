import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.Color;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * The ControlPanel class.
 *
 * @author Skyler Young
 * @version 1.0
 */
public class ControlPanel extends JPanel
{
    /**
     * Fields for the ControlPanel class
     */
    private Dimension panDim;
    
    private ButtonPanel addButton;
    private ButtonPanel removeButton;
    
    private Color panelCol;
    
    private LabelPanel numTotal;
    
    /**
     * Constructor for the ControlPanel class
     */
    public ControlPanel(){
        panDim = new Dimension(500, 75);
        setPreferredSize(panDim);
        
        addButton = new ButtonPanel(0);
        removeButton = new ButtonPanel(1);
        numTotal = new LabelPanel("0",1);

        add(addButton);
        add(numTotal);
        add(removeButton);
        
        panelCol = new Color(255, 255, 230);
        setBackground(Color.white);
    }    
    
    /**
     * retrieves the button from the addButton panel
     */
    public JButton getAddButton(){
        return addButton.getButton();
    }
    
    /**
     * retrieves the button from the removeButton panel
     */
    public JButton getRemoveButton(){
        return removeButton.getButton();
    }
    
    /**
     * retrieves the numTotal label from LabelPanel
     */
    public LabelPanel getTotal(){
        return numTotal;
    }
}
