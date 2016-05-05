package discoverylab.telebot.master.arms.test.unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import discoverylab.telebot.master.arms.TelebotMasterArmsTCPComponent;
import discoverylab.telebot.master.arms.gui.TelebotMasterArmsTCPController;
import discoverylab.telebot.master.arms.gui.TelebotMasterArmsTCPController.DataListener;
import discoverylab.telebot.master.arms.gui.TelebotMasterArmsTCPView;

public class InitiateTest {

	@Test
	public void testInitiate() 
	{
		TelebotMasterArmsTCPView view = new TelebotMasterArmsTCPView();
		TelebotMasterArmsTCPController controller = new TelebotMasterArmsTCPController(view);
		
		DataListener listener = controller.new DataListener();
		
		int portNumber = 6666;
		TelebotMasterArmsTCPComponent telebotMasterArms = new TelebotMasterArmsTCPComponent(listener, portNumber);
		
		telebotMasterArms.initiate();
		boolean serverLaunched = telebotMasterArms.serverLaunched();
		
		assertEquals(true, serverLaunched);
		System.out.println("Tested initiate()");

	}

}
