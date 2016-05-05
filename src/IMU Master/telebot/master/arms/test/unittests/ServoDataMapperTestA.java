package discoverylab.telebot.master.arms.test.unittests;

//ServoDataMapperTest2 class
//@author Curtis Cox
//This is a JUnit test class for the 
//servo position mapping routine 
//for Telebot'a arms and head.
//for FIU Discovery Lab Telebot - Arms

import junit.framework.TestCase;
import discoverylab.telebot.master.arms.*;


public class ServoDataMapperTestA extends TestCase {
	private TelebotMasterArmsTCPComponent controller;
	
	protected void setUp() throws Exception {
		super.setUp();
		controller = new TelebotMasterArmsTCPComponent(6666, null);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		controller = null;
	}
	
	public void testServoDataMapperElbowValid(){
		controller.generatePositions("left_elbow", 0, 0, 0);
		controller.generatePositions("left_elbow", 0, 15, 0);
		controller.generatePositions("left_elbow", 0, 30, 0);
		controller.generatePositions("left_elbow", 0, 45, 0);
		controller.generatePositions("left_elbow", 0, 60, 0);
		controller.generatePositions("left_elbow", 0, 75, 0);
		controller.generatePositions("left_elbow", 0, 90, 0);
	}
	
	public void testServoDataMapperElbowInvalid(){
		controller.generatePositions("left_elbow", 0, -1, 0);
		controller.generatePositions("left_elbow", 0, -90, 0);
		controller.generatePositions("left_elbow", 0, 91, 0);
		controller.generatePositions("left_elbow", 0, 179, 0);
	}
	
	public void testServoDataMapperShoulderValid(){
		controller.generatePositions("right_shoulder", 0, 0, 0);
		controller.generatePositions("right_shoulder", 0, 15, 0);
		controller.generatePositions("right_shoulder", 0, 30, 0);
		controller.generatePositions("right_shoulder", 0, 45, 0);
		controller.generatePositions("right_shoulder", 0, 60, 0);
		controller.generatePositions("right_shoulder", 0, 75, 0);
		controller.generatePositions("right_shoulder", 0, 90, 0);
	}
	
	public void testServoDataMapperShoulderInvalid(){
		controller.generatePositions("right_shoulder", 0, -1, 0);
		controller.generatePositions("right_shoulder", 0, -90, 0);
		controller.generatePositions("right_shoulder", 0, 91, 0);
		controller.generatePositions("right_shoulder", 0, 179, 0);
	}

}
