package TestingTools.ServoTest;
// @author Curtis Cox
// ServoTest console based app
// for FIU Discovery Lab Telebot Arm Servos

import java.io.*;

public class ServoTestApp {

	public static void main(String[] args){
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int servoID = 1;
		int value = 2048;
		ServoControl controller = ServoControl.getSingleton();
		while(servoID > 0)
		{
			System.out.println("Enter the servo ID of the servo you would like to move or 0 to quit.");
			try{
				servoID = Integer.parseInt(br.readLine());
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			if(servoID != 0){
				System.out.println("Enter new Servo Position.");
				try{
					value = Integer.parseInt(br.readLine());
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				controller.newValue(value, servoID);
			}
		}
	}
}
