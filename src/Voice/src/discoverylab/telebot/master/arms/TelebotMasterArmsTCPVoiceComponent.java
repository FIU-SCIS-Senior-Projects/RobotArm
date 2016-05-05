package discoverylab.telebot.master.arms;

import static discoverylab.util.logging.LogUtils.*;
import discoverylab.telebot.master.arms.configurations.MasterArmsVoiceConfig;

import com.rti.dds.infrastructure.InstanceHandle_t;
import TelebotDDSCore.Source.Java.Generated.master.arms.TMasterToArms;
import TelebotDDSCore.Source.Java.Generated.master.arms.TMasterToArmsDataWriter;
import discoverylab.telebot.master.core.component.CoreMasterTCPComponent;
import discoverylab.telebot.master.core.socket.CoreServerSocket;


public class TelebotMasterArmsTCPVoiceComponent extends CoreMasterTCPComponent implements CoreServerSocket.SocketEventListener{
	
	public static String TAG = makeLogTag(TelebotMasterArmsTCPVoiceComponent.class);
	
	private int defaultSpeed = 100;
	
	private TMasterToArmsDataWriter writer;
	TMasterToArms instance = new TMasterToArms();
	InstanceHandle_t instance_handle = InstanceHandle_t.HANDLE_NIL;
	
	public TelebotMasterArmsTCPVoiceComponent(int portNumber) {
		super(portNumber);
	}
	
	/**
	 * Cast the Writer to our Arms DataWriter
	 * This allows us to publish the appropriate Topic data
	 */
	public void initiateDataWriter(){
		writer = (TMasterToArmsDataWriter) getDataWriter();
	}


