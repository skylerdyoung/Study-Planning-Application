
import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.Dimension;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.text.DecimalFormat;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.awt.event.KeyEvent;
import java.awt.Event;
import javax.swing.KeyStroke;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

import java.util.Scanner;

/**
 * The MainClass class, where the program is meant to be started.
 *
 * @author Skyler Young
 * @version 1.0
 */
public class MainClass
{
    /**
     * Fields for the Main Class.
     */
    private JFrame MainFrame;
    private MainPanel mainPanel;
    
    private Dimension dimensionObject;
    
    private JMenuBar menuBar;
    
    private JMenu fileMenu;
    private JMenu editMenu;
    private JMenu optionsMenu;
    private JMenu sortMenu;
    private JMenu helpMenu;
    
    private JMenuItem exit;
    private JMenuItem newTask;
    private JMenuItem removeTask;
    private JMenuItem reset;
    private JMenuItem about;
    private JMenuItem open;
    private JMenuItem load;
    private JMenuItem save;
    private JMenuItem saveas;
    private JMenuItem fileNew;
    private JMenuItem sortUp;
    private JMenuItem sortDown;
    
    private double valTotal;
    private double totalTasks;
    private double ceiling;
    private double percentage;
    
    private DecimalFormat roundPercent;
    
    private ArrayList<TaskItem> taskList;
    
    private OptionPane aboutPane;
    private InputPane openPane;
    private InputPane2 saveasPane;
    
