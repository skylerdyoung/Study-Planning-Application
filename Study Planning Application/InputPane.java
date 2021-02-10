import javax.swing.JOptionPane;

/**
 * 
 *
 * @author SkylerYoung
 * @version 1.0
 */
public class InputPane extends JOptionPane
{
    private String msgContent;
    
    public InputPane(){
    }
    
    public void showPane(){
        
        
        Object thisObject = showInputDialog(null, "File:", "Open", JOptionPane.INFORMATION_MESSAGE,null,null, "newSave"
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
