import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Dimension;

import java.awt.Color;

import java.awt.Font;

import javax.swing.border.Border;

/**
 * The ButtonPanel class
 *
 * @author Skyler Young
 * @version 1.0
 */
public class ButtonPanel extends JPanel
{
    /**
     * Fields for the ButtonPanel
     */
    private Dimension panelDim;
    private Dimension buttonDim;
    private JButton button;
    
    private Color panelCol;
    private Color textCol;
    
    private Font buttonFont;
    
    private int buttonOption;
    
    private Border border;
    
    /**
     * Constructor for the buttonPanel
     */
    public ButtonPanel(int buttonOption){
        this.buttonOption = buttonOption;
        
        if(buttonOption == 0){
            panelDim = new Dimension (50, 55);
        
            buttonDim = new Dimension(50, 50);
            button = new JButton("+");
        
            button.setPreferredSize(buttonDim);
            setPreferredSize(panelDim);
        
            panelCol = new Color(255, 255, 230);
            textCol= new Color(204, 51, 0);
            button.setForeground(Color.black);
            
            buttonFont = new Font("Rockwell",0, 24);    
            button.setFont(buttonFont);
            
            setBackground(Color.white);
            button.setBackground(Color.white);
            
            button.setBorder(border);
            
            
        }
        else if (buttonOption == 1){
            panelDim = new Dimension (50, 55);
        
            buttonDim = new Dimension(50, 50);
            button = new JButton("-");
        
            button.setPreferredSize(buttonDim);
            setPreferredSize(panelDim);
        
            panelCol = new Color(255, 255, 230);
            textCol= new Color(204, 51, 0);
            button.setForeground(Color.black);
            
            buttonFont = new Font("Rockwell",0, 24);    
            button.setFont(buttonFont);
            
            setBackground(Color.white);
            button.setBackground(Color.white);
            
            button.setBorder(border);
        }
        
        add(button);
        
    }
    
    /**
     * returns the button from ButtonPanel
     */
    public JButton getButton(){
        return button;
    }
}