    private String file; 
    private Scanner scan;
    
    
    /**
     * Constructor for the Main Class
     */
    public MainClass(){ 
        MainFrame = new JFrame("StudyAddict");
        
        mainPanel = new MainPanel();
        
        mainPanel.getAddButton().addActionListener(new addListener());
        mainPanel.getRemoveButton().addActionListener(new removeListener());
        
        MainFrame.add(mainPanel);
        
        menuBar = new JMenuBar();
        
        fileMenu = new JMenu(" File ");
        menuBar.add(fileMenu);
        fileNew = new JMenuItem(" New ");
        open = new JMenuItem(" Open... ");
        load = new JMenuItem(" Load ");
        save = new JMenuItem(" Save ");
        saveas = new JMenuItem(" Save As... ");
        exit = new JMenuItem(" Exit ");
        fileNew.addActionListener(new newListener());
        open.addActionListener(new openListener());
        save.addActionListener(new saveListener());
        load.addActionListener(new loadListener());
        saveas.addActionListener(new saveasListener());
        exit.addActionListener(new exitListener());
        
        fileNew.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.Event.CTRL_MASK));
        open.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.Event.CTRL_MASK));
        save.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.Event.CTRL_MASK));
        load.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.Event.CTRL_MASK));
        saveas.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.Event.CTRL_MASK + KeyEvent.SHIFT_MASK));
        exit.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.Event.ALT_MASK));
        
        fileMenu.add(fileNew);
        fileMenu.addSeparator();
        fileMenu.add(open);
        fileMenu.add(save);
        fileMenu.add(load);
        fileMenu.add(saveas);
        fileMenu.addSeparator();
        fileMenu.add(exit);
        
        editMenu = new JMenu(" Edit ");
        menuBar.add(editMenu);
        newTask = new JMenuItem(" Add Task ");
        newTask.addActionListener(new addListener());
        removeTask = new JMenuItem(" Remove Task ");
        removeTask.addActionListener(new removeListener());
        reset = new JMenuItem(" Reset ");
        reset.addActionListener(new resetListener());
        
        newTask.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.Event.CTRL_MASK));
        
        removeTask.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.Event.CTRL_MASK));                                   
        
        reset.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R,
                                           java.awt.Event.CTRL_MASK));
        
        editMenu.add(newTask);
        editMenu.add(removeTask);
        editMenu.addSeparator();
        editMenu.add(reset);
        
        optionsMenu = new JMenu(" Options ");
        menuBar.add(optionsMenu);
        sortUp = new JMenuItem(" Ascending ");
        sortUp.addActionListener(new sortUpListener());
        sortDown = new JMenuItem(" Descending ");
        sortDown.addActionListener(new sortDownListener());
        
        sortUp.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_UP,
                                            java.awt.Event.CTRL_MASK));
                                           
        sortDown.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DOWN,
                                           java.awt.Event.CTRL_MASK));
        
        sortMenu = new JMenu(" Sort Tasks        ");
        
        optionsMenu.add(sortMenu);
                                           
        sortMenu.add(sortUp);
        sortMenu.add(sortDown);
        
        aboutPane = new OptionPane();
        openPane = new InputPane();
        saveasPane = new InputPane2();
        
        helpMenu = new JMenu(" Help ");
        menuBar.add(helpMenu);
        about = new JMenuItem(" About StudyAddict ");
        about.addActionListener(new aboutListener());
        
        about.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1,
                                           0));
        
        helpMenu.add(about);
        
        MainFrame.setJMenuBar(menuBar); 
        
        valTotal = 0.0;
        totalTasks = 0.0;
        
        taskList = new ArrayList<>();
        
        roundPercent = new DecimalFormat("0.00");
        
        setPercentDisplay();
        mainPanel.getHeadPanel().getLabelPanel().setName("StudyAddict");
        
        MainFrame.pack();
        MainFrame.setLocationRelativeTo(null);
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainFrame.setVisible(true); 
        
    }
    
    /**
     * The main method.
     */
    public static void main(String[] args){
        MainClass main = new MainClass();
    }
    
    /**
     * Sets the grade percentage and displays it in the middle pane.
     */
    public void setPercentDisplay(){
        String rounded = roundPercent.format(getPercent());
        
        mainPanel.getControlPanel().getTotal().setName( rounded + "%");
        setGrade();
    }
    
    /**
     *  ActionListener that allows the user to exit.
     */
    private class exitListener implements ActionListener{
        
        public void actionPerformed(ActionEvent event){            
            System.exit(0);
        }
    }
    
    /**
     * ActionListener that creates a new Task in the bottom pane.
     */
    private class addListener implements ActionListener{
        
        public void actionPerformed(ActionEvent event){
            if (taskList.size() < 24){  
                TaskItem item = new TaskItem();
                item.getNumButton().addActionListener(new numListener2());
                
                taskList.add(item);
                
                item.getTextPanel().getTextArea().setText("(untitled task #" + taskList.size() + ")");
            
                addTaskList();
            
                totalTasks += 1;
            
                ceiling = totalTasks * 4;
                percentage = valTotal/ceiling;
                setPercentDisplay();
            
                MainFrame.pack();
            }  
        }
    }
    
    /**
     * ActionListener that wipes the bottom pane of all tasks.
     */
    private class resetListener implements ActionListener{
        
        public void actionPerformed(ActionEvent event){
            mainPanel.getTaskPanel().removeAll();
            
            resetValueTotal();
            resetTotalTasks();
            
            clearTaskList();
            
            percentage = 0.0;
            setPercentDisplay();
            
            mainPanel.updateUI();

            MainFrame.pack();
        }
    }
     
    /**
     * ActionListener that creates a new project.
     */
    private class newListener implements ActionListener{
        
        public void actionPerformed(ActionEvent event){
            mainPanel.getTaskPanel().removeAll();
            
            resetValueTotal();
            resetTotalTasks();
            
            clearTaskList();
            
            percentage = 0.0;
            setPercentDisplay();
            
            mainPanel.getHeadPanel().getTextArea().setText("             New Project");
            mainPanel.getHeadPanel().getTextPanel().setCaret();

            mainPanel.getHeadPanel().getLabelPanel().setName("StudyAddict");
       
            mainPanel.updateUI();

            MainFrame.pack();
        }
    }
    
    /**
     * ActionListener that removes the last task on the list.
     */
    private class removeListener implements ActionListener{
        
        public void actionPerformed(ActionEvent event){ 
            if (taskList.size() > 0){
                totalTasks -= 1;
                valTotal -= taskList.get(taskList.size() - 1).getButtonValue();
            
                mainPanel.getTaskPanel().remove(taskList.get(taskList.size() - 1));
                taskList.remove(taskList.get(taskList.size() - 1));
            
                ceiling = totalTasks * 4;
                percentage = valTotal/ceiling;
                setPercentDisplay();
                
                if (taskList.size() == 0){
                    ceiling = totalTasks * 4;
                    percentage = 0.00;
                    setPercentDisplay();
                }
            }
            else{
               ceiling = totalTasks * 4;
               percentage = 0.00;
               setPercentDisplay(); 
            }
            
            mainPanel.updateUI();

            MainFrame.pack();
        }
            
    }
    
    /**
     * ActionListener that ensures the buttons count to the apppropriate value
     * and reset.
     */
    private class numListener2 implements ActionListener{
        int counter = 0;
        
        public void actionPerformed(ActionEvent event){   
            
            if(counter < 4){
                counter += 1;
                valTotal += 1;
            }
            else{
                counter = 0;
                valTotal -= 4;
            }
            
            ceiling = totalTasks * 4;
            percentage = valTotal/ceiling;
            setPercentDisplay();
        }

        public void setCounter(int counter){
            this.counter = counter;
        }
        
        public int getCounter(){
            return counter;
        }
    }
    
    /**
     * ActionListener that shows the About dialog box.
     */
    private class aboutListener implements ActionListener{
        
        public void actionPerformed(ActionEvent event){   
            
            aboutPane.showPane();
            
        }
        
    }
    
    /**
     * 
     */
    private class openListener implements ActionListener{
        
        public void actionPerformed(ActionEvent event){   
            openFile();
            
            if (file != null){
            
                loadNewFile();
            
                readSaveFile();
                
            }
            
            openPane.setMsgContent(null);
        }
        
    }
    
    /**
     * 
     */
    private class saveListener implements ActionListener{
        
        public void actionPerformed(ActionEvent event){   
            if (file == null){
                
                saveasFile();
                
                if(saveasPane.getMsgContent() != null){
                    file = saveasPane.getMsgContent();
                    writeSaveFile();
                }
                else{
                    file = null;
                }
                
            }
            else{
                writeSaveFile();
            }
        }
        
    }
    
    /**
     * 
     */
    private class loadListener implements ActionListener{
        
        public void actionPerformed(ActionEvent event){   
            
            if (file == null){
                
                openFile();
                
                if(openPane.getMsgContent() != null){
                    file = openPane.getMsgContent();
                    loadNewFile();
                    readSaveFile();
                }
                else{
                    file = null;
                }
                
            }
            else{
                loadNewFile();
                
                readSaveFile();
            }

            
        }
        
    }
    
    /**
     * 
     */
    private class sortUpListener implements ActionListener{
        
        public void actionPerformed(ActionEvent event){   
            sortUp();
        }    
        
    }
    
    /**
     * 
     */
    private class sortDownListener implements ActionListener{
        
        public void actionPerformed(ActionEvent event){   
            sortDown();
        }    
        
    }
    
    /**
     * 
     */
    private class saveasListener implements ActionListener{
        
        public void actionPerformed(ActionEvent event){   
            saveasFile();
            
            if(saveasPane.getMsgContent() != null){
                file = saveasPane.getMsgContent();
                writeSaveFile();
            }
            else{
                file = null;
            }
        }
        
    }
    
    /**
     * Resets the valTotal variable to 0.
     */
    public void resetValueTotal(){
        valTotal = 0.0;
    }
    
    /**
     * Resets the TotalTasks variable to 0. 
     */
    public void resetTotalTasks(){
        totalTasks = 0;
    }
    
    /**
     * calculates Percentage in decimal formal 
     */
    public void calcPercent(){
        ceiling = totalTasks * 4;
        percentage = valTotal/ceiling;
    }
    
    /**
     * Retrieves the percent value from the program
     */
    public double getPercent(){
        return percentage * 100;
    }
    
    /**
     * Retrieves the total confidence ranking from the program
     */
    public double getValTotal(){
        return valTotal;
    }
    
    public void addTaskList(){
        for (TaskItem tempItem: taskList){
            mainPanel.getTaskPanel().add(tempItem);
        }
    }
    
    public void clearTaskList(){
        taskList.clear();
    }
    
    public void setGrade(){
        if(getPercent() < 65){
            if (taskList.size() > 0){
                mainPanel.getHeadPanel().getLabelPanel().setName("     F     ");
            }
            else{
                if(mainPanel.getHeadPanel().getLabelPanel().getName().equals("StudyAddict")){
                    mainPanel.getHeadPanel().getLabelPanel().setName("StudyAddict");
                }
                else{
                mainPanel.getHeadPanel().getLabelPanel().setName("StudyAddict");  
                }
            }
        }
        else if((getPercent() >= 65) && (getPercent() < 70)){
            mainPanel.getHeadPanel().getLabelPanel().setName("     D     ");
        }
        else if((getPercent() >= 70) && (getPercent() < 73)){
            mainPanel.getHeadPanel().getLabelPanel().setName("     C-    ");
        }
        else if((getPercent() >= 73) && (getPercent() < 77)){
            mainPanel.getHeadPanel().getLabelPanel().setName("     C     ");
        }
        else if((getPercent() >= 77) && (getPercent() < 80)){
            mainPanel.getHeadPanel().getLabelPanel().setName("      C+    ");
        }
        else if((getPercent() >= 80) && (getPercent() < 83)){
            mainPanel.getHeadPanel().getLabelPanel().setName("     B-    ");
        }
        else if((getPercent() >= 83) && (getPercent() < 87)){
            mainPanel.getHeadPanel().getLabelPanel().setName("     B     ");
        }
        else if((getPercent() >= 87) && (getPercent() < 90)){
            mainPanel.getHeadPanel().getLabelPanel().setName("      B+    ");
        }
        else if((getPercent() >= 90) && (getPercent() < 93)){
            mainPanel.getHeadPanel().getLabelPanel().setName("     A-    ");
        }
        else if((getPercent() >= 93)){
            mainPanel.getHeadPanel().getLabelPanel().setName("     A     ");
        }
    }
    
    public void printThese(){
        for(TaskItem item: taskList){
            System.out.println(item);
        }
    }
    
    public void addTask(String name, String num){
        if (taskList.size() < 24){  
                TaskItem item = new TaskItem();
                numListener2 tempListener = new numListener2();
                tempListener.setCounter(Integer.parseInt(num));
                item.getNumButton().addActionListener(tempListener);
                
                taskList.add(item);
                
                item.getTextPanel().getTextArea().setText(name);
                item.getNumButton().setText(num);
                
                item.getButtonPanel().setButtonValue(Integer.parseInt(num));
                
                addTaskList();
            
                totalTasks += 1;
                valTotal += Integer.parseInt(num);
            
                ceiling = totalTasks * 4;
                percentage = valTotal/ceiling;
                setPercentDisplay();
            
                MainFrame.pack();
            }  
        
    }
    
    public void loadNewFile(){
            mainPanel.getTaskPanel().removeAll();
            
            resetValueTotal();
            resetTotalTasks();
            
            clearTaskList();
            
            ceiling = totalTasks * 4;
            percentage = valTotal/ceiling;
            percentage = 0.0;
            setPercentDisplay();
            
            mainPanel.getHeadPanel().getTextArea().setText("             New Project");
            mainPanel.getHeadPanel().getTextPanel().setCaret();

            mainPanel.getHeadPanel().getLabelPanel().setName("StudyAddict");
       
            mainPanel.updateUI();

            MainFrame.pack();
        
    }
    
    public void writeSaveFile(){
        try{
            FileWriter writer = new FileWriter(file, false);
            
            String title = mainPanel.getHeadPanel().getTextArea().getText();
            writer.write(title + " Å0Å0Å0 ");
            writer.write("Ç¿1Ç¿ ");
            
            for(TaskItem item: taskList){
                String itemName = item.getTextPanel().getTextArea().getText();
                
                writer.write(itemName + " Å1Å1Å1 ");
                
            }
            
            writer.write("Ç¿1Ç¿ ");
            
            for(TaskItem item: taskList){
                int buttonVal = item.getButtonValue();
                
                writer.write(Integer.toString(buttonVal) + " Å2Å2Å2 ");
                
            }
            
            writer.write("Ç¿1Ç¿ ");
            
            writer.close();
        }catch(IOException ioException){ System.out.println("Error.");
        }    
    
    }
    
    public void readSaveFile(){
        try{
           FileReader reader = new FileReader(file);
           scan = new Scanner(reader);
           scan.useDelimiter("Ç¿1Ç¿ ");
           
           ArrayList<String> lineList = new ArrayList<>();
           ArrayList<String> nameList = new ArrayList<>();
           ArrayList<String> numList = new ArrayList<>();
           
           while (scan.hasNext()){
               String newName = scan.next();
               lineList.add(newName);
           }
           
           Scanner scan1 = new Scanner(lineList.get(0));
           scan1.useDelimiter(" Å0Å0Å0 ");
           
           while (scan1.hasNext()){
               String temp = scan1.next();
               mainPanel.getHeadPanel().getTextArea().setText(temp);
               mainPanel.getHeadPanel().getTextPanel().setCaret2();
           }
           
           Scanner scan2 = new Scanner(lineList.get(1));
           scan2.useDelimiter(" Å1Å1Å1 ");
           
           while (scan2.hasNext()){
               String temp = scan2.next();
               nameList.add(temp);       
           }
           
           Scanner scan3 = new Scanner(lineList.get(2));
           scan3.useDelimiter(" Å2Å2Å2 ");
           
           while (scan3.hasNext()){
               String temp = scan3.next();
               numList.add(temp);       
           }
           
           while (nameList.size() > 0){
               addTask(nameList.get(0),numList.get(0));
               nameList.remove(0);
               numList.remove(0);
           }
           
        }catch(IOException ioException){
            System.out.println("Error.");
        }
           
    }
    
    public void openFile(){
       openPane.showPane();
       file = openPane.getMsgContent();
    }
    
    public void saveasFile(){
        saveasPane.showPane();
    }
    
    public void resetTaskPanel(){
            mainPanel.getTaskPanel().removeAll();
            
            resetValueTotal();
            resetTotalTasks();
            
            clearTaskList();
            
            percentage = 0.0;
            setPercentDisplay();
            
            mainPanel.updateUI();

            MainFrame.pack();
    }    
     
    public void sortUp(){
        ArrayList<TaskItem> tempList = new ArrayList<>();

        for (TaskItem task: taskList){
            if (task.getButtonValue() == 4){
                tempList.add(task);
            }
        }
        
        for (TaskItem task: taskList){
            if (task.getButtonValue() == 3){
                tempList.add(task);
            }
        }
        
        for (TaskItem task: taskList){
            if (task.getButtonValue() == 2){
                tempList.add(task);
            }
        }
        
        for (TaskItem task: taskList){
            if (task.getButtonValue() == 1){
                tempList.add(task);
            }
        }
        
        for (TaskItem task: taskList){
            if (task.getButtonValue() == 0){
                tempList.add(task);
            }
        }
        
        resetTaskPanel();
        
        for(TaskItem task: tempList){
            addTask(task.getTextPanel().getTextArea().getText(),Integer.toString(task.getButtonPanel().getButtonValue()));
        }
        
        tempList.clear();
    }
    
    public void sortDown(){
        ArrayList<TaskItem> tempList = new ArrayList<>();
        
        for (TaskItem task: taskList){
            if (task.getButtonValue() == 0){
                tempList.add(task);
            }
        }
        
        for (TaskItem task: taskList){
            if (task.getButtonValue() == 1){
                tempList.add(task);
            }
        }
        
        for (TaskItem task: taskList){
            if (task.getButtonValue() == 2){
                tempList.add(task);
            }
        }
        
        for (TaskItem task: taskList){
            if (task.getButtonValue() == 3){
                tempList.add(task);
            }
        }
        
        for (TaskItem task: taskList){
            if (task.getButtonValue() == 4){
                tempList.add(task);
            }
        }
        
        resetTaskPanel();
        
        for(TaskItem task: tempList){
            addTask(task.getTextPanel().getTextArea().getText(),Integer.toString(task.getButtonPanel().getButtonValue()));
        }
        
        tempList.clear();
    }
}
