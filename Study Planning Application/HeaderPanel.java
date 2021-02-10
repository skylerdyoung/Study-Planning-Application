import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;

import java.awt.Color;

import java.awt.Font;

import javax.swing.JTextArea;

/**
 * The MainPanel class.
 *
 * @author Skyler Young
 * @version 1.0
 */

public class HeaderPanel extends JPanel
{
    /**
     * Fields for the HeaderPanel class
     */

    private Color colorObject;
    private TextPanel textPanel;
    private LabelPanel labelPanel;
    
    /**
     * Constructor for the HeaderPanel class
     */
    public HeaderPanel(){
        super();
        
        Dimension panelSize = new Dimension(500, 127);
        setPreferredSize(panelSize);
        
        colorObject = new Color(255, 255, 230);
        setBackground(Color.white);
        
        textPanel = new TextPanel(0);
        labelPanel = new LabelPanel("StudyAddict", 0);
        
        add(labelPanel);
        add(textPanel);
        
    }
    
    public TextPanel getTextPanel(){
        return textPanel;
    }
    
    public JTextArea getTextArea(){
        return textPanel.getTextArea();
    }
    
    public LabelPanel getLabelPanel(){
        return labelPanel;
    }
    
    public String getName(){
        return labelPanel.getName();
    }
}
