package TestingTools.ServoTest;
//ServoTestGui class
//@author Curtis Cox
//ServoTestGui is the GUI class for the Servo test suite
//for FIU Discovery Lab Telebot - Arms

import javax.swing.WindowConstants;
import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class ServoTestGui extends JFrame 
							implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private ServoControl controller;
	
	// ServoTestGui creates and displays the UI 
	// for the Servo Test App
	public ServoTestGui() {
		controller = ServoControl.getSingleton();
		
		 Font labelFont = new Font("Calibri", Font.BOLD, 20);
		 Font buttonFont = new Font("Calibri", Font.BOLD, 16);
		 
		 GroupLayout layout = new GroupLayout(getContentPane());
		 getContentPane().setLayout(layout);
		 layout.setAutoCreateGaps(true);
		 layout.setAutoCreateContainerGaps(true);
		 		 
		 JButton s10Button0, s10Button1, 
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
		 
		 JLabel s10Label, s11Label,
			s20Label, s21Label, s22Label, s23Label, 
			s24Label, s25Label,
			s30Label, s31Label, s32Label, s33Label, 
			s34Label, s35Label;

		 //Format and layout buttons and labels
		 //Head
		 //Servo 10 - Head Pitch
		 s10Label = new JLabel("Servo 10 - Head Pitch");
		 s10Label.setFont(labelFont);
		 s10Button0 = new JButton("Head Looking Down");
		 s10Button0.setFont(buttonFont);
		 s10Button0.setHorizontalTextPosition(AbstractButton.CENTER);
		 s10Button0.setActionCommand("10Min");
		 s10Button0.addActionListener(this);
		 s10Button1 = new JButton("Head Looking Up");
		 s10Button1.setFont(buttonFont);
		 s10Button1.setHorizontalTextPosition(AbstractButton.CENTER);
		 s10Button1.setActionCommand("10Max");
		 s10Button1.addActionListener(this);
		 
		 //Servo 11 - Head Yaw
		 s11Label = new JLabel("Servo 11 - Head Yaw");
		 s11Label.setFont(labelFont);
		 s11Button0 = new JButton("Head Looking Right");
		 s11Button0.setFont(buttonFont);
		 s11Button0.setHorizontalTextPosition(AbstractButton.CENTER);
		 s11Button0.setActionCommand("11Min");
		 s11Button0.addActionListener(this);
		 s11Button1 = new JButton("Head Looking Forward");
		 s11Button1.setFont(buttonFont);
		 s11Button1.setHorizontalTextPosition(AbstractButton.CENTER);
		 s11Button1.setActionCommand("11Rest");
		 s11Button1.addActionListener(this);
		 s11Button2 = new JButton("Head Looking Left");
		 s11Button2.setFont(buttonFont);
		 s11Button2.setHorizontalTextPosition(AbstractButton.CENTER);
		 s11Button2.setActionCommand("11Max");
		 s11Button2.addActionListener(this);
	
		 //Left Arm
		 //Servo 20 - Left Shoulder Pitch
		 s20Label = new JLabel("Servo 20 - Left Shoulder Pitch");
		 s20Label.setFont(labelFont);
		 s20Button0 = new JButton("Left Arm At Side - Rest");
		 s20Button0.setFont(buttonFont);
		 s20Button0.setHorizontalTextPosition(AbstractButton.CENTER);
		 s20Button0.setActionCommand("20Min");
		 s20Button0.addActionListener(this);
		 s20Button1 = new JButton("Left Arm Raised Forward");
		 s20Button1.setFont(buttonFont);
		 s20Button1.setHorizontalTextPosition(AbstractButton.CENTER);
		 s20Button1.setActionCommand("20Max");
		 s20Button1.addActionListener(this);
		
		 //Servo 21 - Left Shoulder Roll
		 s21Label = new JLabel("Servo 21 - Left Shoulder Roll");
		 s21Label.setFont(labelFont);
		 s21Button0 = new JButton("Left Arm At Side - Rest");
		 s21Button0.setFont(buttonFont);
		 s21Button0.setHorizontalTextPosition(AbstractButton.CENTER);
		 s21Button0.setActionCommand("21Rest");
		 s21Button0.addActionListener(this);
		 s21Button1 = new JButton("Left Arm Raised Out");
		 s21Button1.setFont(buttonFont);
		 s21Button1.setHorizontalTextPosition(AbstractButton.CENTER);
		 s21Button1.setActionCommand("21Max");
		 s21Button1.addActionListener(this);
		
		 //Servo 22 - Left Arm Yaw
		 s22Label = new JLabel("Servo 22 - Left Arm Yaw");
		 s22Label.setFont(labelFont);
		 s22Button0 = new JButton("Left Elbow Pointing Back");
		 s22Button0.setFont(buttonFont);
		 s22Button0.setHorizontalTextPosition(AbstractButton.CENTER);
		 s22Button0.setActionCommand("22Min");
		 s22Button0.addActionListener(this);
		 s22Button1 = new JButton("Left Elbow Pointing In - Rest");
		 s22Button1.setFont(buttonFont);
		 s22Button1.setHorizontalTextPosition(AbstractButton.CENTER);
		 s22Button1.setActionCommand("22Rest");
		 s22Button1.addActionListener(this);
		
		 //Servo 23 - Left Elbow Roll
		 s23Label = new JLabel("Servo 23 - Left Elbow Roll");
		 s23Label.setFont(labelFont);
		 s23Button0 = new JButton("Left Elbow Straight - Rest");
		 s23Button0.setFont(buttonFont);
		 s23Button0.setHorizontalTextPosition(AbstractButton.CENTER);
		 s23Button0.setActionCommand("23Rest");
		 s23Button0.addActionListener(this);
		 s23Button1 = new JButton("Left Elbow 90 Deg");
		 s23Button1.setFont(buttonFont);
		 s23Button1.setHorizontalTextPosition(AbstractButton.CENTER);
		 s23Button1.setActionCommand("23Max");
		 s23Button1.addActionListener(this);
		
		 //Servo 24 - Lfet Forearm Yaw
		 s24Label = new JLabel("Servo 24 - Left Forearm Yaw");
		 s24Label.setFont(labelFont);
		 s24Button0 = new JButton("Left Wrist In Line With Elbow - Rest");
		 s24Button0.setFont(buttonFont);
		 s24Button0.setHorizontalTextPosition(AbstractButton.CENTER);
		 s24Button0.setActionCommand("24Rest");
		 s24Button0.addActionListener(this);
		 s24Button1 = new JButton("Left Wrist Turned In");
		 s24Button1.setFont(buttonFont);
		 s24Button1.setHorizontalTextPosition(AbstractButton.CENTER);
		 s24Button1.setActionCommand("24Max");
		 s24Button1.addActionListener(this);
		
		 //Servo 25 - Left Wrist Roll
		 s25Label = new JLabel("Servo 25 - Left Wrist Roll");
		 s25Label.setFont(labelFont);
		 s25Button0 = new JButton("Left Wrist Back");
		 s25Button0.setFont(buttonFont);
		 s25Button0.setHorizontalTextPosition(AbstractButton.CENTER);
		 s25Button0.setActionCommand("25Min");
		 s25Button0.addActionListener(this);
		 s25Button1 = new JButton("Left Wrist Straight - Rest");
		 s25Button1.setFont(buttonFont);
		 s25Button1.setHorizontalTextPosition(AbstractButton.CENTER);
		 s25Button1.setActionCommand("25Rest");
		 s25Button1.addActionListener(this);
		 s25Button2 = new JButton("Left Wrist Forward");
		 s25Button2.setFont(buttonFont);
		 s25Button2.setHorizontalTextPosition(AbstractButton.CENTER);
		 s25Button2.setActionCommand("25Max");
		 s25Button2.addActionListener(this);
		
		 // Right Arm
		 //Servo 30 - Right Shoulder Pitch
		 s30Label = new JLabel("Servo 30 - Right Shoulder Pitch");
		 s30Label.setFont(labelFont);
		 s30Button0 = new JButton("Right Arm At Side - Rest");
		 s30Button0.setFont(buttonFont);
		 s30Button0.setHorizontalTextPosition(AbstractButton.CENTER);
		 s30Button0.setActionCommand("30Max");
		 s30Button0.addActionListener(this);
		 s30Button1 = new JButton("Right Arm Raised Forward");
		 s30Button1.setFont(buttonFont);
		 s30Button1.setHorizontalTextPosition(AbstractButton.CENTER);
		 s30Button1.setActionCommand("30Min");
		 s30Button1.addActionListener(this);
		
		 //Servo 31 - Right Shoulder Roll
		 s31Label = new JLabel("Servo 31 - Right Shoulder Roll");
		 s31Label.setFont(labelFont);
		 s31Button0 = new JButton("Right Arm At Side - Rest");
		 s31Button0.setFont(buttonFont);
		 s31Button0.setHorizontalTextPosition(AbstractButton.CENTER);
		 s31Button0.setActionCommand("31Max");
		 s31Button0.addActionListener(this);
		 s31Button1 = new JButton("Right Arm Raised Out");
		 s31Button1.setFont(buttonFont);
		 s31Button1.setHorizontalTextPosition(AbstractButton.CENTER);
		 s31Button1.setActionCommand("31Min");
		 s31Button1.addActionListener(this);
		
		 //Servo 32 - Right Arm Yaw
		 s32Label = new JLabel("Servo 32 - Right Arm Yaw");
		 s32Label.setFont(labelFont);
		 s32Button0 = new JButton("Right Arm Yaw Min");
		 s32Button0.setFont(buttonFont);
		 s32Button0.setHorizontalTextPosition(AbstractButton.CENTER);
		 s32Button0.setActionCommand("32Min");
		 s32Button0.addActionListener(this);
		 s32Button1 = new JButton("Right Arm Yaw Rest");
		 s32Button1.setFont(buttonFont);
		 s32Button1.setHorizontalTextPosition(AbstractButton.CENTER);
		 s32Button1.setActionCommand("32Rest");
		 s32Button1.addActionListener(this);
		 s32Button2 = new JButton("Right Arm Yaw Max");
		 s32Button2.setFont(buttonFont);
		 s32Button2.setHorizontalTextPosition(AbstractButton.CENTER);
		 s32Button2.setActionCommand("32Max");
		 s32Button2.addActionListener(this);
		
		 //Servo 33 - Right Elbow Roll
		 s33Label = new JLabel("Servo 33 - Right Elbow Roll");
		 s33Label.setFont(labelFont);
		 s33Button0 = new JButton("Right Elbow Straight - Rest");
		 s33Button0.setFont(buttonFont);
		 s33Button0.setHorizontalTextPosition(AbstractButton.CENTER);
		 s33Button0.setActionCommand("33Rest");
		 s33Button0.addActionListener(this);
		 s33Button1 = new JButton("Right Elbow 90 Deg");
		 s33Button1.setFont(buttonFont);
		 s33Button1.setHorizontalTextPosition(AbstractButton.CENTER);
		 s33Button1.setActionCommand("33Min");
		 s33Button1.addActionListener(this);
		
		 //Servo 34 - Right Forearm Yaw
		 s34Label = new JLabel("Servo 34 - Right Forearm Yaw");
		 s34Label.setFont(labelFont);
		 s34Button0 = new JButton("Right Wrist In Line With Elbow - Rest");
		 s34Button0.setFont(buttonFont);
		 s34Button0.setHorizontalTextPosition(AbstractButton.CENTER);
		 s34Button0.setActionCommand("34Rest");
		 s34Button0.addActionListener(this);
		 s34Button1 = new JButton("Right Wrist Turned In");
		 s34Button1.setFont(buttonFont);
		 s34Button1.setHorizontalTextPosition(AbstractButton.CENTER);
		 s34Button1.setActionCommand("34Min");
		 s34Button1.addActionListener(this);
		
		 //Servo 35 - Right Wrist Roll
		 s35Label = new JLabel("Servo 35 - Right Wrist Roll");
		 s35Label.setFont(labelFont);
		 s35Button0 = new JButton("Right Wrist Back");
		 s35Button0.setFont(buttonFont);
		 s35Button0.setHorizontalTextPosition(AbstractButton.CENTER);
		 s35Button0.setActionCommand("35Max");
		 s35Button0.addActionListener(this);
		 s35Button1 = new JButton("Right Wrist Straight - Rest");
		 s35Button1.setFont(buttonFont);
		 s35Button1.setHorizontalTextPosition(AbstractButton.CENTER);
		 s35Button1.setActionCommand("35Rest");
		 s35Button1.addActionListener(this);
		 s35Button2 = new JButton("Right Wrist Forward");
		 s35Button2.setFont(buttonFont);
		 s35Button2.setHorizontalTextPosition(AbstractButton.CENTER);
		 s35Button2.setActionCommand("35Min");
		 s35Button2.addActionListener(this);
		
		 //Create the HorizontalGroups in the layout
		 layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
						.addComponent(s10Button0)
						.addComponent(s11Button0)
						.addComponent(s20Button0)
						.addComponent(s21Button0)
						.addComponent(s22Button0)
						.addComponent(s23Button0)
						.addComponent(s24Button0)
						.addComponent(s25Button0)
						.addComponent(s30Button0)
						.addComponent(s31Button0)
						.addComponent(s32Button0)
						.addComponent(s33Button0)
						.addComponent(s34Button0)
						.addComponent(s35Button0))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
						.addComponent(s10Label)
						.addComponent(s10Button1)
						.addComponent(s11Label)
		                .addComponent(s11Button1)
						.addComponent(s20Label)
		                .addComponent(s20Button1)
						.addComponent(s21Label)
		                .addComponent(s21Button1)
						.addComponent(s22Label)
		                .addComponent(s22Button1)
						.addComponent(s23Label)
		                .addComponent(s23Button1)
						.addComponent(s24Label)
		                .addComponent(s24Button1)
						.addComponent(s25Label)
		                .addComponent(s25Button1)
						.addComponent(s30Label)
		                .addComponent(s30Button1)
						.addComponent(s31Label)
		                .addComponent(s31Button1)
						.addComponent(s32Label)
		                .addComponent(s32Button1)
						.addComponent(s33Label)
		                .addComponent(s33Button1)
						.addComponent(s34Label)
		                .addComponent(s34Button1)
						.addComponent(s35Label)
		                .addComponent(s35Button1))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
						.addComponent(s11Button2)
						.addComponent(s25Button2)
						.addComponent(s32Button2)
						.addComponent(s35Button2))
	        );

		//Create the VerticalGroups in the layout
		 layout.setVerticalGroup(layout.createSequentialGroup()
				 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
						 .addComponent(s10Label))
				 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						 .addComponent(s10Button0)
						 .addComponent(s10Button1))
				 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
						 .addComponent(s11Label))
				 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						 .addComponent(s11Button0)
						 .addComponent(s11Button1)
						 .addComponent(s11Button2))
				 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
						 .addComponent(s20Label))
				 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						 .addComponent(s20Button0)
						 .addComponent(s20Button1))
				 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
						 .addComponent(s21Label))
				 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						 .addComponent(s21Button0)
						 .addComponent(s21Button1))
				 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
						 .addComponent(s22Label))
				 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						 .addComponent(s22Button0)
						 .addComponent(s22Button1))
				 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
						 .addComponent(s23Label))
				 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						 .addComponent(s23Button0)
						 .addComponent(s23Button1))
				 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
						 .addComponent(s24Label))
				 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						 .addComponent(s24Button0)
						 .addComponent(s24Button1))
				 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
						 .addComponent(s25Label))
				 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						 .addComponent(s25Button0)
						 .addComponent(s25Button1)
						 .addComponent(s25Button2))
				 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
						 .addComponent(s30Label))
				 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						 .addComponent(s30Button0)
						 .addComponent(s30Button1))
				 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
						 .addComponent(s31Label))
				 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						 .addComponent(s31Button0)
						 .addComponent(s31Button1))
				 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
						 .addComponent(s32Label))
				 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						 .addComponent(s32Button0)
						 .addComponent(s32Button1)
						 .addComponent(s32Button2))
				 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
						 .addComponent(s33Label))
				 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						 .addComponent(s33Button0)
						 .addComponent(s33Button1))
				 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
						 .addComponent(s34Label))
				 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						 .addComponent(s34Button0)
						 .addComponent(s34Button1))
				 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
						 .addComponent(s35Label))
				 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						 .addComponent(s35Button0)
						 .addComponent(s35Button1)
						 .addComponent(s35Button2))
			   );    
		 
		 setTitle("Telebot Arm Servo Tester");
		 pack();
		 setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	//actionPerformed will examine the ActionCommand
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		 
		int servoID = Integer.parseInt(command.substring(0, 2));
		int value = 2048;
		if(command.substring(2, 5).equals("Max"))
			value = controller.getMax(servoID);
		else if(command.substring(2, 5).equals("Min"))
			value = controller.getMin(servoID);
		else if(command.substring(2, 5).equals("Res"))
			value = 2048;
		controller.newValue(value, servoID);
	}
	 	
	public static void main(String args[]) {
		new ServoTestGui().setVisible(true);
	}



}
