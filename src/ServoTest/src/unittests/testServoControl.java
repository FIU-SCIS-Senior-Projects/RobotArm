package unittests;
//testServoControl class
//@author Curtis Cox
//testServoControl is the JUnit class for the 
//ServoControl and PositionsModel classes 
//of the test suite for FIU Discovery Lab 
//Telebot - Arms

import TestingTools.ServoTest.ServoControl;
import TestingTools.ServoTest.PositionsModel;
import junit.framework.TestCase;
import discoverylab.telebot.master.arms.configurations.*;

public class testServoControl extends TestCase {
	
	private ServoControl controller;
	private PositionsModel model;
	
	protected void setUp() throws Exception {
		super.setUp();
		controller = ServoControl.getSingleton();
		model = PositionsModel.getSingleton();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		controller = null;
		model = null;
	}
	
	public void testServoControlConstruct(){
	
		assertNotNull(controller);
		assertEquals(true, controller.getSerialConnected());
		ServoControl controller2 = ServoControl.getSingleton();
		assertEquals(controller, controller2);
		controller2 = null;
	}
	
	public void testPositionsModel(){
		
		assertNotNull(model);
		PositionsModel model2 = PositionsModel.getSingleton();
		assertEquals(model, model2);
		model2 = null;
	}
	
	public void testNewValue(){
		
		controller.newValue(3000, 25);
		assertEquals(3000, model.getPosition(25));
		controller.newValue(5000, 25);
		assertEquals(MasterArmsConfig.WRIST_ROLL_LEFT_MAX, model.getPosition(25));
		controller.newValue(0, 25);
		assertEquals(MasterArmsConfig.WRIST_ROLL_LEFT_MIN, model.getPosition(25));
	}
	
	public void testGetPosition(){
		assertEquals(2048, model.getPosition(25));
	}
	
	public void testSetArmToRest(){
		controller.newValue(3000, 23);
		controller.newValue(3000, 25);
	}

}
