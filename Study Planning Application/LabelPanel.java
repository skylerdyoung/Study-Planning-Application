import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;

import java.awt.Color;

import java.awt.Font;


/**
 * The LabelPanel class
 *
 * @author Skyler Young
 * @version 1.0
 */
public class LabelPanel extends JPanel
{
    /**
     * Fields for the LabelPanel class
     */
    
    private Font titleFont;
    private JLabel titleLabel;
    
    private Color BGColorObject;
    
    private Color FontColorObject;
    
    private int labelOption;
    
    /**
     * Constructor for the LabelPanel class
     */
    public LabelPanel(String name, int labelOption){
        this.labelOption = labelOption;
        
        if(labelOption == 0){
            titleFont = new Font("Rockwell",0, 60);      
            titleLabel = new JLabel(name);        
            titleLabel.setFont(titleFont);
        
            FontColorObject = new Color(204, 51, 0);
            titleLabel.setForeground(Color.black);
        
            BGColorObject = new Color(255, 255, 230);
            setBackground(Color.white);
        }
        else if(labelOption == 1){
            titleFont = new Font("Rockwell",0, 40);      
            titleLabel = new JLabel(name);        
            titleLabel.setFont(titleFont);
        
            FontColorObject = new Color(204, 51, 0);
            titleLabel.setForeground(Color.black);
        
            BGColorObject = new Color(255, 255, 230);
            setBackground(Color.white);
        }
        
        add(titleLabel);
        
    }
    
     /**
     * Sets the text value for the label
     */
    public void setName(String name){
        titleLabel.setText(name);
    }
    
    public String getName(){
        return titleLabel.getText();
    }
}
