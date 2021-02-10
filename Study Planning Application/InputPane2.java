import javax.swing.JOptionPane;

/**
 * 
 *
 * @author SkylerYoung
 * @version 1.0
 */
public class InputPane2 extends JOptionPane
{
    private String msgContent;
    
    public InputPane2(){
    }
    
    public void showPane(){
        
        
        Object thisObject = showInputDialog(null, "File:", "Save As", JOptionPane.QUESTION_MESSAGE,null,null, "newSave"
        );
        
        if(thisObject != null){
            msgContent = "saves\\" + thisObject.toString() + ".sat";
        }
    }
   
    public void printMsgContent(){
        System.out.println(msgContent);
    }
    
    public String getMsgContent(){
        return msgContent;
    }
    
     public void setMsgContent(String msgContent){
        this.msgContent = msgContent;
    }
}
