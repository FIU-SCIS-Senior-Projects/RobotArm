package discoverylab.telebot.master.arms;

import static discoverylab.util.logging.LogUtils.*;
import discoverylab.telebot.master.arms.configurations.MasterArmsConfig;
import discoverylab.telebot.master.arms.configurations.SensorConfig;
import discoverylab.telebot.master.arms.gui.TelebotMasterArmsTCPController;
import discoverylab.telebot.master.arms.gui.TelebotMasterArmsTCPController.DataListener;
import discoverylab.telebot.master.arms.gui.TelebotMasterArmsTCPView;
import discoverylab.telebot.master.arms.mapper.ServoDataMapper;
import com.rti.dds.infrastructure.InstanceHandle_t;
import TelebotDDSCore.Source.Java.Generated.master.arms.TMasterToArms;
import TelebotDDSCore.Source.Java.Generated.master.arms.TMasterToArmsDataWriter;
import discoverylab.telebot.master.arms.model.YEIDataModel;
import discoverylab.telebot.master.arms.parser.YEIDataParser;
import discoverylab.telebot.master.core.component.CoreMasterTCPComponent;
import discoverylab.telebot.master.core.socket.CoreServerSocket;


public class TelebotMasterArmsTCPComponent extends CoreMasterTCPComponent implements CoreServerSocket.SocketEventListener{
	
	public static String TAG = makeLogTag(TelebotMasterArmsTCPComponent.class);
	
	private YEIDataParser parser;
	private ServoDataMapper mapper;
	
	private int defaultSpeed = 100;
	
	private int[] jointPositions;
	
	private TMasterToArmsDataWriter writer;
	private TelebotMasterArmsTCPView view;
	private DataListener listener;
	
	TMasterToArms instance = new TMasterToArms();
	InstanceHandle_t instance_handle = InstanceHandle_t.HANDLE_NIL;
	
	public TelebotMasterArmsTCPComponent(DataListener listener, int portNumber) 
	{
		super(portNumber);
		parser = new YEIDataParser();
		mapper = new ServoDataMapper();
		this.listener = listener;
		
		jointPositions = new int[14];
		
		for(int i = 0; i < jointPositions.length; i++)
		{
			jointPositions[i] = -1;
		}
	}
	
	public TelebotMasterArmsTCPComponent(int portNumber) 
	{
		super(portNumber);
		parser = new YEIDataParser();
		mapper = new ServoDataMapper();
		
		jointPositions = new int[14];
		
		for(int i = 0; i < jointPositions.length; i++)
		{
			jointPositions[i] = -1;
		}
	}
	
	public int[] getJointPositions()
	{
		return jointPositions;
	}
	/**
	 * Cast the Writer to our Arms DataWriter
	 * This allows us to publish the appropriate Topic data
	 */
	public void initiateDataWriter(){
		writer = (TMasterToArmsDataWriter) getDataWriter();
	}

	public String writeServoData(int servoID, int servoPosition, int servoSpeed)
	{
		instance.servoId = servoID;
		instance.servoPositon = servoPosition;
		instance.servoSpeed = servoSpeed;
		writer.write(instance, instance_handle);
		String data = instance.servoId + " " + instance.servoPositon + " " + instance.servoSpeed;
		
		return data;
	}
	
