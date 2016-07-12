package prf.dbUtil.relational;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import prf.dbUtil.DBUtil;
import prf.fileUtil.FileOperationsUtil;

public abstract class RelationalDBUtil extends DBUtil {
	protected Connection connection = null;
	
	protected RelationalDBUtil(){};
	
    public boolean createConnection() {
    	
        try {
        	Class.forName(driverClassName);
        	connection = DriverManager.getConnection(url, userName, password);
        	System.out.println("Connection created!");
		} catch (SQLException | ClassNotFoundException e ) {
			e.printStackTrace();
			System.out.println("Fail to connect database!");
			return false;
		}
        return true;
    }
    
    public boolean closeConnection() {
    	try {
    		if(connection != null)
    			connection.close();
    		System.out.println("Connection closed!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fail to close connection!");
			return false;
		}
    	return true;
    }
    
    public boolean executeInsertAndUpdate(String sql) {
    	
    	Statement st;
		try {
			st = connection.createStatement();
			st.executeUpdate(sql);
	        st.close();
	        System.out.println("Succeed to execute!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fail to execute!");
			return false;
		}
		
		return true;
        
    }
    
    public String executeQuery(String querySql) {
    	String resultString = new String();
    	Statement st;
    	ResultSet rs;
		try {
			st = connection.createStatement();
			rs = st.executeQuery(querySql); 
			ResultSetMetaData rsmd = rs.getMetaData(); 
			ArrayList<String> columnNames = new ArrayList<String>();
			String types = "";
			for(int i = 1 ; i <= rsmd.getColumnCount() ; i++) {
				columnNames.add(rsmd.getColumnName(i));
				resultString += rsmd.getColumnName(i) + ",";
				types += rsmd.getColumnTypeName(i) + ",";
			}
			resultString = resultString.substring(0,resultString.length()-1) + "\r\n";
			types = types.substring(0,types.length()-1) + "\r\n";
			resultString += types;
			while(rs.next()) {
				for(int i = 0 ; i < columnNames.size()-1; i++) {
					resultString += rs.getString(columnNames.get(i)) + ",";
				}
				resultString += rs.getString(columnNames.get(columnNames.size()-1)) + "\r\n";
			}
			
			
			rs.close();
	        st.close();
	        System.out.println("Succeed to execute!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fail to execute!");
			return null;
		}
		
		return resultString;
    }
    
    public boolean executeQueryToFile(String querySql,String filePath) {
    	Statement st;
    	ResultSet rs;
		try {
			FileOperationsUtil.deleteFile(filePath);
			st = connection.createStatement();
			rs = st.executeQuery(querySql); 
			ResultSetMetaData rsmd = rs.getMetaData(); 
			ArrayList<String> columnNames = new ArrayList<String>();
			String columnString = "";
			String typeString = "";
			for(int i = 1 ; i <= rsmd.getColumnCount() ; i++) {
				columnNames.add(rsmd.getColumnName(i));
				columnString += rsmd.getColumnName(i) + ",";
				typeString += rsmd.getColumnTypeName(i) + ",";
			}
			columnString = columnString.substring(0,columnString.length()-1) + "\r\n";
			typeString = typeString.substring(0,typeString.length()-1) + "\r\n";
			columnString += typeString;
			FileOperationsUtil.writeFile(filePath, columnString, true);
			while(rs.next()) {
				String resultString = "";
				for(int i = 0 ; i < columnNames.size()-1; i++) {
					resultString += rs.getString(columnNames.get(i)) + ",";
				}
				resultString += rs.getString(columnNames.get(columnNames.size()-1)) + "\r\n";
				FileOperationsUtil.writeFile(filePath, resultString, true);
			}
			
			rs.close();
	        st.close();
	        
	        System.out.println("Succeed to execute!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fail to execute!");
			return false;
		}
		return true;
    }

}
