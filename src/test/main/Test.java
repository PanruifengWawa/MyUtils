package test.main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import prf.cloneUtil.CloneUtil;
import prf.dbUtil.DBUtil;
import prf.dbUtil.factory.DBFactory;
import prf.dbUtil.relational.PostgresSqlDBUtil;
import prf.encodingUtil.MD5Util;
import prf.fileUtil.FileOperationsUtil;
import prf.httpRequestUtil.RestfulAPIUtil;
import prf.propertyFileUtil.PropertyUtil;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
//		String values = PropertyUtil.getValueByName("db.properties", "url1");
//		System.out.println(values);
		
//		Map<String,String> values = PropertyUtils.getValueByNames("db.properties", "url","usr","psd","className");
//		String url = values.get("url");
//	    String usr = values.get("usr");
//		String psd = values.get("psd");
//		String className = values.get("className");
//		DBUtils dbUtils =  (DBUtils) DBFactory.getConnectionByName(className,url,usr,psd);
//		dbUtils.createConnection();
//		dbUtils.executeQueryToFile("select * from ebd_auth_user_account","ba.txt");
////		dbUtils.executeInsertAndUpdate("insert into ebd_auth_user_account(user_name) values('test_user1')");
////		System.out.println(dbUtils.executeQuery("select * from ebd_auth_user_account"));		
//		dbUtils.closeConnection();
		
//		Model model1 = new Model();
//		model1.model = "model1";
//		model1.models[0] = "model1 array";
//		
//		Model model2 = CloneUtils.clone(model1);
////		Model model2 = M;
//		model2.model = "model2";
//		model2.models[0] = "model2 array";
//		
//		System.out.println(model1.model + " " + model1.models[0]);
//		System.out.println(model2.model + " " + model2.models[0]);
		
//		LinkedHashMap<String,String> map = new LinkedHashMap<String,String>();
//		map.put("ad", "test");
//		map.put("aa", "ssd");
//		map.put("ccc", "Asda");
//		
//		Iterator<Map.Entry<String,String>> it = map.entrySet().iterator();
//		
//		while(it.hasNext()) {
//			Map.Entry<String, String> entry = it.next();
//			
////			map.remove(entry.getKey());
//			it.remove();
//			
//			System.out.println(entry.getKey() + " " + entry.getValue());
//		}
//		
//		System.out.println(map);
		

//		System.out.print(RestfulAPIUtil.sendGet("http://localhost:8080/PARisk/api/user/login?userName=umrunner&userPWD=aaaaa888"));
		
		String a = RestfulAPIUtil.sendGet("http://localhost:8081/apiA/my/a/2?token=testToken");
		System.out.println(a);

	}

}
