package TestingTools.ServoTest;
//ServoTestGui class
//@author Curtis Cox
//ServoTestGui is the GUI class for the Servo test suite
//for FIU Discovery Lab Telebot - Arms

import javax.swing.JPanel;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ServoTestGui extends JPanel 
							implements ActionListener{
	protected JButton s10Button0, s10Button1, 
					s11Button0, s11Button1, s11Button2,
					s20Button0, s20Button1,
					s21Button0, s21Button1,
					s22Button0, s22Button1,
					s23Button0, s23Button1,
					s24Button0, s24Button1, s24Button2,
					s25Button0, s25Button1, s25Button2,
					s30Button0, s30Button1,
					s31Button0, s31Button1,
					s32Button0, s32Button1,
					s33Button0, s33Button1,
					s34Button0, s34Button1, s34Button2,
					s35Button0, s35Button1, s35Button2;
	
	public ServoTestGui(){
		s10Button0 = new JButton("Head Looking Down");
		s10Button0.setHorizontalTextPosition(AbstractButton.CENTER);
		s10Button0.setActionCommand("headDown");
		s10Button0.addActionListener(this);
		s10Button1 = new JButton("Head Looking Up");
		s10Button1.setHorizontalTextPosition(AbstractButton.CENTER);
		s10Button1.setActionCommand("headUp");
		s10Button1.addActionListener(this);
		
		s11Button0 = new JButton("Head Looking Right");
		s11Button0.setHorizontalTextPosition(AbstractButton.CENTER);
		s11Button0.setActionCommand("headRight");
		s11Button0.addActionListener(this);
		s11Button1 = new JButton("Head Looking Forward");
		s11Button1.setHorizontalTextPosition(AbstractButton.CENTER);
		s11Button1.setActionCommand("headForward");
		s11Button1.addActionListener(this);
		s11Button1 = new JButton("Head Looking Left");
		s11Button1.setHorizontalTextPosition(AbstractButton.CENTER);
		s11Button1.setActionCommand("headLeft");
		s11Button1.addActionListener(this);
	}
					

}
