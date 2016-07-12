package prf.dbUtil.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class DBFactory {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Object getConnectionByName(String className,String url,String usr,String psd) {
		Object dbConnection = null;
		try {
			Class dbClass = Class.forName(className);
			Constructor constructor = dbClass.getConstructor(String.class, String.class,String.class);
			dbConnection = constructor.newInstance(url,usr,psd);
		} catch (ClassNotFoundException |InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dbConnection;
	}

}
