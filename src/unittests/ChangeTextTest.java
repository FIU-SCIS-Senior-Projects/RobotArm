package discoverylab.telebot.master.arms.test.unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import discoverylab.telebot.master.arms.gui.TelebotMasterArmsTCPController;
import discoverylab.telebot.master.arms.gui.TelebotMasterArmsTCPController.DataListener;
import discoverylab.telebot.master.arms.gui.TelebotMasterArmsTCPView;

public class ChangeTextTest 
{
	
	@Test
	public void testChangeText() 
	{
		String jointType = "head";
		int x = 30;
		int y = 60;
		int z = -1;
		
		TelebotMasterArmsTCPView view = new TelebotMasterArmsTCPView();
		TelebotMasterArmsTCPController controller = new TelebotMasterArmsTCPController(view);
		DataListener listener = controller.new DataListener();
		
		listener.changeText(jointType, x, y, z);
		String displayedText = x + " " + y + " " + z;
		assertEquals(view.getHeadText(), displayedText);
		System.out.println("Tested changeText()");
	}

}
