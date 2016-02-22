package TestingTools.ServoTest;
//ServoFeedBack class
//@author Curtis Cox
//ServoFeedback implements SerialPortEventListener
//for the Servo test suite
//for FIU Discovery Lab Telebot - Arms

import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
import java.util.HashMap;
//import TestingTools.ServoTest.ServoControl;

public class ServoFeedback implements SerialPortEventListener {

	private static ServoFeedback singleton = null;
	private SerialPort serialPort;
	private HashMap<Integer, Integer> currentPositions;
	private Integer[] servoIDList = {10, 11, 25, 35, 23, 33, 24, 34, 22, 32, 21, 31, 20, 30}; 
	
	private ServoFeedback()
	{
		currentPositions = new HashMap<Integer, Integer>();
		
		for(int i =0; i<14; i++)
			currentPositions.put(servoIDList[i], -1);
	}
	
	public void setSerialPort(SerialPort port)
	{
		serialPort = port;
	}
	
	public static ServoFeedback getSingleton()
	{
		if(singleton == null)
			singleton = new ServoFeedback();
		return singleton;
	}
	
	public int getFeedback(int servoID)
	{
		return currentPositions.get(servoID);
	}

	@Override
	public void serialEvent(SerialPortEvent arg0) {
		String feedBack = " ";
		while(feedBack != null)
		{
			try {
				feedBack = serialPort.readString(10);
				System.out.println(feedBack);
			} catch (SerialPortException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(feedBack.startsWith("<"))
			{
				int servoID = Integer.parseInt(feedBack.substring(1, 3));
				if(currentPositions.get(servoID) != null)
				{
					int position = Integer.parseInt(feedBack.substring(4, 8));
					if(position != currentPositions.get(servoID))
					{
						currentPositions.remove(servoID);
						currentPositions.put(servoID, position);
						System.out.println(position);
					}
				}
			}
			else //sync read to start of serial feedback message
			{
				for(int i = 0; i<10; i++)
				{
					if(feedBack.substring(i, i+1).equals(">"))
					{
						try {
							serialPort.readBytes((i+2)%10);
						} catch (SerialPortException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						i = 10;
					}
				}
			}
		}
		
	}
	
}
