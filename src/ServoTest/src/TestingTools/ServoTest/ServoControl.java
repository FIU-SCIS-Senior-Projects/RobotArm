package TestingTools.ServoTest;
// ServoControl class
// @author Curtis Cox
// ServoControl is the contoller class for the Servo test suite
// for FIU Discovery Lab Telebot - Arms

import TestingTools.ServoTest.PositionsModel;
import jssc.SerialPort;
import jssc.SerialPortException;




public class ServoControl {
	
	private static ServoControl singleton = null;
	private PositionsModel servoModel = null;
	private SerialPort serialPort;
	private Boolean serialConnected 				= false;
	private String serialPortName;
	private Integer baudRate;
	private Integer dataBits;
	private Integer stopBits; 
	private Integer parityType;
	private Integer eventMask;
	
	//Private constructor to force use of getSingleton()
	private ServoControl()
	{
		servoModel = PositionsModel.getSingleton();
		serialPortName = "/dev/ttyUSB0";
		baudRate = 57600;
		dataBits = SerialPort.DATABITS_8;
		stopBits = SerialPort.STOPBITS_1;
		parityType = SerialPort.PARITY_NONE;
		eventMask = SerialPort.MASK_RXCHAR;
		
		serialPort = new SerialPort(serialPortName);
		if(initiate())
			serialConnected = true;
		
	}
	
	public static ServoControl getSingleton(){
		if(singleton == null)
			singleton = new ServoControl();
		return singleton;
	}
	
	/**
	 * Slave Hands Initiate - Open Hand Serial Connection
	 * @return
	 */
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
	

	
	private void setPosition(int value, int servoID)
	{
		if(serialConnected){
			try{
			String commandString = servoID + " " + value + " 50\r"; //50 = servoSpeed
			System.out.println(commandString);
			serialPort.writeString(commandString);
			}
			catch (SerialPortException e){ 
				e.printStackTrace();
			}
		}
		else
			System.out.println("Cannot set new Position. Serial port not open.\n");
	}
	
	public int newValue (int value, int servoID)
	{
		int correctedValue = value;
		correctedValue = servoModel.setSevoValue(correctedValue, servoID);
		setPosition(correctedValue, servoID);
		return correctedValue;
	}
}