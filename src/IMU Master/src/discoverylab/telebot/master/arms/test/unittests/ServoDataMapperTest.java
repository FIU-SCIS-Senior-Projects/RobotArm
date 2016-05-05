package discoverylab.telebot.master.arms.test.unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import discoverylab.telebot.master.arms.mapper.ServoDataMapper;

public class ServoDataMapperTest 
{
	ServoDataMapper servoDataMapper = new ServoDataMapper();
	
	int sensor_val = 30;
	int servo_val = 2081;
	int sensor_max = -62;
	int sensor_min = 36;
	int servo_max = 2600;
	int servo_min = 2048;
	
	@Test
	public void testConstrain() 
	{
		assertEquals(2081, servoDataMapper.constrain(servo_val, servo_max, servo_min));
		System.out.println("Tested constrain()");
	}
	
	/*public void testMap()
	{
		assertEquals(2081, servoDataMapper.map(sensor_val, sensor_max, sensor_min, servo_max, servo_min));
		System.out.println("Tested map()");
	}
	
	public void process()
	{
		assertEquals(2081, servoDataMapper.process(sensor_val, sensor_max, sensor_min, servo_max, servo_min));
		System.out.println("Tested process()");
	}*/

}
