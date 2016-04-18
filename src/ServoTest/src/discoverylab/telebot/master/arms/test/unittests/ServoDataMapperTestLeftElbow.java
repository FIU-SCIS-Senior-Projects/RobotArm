package discoverylab.telebot.master.arms.test.unittests;

//ServoDataMapperTest2 class
//@author Curtis Cox
//This is a JUnit test class for the 
//servo position mapping routine 
//for Telebot'a arms and head.
//for FIU Discovery Lab Telebot - Arms

import junit.framework.TestCase;
import TelebotDDSCore.Source.Java.Generated.master.arms.TMasterToArms;
import TelebotDDSCore.Source.Java.Generated.master.arms.TOPIC_MASTER_TO_SLAVE_ARMS;
import discoverylab.telebot.master.arms.*;


public class ServoDataMapperTestLeftElbow extends TestCase {
	private TelebotMasterArmsTCPComponent controller;
	
	protected void setUp() throws Exception {
		super.setUp();
		controller = new TelebotMasterArmsTCPComponent(6666);
		controller.initiate();
		controller.initiateTransmissionProtocol(TOPIC_MASTER_TO_SLAVE_ARMS.VALUE, TMasterToArms.class);
		controller.initiateDataWriter();
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
		controller.generatePositions("left_elbow", 0, 90, 0);
		controller.generatePositions("left_elbow", 0, -1, 0);
		controller.generatePositions("left_elbow", 0, 180, 0);
		controller.generatePositions("left_elbow", 0, -180, 0);
	}
	
	public void testServoDataMapperArmYawValid(){
		controller.generatePositions("left_elbow", 0, 0, 0);
		controller.generatePositions("left_elbow", 45, 0, 45);
		controller.generatePositions("left_elbow", 90, 0, 90);
		controller.generatePositions("left_elbow", 104, 0, 104);
	}
	
	public void testServoDataMapperArmYawInvalid(){
		controller.generatePositions("left_elbow", -1, 0, -1);
		controller.generatePositions("left_elbow", 105, 0, 105);
		controller.generatePositions("left_elbow", -36, 0, -36);
		controller.generatePositions("left_elbow", 180, 0, 180);
	}

}
