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
		this.view.addDDSListener(new DDSListener());
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
		
		public void changeLabel()
		{
			view.setHeadText("no data");
			view.setLeftShoulderText("no data");
			view.setLeftElbowText("no data");
			view.setLeftWristText("no data");
			view.setRightShoulderText("no data");
			view.setRightElbowText("no data");
			view.setRightWristText("no data");
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
			}
			catch(NumberFormatException exception)
			{
				view.displayErrorMessage("Please enter a valid port number.");
			}
		}
	}
	
	class DDSListener implements ActionListener
	{	
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				if(telebotMasterArms.isConnected())
				{
					// 2. INITIATE Transmission PROTOCOL
					telebotMasterArms.initiateTransmissionProtocol(TOPIC_MASTER_TO_SLAVE_ARMS.VALUE
													, TMasterToArms.class);
											
					// 3. INITIATE DataWriter
					telebotMasterArms.initiateDataWriter();	
				}
				else
				{
					view.displayErrorMessage("Please connect to the Mocap System to the Publisher Program.");
				}

			}
			catch(Exception exception)
			{
				view.displayErrorMessage("Cannot launch Publisher. Please enter port number, Listen to Port, and "
						+ "connect the Mocap System to the Publisher Program.");
			}
		}
		
	}
}

