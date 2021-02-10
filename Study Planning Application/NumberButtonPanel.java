import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Dimension;

import java.awt.Color;

import java.awt.Font;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.Border;

/**
 * The NumberButtonPanel class
 *
 * @author Skyler Young
 * @version 1.0
 */
public class NumberButtonPanel extends JPanel
{
    /**
     * The fields for NumberButtonPanel
     */
    private Dimension panelDim;
    private Dimension buttonDim;
    private JButton button;
    
    private Color panelCol;

    private Color oneCol;
    private Color twoCol;
    private Color threeCol;
    private Color fourCol;
    private Color fiveCol;
    
    private Font buttonFont;
    private Font buttonFont1;
    
    private int buttonValue;
    private int counter;
    
    private Border border;
    
    /**
     * The constructor for NumberButtonPanel
     */
    public NumberButtonPanel(){
        
            panelDim = new Dimension (50, 40);
        
            buttonDim = new Dimension(50, 28);
            button = new JButton("0");
        
            button.setPreferredSize(buttonDim);
            setPreferredSize(panelDim);
        
            panelCol = new Color(255, 255, 230);
            
            oneCol = new Color(153, 38, 0);
            twoCol = new Color(204, 51, 0);
            threeCol = new Color(230,57, 0);
            fourCol = new Color(255, 64, 0);
            fiveCol = new Color(230, 57, 0);
            
            button.setForeground(Color.black);
            
            buttonFont = new Font("Rockwell",0, 22);    
            button.setFont(buttonFont);
            
            setBackground(Color.white);
            button.setBackground(Color.white);
            
            buttonValue = 0;
            
            button.addActionListener(new numListener());
            
            button.setBorder(border);
            
            add(button);
    }
    
    public JButton getButton(){
        return button;
    }
    
    public int getButtonValue(){
        return buttonValue;
    }
    
    public void setButtonValue(int buttonValue){
        this.buttonValue = buttonValue;
    }
    
    private class numListener implements ActionListener{
        
        public void actionPerformed(ActionEvent event){
            if(buttonValue == 0){
                button.setText("1");  
                buttonValue = 1;
            }
            else if(buttonValue == 1){
                button.setText("2");
                buttonValue = 2;
            }
            else if(buttonValue == 2){
                button.setText("3");
                buttonValue = 3;
            }
            else if(buttonValue == 3){
                button.setText("4");
                buttonValue = 4;
            }
            else if(buttonValue == 4){
                button.setText("0");
                buttonValue = 0;
            }
        }
    }
}
