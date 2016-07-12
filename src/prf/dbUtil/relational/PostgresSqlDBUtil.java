package prf.dbUtil.relational;



public class PostgresSqlDBUtil extends RelationalDBUtil {
    
    public PostgresSqlDBUtil() {
    	
    }
    
    public PostgresSqlDBUtil(String url,String userName,String password) {
    	super.url = url;
    	super.userName = userName;
    	super.password = password;
    	super.driverClassName = "org.postgresql.Driver";
    }
    
}
