import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Dimension;
import java.awt.Font;

import java.awt.Color;

import java.awt.BorderLayout;

/**
 * The TextPanel class
 *
 * @author SkylerYoung
 * @version 1.0
 */
public class TextPanel extends JPanel
{
    /**
     * Fields for the TextPanel class
     */
    private JTextArea textArea;
    private Dimension panDim;
    private Dimension textDim;
    
    private Font fontObject;
    
    private Color panelCol;
    private Color textCol;
    
    private int selector;

    private BorderLayout layout;
    
    /**
     * Constructor for the TextPanel class
     */
    public TextPanel(int selector){
        
        this.selector = selector;
        
        if (selector == 0){
            textArea = new JTextArea("             New Project");
            textArea.setCaretPosition(13);
            textArea.moveCaretPosition(24);
            panDim = new Dimension(300, 50);
            textDim = new Dimension(300, 50);
        
            fontObject = new Font("Rockwell",0, 24);
            textCol = new Color(204, 51, 0);
            textArea.setFont(fontObject);
            textArea.setForeground(Color.black);
        
            textArea.setPreferredSize(textDim);
            setPreferredSize(panDim);
            
            panelCol = new Color(255, 255, 230);
            setBackground(Color.white);
        
            textArea.setBackground(Color.white);
        
            add(textArea);
            
        }
        else if (selector == 1){
            textArea = new JTextArea("(Task Name)");
            panDim = new Dimension(135, 55);
            textDim = new Dimension(135, 55);
        
            fontObject = new Font("Rockwell",20, 16);
            textCol = new Color(204, 51, 0);
            textArea.setFont(fontObject);
            textArea.setForeground(Color.black);
        
            textArea.setPreferredSize(textDim);
            setPreferredSize(panDim);
        
            panelCol = new Color(255, 255, 230);
            setBackground(Color.white);
        
            textArea.setBackground(Color.white);
            
            add(textArea);
        }
    }
    
    public JTextArea getTextArea(){
        return textArea;
    }
    
    public void setCaret(){
        textArea.setCaretPosition(13);
        textArea.moveCaretPosition(24);
    }
    
    public void setCaret2(){
        int temp = textArea.getText().length();
        textArea.setCaretPosition(temp);
    }
}
