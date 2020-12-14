package practise.Asignment.Utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {

	public static Properties properties;
	public static final String filePath = System.getProperty("user.dir")+"\\src\\main\\java\\practise\\Assignment\\Resource\\Config.properties";
	public static final String src = System.getProperty("user.dir");
	
	public static void configFileReader()
	{
		BufferedReader reader;
		try
		{
			reader = new BufferedReader(new FileReader(filePath));
			properties = new Properties();
			try
			{
				properties.load(reader);
				reader.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			throw new RuntimeException("config.properties not found at" + filePath);
		}
	}
	
	public static String getChromeBrowser()
	{
		String chromePath = properties.getProperty("ChromePath");
		if(chromePath!= null) return chromePath;
		 else throw new RuntimeException("chrome Path is not specified in the Configuration.properties file."); 
	}
	
	
	
	public static String getTripUrl(){
		String tripPath = properties.getProperty("TripUrl");
		if(tripPath!= null) return tripPath;
		 else throw new RuntimeException("Trip Advisor URL not specified in the Configuration.properties file."); 
	}
	
}
