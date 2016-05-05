package discoverylab.telebot.master.arms.synchronization;

public abstract class Synchronizer {
	
	public abstract void findMaxMin(Object instance, int maxX, int minX, 
			int maxY, int minY, int maxZ, int minZ);
	
	public abstract int synchronize(Object instance, int count);
	
}
