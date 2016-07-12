package prf.dbUtil;


public abstract class DBUtil {
	protected String url;
	protected String userName;
	protected String password;
	protected String driverClassName;
    
    public abstract boolean createConnection();
    
    public abstract boolean closeConnection();
    
    public abstract boolean executeInsertAndUpdate(String sql);
    
    public abstract String executeQuery(String querySql);
    
    public abstract boolean executeQueryToFile(String querySql,String filePath);
    

}
