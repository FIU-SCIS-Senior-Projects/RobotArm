package discoverylab.telebot.master.arms.model;

public class ServoDataModel {
	
	public ServoDataModel(){
	}
	
	public ServoDataModel(int servoID, int max, int min)
	{
		this.servoID = servoID;
		this.max = max;
		this.min = min;
	}
	
	public int getServoID() {
		return servoID;
	}
	public void setServoID(int servoID) {
		this.servoID = servoID;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	private int servoID;
	private int max;
	private int min;
}
