package discoverylab.telebot.master.arms.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import TelebotDDSCore.Source.Java.Generated.master.arms.TMasterToArms;
import TelebotDDSCore.Source.Java.Generated.master.arms.TOPIC_MASTER_TO_SLAVE_ARMS;
import discoverylab.telebot.master.arms.TelebotMasterArmsTCPComponent;

public class TelebotMasterArmsTCPController 
{
	private TelebotMasterArmsTCPView view;
	public TelebotMasterArmsTCPComponent telebotMasterArms;
	
	public TelebotMasterArmsTCPController(TelebotMasterArmsTCPView view)
	{
		this.view = view;
		this.view.addConnectListener(new ConnectListener());
	}

	public class DataListener
	{
		public void changeText(String jointType, int x, int y, int z)
		{
			if(jointType.equals("head"))
			{
				view.setHeadText(x + " " + y + " " + z);
			}
			else if(jointType.equals("left_shoulder"))
			{
				view.setLeftShoulderText(x + " " + y + " " + z);
			}
			else if(jointType.equals("left_elbow"))
			{
				view.setLeftElbowText(x + " " + y + " " + z);
			}
			else if(jointType.equals("left_wrist"))
			{
				view.setLeftWristText(x + " " + y + " " + z);
			}
			else if(jointType.equals("right_shoulder"))
			{
				view.setRightShoulderText(x + " " + y + " " + z);
			}
			else if(jointType.equals("right_elbow"))
			{
				view.setRightElbowText(x + " " + y + " " + z);
			}
			else if(jointType.equals("right_wrist"))
			{
				view.setRightWristText(x + " " + y + " " + z);
			}
		}
	}
	
	
	class ConnectListener implements ActionListener
	{	
		public void actionPerformed(ActionEvent e)
		{
			DataListener listener = new DataListener();
		
			try
			{
				int portNumber = Integer.parseInt(view.getPortNumberText());
				
				telebotMasterArms = new TelebotMasterArmsTCPComponent(listener, portNumber);

				// 1. INITIATE Slave Component DEVICE
				telebotMasterArms.initiate();
					
				// 2. INITIATE Transmission PROTOCOL
				telebotMasterArms.initiateTransmissionProtocol(TOPIC_MASTER_TO_SLAVE_ARMS.VALUE
											, TMasterToArms.class);
									
				// 3. INITIATE DataWriter
				telebotMasterArms.initiateDataWriter();	
			}
			catch(NumberFormatException exception)
			{
				view.displayErrorMessage("Please enter a valid port number.");
			}
		}
	}
}

