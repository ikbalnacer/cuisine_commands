package systemIMP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO_Factory {
    static Connection con;
    public static final String path = "jdbc:mysql://127.0.0.1:3306/";
    
	public static void charger(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
    public static Connection getConnection(String basename,String user,String motdepass){
    	try {
			return con =DriverManager.getConnection(path+basename,user,motdepass);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }
    
	public static PreparedStatement prepare(String str){
			try {
				return con.prepareStatement(str);
			} catch (SQLException e) {
			e.printStackTrace();
			return null;
			}
     }
	
	public static ResultSet RequetS(PreparedStatement prep){
		try {
			return prep.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		    return null;
		}
	}
	
	public static int Requetu(PreparedStatement prep){
		try {
		 return 	prep.executeUpdate();
		} catch (SQLException e) {
			System.out.println("RAWE ehna exact !!");
		}
		return 0;
	}
	
	public static void Close(PreparedStatement prep ){
		try {
			
			prep.close();
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	
}
