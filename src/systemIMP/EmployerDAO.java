package systemIMP;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import system.emplyer;

public class EmployerDAO {

	 PreparedStatement prep ;
     public EmployerDAO(){
    	prep = DAO_Factory.prepare("select *from employer where nom=? and mot_de_pass=?");
     }
	
	public String  authen(emplyer e){
		String str="";
		try{
			prep.setString(1,e.nom);
			prep.setString(2,e.motDepass);
			ResultSet r = DAO_Factory.RequetS(prep);
			str = r.getString("type_emplo");
		}catch (SQLException e1){
			
		}
		return str;
	}
}
