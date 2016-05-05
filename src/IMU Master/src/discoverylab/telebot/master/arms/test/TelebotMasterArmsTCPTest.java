package discoverylab.telebot.master.arms.test;

import static discoverylab.util.logging.LogUtils.*;
import TelebotDDSCore.Source.Java.Generated.master.arms.TMasterToArms;
import TelebotDDSCore.Source.Java.Generated.master.arms.TOPIC_MASTER_TO_SLAVE_ARMS;
import discoverylab.telebot.master.arms.TelebotMasterArmsTCPComponent;
import discoverylab.telebot.master.arms.gui.TelebotMasterArmsTCPController;
import discoverylab.telebot.master.arms.gui.TelebotMasterArmsTCPView;

public class TelebotMasterArmsTCPTest {

	public static String TAG = makeLogTag("TelebotMasterArmsTCPTest");
	
	public static void main(String args []) {
		
		TelebotMasterArmsTCPView view = new TelebotMasterArmsTCPView();
		TelebotMasterArmsTCPController controller = new TelebotMasterArmsTCPController(view);
		
		view.setVisible(true);
		
	}
}
