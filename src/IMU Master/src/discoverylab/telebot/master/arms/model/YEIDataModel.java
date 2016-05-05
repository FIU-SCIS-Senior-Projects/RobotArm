package discoverylab.telebot.master.arms.model;

public class YEIDataModel {
	
	public YEIDataModel(){	
	}
	
	public YEIDataModel(String jointType, int x, int y, int z){
		this.jointType = jointType;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public String getJointType() {
		return jointType;
	}
	public void setJointType(String jointType) {
		this.jointType = jointType;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}

	private String jointType;
	private int x;
	private int y;
	private int z;
	

}
