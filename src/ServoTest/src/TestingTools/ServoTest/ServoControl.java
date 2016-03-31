package TestingTools.ServoTest;
// ServoControl class
// @author Curtis Cox
// ServoControl is the controller class for the Servo test suite
// for FIU Discovery Lab Telebot - Arms

import TestingTools.ServoTest.PositionsModel;
import TestingTools.ServoTest.ServoFeedback;
import discoverylab.telebot.master.arms.configurations.MasterArmsConfig;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
import java.awt.event.ActionEvent;


public class ServoControl implements SerialPortEventListener {
	
	private static ServoControl singleton = null;
	private PositionsModel servoModel = null;
	private ServoFeedback feedBack = null;
	private ServoFeedbackTestGui gui = null;
	private SerialPort serialPort;
	private Boolean serialConnected = false;
	private String serialPortName;
	private Integer baudRate;
	private Integer dataBits;
	private Integer stopBits; 
	private Integer parityType;
	private Integer eventMask;
	private Integer[] servoIDList = {10, 11, 25, 35, 23, 33, 24, 34, 22, 32, 21, 31, 20, 30};
	//servoIDList is ordered to reduce risk of the robot arm hitting the
	//robot body while the servos are being initialized when the class
	//singleton is instantiated
	
	//Private constructor to force use of getSingleton()
	private ServoControl()
	{
		servoModel = PositionsModel.getSingleton();
		feedBack = ServoFeedback.getSingleton();
		
		//Serial Port init
		serialPortName = "Com8"; //"/dev/TelebotArms";
		baudRate = 57600;
		dataBits = SerialPort.DATABITS_8;
		stopBits = SerialPort.STOPBITS_1;
		parityType = SerialPort.PARITY_NONE;
		eventMask = SerialPort.MASK_RXCHAR;
		
		serialPort = new SerialPort(serialPortName);
		if(initiate())
			serialConnected = true;
		
		feedBack.setSerialPort(serialPort);
		try {
			serialPort.addEventListener(this, eventMask);
		} catch (SerialPortException e) {
			e.printStackTrace();
		}
	
		//Set all servos to their starting position
		for(int i=0; i < servoIDList.length; i++){
			setPosition(servoModel.getPosition(servoIDList[i]), servoIDList[i]);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static ServoControl getSingleton(){
		if(singleton == null)
			singleton = new ServoControl();
		return singleton;
	}
	
	//This method was copied from:
	/* Discovery Lab github Telebot files
	 * CoreSlaveComponent.java
	 * @author Irvin Steve Cardenas
	 */
	//To ensure that for testing the serial port is opened 
	//in the same manner as it is opened in practice
	@SuppressWarnings("finally")
	public boolean initiate(){
		try {
			serialPort.openPort();
			serialPort.setParams(baudRate
						, dataBits
						, stopBits
						, parityType);
				
			serialPort.setEventsMask(eventMask);
		} catch (SerialPortException e) {
			System.out.printf("Error opening SerialPort: " + serialPortName  + " with Baudrate: " + baudRate);
			e.printStackTrace();
		}
		finally{
			return serialPort.isOpened();
		}
	}
	
	public boolean getSerialConnected(){
		return serialConnected;
	}
	
	//setArmToRest will check which arm the selected servo
	//is in. It then checks the other servos in that arm in
	//an order designed to prevent the robot arm from hitting
	//robot body. If the other servo is not in it's rest position
	//it will be set to it's rest position before moving on 
	//to the next servo.
	private void setArmToRest(int servoID)
	{
		//Check if servo is in left arm
		if((servoID >= 20) && (servoID <= 25))
		{
			//Check that other servos in left arm at rest
			//If not, set them to rest pausing to allow arm
			//to move. Move order: 1-Wrist roll 2-Elbow roll 3-Forearm yaw 
			//4-Arm yaw 5-Arm roll 6-Arm pitch
			if(servoID != 25)//Wrist roll
				if(servoModel.getPosition(25) != MasterArmsConfig.WRIST_ROLL_LEFT_REST)
				{ 
					setPosition(servoModel.setSevoValue(MasterArmsConfig.WRIST_ROLL_LEFT_REST, 25), 25);
					try{
						Thread.sleep(2000);
					}
					catch(InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				}
			if(servoID != 23)//Elbow roll
				if(servoModel.getPosition(23) != MasterArmsConfig.ELBOW_ROLL_LEFT_REST){
					setPosition(servoModel.setSevoValue(MasterArmsConfig.ELBOW_ROLL_LEFT_REST, 23), 23);			
					try{
						Thread.sleep(2000);
					}
					catch(InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				}
			if(servoID != 24)//Forearm yaw
				if(servoModel.getPosition(24) != MasterArmsConfig.FOREARM_YAW_LEFT_REST){
					setPosition(servoModel.setSevoValue(MasterArmsConfig.FOREARM_YAW_LEFT_REST, 24), 24);			
					try{
						Thread.sleep(2000);
					}
					catch(InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				}
			if(servoID != 22)//Arm yaw
				if(servoModel.getPosition(22) != MasterArmsConfig.ARM_YAW_LEFT_REST){
					setPosition(servoModel.setSevoValue(MasterArmsConfig.ARM_YAW_LEFT_REST, 22), 22);			
					try{
						Thread.sleep(2000);
					}
					catch(InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				}
			if(servoID != 21)//Arm roll
				if(servoModel.getPosition(21) != MasterArmsConfig.ARM_ROLL_LEFT_REST){
					setPosition(servoModel.setSevoValue(MasterArmsConfig.ARM_ROLL_LEFT_REST, 21), 21);			
					try{
						Thread.sleep(2000);
					}
					catch(InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				}
			if(servoID != 20)//Arm pitch
				if(servoModel.getPosition(20) != MasterArmsConfig.ARM_PITCH_LEFT_REST){
					setPosition(servoModel.setSevoValue(MasterArmsConfig.ARM_PITCH_LEFT_REST, 20), 20);			
					try{
						Thread.sleep(2000);
					}
					catch(InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				}
		}
		//Check if servo is in right arm
		else if((servoID >= 30) && (servoID <= 35))
		{
			//Check that other servos in right arm at rest
			//If not, set them to rest pausing to allow arm
			//to move. Move order: 1-Wrist roll 2-Elbow roll 3-Forearm yaw 
			//4-Arm yaw 5-Arm roll 6-Arm pitch
			if(servoID != 35)//Wrist roll
				if(servoModel.getPosition(35) != MasterArmsConfig.WRIST_ROLL_RIGHT_REST)
				{ 
					setPosition(servoModel.setSevoValue(MasterArmsConfig.WRIST_ROLL_RIGHT_REST, 35), 35);
					try{
						Thread.sleep(2000);
					}
					catch(InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				}
			if(servoID != 33)//Elbow roll
				if(servoModel.getPosition(33) != MasterArmsConfig.ELBOW_ROLL_RIGHT_REST){
					setPosition(servoModel.setSevoValue(MasterArmsConfig.ELBOW_ROLL_RIGHT_REST, 33), 33);			
					try{
						Thread.sleep(2000);
					}
					catch(InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				}
			if(servoID != 34)//Forearm yaw
				if(servoModel.getPosition(34) != MasterArmsConfig.FOREARM_YAW_RIGHT_REST){
					setPosition(servoModel.setSevoValue(MasterArmsConfig.FOREARM_YAW_RIGHT_REST, 34), 34);			
					try{
						Thread.sleep(2000);
					}
					catch(InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				}
			if(servoID != 32)//Arm yaw
				if(servoModel.getPosition(32) != MasterArmsConfig.ARM_YAW_RIGHT_REST){
					setPosition(servoModel.setSevoValue(MasterArmsConfig.ARM_YAW_RIGHT_REST, 32), 32);			
					try{
						Thread.sleep(2000);
					}
					catch(InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				}
			if(servoID != 31)//Arm roll
				if(servoModel.getPosition(31) != MasterArmsConfig.ARM_ROLL_RIGHT_REST){
					setPosition(servoModel.setSevoValue(MasterArmsConfig.ARM_ROLL_RIGHT_REST, 31), 31);			
					try{
						Thread.sleep(2000);
					}
					catch(InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				}
			if(servoID != 30)//Arm pitch
				if(servoModel.getPosition(30) != MasterArmsConfig.ARM_PITCH_RIGHT_REST){
					setPosition(servoModel.setSevoValue(MasterArmsConfig.ARM_PITCH_RIGHT_REST, 30), 30);			
					try{
						Thread.sleep(2000);
					}
					catch(InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				}		
		}
	}
	
	//setPosition prepares the command string to send to
	//serial port to be sent to the CM-700 servo control board
	private void setPosition(int value, int servoID)
	{
		if(serialConnected){
			try{
			String commandString = "<" + servoID + " " + value + " 150>?"; //50 servoSpeed
			System.out.println(commandString);
			serialPort.writeString(commandString);
			}
			catch (SerialPortException e){ 
				e.printStackTrace();
			}
		}
		else
			System.out.println("Cannot set new Position. Serial port not open.\n");
		if(gui != null)
			refreshFeedback();
	}
	
	//newValue takes a servo position value and servoID
	//It will call setArmToRest to prepare to move the
	//selected servo. It then updates the model by 
	//calling setServoValue. If value is outside of
	//the valid range for servoID, setServoValue will
	//return the appropriately corrected value. This
	//new value will then be sent to the servo by
	//calling setPosition. The corrected value is 
	//returned to the calling method.
	public int newValue (int value, int servoID)
	{
		int correctedValue = value;
		setArmToRest(servoID);
		correctedValue = servoModel.setSevoValue(correctedValue, servoID);
		setPosition(correctedValue, servoID);
		return correctedValue;
	}
	
	private void refreshFeedback()
	{
		try {
			serialPort.writeByte((byte)'?');
		} catch (SerialPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int servoID;
		int currentValue;
		int requestedValue;
		for(int i = 0; i<14; i++)
		{
			servoID = servoIDList[i];
			currentValue = feedBack.getFeedback(servoID);
			requestedValue = servoModel.getPosition(servoID); 
			gui.refreshView(servoID, requestedValue, currentValue);
            ActionEvent e = new ActionEvent(gui, 2345, "00 Paint");
			gui.actionPerformed(e);
		}
	}
	
	public void setGui(ServoFeedbackTestGui gui)
	{
		this.gui = gui;
	}
	
	public int getRest(int servoID)
	{
		return servoModel.getRest(servoID);
	}
	
	public int getMax(int servoID)
	{
		return servoModel.getMax(servoID);
	}
	
	public int getMin(int servoID)
	{
		return servoModel.getMin(servoID);
	}

	@Override
	public void serialEvent(SerialPortEvent arg0) {
		feedBack.readSerialData();
		if(gui != null)
			refreshFeedback();
	}
	
}