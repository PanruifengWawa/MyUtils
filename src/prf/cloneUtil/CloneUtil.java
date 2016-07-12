package prf.cloneUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CloneUtil {//深拷贝
	
	@SuppressWarnings("unchecked")
	public static <T extends Serializable> T clone(T obj) {
		T clonedObj = null;
		try {
			//序列化
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			ObjectOutputStream objOutput = new ObjectOutputStream(output);
			objOutput.writeObject(obj);
			objOutput.close();
			
			//反序列化
			ByteArrayInputStream input = new ByteArrayInputStream(output.toByteArray());
			ObjectInputStream objInput = new ObjectInputStream(input);
			
			clonedObj = (T) objInput.readObject();
			
			objInput.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return clonedObj;
		
	}

}
