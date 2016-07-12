package prf.propertyFileUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyUtil {
	
	public static String getValueByName(String path,String name) {
		String value = null;  
        try {   
        	Properties properties = new Properties();   
    		FileInputStream in = new FileInputStream(path); 
        	properties.load(in);   
            value = properties.getProperty(name).trim();   
        } catch (Exception e) {   
            e.printStackTrace();  
        }   
        return value;
	}
	
	public static Map<String,String> getValueByNames(String path,String... name) {
		Map<String,String> values = null;  
        try {   
        	Properties properties = new Properties();   
    		FileInputStream in = new FileInputStream(path); 
        	properties.load(in);
        	values = new HashMap<String,String>();
            for(int i = 0 ; i < name.length ; i++) {
            	try {
            		values.put(name[i], properties.getProperty(name[i]).trim());
            	} catch (Exception e) {
            		values.put(name[i], null);
            	}
            }
        } catch (IOException e) {   
            e.printStackTrace();   
            return null;
        }   
        return values;
	}

}
