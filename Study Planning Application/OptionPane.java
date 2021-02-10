import javax.swing.JOptionPane;

/**
 * 
 *
 * @author SkylerYoung
 * @version 1.0
 */
public class OptionPane extends JOptionPane
{
    private String aboutText;
    
    public OptionPane(){
        aboutText = "\n \n       StudyAddict is an interactive planning application that students can use to " + 
            "\ntrack their progress while studying " +
            "or working on a project. " +
            "\n \n      It attempts to give the user an idea of " +
            "how they are doing on their assignment " +
            "\nby encouraging them to break it up into " +
            "individual tasks and allowing them the " +
            "\nability to rank their perceived level of " +
            "competence on each item. " +
            "\n \n       From there, the program takes in each "+
            "value that the user has provided and " +
            "\ncalculates a prediction of what score they " +
            "will receive on the assignment. " + 
            "\n \n       The goal of this application is to provide " + 
            "users with a sense of clarity and " +
            "\nfocus with respect to their assignments. " +
            "\n \n       It is also meant to motivate the successful " +
            "completion of schoolwork by " +
            "\n providing students with a visual indication of the progress that they've " +
            "made." +
            "\n \n      Thank you for using StudyAddict! " +
            "\n \n                      Sincerely, " +
            "\n                      Skyler Young " 
            ;
    }
    
    public void showPane(){
        Object options[] = { "Close"};
        showOptionDialog(
            null,
             " (Version 1.0)" +
             aboutText +
            "\n \n Author(s): " + 
            "\n      Skyler Young" + 
            "\n \n Contributor(s): " +
            "\n      RCC Computer \n      Science Club" + "\n ",
            "About StudyAddict",
            0,
            1,
            null,
            options,
            options[0]
            
        );
        
    }
   
}
