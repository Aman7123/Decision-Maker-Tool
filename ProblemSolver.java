package random;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
 
 
public class ProblemSolver extends JPanel
                          implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static String OK = "ok";
    private static String HELP = "help";
    private static String CLEAR = "clear";
    private static String EXIT = "exit";
    private static String REMOVE = "remove";
    private static String ADD = "add";
    private static JFrame frame;
 
    private JFrame controllingFrame;
    private static Boolean Option3Visible;
    private static Boolean Option4Visible;
    protected static JTextArea textArea;
    private JTextField Option1;
    private JTextField Option2;
    private JTextField Option3;
    private JTextField Option4;
    private JPanel textPane;
    private JPanel inputPane;
    private static JButton okButton;
    private static JButton exitButton;
    private static JButton helpButton;
    private static JButton addButton;
    private static JButton removeButton;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    
    public ProblemSolver(JFrame f) {
        controllingFrame = f;
        
        
        textArea = new JTextArea(25, 60);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setFont(Font.getFont(Font.SANS_SERIF));
        JScrollPane scroller = new JScrollPane(textArea);
        
        //Create everything.
        Option1 = new JTextField(15);
        Option1.setActionCommand(OK);
        Option1.addActionListener(this);
        
        Option2 = new JTextField(15);
        Option2.setActionCommand(OK);
        Option2.addActionListener(this);
        
        Option3 = new JTextField(15);
        Option3.setActionCommand(OK);
        Option3.addActionListener(this);
        Option3Visible = false;
        Option3.setVisible(false);
        
        Option4 = new JTextField(15);
        Option4.setActionCommand(OK);
        Option4.addActionListener(this);
        Option4Visible = false;
        Option4.setVisible(false);
        

        label1 = new JLabel("Enter option 1:");
        label1.setFont(label1.getFont().deriveFont(1, label1.getFont().getSize() + 2));
        label1.setLabelFor(Option1);
        
        label2 = new JLabel("Enter option 2:");
        //label2.setPreferredSize(preferredSize);
        label2.setFont(label2.getFont().deriveFont(1, label2.getFont().getSize() + 2));
        label2.setLabelFor(Option2);
        
        label3 = new JLabel("Enter option 3:");
        label3.setFont(label3.getFont().deriveFont(1, label3.getFont().getSize() + 2));
        label3.setLabelFor(Option3);
        label3.setVisible(false);
        
        label4 = new JLabel("Enter option 4:");
        label4.setFont(label4.getFont().deriveFont(1, label4.getFont().getSize() + 2));
        label4.setLabelFor(Option4);
        label4.setVisible(false);
        
        JButton helpButton = createHelpButton();
        JButton okButton = createOkButton();
        JButton exitButton = createExitButton();
        JButton addButton = createAddButton();
        JButton removeButton = createRemoveButton();
        
        
        okButton.setActionCommand(OK);
        helpButton.setActionCommand(HELP);
        exitButton.setActionCommand(EXIT);
        addButton.setActionCommand(ADD);
        removeButton.setActionCommand(REMOVE);
        
        okButton.addActionListener(this);
        helpButton.addActionListener(this);
        exitButton.addActionListener(this);
        addButton.addActionListener(this);
        removeButton.addActionListener(this);
        
        JPanel textAreaPane = new JPanel();
        textAreaPane.add(scroller);
        inputPane = new JPanel(new GridLayout(0,1));
        inputPane.setLayout(new BoxLayout(inputPane, BoxLayout.X_AXIS));
        textPane = new JPanel();
        textArea.setBackground(Color.black);
        textArea.setForeground(Color.white);
        textPane.setOpaque(false);
        textPane.add(textAreaPane);
        textPane.add(label1);
        textPane.add(Option1);
        
        textPane.add(label2);
        textPane.add(Option2);
        
        textPane.add(label3);
        textPane.add(Option3);
        
        textPane.add(label4);
        textPane.add(Option4);
        
        inputPane.add(addButton);
        inputPane.add(Box.createRigidArea(new Dimension(10,0)));
        inputPane.add(helpButton);
        inputPane.add(Box.createRigidArea(new Dimension(10,0)));
        inputPane.add(okButton);
        inputPane.add(Box.createRigidArea(new Dimension(10,0)));
        inputPane.add(exitButton);
        inputPane.add(Box.createRigidArea(new Dimension(10,0)));
        inputPane.add(removeButton);
        inputPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        textPane.add(inputPane);
        add(textPane);
    }
    
    protected JButton createHelpButton() {
    	helpButton = new JButton("Help");
    	setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = 1;
        constraints.weightx = 1.0D;
        constraints.weighty = 1.0D;
        
        constraints.gridy = 0;
        constraints.gridx = 0;
        helpButton.setFont(helpButton.getFont().deriveFont(1, helpButton.getFont().getSize() + 2));
        
        return helpButton;
    }
    
    protected JButton createAddButton() {
    	addButton = new JButton("Add a option");
    	setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = 1;
        constraints.weightx = 1.0D;
        constraints.weighty = 1.0D;
        
        constraints.gridy = 0;
        constraints.gridx = 0;
        addButton.setFont(addButton.getFont().deriveFont(1, addButton.getFont().getSize() + 2));
        
        return addButton;
    }
    
    protected JButton createRemoveButton() {
    	removeButton = new JButton("Remove a option");
    	setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = 1;
        constraints.weightx = 1.0D;
        constraints.weighty = 1.0D;
        
        constraints.gridy = 0;
        constraints.gridx = 0;
        removeButton.setFont(removeButton.getFont().deriveFont(1, removeButton.getFont().getSize() + 2));
        
        return removeButton;
    }
    
    protected JButton createOkButton() {
    	okButton = new JButton("Submit");
    	setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = 1;
        constraints.weightx = 1.0D;
        constraints.weighty = 1.0D;
        
        constraints.gridy = 0;
        constraints.gridx = 0;
        okButton.setFont(okButton.getFont().deriveFont(1, okButton.getFont().getSize() + 2));
        
        return okButton;
    }
    
    protected JButton createExitButton() {
    	exitButton = new JButton("Exit");
    	setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = 1;
        constraints.weightx = 1.0D;
        constraints.weighty = 1.0D;
        
        constraints.gridy = 0;
        constraints.gridx = 0;
        exitButton.setFont(exitButton.getFont().deriveFont(1, exitButton.getFont().getSize() + 2));
        
        return exitButton;
    }
    
    public static final int getnumbers() {
        String Option3State = Option3Visible.toString();
        String Option4State = Option4Visible.toString();
        Random random = new Random();
        int number = 0;
        if(Option3State.equalsIgnoreCase("false")) {
        	number = showRandomInteger(1, 4, random);
        }
        else if(Option4State.equalsIgnoreCase("true")) {
        	number = showRandomInteger(1, 8, random);
        }
        else if(Option3State.equalsIgnoreCase("true")) {
        	if(Option4State.equalsIgnoreCase("false")) {
        		number = showRandomInteger(1, 6, random);
        	}
        }
        return number;
    }
      
    private static int showRandomInteger(int aStart, int aEnd, Random aRandom){
        if (aStart > aEnd) {
          throw new IllegalArgumentException("Start cannot exceed End.");
        }
        //get the range, casting to long to avoid overflow problems
        long range = (long)aEnd - (long)aStart + 1;
        long fraction = (long)(range * aRandom.nextDouble());
        int randomNumber =  (int)(fraction + aStart);
        return randomNumber;
      }
 
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        String Option3State = Option3Visible.toString();
        String Option4State = Option4Visible.toString();
        
        String option1 = Option1.getText();
        String option2 = Option2.getText();
        String option3 = Option3.getText();
        String option4 = Option4.getText();
        
        if (CLEAR.equals(cmd)) {
        	frame.dispose();
        	createAndShowGUI();
        }
        
        if (OK.equals(cmd)) {
        	if(option1.equalsIgnoreCase("throwerror") || option1.equalsIgnoreCase("error") || option2.equalsIgnoreCase("error") || option2.equalsIgnoreCase("throwerror")) {
                okButton.setText("Restart Window!");
                okButton.setActionCommand(CLEAR);
                exitButton.setVisible(false);
                addButton.setVisible(false);
                removeButton.setVisible(false);
                helpButton.setVisible(false);
                textArea.setBackground(Color.red);
                textArea.setToolTipText("An Error Occured");
                okButton.setToolTipText("An Error Occured, Click to restart!");
                Option1.setToolTipText("An Error Occured");
                Option2.setToolTipText("An Error Occured");
                Option3.setToolTipText("An Error Occured");
                Option4.setToolTipText("An Error Occured");
                textArea.append(" \n");
                Option1.setText("An Error Occured");
                Option2.setText("An Error Occured");
                Option3.setText("An Error Occured");
                Option4.setText("An Error Occured");
                frame.setTitle(time() + " An Error Has Occured");
                Option1.setEditable(false);
                Option2.setEditable(false);
                frame.setSize(690, 560);
                Option3.setEditable(false);
                Option4.setEditable(false);
                IllegalArgumentException error = new IllegalArgumentException("The wizard cannot process a \"0\"!");
                StringWriter writer = new StringWriter();
                PrintWriter printWriter = new PrintWriter( writer );
                error.printStackTrace( printWriter );
                String stackTrace = writer.toString();
                textArea.append(stackTrace);
        		throw new IllegalArgumentException("");
        	}
        	int number = getnumbers();
        	textArea.append(time() + " The wizard rolled a: " + number + "\n");
        	if(number == 0) {
                okButton.setText("Restart Window!");
                okButton.setActionCommand(CLEAR);
                exitButton.setVisible(false);
                addButton.setVisible(false);
                removeButton.setVisible(false);
                helpButton.setVisible(false);
                textArea.setBackground(Color.red);
                textArea.setToolTipText("An Error Occured");
                okButton.setToolTipText("An Error Occured, Click to restart!");
                Option1.setToolTipText("An Error Occured");
                Option2.setToolTipText("An Error Occured");
                Option3.setToolTipText("An Error Occured");
                Option4.setToolTipText("An Error Occured");
                textArea.append(" \n");
                Option1.setText("An Error Occured");
                Option2.setText("An Error Occured");
                Option3.setText("An Error Occured");
                Option4.setText("An Error Occured");
                frame.setTitle(time() + " An Error Has Occured");
                Option1.setEditable(false);
                Option2.setEditable(false);
                frame.setSize(690, 560);
                Option3.setEditable(false);
                Option4.setEditable(false);
                IllegalArgumentException error = new IllegalArgumentException("The wizard cannot process a \"0\"!");
                StringWriter writer = new StringWriter();
                PrintWriter printWriter = new PrintWriter( writer );
                error.printStackTrace( printWriter );
                String stackTrace = writer.toString();
                textArea.append(stackTrace);
        		throw new IllegalArgumentException("");
        	}
            if(Option3State.equalsIgnoreCase("false")) {
            	if(number== 1 || number == 3) {
            		textArea.append(time() + " The magic wizard has chosen: " + option1 + "\n");
            		Option1.setBackground(Color.red);
            		Option1.setForeground(Color.white);
            	}
            	else if(number == 2 || number == 4) {
            		textArea.append(time() + " The magic wizard has chosen: " + option2 + "\n");
            		Option2.setBackground(Color.red);
            		Option2.setForeground(Color.white);
            	}
            }
            else if(Option4State.equalsIgnoreCase("true")) {
            	if(number == 1 || number == 4) {
            		textArea.append(time() + " The magic wizard has chosen: " + option1 + "\n");
            		Option1.setBackground(Color.red);
            		Option1.setForeground(Color.white);
            	}
            	else if(number == 2 || number == 5) {
            		textArea.append(time() + " The magic wizard has chosen: " + option2 + "\n");
            		Option2.setBackground(Color.red);
            		Option2.setForeground(Color.white);
            	}
            	else if(number == 3 || number == 6) {
            		textArea.append(time() + " The magic wizard has chosen: " + option3 + "\n");
            		Option3.setBackground(Color.red);
            		Option3.setForeground(Color.white);
            	}
            	
            }
            else if(Option3State.equalsIgnoreCase("true")) {
            	if(Option4State.equalsIgnoreCase("false")) {
                	if(number == 4 || number == 6) {
                		textArea.append(time() + " The magic wizard has chosen: " + option1 + "\n");
                		Option1.setBackground(Color.red);
                		Option1.setForeground(Color.white);
                	}
                	else if(number == 2 || number == 7) {
                		textArea.append(time() + " The magic wizard has chosen: " + option2 + "\n");
                		Option2.setBackground(Color.red);
                		Option2.setForeground(Color.white);
                	}
                	else if(number == 5 || number == 8) {
                		textArea.append(time() + " The magic wizard has chosen: " + option3 + "\n");
                		Option3.setBackground(Color.red);
                		Option3.setForeground(Color.white);
                	}
                	else if(number == 1 || number == 3) {
                		textArea.append(time() + " The magic wizard has chosen: " + option4 + "\n");
                		Option4.setBackground(Color.red);
                		Option4.setForeground(Color.white);
                	}
            	}
            }
            okButton.setText("Clear Options!");
            okButton.setActionCommand(CLEAR);
            exitButton.setVisible(false);
            addButton.setVisible(false);
            removeButton.setVisible(false);
            helpButton.setVisible(false);
            okButton.setToolTipText("You must clear before you use it again!");
            Option1.setToolTipText("You must clear before you use it again!");
            Option2.setToolTipText("You must clear before you use it again!");
            Option3.setToolTipText("You must clear before you use it again!");
            Option4.setToolTipText("You must clear before you use it again!");
            Option1.setEditable(false);
            Option2.setEditable(false);
            Option3.setEditable(false);
            Option4.setEditable(false);
        }
        
        if (HELP.equals(cmd)) {
            textArea.append("\n-- Can you not decide something on your own? \n    Well we have a fix for that, just enter your options, \n    In here, to your problem and let JAVA decide!");
        }
        
        if (EXIT.equals(cmd)) {
        	frame.dispose();
        }
        
        if (ADD.equals(cmd)) {
        	if (Option3State.equalsIgnoreCase("false")) {
        		Option3Visible = true;
        		Option3.setVisible(true);
        		label3.setVisible(true);
        	}
        	
        	else if (Option4State.equalsIgnoreCase("false")) {
        		Option4Visible = true;
        		Option4.setVisible(true);
        		label4.setVisible(true);
        	}
        	else {
                JOptionPane.showMessageDialog(controllingFrame,"Their is no way u have more then Four options", "Really?!", JOptionPane.ERROR_MESSAGE);
        	}
        }
        
        if (REMOVE.equals(cmd)) {
        	if (Option4State.equalsIgnoreCase("true")) {
        		Option4Visible = false;
        		Option4.setVisible(false);
        		label4.setVisible(false);
        	}
        	
        	else if (Option3State.equalsIgnoreCase("true")) {
        		Option3Visible = false;
        		Option3.setVisible(false);
        		label3.setVisible(false);
        	}
        	else {
                JOptionPane.showMessageDialog(controllingFrame,"If you have less then two options then \nI dont need to decide for you!", "Duh", JOptionPane.ERROR_MESSAGE);
        	}
        }
        
    }
 
    //Must be called from the event dispatch thread.
    public void resetFocus() {
    	Option1.requestFocusInWindow();
    }
    
	public static void main(String... args)
    {
		createAndShowGUI();
    }
	
	public static String time() {
	      Date dNow = new Date( );
	      SimpleDateFormat ft = 
	      new SimpleDateFormat ("hh:mm:ss a");
	      String time = "[" + ft.format(dNow) + "]";
	      return time;
	}
 
    static void createAndShowGUI() {
        //Create and set up the window.
    	UIManager.put("swing.boldMetal", Boolean.FALSE);
        frame = new JFrame("Decision Maker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        final ProblemSolver newContentPane = new ProblemSolver(frame);
        newContentPane.setOpaque(false); //content panes must be opaque
        frame.setContentPane(newContentPane);
        frame.setLayout(new BoxLayout(newContentPane, BoxLayout.Y_AXIS));
        frame.getRootPane().setDefaultButton(okButton);
        frame.setResizable(false);
        
        frame.addWindowListener(new WindowAdapter() {
            public void windowActivated(WindowEvent e) {
                newContentPane.resetFocus();
            }
        });

  	    textArea.append("Current time is " + DateFormat.getDateTimeInstance(2, 2, Locale.US).format(new Date()) + "\n");
  	    textArea.append("Welcome back, " + System.getProperty("user.name") + "\n");
        //Display the window.
        frame.pack();
        frame.setSize(675, 560);
        frame.setVisible(true);
    }
}
