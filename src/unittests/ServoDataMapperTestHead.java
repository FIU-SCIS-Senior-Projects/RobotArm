package discoverylab.telebot.master.arms.test.unittests;

//ServoDataMapperTestHead class
//@author Curtis Cox
//This is a JUnit test class for the 
//servo position mapping routine 
//for Telebot'a arms and head.
//for FIU Discovery Lab Telebot - Arms

import junit.framework.TestCase;
import discoverylab.telebot.master.arms.*;


public class ServoDataMapperTestHead extends TestCase {
	private TelebotMasterArmsTCPComponent component;

	
	protected void setUp() throws Exception {
		super.setUp();
		component = new TelebotMasterArmsTCPComponent(6666);
		//component.initiateDataWriter();

	}

	protected void tearDown() throws Exception {
		super.tearDown();
		component = null;

	}
	
	public void testServoDataMapperHeadYawValid(){
		component.generatePositions("head", 0, 0, 0);
		component.generatePositions("head", 0, 15, 0);
		component.generatePositions("head", 0, 30, 0);
		component.generatePositions("head", 0, 45, 0);
		component.generatePositions("head", 0, -15, 0);
		component.generatePositions("head", 0, -30, 0);
		component.generatePositions("head", 0, -45, 0);
	}
	
	public void testServoDataMapperHeadYawInvalid(){
		component.generatePositions("head", 0, 50, 0);
		component.generatePositions("head", 0, -50, 0);
		component.generatePositions("head", 0, 180, 0);
		component.generatePositions("head", 0, -180, 0);
	}
	
	public void testServoDataMapperHeadTiltValid(){
		component.generatePositions("head", 0, 0, 0);
		component.generatePositions("head", 15, 0, 0);
		component.generatePositions("head", 17, 0, 0);
		component.generatePositions("head", -15, 0, 0);
		component.generatePositions("head", -30, 0, 0);
		component.generatePositions("head", -35, 0, 0);
	}
	
	public void testServoDataMapperHeadTiltInvalid(){
		component.generatePositions("head", 18, 0, 0);
		component.generatePositions("head", 90, 0, 0);
		component.generatePositions("head", -36, 0, 0);
		component.generatePositions("head", -180, 0, 0);
	}

}
