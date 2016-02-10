package TestingTools.ServoTest;
// PositionsModel class - Singelton 
// @author Curtis Cox
// PositionsModel is the model class for the Servo test suite
// for FIU Discovery Lab Telebot - Arms

import java.util.HashMap;
import discoverylab.telebot.master.arms.configurations.*;

public class PositionsModel{
	
	private static PositionsModel singleton = null;
	private HashMap<Integer, Integer> maximum;
	private HashMap<Integer, Integer> minimum;
	private HashMap<Integer, Integer> position;
	
	
	//Constructor is Private to force Singleton implementation
	private PositionsModel(){
		
		//Create HashMaps
		maximum = new HashMap<Integer, Integer>();
		minimum = new HashMap<Integer, Integer>();
		position = new HashMap<Integer, Integer>();
		
		//Populate maximum
		maximum.put(10, MasterArmsConfig.HEAD_PITCH_MAX);
		maximum.put(11, MasterArmsConfig.HEAD_YAW_MAX);
		maximum.put(20, MasterArmsConfig.ARM_PITCH_LEFT_MAX);
		maximum.put(21, MasterArmsConfig.ARM_ROLL_LEFT_MAX);
		maximum.put(22, MasterArmsConfig.ARM_YAW_LEFT_MAX);
		maximum.put(23, MasterArmsConfig.ELBOW_ROLL_LEFT_MAX);
		maximum.put(24, MasterArmsConfig.FOREARM_YAW_LEFT_MAX);
		maximum.put(25, MasterArmsConfig.WRIST_ROLL_LEFT_MAX);
		maximum.put(30, MasterArmsConfig.ARM_PITCH_RIGHT_MAX);
		maximum.put(31, MasterArmsConfig.ARM_ROLL_RIGHT_MAX);
		maximum.put(32, MasterArmsConfig.ELBOW_ROLL_RIGHT_MAX);
		maximum.put(33, MasterArmsConfig.ARM_YAW_RIGHT_MAX);
		maximum.put(34, MasterArmsConfig.FOREARM_YAW_RIGHT_MAX);
		maximum.put(35, MasterArmsConfig.WRIST_ROLL_RIGHT_MAX);
		
		//Populate minimum
		minimum.put(10, MasterArmsConfig.HEAD_PITCH_MIN);
		minimum.put(11, MasterArmsConfig.HEAD_YAW_MIN);
		minimum.put(20, MasterArmsConfig.ARM_PITCH_LEFT_MIN);
		minimum.put(21, MasterArmsConfig.ARM_ROLL_LEFT_MIN);
		minimum.put(22, MasterArmsConfig.ARM_YAW_LEFT_MIN);
		minimum.put(23, MasterArmsConfig.ELBOW_ROLL_LEFT_MIN);
		minimum.put(24, MasterArmsConfig.FOREARM_YAW_LEFT_MIN);
		minimum.put(25, MasterArmsConfig.WRIST_ROLL_LEFT_MIN);
		minimum.put(30, MasterArmsConfig.ARM_PITCH_RIGHT_MIN);
		minimum.put(31, MasterArmsConfig.ARM_ROLL_RIGHT_MIN);
		minimum.put(32, MasterArmsConfig.ELBOW_ROLL_RIGHT_MIN);
		minimum.put(33, MasterArmsConfig.ARM_YAW_RIGHT_MIN);
		minimum.put(34, MasterArmsConfig.FOREARM_YAW_RIGHT_MIN);
		minimum.put(35, MasterArmsConfig.WRIST_ROLL_RIGHT_MIN);
		
		//Populate position
		position.put(10, MasterArmsConfig.HEAD_PITCH_REST);
		position.put(11, MasterArmsConfig.HEAD_YAW_REST);
		position.put(20, MasterArmsConfig.ARM_PITCH_LEFT_REST);
		position.put(21, MasterArmsConfig.ARM_ROLL_LEFT_REST);
		position.put(22, MasterArmsConfig.ARM_YAW_LEFT_REST);
		position.put(23, MasterArmsConfig.ELBOW_ROLL_LEFT_REST);
		position.put(24, MasterArmsConfig.FOREARM_YAW_LEFT_REST);
		position.put(25, MasterArmsConfig.WRIST_ROLL_LEFT_REST);
		position.put(30, MasterArmsConfig.ARM_PITCH_RIGHT_REST);
		position.put(31, MasterArmsConfig.ARM_ROLL_RIGHT_REST);
		position.put(32, MasterArmsConfig.ELBOW_ROLL_RIGHT_REST);
		position.put(33, MasterArmsConfig.ARM_YAW_RIGHT_REST);
		position.put(34, MasterArmsConfig.FOREARM_YAW_RIGHT_REST);
		position.put(35, MasterArmsConfig.WRIST_ROLL_RIGHT_REST);
		
	}

	//getSingleton returns a reference to the singleton
	//PositionsModel instance
	public static PositionsModel getSingleton(){
		if(singleton == null)
			singleton = new PositionsModel();
		return singleton;
	}
	
	//getPosition returns the position of the given Servo
	public int getPosition(int servoID)
	{
		return position.get(servoID);
	}
	
	//validateValue checks that the desired value is
	//within the range of selected servo. If it is not
	//it replaces the value with the appropriate min or max
	private int validateValue(int value, int servoID)
	{
		int validValue = value;
		if(validValue < minimum.get(servoID))
			validValue = minimum.get(servoID);
		if(validValue > maximum.get(servoID))
			validValue = maximum.get(servoID);
		return validValue;
	}
	
	//recordValue stores the new position value for the servo
	//into the model
	private Boolean recordValue(int value, int servoID){
		int currentValue = position.get(servoID);
		if(value != currentValue)
		{
			position.replace(servoID, value);
		}
		return (position.get(servoID) == value);
	}
	
	public int setSevoValue(int value, int servoID){
		int finalValue = validateValue(value, servoID);
		recordValue(finalValue, servoID);
		
		return finalValue;
	}
	

	
}