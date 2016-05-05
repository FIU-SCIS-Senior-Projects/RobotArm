//package discoverylab.telebot.master.arms.synchronization;
//
//import discoverylab.telebot.master.arms.model.YEIDataModel;
//
//public class YEIDataSynchronizer extends Synchronizer {
//	
//	public YEIDataSynchronizer(){}
//	
//	public void findMaxMin(YEIDataModel instance, int maxX, int minX, 
//			int maxY, int minY, int maxZ, int minZ)
//	{
//		int x = instance.getX();
//		int y = instance.getY();
//		int z = instance.getZ();
//		
//		if(x < minX)
//		{
//			instance.setMinX(x);
//		}
//		else if(x > maxX)
//		{
//			instance.setMaxX(x);
//		}
//		
//		if(y < minY)
//		{
//			instance.setMinY(y);
//		}
//		else if(y > maxY)
//		{
//			instance.setMaxY(y);
//		}
//		
//		if(z < minZ)
//		{
//			instance.setMinZ(z);
//		}
//		else if(z > maxZ)
//		{
//			instance.setMaxZ(z);
//		}
//	}
//	
//	public int synchronize(YEIDataModel instance, int count)
//	{
//		int maxX = -360;
//		int minX = 360;
//		int maxY = -360;
//		int minY = 360;
//		int maxZ = -360;
//		int minZ = 360;
//		
//		
//		if(instance.getJointType().equals("head"))
//		{
//			findMaxMin(instance, maxX, minX, maxY, minY, maxZ, minZ);
//		}
//		else if(instance.getJointType().equals("left_shoulder"))
//		{
//			findMaxMin(instance, maxX, minX, maxY, minY, maxZ, minZ);
//		}
//		else if(instance.getJointType().equals("left_elbow"))
//		{
//			findMaxMin(instance, maxX, minX, maxY, minY, maxZ, minZ);
//		}
//		else if(instance.getJointType().equals("left_wrist"))
//		{
//			findMaxMin(instance, maxX, minX, maxY, minY, maxZ, minZ);
//		}
//		else if(instance.getJointType().equals("right_shoulder"))
//		{
//			findMaxMin(instance, maxX, minX, maxY, minY, maxZ, minZ);
//		}
//		else if(instance.getJointType().equals("right_elbow"))
//		{
//			findMaxMin(instance, maxX, minX, maxY, minY, maxZ, minZ);
//		}
//		else if(instance.getJointType().equals("right_wrist"))
//		{
//			findMaxMin(instance, maxX, minX, maxY, minY, maxZ, minZ);
//		}
//		
//		count++;
//		return count;
//	}
//
//	@Override
//	public void findMaxMin(Object instance, int maxX, int minX, int maxY,
//			int minY, int maxZ, int minZ) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public int synchronize(Object instance, int count) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//	
//}
