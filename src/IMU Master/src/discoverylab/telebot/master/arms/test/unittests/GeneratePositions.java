package discoverylab.telebot.master.arms.test.unittests;

import static org.junit.Assert.*;

import discoverylab.telebot.master.arms.TelebotMasterArmsTCPComponent;
import discoverylab.telebot.master.arms.gui.TelebotMasterArmsTCPController.DataListener;
import TelebotDDSCore.Source.Java.Generated.master.arms.TMasterToArms;
import TelebotDDSCore.Source.Java.Generated.master.arms.TOPIC_MASTER_TO_SLAVE_ARMS;

import org.junit.Test;

public class GeneratePositions {
	private DataListener listener;
	int portNumber = 6666;
	
	TelebotMasterArmsTCPComponent telebotMasterArms = new TelebotMasterArmsTCPComponent(listener, portNumber);
	@Test
	public void generatePositionsTest() {
		String jointType = "null";
		int x = -1;
		int y = -1;
		int z = -1;
		
		telebotMasterArms.initiate();
		telebotMasterArms.initiateTransmissionProtocol(TOPIC_MASTER_TO_SLAVE_ARMS.VALUE
				, TMasterToArms.class);
		telebotMasterArms.initiateDataWriter();
		telebotMasterArms.generatePositions(jointType, x, y, z);
	}

}
