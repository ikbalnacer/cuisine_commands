package systemIMP;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import system.ListCommandLevel1Package.Command;
import system.ListCommandLevel1Package.CommandNotFound;

public class CommandsDAO {
   
     private   PreparedStatement prep ;
     private PreparedStatement prep1 ;
     private PreparedStatement prep2 ;
     private PreparedStatement prep3 ;
     private PreparedStatement prep4 ;
     private PreparedStatement prep5 ;
     private PreparedStatement prep6 ;
     private PreparedStatement prep7 ;
     int co=1;
     public CommandsDAO(){

    	prep = DAO_Factory.prepare("insert into command values(?,?,?,?,?)");
    	prep1 = DAO_Factory.prepare("delete from command where numeroDecommand = ? and etat=\"NEW\"");
    	prep2 = DAO_Factory.prepare("update command set etat=\"PRET\" where numeroDecommand=?");
    	prep3 = DAO_Factory.prepare("select *from command where etat = ? ");
    	prep4 = DAO_Factory.prepare("update command set etat=\"LIVRER\" where numeroDecommand=?" );
        prep5 = DAO_Factory.prepare("select *from command where numeroDecommand= ? and etat =\"PRET\" ");
        prep6 = DAO_Factory.prepare("select *from command where numeroDecommand=? ");
        prep7=DAO_Factory.prepare("select *from command ");
        }
     
    public int getnumber(){
    	ResultSet r = DAO_Factory.RequetS(prep7);
    	int i =0;
    	try {
			while(r.next()){
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    return i;
    } 
	
	public void ajouterCommand(Command command){
		try {
			prep.setInt(1,0);
			prep.setString(2,command.adressDeCommand);
			prep.setInt(3,Integer.valueOf(command.codeMenu));
			prep.setInt(4,Integer.valueOf( command.numeroDeCommand));
			prep.setString(5,command.etat);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(command.codeMenu);
		System.out.println(command.adressDeCommand);
		System.out.println(command.numeroDeCommand);
		System.out.println(command.etat);
		DAO_Factory.Requetu(prep);
	}
	
	public void supprimerCommand(int numDecommand)throws CommandNotFound{
		try{
			prep1.setInt(1, numDecommand);
		}catch(SQLException e){
			
		}
		DAO_Factory.Requetu(prep1);
	}
	
	public void valider(int numDecommand){
		try{
			prep2.setInt(1, numDecommand);
		}catch(SQLException e){	
		}
		DAO_Factory.Requetu(prep2);
	}
	
	public Command[] getCommands(String type){
		ArrayList<Command> listCommand = new ArrayList<Command>();
		try {	
			prep3.setString(1,type);
		    ResultSet result =DAO_Factory.RequetS(prep3);
			while (result.next()) {
			    Command c = new Command();  
				c.adressDeCommand=result.getString("adressDeCommand");
				c.codeMenu=String.valueOf(result.getInt("codeMenu"));
				c.etat=result.getString("etat");
				c.numeroDeCommand=String.valueOf(result.getInt("numeroDecommand"));
				listCommand.add(c);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
			}
		Command[] tab = new Command [listCommand.size()];
		return listCommand.toArray(tab);
	}
	
	public void livrer(int numDecommand){
		try{
			prep4.setInt(1,numDecommand);
		}catch(SQLException e){
		
		}
		System.out.println("yesyes");
		DAO_Factory.Requetu(prep4);
	}
	
	public String consulterAdress(int numDecommand){
		try{
			prep5.setInt(1,numDecommand);
		}catch(SQLException e){	
		}
		String str ="";
		ResultSet r= DAO_Factory.RequetS(prep5);
		try {
			if(r==null){
				return "";
			}
		while (r.next()) {
			 str = r.getString("adressDeCommand");
		}
		return  str;
		} catch (SQLException e) {
		   e.printStackTrace();
		return null;
		}
	}
	public Command consulter(int numero){
		Command c=null;
		try {
			prep6.setInt(1, numero);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSet r = DAO_Factory.RequetS(prep6);
		
		try {
			while (r.next()) {
				 c=new Command(r.getString("etat"),r.getString("adressDeCommand"),String
						 .valueOf(r.getInt("codeMenu")),String
						 .valueOf(r.getInt("numeroDeCommand")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("jhaahaha");
		return c;
	}
	
}
