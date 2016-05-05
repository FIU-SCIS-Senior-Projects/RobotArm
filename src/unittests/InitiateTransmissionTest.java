package discoverylab.telebot.master.arms.test.unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import TelebotDDSCore.Source.Java.Generated.master.arms.TMasterToArms;
import TelebotDDSCore.Source.Java.Generated.master.arms.TOPIC_MASTER_TO_SLAVE_ARMS;
import discoverylab.telebot.master.arms.TelebotMasterArmsTCPComponent;
import discoverylab.telebot.master.arms.gui.TelebotMasterArmsTCPController;
import discoverylab.telebot.master.arms.gui.TelebotMasterArmsTCPView;
import discoverylab.telebot.master.arms.gui.TelebotMasterArmsTCPController.DataListener;

public class InitiateTransmissionTest {
	
	TelebotMasterArmsTCPView view = new TelebotMasterArmsTCPView();
	TelebotMasterArmsTCPController controller = new TelebotMasterArmsTCPController(view);
	
	DataListener listener = controller.new DataListener();
	
	int portNumber = 6666;
	
	@Test
	public void initiateTransmission() 
	{
		TelebotMasterArmsTCPComponent telebotMasterArms = new TelebotMasterArmsTCPComponent(listener, portNumber);
		
		boolean ddsActivated = telebotMasterArms.initiateTransmissionProtocol(TOPIC_MASTER_TO_SLAVE_ARMS.VALUE
				, TMasterToArms.class);
		
		assertNotEquals(false, ddsActivated);
		System.out.println("Tested initiateTransmission()");
	}

}
