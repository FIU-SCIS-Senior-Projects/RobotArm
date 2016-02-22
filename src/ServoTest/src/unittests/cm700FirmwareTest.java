package unittests;
//cm700FirmwareTest class
//@author Curtis Cox
//This is a JUnit test class for the 
//servo position feedback routine in
//the firmware for CM-700 servo controller
//for Telebot'a arms and head, as well as
//the ServoFeedback class. It is part 
//of the Servo test suite
//for FIU Discovery Lab Telebot - Arms

import junit.framework.TestCase;
import TestingTools.ServoTest.ServoControl;
import TestingTools.ServoTest.ServoFeedback;

public class cm700FirmwareTest extends TestCase {

	private ServoControl controller;
	private ServoFeedback feedback;
	
	protected void setUp() throws Exception {
		super.setUp();
		controller = ServoControl.getSingleton();
		feedback = ServoFeedback.getSingleton();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		controller = null;
		feedback = null;
	}
	
	public void testcm700FirmwareFeedback(){
		
				controller.newValue(500, 10);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		controller.newValue(0, 11);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(500, feedback.getFeedback(10));
	}
	
	public void testServoFeedbackGetSingleton()
	{
		ServoFeedback feedback2 = ServoFeedback.getSingleton();
		assertEquals(feedback, feedback2);
		feedback2 = null;
	}

}