	@Override
	public synchronized void callback(String data) { //try synchronized
		
		LOGI(TAG, "DATA: " + data );
		String command = data;
		
		if(command.equals("ST"))
		{
			instance.servoId = 10;
			instance.servoPositon = MasterArmsVoiceConfig.STOP_SERVO_10;
			instance.servoSpeed = defaultSpeed;
			writer.write(instance, instance_handle);
		
			instance.servoId = 11;
			instance.servoPositon = MasterArmsVoiceConfig.STOP_SERVO_11;
			instance.servoSpeed = defaultSpeed;
			writer.write(instance, instance_handle);
			
			instance.servoId = 30;
			instance.servoPositon = MasterArmsVoiceConfig.STOP_RIGHT_SERVO_30;
			instance.servoSpeed = defaultSpeed;
			writer.write(instance, instance_handle);
			
			instance.servoId = 31;
			instance.servoPositon = MasterArmsVoiceConfig.STOP_RIGHT_SERVO_31;
			instance.servoSpeed = defaultSpeed;
			writer.write(instance, instance_handle);
			
			instance.servoId = 32;
			instance.servoPositon = MasterArmsVoiceConfig.STOP_RIGHT_SERVO_32;
			instance.servoSpeed = defaultSpeed;
			writer.write(instance, instance_handle);
			
			instance.servoId = 33;
			instance.servoPositon = MasterArmsVoiceConfig.STOP_RIGHT_SERVO_33;
			instance.servoSpeed = defaultSpeed;
			writer.write(instance, instance_handle);
			
			instance.servoId = 34;
			instance.servoPositon = MasterArmsVoiceConfig.STOP_RIGHT_SERVO_34;
			instance.servoSpeed = defaultSpeed;
			writer.write(instance, instance_handle);
			
			instance.servoId = 35;
			instance.servoPositon = MasterArmsVoiceConfig.STOP_RIGHT_SERVO_35;
			instance.servoSpeed = defaultSpeed;
			writer.write(instance, instance_handle);
		}

		else if(command.equals("LS"))
		{
			instance.servoId = 10;
			instance.servoPositon = MasterArmsVoiceConfig.LASERS_SERVO_10;
			instance.servoSpeed = defaultSpeed;
			writer.write(instance, instance_handle);
			
			instance.servoId = 11;
			instance.servoPositon = MasterArmsVoiceConfig.LASERS_SERVO_11;
			instance.servoSpeed = defaultSpeed;
			writer.write(instance, instance_handle);
			
			instance.servoId = 20;
			instance.servoPositon = MasterArmsVoiceConfig.LASERS_LEFT_SERVO_20;
			instance.servoSpeed = defaultSpeed;
			writer.write(instance, instance_handle);
			
			instance.servoId = 21;
			instance.servoPositon = MasterArmsVoiceConfig.LASERS_LEFT_SERVO_21;
			instance.servoSpeed = defaultSpeed;
			writer.write(instance, instance_handle);
			
			instance.servoId = 22;
			instance.servoPositon = MasterArmsVoiceConfig.LASERS_LEFT_SERVO_22;
			instance.servoSpeed = defaultSpeed;
			writer.write(instance, instance_handle);
			
			instance.servoId = 23;
			instance.servoPositon = MasterArmsVoiceConfig.LASERS_LEFT_SERVO_23;
			instance.servoSpeed = defaultSpeed;
			writer.write(instance, instance_handle);
			
			instance.servoId = 24;
			instance.servoPositon = MasterArmsVoiceConfig.LASERS_LEFT_SERVO_24;
			instance.servoSpeed = defaultSpeed;
			writer.write(instance, instance_handle);
			
			instance.servoId = 25;
			instance.servoPositon = MasterArmsVoiceConfig.LASERS_LEFT_SERVO_25;
			instance.servoSpeed = defaultSpeed;
			writer.write(instance, instance_handle);
			
			instance.servoId = 30;
			instance.servoPositon = MasterArmsVoiceConfig.LASERS_RIGHT_SERVO_30;
			instance.servoSpeed = defaultSpeed;
			writer.write(instance, instance_handle);
			
			instance.servoId = 31;
			instance.servoPositon = MasterArmsVoiceConfig.LASERS_RIGHT_SERVO_31;
			instance.servoSpeed = defaultSpeed;
			writer.write(instance, instance_handle);
			
			instance.servoId = 32;
			instance.servoPositon = MasterArmsVoiceConfig.LASERS_RIGHT_SERVO_32;
			instance.servoSpeed = defaultSpeed;
			writer.write(instance, instance_handle);
			
			instance.servoId = 33;
			instance.servoPositon = MasterArmsVoiceConfig.LASERS_RIGHT_SERVO_33;
			instance.servoSpeed = defaultSpeed;
			writer.write(instance, instance_handle);
			
			instance.servoId = 34;
			instance.servoPositon = MasterArmsVoiceConfig.LASERS_RIGHT_SERVO_34;
			instance.servoSpeed = defaultSpeed;
			writer.write(instance, instance_handle);
			
			instance.servoId = 35;
			instance.servoPositon = MasterArmsVoiceConfig.LASERS_RIGHT_SERVO_35;
			instance.servoSpeed = defaultSpeed;
			writer.write(instance, instance_handle);
		}
			
		else if(command.equals("RT"))
		{
			instance.servoId = 10;
			instance.servoPositon = MasterArmsVoiceConfig.REST_SERVO_10;
			instance.servoSpeed = defaultSpeed;
			writer.write(instance, instance_handle);
			
			instance.servoId = 11;
			instance.servoPositon = MasterArmsVoiceConfig.REST_SERVO_11;
			instance.servoSpeed = defaultSpeed;
			writer.write(instance, instance_handle);
			
			instance.servoId = 20;
			instance.servoPositon = MasterArmsVoiceConfig.REST_LEFT_SERVO_20;
			instance.servoSpeed = defaultSpeed;
			writer.write(instance, instance_handle);
			
			instance.servoId = 21;
			instance.servoPositon = MasterArmsVoiceConfig.REST_LEFT_SERVO_21;
			instance.servoSpeed = defaultSpeed;
			writer.write(instance, instance_handle);
			
			instance.servoId = 22;
			instance.servoPositon = MasterArmsVoiceConfig.REST_LEFT_SERVO_22;
			instance.servoSpeed = defaultSpeed;
			writer.write(instance, instance_handle);
			
			instance.servoId = 23;
			instance.servoPositon = MasterArmsVoiceConfig.REST_LEFT_SERVO_23;
			instance.servoSpeed = defaultSpeed;
			writer.write(instance, instance_handle);
			
			instance.servoId = 24;
			instance.servoPositon = MasterArmsVoiceConfig.REST_LEFT_SERVO_24;
			instance.servoSpeed = defaultSpeed;
			writer.write(instance, instance_handle);
			
			instance.servoId = 25;
			instance.servoPositon = MasterArmsVoiceConfig.REST_LEFT_SERVO_25;
			instance.servoSpeed = defaultSpeed;
			writer.write(instance, instance_handle);
			
			instance.servoId = 30;
			instance.servoPositon = MasterArmsVoiceConfig.REST_RIGHT_SERVO_30;
			instance.servoSpeed = defaultSpeed;
			writer.write(instance, instance_handle);
			
			instance.servoId = 31;
			instance.servoPositon = MasterArmsVoiceConfig.REST_RIGHT_SERVO_31;
			instance.servoSpeed = defaultSpeed;
			writer.write(instance, instance_handle);
			
			instance.servoId = 32;
			instance.servoPositon = MasterArmsVoiceConfig.REST_RIGHT_SERVO_32;
			instance.servoSpeed = defaultSpeed;
			writer.write(instance, instance_handle);
			
			instance.servoId = 33;
			instance.servoPositon = MasterArmsVoiceConfig.REST_RIGHT_SERVO_33;
			instance.servoSpeed = defaultSpeed;
			writer.write(instance, instance_handle);
			
			instance.servoId = 34;
			instance.servoPositon = MasterArmsVoiceConfig.REST_RIGHT_SERVO_34;
			instance.servoSpeed = defaultSpeed;
			writer.write(instance, instance_handle);
			
			instance.servoId = 35;
			instance.servoPositon = MasterArmsVoiceConfig.REST_RIGHT_SERVO_35;
			instance.servoSpeed = defaultSpeed;
			writer.write(instance, instance_handle);		
		}
	}

	/**
	 * CallbackInterface
	 * @author Irvin Steve Cardenas
	 * 
	 * Callback interface to retrieve parsed Data Object
	 * Purpose: GUI or other components can implement this to receive a  YEIDataModel object object
	 *
	 */
	public interface CallbackInterface{
		public void callback(String data);
	}
}
