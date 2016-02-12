package TestingTools.ServoTest;
//ServoTestGui class
//@author Curtis Cox
//ServoTestGui is the GUI class for the Servo test suite
//for FIU Discovery Lab Telebot - Arms

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ServoTestGui extends JFrame 
							implements ActionListener{
	protected JButton s10Button0, s10Button1, 
					s11Button0, s11Button1, s11Button2,
					s20Button0, s20Button1,
					s21Button0, s21Button1,
					s22Button0, s22Button1,
					s23Button0, s23Button1,
					s24Button0, s24Button1,
					s25Button0, s25Button1, s25Button2,
					s30Button0, s30Button1,
					s31Button0, s31Button1,
					s32Button0, s32Button1, s32Button2,
					s33Button0, s33Button1,
					s34Button0, s34Button1,
					s35Button0, s35Button1, s35Button2;
	protected JLabel s10Label, s11Label,
					s20Label, s21Label, s22Label, s23Label, 
					s24Label, s25Label,
					s30Label, s31Label, s32Label, s33Label, 
					s34Label, s35Label;
	protected FlowLayout labelLayout, buttonLayout;
	
	public ServoTestGui(String name){
		super(name);
	}
	
	 public void addComponentsToPane(final Container pane) {
		 
		 labelLayout = new FlowLayout();
		 labelLayout.setAlignment(FlowLayout.CENTER);
		 buttonLayout = new FlowLayout();
		 buttonLayout.setAlignment(FlowLayout.LEFT);
		 

		 
		 
		 s10Label = new JLabel("Servo 10 - Head Pitch");
		 s10Button0 = new JButton("Head Looking Down");
		 s10Button0.setHorizontalTextPosition(AbstractButton.CENTER);
		 s10Button0.setActionCommand("10Min");
		 s10Button0.addActionListener(this);
		 s10Button1 = new JButton("Head Looking Up");
		 s10Button1.setHorizontalTextPosition(AbstractButton.CENTER);
		 s10Button1.setActionCommand("10Max");
		 s10Button1.addActionListener(this);
		
		 JPanel s10LabelPanel = new JPanel();
		 s10LabelPanel.setLayout(labelLayout);
		 s10LabelPanel.add(s10Label);
		 pane.add(s10LabelPanel, BorderLayout.CENTER);
		 JPanel s10ButtonPanel = new JPanel();
		 s10ButtonPanel.setLayout(buttonLayout);
		 s10ButtonPanel.add(s10Button0);
		 s10ButtonPanel.add(s10Button1);
		 pane.add(s10ButtonPanel, BorderLayout.SOUTH);
		
		s11Label = new JLabel("Servo 11 - Head Yaw");
		s11Button0 = new JButton("Head Looking Right");
		s11Button0.setHorizontalTextPosition(AbstractButton.CENTER);
		s11Button0.setActionCommand("11Min");
		s11Button0.addActionListener(this);
		s11Button1 = new JButton("Head Looking Forward");
		s11Button1.setHorizontalTextPosition(AbstractButton.CENTER);
		s11Button1.setActionCommand("11Rest");
		s11Button1.addActionListener(this);
		s11Button2 = new JButton("Head Looking Left");
		s11Button2.setHorizontalTextPosition(AbstractButton.CENTER);
		s11Button2.setActionCommand("11Max");
		s11Button2.addActionListener(this);
		
		 JPanel s11LabelPanel = new JPanel();
		 s11LabelPanel.setLayout(labelLayout);
		 s11LabelPanel.add(s11Label);
		 pane.add(s11LabelPanel, BorderLayout.CENTER);
		 JPanel s11ButtonPanel = new JPanel();
		 s11ButtonPanel.setLayout(buttonLayout);
		 s11ButtonPanel.add(s11Button0);
		 s11ButtonPanel.add(s11Button1);
		 s11ButtonPanel.add(s11Button2);
		 pane.add(s11ButtonPanel, BorderLayout.SOUTH);
		 
		s20Label = new JLabel("Servo 20 - Left Shoulder Pitch");
		s20Button0 = new JButton("Left Arm At Side - Rest");
		s20Button0.setHorizontalTextPosition(AbstractButton.CENTER);
		s20Button0.setActionCommand("20Min");
		s20Button0.addActionListener(this);
		s20Button1 = new JButton("Left Arm Raised Forward");
		s20Button1.setHorizontalTextPosition(AbstractButton.CENTER);
		s20Button1.setActionCommand("20Max");
		s20Button1.addActionListener(this);
		
		s21Label = new JLabel("Servo 21 - Left Shoulder Roll");
		s21Button0 = new JButton("Left Arm At Side - Rest");
		s21Button0.setHorizontalTextPosition(AbstractButton.CENTER);
		s21Button0.setActionCommand("21Rest");
		s21Button0.addActionListener(this);
		s21Button1 = new JButton("Left Arm Raised Out");
		s21Button1.setHorizontalTextPosition(AbstractButton.CENTER);
		s21Button1.setActionCommand("21Max");
		s21Button1.addActionListener(this);
		
		s22Label = new JLabel("Servo 22 - Left Arm Yaw");
		s22Button0 = new JButton("Left Elbow Pointing Back");
		s22Button0.setHorizontalTextPosition(AbstractButton.CENTER);
		s22Button0.setActionCommand("22Min");
		s22Button0.addActionListener(this);
		s22Button1 = new JButton("Left Elbow Pointing In - Rest");
		s22Button1.setHorizontalTextPosition(AbstractButton.CENTER);
		s22Button1.setActionCommand("22Rest");
		s22Button1.addActionListener(this);
		
		s23Label = new JLabel("Servo 23 - Left Elbow Roll");
		s23Button0 = new JButton("Left Elbow Straight - Rest");
		s23Button0.setHorizontalTextPosition(AbstractButton.CENTER);
		s23Button0.setActionCommand("23Rest");
		s23Button0.addActionListener(this);
		s23Button1 = new JButton("Left Elbow 90 Deg");
		s23Button1.setHorizontalTextPosition(AbstractButton.CENTER);
		s23Button1.setActionCommand("23Max");
		s23Button1.addActionListener(this);
		
		s24Label = new JLabel("Servo 24 - Left Forearm Yaw");
		s24Button0 = new JButton("Left Wrist In Line With Elbow - Rest");
		s24Button0.setHorizontalTextPosition(AbstractButton.CENTER);
		s24Button0.setActionCommand("24Rest");
		s24Button0.addActionListener(this);
		s24Button1 = new JButton("Left Wrist Turned In");
		s24Button1.setHorizontalTextPosition(AbstractButton.CENTER);
		s24Button1.setActionCommand("24Max");
		s24Button1.addActionListener(this);
		
		s25Label = new JLabel("Servo 25 - Left Wrist Roll");
		s25Button0 = new JButton("Left Wrist Back");
		s25Button0.setHorizontalTextPosition(AbstractButton.CENTER);
		s25Button0.setActionCommand("25Min");
		s25Button0.addActionListener(this);
		s25Button1 = new JButton("Left Wrist Straight - Rest");
		s25Button1.setHorizontalTextPosition(AbstractButton.CENTER);
		s25Button1.setActionCommand("25Rest");
		s25Button1.addActionListener(this);
		s25Button2 = new JButton("Left Wrist Forward");
		s25Button2.setHorizontalTextPosition(AbstractButton.CENTER);
		s25Button2.setActionCommand("25Max");
		s25Button2.addActionListener(this);
		
		
		s30Label = new JLabel("Servo 30 - Right Shoulder Pitch");
		s30Button0 = new JButton("Right Arm At Side - Rest");
		s30Button0.setHorizontalTextPosition(AbstractButton.CENTER);
		s30Button0.setActionCommand("30Max");
		s30Button0.addActionListener(this);
		s30Button1 = new JButton("Right Arm Raised Forward");
		s30Button1.setHorizontalTextPosition(AbstractButton.CENTER);
		s30Button1.setActionCommand("30Min");
		s30Button1.addActionListener(this);
		
		s31Label = new JLabel("Servo 31 - Right Shoulder Roll");
		s31Button0 = new JButton("Right Arm At Side - Rest");
		s31Button0.setHorizontalTextPosition(AbstractButton.CENTER);
		s31Button0.setActionCommand("31Max");
		s31Button0.addActionListener(this);
		s31Button1 = new JButton("Right Arm Raised Out");
		s31Button1.setHorizontalTextPosition(AbstractButton.CENTER);
		s31Button1.setActionCommand("31Min");
		s31Button1.addActionListener(this);
		
		s32Label = new JLabel("Servo 32 - Right Arm Yaw");
		s32Button0 = new JButton("Right Arm Yaw Min");
		s32Button0.setHorizontalTextPosition(AbstractButton.CENTER);
		s32Button0.setActionCommand("32Min");
		s32Button0.addActionListener(this);
		s32Button1 = new JButton("Right Arm Yaw Rest");
		s32Button1.setHorizontalTextPosition(AbstractButton.CENTER);
		s32Button1.setActionCommand("32Rest");
		s32Button1.addActionListener(this);
		s32Button2 = new JButton("Right Arm Yaw Max");
		s32Button2.setHorizontalTextPosition(AbstractButton.CENTER);
		s32Button2.setActionCommand("32Max");
		s32Button2.addActionListener(this);
		
		s33Label = new JLabel("Servo 33 - Right Elbow Roll");
		s33Button0 = new JButton("Right Elbow Straight - Rest");
		s33Button0.setHorizontalTextPosition(AbstractButton.CENTER);
		s33Button0.setActionCommand("33Rest");
		s33Button0.addActionListener(this);
		s33Button1 = new JButton("Right Elbow 90 Deg");
		s33Button1.setHorizontalTextPosition(AbstractButton.CENTER);
		s33Button1.setActionCommand("33Min");
		s33Button1.addActionListener(this);
		
		s34Label = new JLabel("Servo 34 - Right Forearm Yaw");
		s34Button0 = new JButton("Right Wrist In Line With Elbow - Rest");
		s34Button0.setHorizontalTextPosition(AbstractButton.CENTER);
		s34Button0.setActionCommand("34Rest");
		s34Button0.addActionListener(this);
		s34Button1 = new JButton("Right Wrist Turned In");
		s34Button1.setHorizontalTextPosition(AbstractButton.CENTER);
		s34Button1.setActionCommand("34Min");
		s34Button1.addActionListener(this);
		
		s35Label = new JLabel("Servo 35 - Right Wrist Roll");
		s35Button0 = new JButton("Right Wrist Back");
		s35Button0.setHorizontalTextPosition(AbstractButton.CENTER);
		s35Button0.setActionCommand("35Max");
		s35Button0.addActionListener(this);
		s35Button1 = new JButton("Right Wrist Straight - Rest");
		s35Button1.setHorizontalTextPosition(AbstractButton.CENTER);
		s35Button1.setActionCommand("35Rest");
		s35Button1.addActionListener(this);
		s35Button2 = new JButton("Right Wrist Forward");
		s35Button2.setHorizontalTextPosition(AbstractButton.CENTER);
		s35Button2.setActionCommand("35Min");
		s35Button2.addActionListener(this);
		
	}
		
	
public void actionPerformed(ActionEvent e) {
	
}
	
	 /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     * this method copied from:
     * https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/layout/FlowLayoutDemoProject/src/layout/FlowLayoutDemo.java
     * 
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        ServoTestGui frame = new ServoTestGui("FlowLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        frame.addComponentsToPane(frame.getContentPane());
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

 
    /**
    * This method copied from:
    * https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/components/LabelDemoProject/src/components/LabelDemo.java
    */
    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
        //Turn off metal's use of bold fonts
            UIManager.put("swing.boldMetal", Boolean.FALSE);
                 
        createAndShowGUI();
            }
        });
    }


}
