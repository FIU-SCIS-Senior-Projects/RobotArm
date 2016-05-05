package discoverylab.telebot.master.arms.test.unittests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.Socket;

import discoverylab.telebot.master.arms.TelebotMasterArmsTCPComponent;
import discoverylab.telebot.master.arms.gui.TelebotMasterArmsTCPController;
import discoverylab.telebot.master.arms.gui.TelebotMasterArmsTCPController.DataListener;
import discoverylab.telebot.master.arms.gui.TelebotMasterArmsTCPView;

import org.junit.BeforeClass;
import org.junit.Test;

import TelebotDDSCore.Source.Java.Generated.master.arms.TMasterToArms;
import TelebotDDSCore.Source.Java.Generated.master.arms.TOPIC_MASTER_TO_SLAVE_ARMS;

public class TelebotMasterArmsTCPComponentTest {
	
	static String portName = "127.0.0.1";
	static int dummyPort = 8888;
	
	String data = "head 30 60 -1";
	int servoID = 10;
	int servoPosition = 3600;
	int servoSpeed = 100;
	int[] jointPositions = {2081, 2434, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
	
	TelebotMasterArmsTCPComponent telebotMasterArms;
	TelebotMasterArmsTCPController controller;
	TelebotMasterArmsTCPView view;
	
	@BeforeClass
	public static void onceExecutedBeforeAll()
	{
		Socket dummyClient;
		
		try
		{
			dummyClient = new Socket(portName, dummyPort);
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
	
			
	public void activate()
	{
		
		controller = new TelebotMasterArmsTCPController(view);
		DataListener listener = controller.new DataListener();
		telebotMasterArms = new TelebotMasterArmsTCPComponent(listener, dummyPort);
		telebotMasterArms.initiate();
		telebotMasterArms.initiateTransmissionProtocol(TOPIC_MASTER_TO_SLAVE_ARMS.VALUE
				, TMasterToArms.class);
		telebotMasterArms.initiateDataWriter();
	}
	
	@Test
	public void testWriteServoData() 
	{
		activate();
		String instanceData = servoID + " " + servoPosition + " " + servoSpeed;
		assertEquals(instanceData, telebotMasterArms.writeServoData(servoID, servoPosition, servoSpeed));
		System.out.println("Test writeServoData()");
	}
	
	@Test
	public void testGeneratePositions() 
	{
		String jointType = "head";
		int x = 30;
		int y = 60;
		int z = -1;
		
		activate();
		
		telebotMasterArms.generatePositions(jointType, x, y, z);
		
		assertArrayEquals(jointPositions, telebotMasterArms.getJointPositions());
		System.out.println("Test generatePositions()");
	}
	
	@Test
	public void testCallback() 
	{
		activate();
		
		telebotMasterArms.callback(data);
		
		assertArrayEquals(jointPositions, telebotMasterArms.getJointPositions());
		System.out.println("Test callback()");
	}

}

