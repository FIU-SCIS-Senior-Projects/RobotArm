package TestingTools.ServoTest;
// ServoControl class
// @author Curtis Cox
// ServoControl is the contoller class for the Servo test suite
// for FIU Discovery Lab Telebot - Arms

import TestingTools.ServoTest.PositionsModel;
import ThirdParty.jssc.SerialPort;



public class ServoControl {
	
	private static ServoControl singleton = null;
	private PositionsModel servoModel = null;
	
	//Private constructor to force use of getSingleton()
	private ServoControl()
	{
		servoModel = PositionsModel.getSingleton();
	}
	
	public static ServoControl getSingleton(){
		if(singleton == null)
			singleton = new ServoControl();
		return singleton;
	}
	
	private void setPosition(int value, int servoID)
	{
		
	}
	
	public int newValue (String value, int servoID)
	{
		int correctedValue = Integer.parseInt(value);
		correctedValue = servoModel.setSevoValue(correctedValue, servoID);
		setPosition(correctedValue, servoID);
		return correctedValue;
	}
}