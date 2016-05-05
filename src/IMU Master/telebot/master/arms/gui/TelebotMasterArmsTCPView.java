package discoverylab.telebot.master.arms.gui;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelebotMasterArmsTCPView extends JFrame 
{
	private JLabel headLabel = new JLabel("Head: ");
	private JLabel leftShoulderLabel = new JLabel("Left Shoulder: ");
	private JLabel leftElbowLabel = new JLabel("Left Elbow: ");
	private JLabel leftWristLabel = new JLabel("Left Wrist: ");
	private JLabel rightShoulderLabel = new JLabel("Right Shoulder: ");
	private JLabel rightElbowLabel = new JLabel("Right Elbow: ");
	private JLabel rightWristLabel = new JLabel("Right Wrist: ");
	
	private JTextField headText = new JTextField("no data");
	private JTextField leftShoulderText = new JTextField("no data", 1);
	private JTextField leftElbowText = new JTextField("no data", 1);
	private JTextField leftWristText = new JTextField("no data", 1);
	private JTextField rightShoulderText = new JTextField("no data", 1);
	private JTextField rightElbowText = new JTextField("no data", 1);
	private JTextField rightWristText = new JTextField("no data", 1);
	
	private JLabel portNumberLabel = new JLabel("Port Number: ");
	private JTextField portNumberText = new JTextField("enter port");
	private JButton listenButton = new JButton("Listen");

	public TelebotMasterArmsTCPView()
	{
		JPanel viewPanel = new JPanel(new GridLayout(9, 4, 10, 50));
		viewPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		this.setTitle("IMU Control System");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 700);
	
		viewPanel.add(headLabel);
		viewPanel.add(headText);
		viewPanel.add(leftShoulderLabel);
		viewPanel.add(leftShoulderText);
		viewPanel.add(leftElbowLabel);
		viewPanel.add(leftElbowText);
		viewPanel.add(leftWristLabel);
		viewPanel.add(leftWristText);
		viewPanel.add(rightShoulderLabel);
		viewPanel.add(rightShoulderText);
		viewPanel.add(rightElbowLabel);
		viewPanel.add(rightElbowText);
		viewPanel.add(rightWristLabel);
		viewPanel.add(rightWristText);
		viewPanel.add(portNumberLabel);
		viewPanel.add(portNumberText);
		viewPanel.add(listenButton);
		this.add(viewPanel);
	}
	
	public String getPortNumberText() {
		return portNumberText.getText();
	}
	
	public String getHeadText() {
		return headText.getText();
	}

	public String getLeftShoulderText() {
		return leftShoulderText.getText();
	}

	public String getLeftElbowText() {
		return leftElbowText.getText();
	}

	public String getLeftWristText() {
		return leftWristText.getText();
	}

	public String getRightShoulderText() {
		return rightShoulderText.getText();
	}

	public String getRightElbowText() {
		return rightElbowText.getText();
	}

	public String getRightWristText() {
		return rightWristText.getText();
	}

	public void setPortNumberText(String text)
	{
		portNumberText.setText(text);
	}
	
	public void setHeadText(String text)
	{
		headText.setText(text);
	}
	
	public void setLeftShoulderText(String text)
	{
		leftShoulderText.setText(text);
	}
	
	public void setLeftElbowText(String text)
	{
		leftElbowText.setText(text);
	}
	
	public void setLeftWristText(String text)
	{
		leftWristText.setText(text);
	}
	
	public void setRightShoulderText(String text)
	{
		rightShoulderText.setText(text);
	}
	
	public void setRightElbowText(String text)
	{
		rightElbowText.setText(text);
	}
	
	public void setRightWristText(String text)
	{
		rightWristText.setText(text);
	}
	
	void addConnectListener(ActionListener e)
	{
		listenButton.addActionListener(e);
	}
	
	void displayErrorMessage(String error)
	{
		JOptionPane.showMessageDialog(this, error);
	}
}
