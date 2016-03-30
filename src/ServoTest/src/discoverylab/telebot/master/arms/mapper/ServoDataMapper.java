package discoverylab.telebot.master.arms.mapper;

import static discoverylab.util.logging.LogUtils.*;

public class ServoDataMapper //extends Mapper
{
	public static String TAG = makeLogTag(ServoDataMapper.class);
	
	//@Override
	public int constrain(int servo_val, int servo_max, int servo_min)
	{
		int pos = servo_val;

		if(servo_val <= servo_min)
		{
			pos = servo_min;
		}
		else if(servo_val >= servo_max)
		{
			pos = servo_max;
		}
		
		return pos;
	}
	
	public int process(int sensorAngle, double servoSensorRatio, int servoMax, int servoMin, boolean invert)
	{
		int mapped = 0;
		if(invert == true)
			mapped = (int)(servoMax - (sensorAngle*servoSensorRatio));
		else
			mapped = (int)((sensorAngle*servoSensorRatio) + servoMin); 
		
		int position = constrain(mapped, servoMax, servoMin);
		
		return position;
	}
	
	//processHead is used to map MocapStudio angle values to TeleBot servo values for the 
	//servos in TeleBot's neck. The angles are set as rotation amount from the rest position
	//of looking straight forward
	public int processHead(int sensorAngle, double servoSensorRatio, int servoMax, int servoMin, int servoRest, boolean invert)
	{
		int mapped = 0;
		if(invert == true)
			mapped = (int)(servoRest - (sensorAngle*servoSensorRatio));
		else
			mapped = (int)(servoRest + (sensorAngle*servoSensorRatio)); 
		
		int position = constrain(mapped, servoMax, servoMin);
		
		return position;
	}
}
