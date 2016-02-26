package discoverylab.telebot.master.arms.configurations;

public class MasterArmsConfig {
	
	public static final int HEAD_PITCH_MAX = 2600;
	public static final int HEAD_PITCH_MIN = 2000; //2048;
	public static final int HEAD_YAW_MAX = 2600;
	public static final int HEAD_YAW_MIN = 1500;
	
	public static final int ARM_ROLL_LEFT_MAX = 3600; 
	public static final int ARM_ROLL_LEFT_MIN = 1600; //2048;
	public static final int ARM_PITCH_LEFT_MAX = 4000; //3600; 
	public static final int ARM_PITCH_LEFT_MIN = 2048;
	public static final int ARM_YAW_LEFT_MAX = 1700; //3072; 
	public static final int ARM_YAW_LEFT_MIN = 200; //1024;

	public static final int ARM_ROLL_RIGHT_MAX = 2048;
	public static final int ARM_ROLL_RIGHT_MIN = 600;
	public static final int ARM_PITCH_RIGHT_MAX = 2048;
	public static final int ARM_PITCH_RIGHT_MIN = 600;
	public static final int ARM_YAW_RIGHT_MAX = 4095; //3072;
	public static final int ARM_YAW_RIGHT_MIN = 2400; //1024;
	
	public static final int ELBOW_ROLL_LEFT_MAX = 3072; 
	public static final int ELBOW_ROLL_LEFT_MIN = 2048;
	
	public static final int ELBOW_ROLL_RIGHT_MAX = 3048; //2048;
	public static final int ELBOW_ROLL_RIGHT_MIN = 2048; //1024;
	
	public static final int FOREARM_YAW_LEFT_MAX = 4050; //3072; 
	public static final int FOREARM_YAW_LEFT_MIN = 2400; //1024;
	
	public static final int FOREARM_YAW_RIGHT_MAX = 1800; //3072; 
	public static final int FOREARM_YAW_RIGHT_MIN = 50; //1024;
	
	public static final int WRIST_ROLL_LEFT_MAX = 2700; //3072;
	public static final int WRIST_ROLL_LEFT_MIN = 1600; //1042;
	
	public static final int WRIST_ROLL_RIGHT_MAX = 3072;
	public static final int WRIST_ROLL_RIGHT_MIN = 1024;
	
	public static final int HEAD_PITCH_REST = 2200; //2048;
	public static final int HEAD_YAW_REST = 2048;
	
	public static final int ARM_ROLL_LEFT_REST = 2560; //2420; //2048; 
	public static final int ARM_PITCH_LEFT_REST = 2560;//1965; //2048; 
	public static final int ARM_YAW_LEFT_REST = 1024; //2048;

	public static final int ARM_ROLL_RIGHT_REST = 2048;
	public static final int ARM_PITCH_RIGHT_REST = 2048;
	public static final int ARM_YAW_RIGHT_REST = 3072; //3050; //2048;
	
	public static final int ELBOW_ROLL_LEFT_REST = 2048; 
	
	public static final int ELBOW_ROLL_RIGHT_REST = 2048;
	
	public static final int FOREARM_YAW_LEFT_REST = 3072; //2965; //2048; 
	
	public static final int FOREARM_YAW_RIGHT_REST = 1024; //1800; //2048;
	
	public static final int WRIST_ROLL_LEFT_REST = 2048; //2010; //2048;
	
	public static final int WRIST_ROLL_RIGHT_REST = 2048;
}