	public void generatePositions(String jointType, int x, int y, int z)
	{
		String data;
		int servoOnePosition, servoTwoPosition;
		
		if(jointType.equals("head"))
		{
			servoOnePosition = mapper.processHead(
					x, 
					MasterArmsConfig.SERVO_SENSOR_RATIO, 
					MasterArmsConfig.HEAD_PITCH_MAX, 
					MasterArmsConfig.HEAD_PITCH_MIN,
					MasterArmsConfig.HEAD_PITCH_REST,
					true
					);
			
			servoTwoPosition = mapper.processHead(
					y, 
					MasterArmsConfig.SERVO_SENSOR_RATIO,
					MasterArmsConfig.HEAD_YAW_MAX, 
					MasterArmsConfig.HEAD_YAW_MIN,
					MasterArmsConfig.HEAD_YAW_REST,
					false
					);
			
			if(servoOnePosition != jointPositions[0])
			{
				data = writeServoData(10, servoOnePosition, defaultSpeed);
				jointPositions[0] = servoOnePosition;
				LOGI(TAG, data);
			}

			if(servoTwoPosition != jointPositions[1])
			{
				data = writeServoData(11, servoTwoPosition, defaultSpeed);
				jointPositions[1] = servoTwoPosition;
				LOGI(TAG, data);
			}
		}
		else if(jointType.equals("left_shoulder"))
		{
			servoOnePosition = mapper.process( 
					y, 
					MasterArmsConfig.GEARED_SERVO_SENSOR_RATIO, 
					MasterArmsConfig.ARM_ROLL_LEFT_MAX, 
					MasterArmsConfig.ARM_ROLL_LEFT_MIN,
					true
					);
			
			servoTwoPosition = mapper.process( 
					x, 
					MasterArmsConfig.GEARED_SERVO_SENSOR_RATIO, 
					MasterArmsConfig.ARM_PITCH_LEFT_MAX, 
					MasterArmsConfig.ARM_PITCH_LEFT_MIN,
					true
					);
			
			if(servoTwoPosition != jointPositions[2])
			{
				data = writeServoData(20, servoTwoPosition, defaultSpeed);
				jointPositions[2] = servoTwoPosition;
				LOGI(TAG, data);
			}
			
			if(servoOnePosition != jointPositions[3])
			{
				data = writeServoData(21, servoOnePosition, defaultSpeed);
				jointPositions[3] = servoOnePosition;
				LOGI(TAG, data);
			}
		}
		else if(jointType.equals("left_elbow"))
		{
			servoOnePosition = mapper.process( 
					y, 
					MasterArmsConfig.SERVO_SENSOR_RATIO, 
					MasterArmsConfig.ELBOW_ROLL_LEFT_MAX, 
					MasterArmsConfig.ELBOW_ROLL_LEFT_MIN,
					true
					);
			
			servoTwoPosition = mapper.process( 
					x, 
					MasterArmsConfig.SERVO_SENSOR_RATIO, 
					MasterArmsConfig.ARM_YAW_LEFT_MAX, 
					MasterArmsConfig.ARM_YAW_LEFT_MIN,
					false
					);
			
			if(servoTwoPosition != jointPositions[4])
			{
				data = writeServoData(22, servoTwoPosition, defaultSpeed);
				jointPositions[4] = servoTwoPosition;
				LOGI(TAG, data);
			}

			if(servoOnePosition != jointPositions[5])
			{
				data = writeServoData(23, servoOnePosition, defaultSpeed);
				jointPositions[5] = servoOnePosition;
				LOGI(TAG, data);
			}
		}
		else if(jointType.equals("left_wrist"))
		{
			servoOnePosition = mapper.process( 
					z, 
					MasterArmsConfig.SERVO_SENSOR_RATIO, 
					MasterArmsConfig.WRIST_ROLL_LEFT_MAX, 
					MasterArmsConfig.WRIST_ROLL_LEFT_MIN,
					true
					);
			
			servoTwoPosition = mapper.process( 
					x, //100-y
					MasterArmsConfig.SERVO_SENSOR_RATIO, 
					MasterArmsConfig.FOREARM_YAW_LEFT_MAX, 
					MasterArmsConfig.FOREARM_YAW_LEFT_MIN,
					false
					);
			
			if(servoTwoPosition != jointPositions[6])
			{
				data = writeServoData(24, servoTwoPosition, defaultSpeed);
				jointPositions[6] = servoTwoPosition;
				LOGI(TAG, data);
			}

			if(servoOnePosition != jointPositions[7])
			{
				data = writeServoData(25, servoOnePosition, defaultSpeed);
				jointPositions[7] = servoOnePosition;
				LOGI(TAG, data);
			}
		}
		else if(jointType.equals("right_shoulder"))
		{
			servoOnePosition = mapper.process( 
					y, 
					MasterArmsConfig.GEARED_SERVO_SENSOR_RATIO, 
					MasterArmsConfig.ARM_ROLL_RIGHT_MAX, 
					MasterArmsConfig.ARM_ROLL_RIGHT_MIN,
					false
					);
			
			servoTwoPosition = mapper.process(
					x, 
					MasterArmsConfig.GEARED_SERVO_SENSOR_RATIO, 
					MasterArmsConfig.ARM_PITCH_RIGHT_MAX, 
					MasterArmsConfig.ARM_PITCH_RIGHT_MIN,
					true
					);
			
			if(servoTwoPosition != jointPositions[8])
			{
				data = writeServoData(30, servoTwoPosition, defaultSpeed);
				jointPositions[8] = servoTwoPosition;
				LOGI(TAG, data);
			}

			if(servoOnePosition != jointPositions[9])
			{
				data = writeServoData(31, servoOnePosition, defaultSpeed);
				jointPositions[9] = servoOnePosition;
				LOGI(TAG, data);
			}			
		}
		else if(jointType.equals("right_elbow"))
		{
			servoOnePosition = mapper.process( 
					y, //50 - x
					MasterArmsConfig.SERVO_SENSOR_RATIO,
					MasterArmsConfig.ELBOW_ROLL_RIGHT_MAX, 
					MasterArmsConfig.ELBOW_ROLL_RIGHT_MIN,
					false
					);
			
			servoTwoPosition = mapper.process( 
					x, //130 - y
					MasterArmsConfig.SERVO_SENSOR_RATIO, 
					MasterArmsConfig.ARM_YAW_RIGHT_MAX, 
					MasterArmsConfig.ARM_YAW_RIGHT_MIN,
					true
					);
			
			if(servoTwoPosition != jointPositions[10])
			{
				data = writeServoData(32, servoTwoPosition, defaultSpeed);
				jointPositions[10] = servoTwoPosition;
				LOGI(TAG, data);
			}

			if(servoOnePosition != jointPositions[11])
			{
				data = writeServoData(33, servoOnePosition, defaultSpeed);
				jointPositions[11] = servoOnePosition;
				LOGI(TAG, data);
			}
		}
		else if(jointType.equals("right_wrist"))
		{
			servoOnePosition = mapper.process( 
					z, 
					MasterArmsConfig.SERVO_SENSOR_RATIO, 
					MasterArmsConfig.WRIST_ROLL_RIGHT_MAX, 
					MasterArmsConfig.WRIST_ROLL_RIGHT_MIN,
					true
					);
			
			servoTwoPosition = mapper.process( 
					x, 
					MasterArmsConfig.SERVO_SENSOR_RATIO, 
					MasterArmsConfig.FOREARM_YAW_RIGHT_MAX, 
					MasterArmsConfig.FOREARM_YAW_RIGHT_MIN,
					true
					);

			if(servoTwoPosition != jointPositions[12])
			{
				data = writeServoData(34, servoTwoPosition, defaultSpeed);
				jointPositions[12] = servoTwoPosition;
				LOGI(TAG, data);
			}

			if(servoOnePosition != jointPositions[13])
			{
				data = writeServoData(35, servoOnePosition, defaultSpeed);
				jointPositions[13] = servoOnePosition;
				LOGI(TAG, data);
			}
		}
		else if(jointType.equals("null"))
		{
			try
			{
				Thread.sleep(1000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			LOGI(TAG, writeServoData(10, MasterArmsConfig.HEAD_PITCH_REST, defaultSpeed));
			LOGI(TAG, writeServoData(11, MasterArmsConfig.HEAD_YAW_REST, defaultSpeed));
			LOGI(TAG, writeServoData(20, MasterArmsConfig.ARM_PITCH_LEFT_REST, defaultSpeed));
			LOGI(TAG, writeServoData(21, MasterArmsConfig.ARM_ROLL_LEFT_REST, defaultSpeed));
			LOGI(TAG, writeServoData(22, MasterArmsConfig.ARM_YAW_LEFT_REST, defaultSpeed));
			LOGI(TAG, writeServoData(23, MasterArmsConfig.ELBOW_ROLL_LEFT_REST, defaultSpeed));
			LOGI(TAG, writeServoData(24, MasterArmsConfig.FOREARM_YAW_LEFT_REST, defaultSpeed));
			LOGI(TAG, writeServoData(25, MasterArmsConfig.WRIST_ROLL_LEFT_REST, defaultSpeed));
			LOGI(TAG, writeServoData(30, MasterArmsConfig.ARM_PITCH_RIGHT_REST, defaultSpeed));
			LOGI(TAG, writeServoData(31, MasterArmsConfig.ARM_ROLL_RIGHT_REST, defaultSpeed));
			LOGI(TAG, writeServoData(32, MasterArmsConfig.ARM_YAW_RIGHT_REST, defaultSpeed));
			LOGI(TAG, writeServoData(33, MasterArmsConfig.ELBOW_ROLL_RIGHT_REST, defaultSpeed));
			LOGI(TAG, writeServoData(34, MasterArmsConfig.FOREARM_YAW_RIGHT_REST, defaultSpeed));
			LOGI(TAG, writeServoData(35, MasterArmsConfig.WRIST_ROLL_RIGHT_REST, defaultSpeed));		
		}
	}
	
	@Override
	public void callback(String data) { //try synchronized
		
//		LOGI(TAG, "DATA: " + data );
		YEIDataModel yeiDataInstance = (YEIDataModel) parser.parse(data);
		
		int x, y, z = -1;
		
		String jointType = yeiDataInstance.getJointType();
		x = yeiDataInstance.getX();
		y = yeiDataInstance.getY();
		z = yeiDataInstance.getZ();
		yeiDataInstance = null;
		
		listener.changeText(jointType, x, y, z);
		generatePositions(jointType, x, y, z);
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
		public void callback(YEIDataModel data);
	}
}
