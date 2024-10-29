package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class readFromProperties {

	String path="D:\\Eclipse\\seleniumByPawanKumar\\SBILProductJourney\\src\\test\\resources\\data.properties";
	
	public String readData(String key) throws IOException
	{
		Properties p =new Properties();
		FileInputStream file = new FileInputStream(path);
		p.load(file);
		return p.getProperty(key);
	}
}
