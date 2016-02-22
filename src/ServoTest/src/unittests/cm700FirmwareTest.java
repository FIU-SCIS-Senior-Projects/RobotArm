package unittests;

import junit.framework.TestCase;
import TestingTools.ServoTest.ServoControl;
import TestingTools.ServoTest.ServoFeedback;
//import TestingTools.ServoTest.PositionsModel;
//import discoverylab.telebot.master.arms.configurations.*;

public class cm700FirmwareTest extends TestCase {

	private ServoControl controller;
	private ServoFeedback feedBack;
	
	protected void setUp() throws Exception {
		super.setUp();
		controller = ServoControl.getSingleton();
		feedBack = ServoFeedback.getSingleton();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		controller = null;
		feedBack = null;
	}
	
	public void testcm700FirmwareFeedback(){
		
		//assertNotNull(controller);
		//assertEquals(true, controller.getSerialConnected());
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
		assertEquals(500, feedBack.getFeedback(10));
	}

}
