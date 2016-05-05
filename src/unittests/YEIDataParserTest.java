package discoverylab.telebot.master.arms.test.unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import discoverylab.telebot.master.arms.model.YEIDataModel;
import discoverylab.telebot.master.arms.parser.YEIDataParser;

public class YEIDataParserTest 
{
	YEIDataParser yeiDataParser = new YEIDataParser();
	
	@Test
	public void testParse() 
	{
		String str = "head 30 60 -1";
		
		YEIDataModel instanceActual = (YEIDataModel) yeiDataParser.parse(str);
		
		YEIDataModel instanceExpected = new YEIDataModel();
		instanceExpected.setJointType("head");
		instanceExpected.setX(30);
		instanceExpected.setY(60);
		instanceExpected.setZ(-1);
		
		assertEquals(instanceExpected.getJointType(), instanceActual.getJointType());
		System.out.println("Tested JointType");
		
		assertEquals(instanceExpected.getX(), instanceActual.getX());
		System.out.println("Tested X");

		assertEquals(instanceExpected.getY(), instanceActual.getY());
		System.out.println("Tested Y");

		assertEquals(instanceExpected.getZ(), instanceActual.getZ());
		System.out.println("Tested Z");

	}

}
