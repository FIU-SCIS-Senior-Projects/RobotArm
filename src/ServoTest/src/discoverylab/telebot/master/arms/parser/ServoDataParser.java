package discoverylab.telebot.master.arms.parser;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import discoverylab.telebot.master.arms.model.ServoDataModel;
import discoverylab.telebot.master.core.parser.CoreDataParser;

public class ServoDataParser extends CoreDataParser {
	
	@Override
	public Object parse(String str) {
		StringTokenizer tokenizer = parseUsingTokenizer(str);
		ServoDataModel instance = new ServoDataModel();
		instance.setServoID(Integer.parseInt( tokenizer.nextToken()) );
		instance.setMax( Integer.parseInt(tokenizer.nextToken()) );
		instance.setMin( Integer.parseInt(tokenizer.nextToken()) );
		return instance;
	}
	
	public ArrayList<ServoDataModel> parseConfigurationFile(String fileName) {
		ArrayList<ServoDataModel> servoDataList = new ArrayList<>();
		
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String str;
			
			while((str = br.readLine()) != null) {
				servoDataList.add((ServoDataModel)parse(str));
			}
			
			br.close();
			fr.close();
		} 
		catch(IOException e) {
			e.printStackTrace();
		}
		return servoDataList;
	}
}
