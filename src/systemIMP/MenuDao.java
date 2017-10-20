package systemIMP;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import system.ListMenuLevel1Package.MenuP;


public class MenuDao {
   private PreparedStatement prep ;
   private PreparedStatement prep1 ;
   private PreparedStatement prep2 ;
   private PreparedStatement prep3 ;

    public MenuDao(){
      	prep = DAO_Factory.prepare("select *from menu ");
      	prep1 =DAO_Factory.prepare("insert into menu values(?,?,?,?,?)");
      	prep2=DAO_Factory.prepare("update menu set entree=?,plat=?,boisson=?,prix=? where id=? ");
      	prep3=DAO_Factory.prepare("delete from menu  where id=?  ");
    }
	
	public MenuP [] getMenus(){
		ResultSet result =DAO_Factory.RequetS(prep);
		ArrayList<MenuP> listmenu = new ArrayList<MenuP>();
		try{
			while (result.next()){	
				listmenu.add(new MenuP(result.getString("entree"),result.getString("plat"),result.getString("boisson"),
						result.getString("prix"),String.valueOf(result.getInt("id"))));			
			}
			result.close();
		}catch (SQLException e){}
		MenuP[] c = new MenuP [listmenu.size()];
		
		System.out.println("yeah");
		return listmenu.toArray(c);
	}
	
	public void ajouterMenu(MenuP menu){
	try{
		prep1.setInt(1, Integer.valueOf(menu.id));
		prep1.setString(2, menu.entrée);
		prep1.setString(3, menu.plat);
		prep1.setString(4, menu.boisson);
		prep1.setString(5, menu.prix);
	}catch (SQLException e){}
	DAO_Factory.Requetu(prep1);
	}
	
	public MenuP[] ModifiéMenu(MenuP menu,int id){
		try{
			
			prep2.setString(1, menu.entrée);
			prep2.setString(2, menu.plat);
			prep2.setString(3, menu.boisson);
			prep2.setString(4, menu.prix);
			prep2.setString(5, menu.id);
		}catch (SQLException e){}
		DAO_Factory.Requetu(prep2);
		return getMenus();
	}
	
	public int supprimerMenu(int id){
		try {
			 prep3.setString(1,String.valueOf(id));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return	DAO_Factory.Requetu(prep3);
	}
	
}
