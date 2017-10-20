package systemIMP;

import system.ListMenuPOA;
import system.ListMenuLevel1Package.MenuP;
import system.ListMenuPackage.MenuNotFound;

 public class ListMenuIMP extends ListMenuPOA{
	
    MenuDao dao = new MenuDao();
    MenuP[] Menus = null ;
	@Override
	public MenuP[] getMenu() {
		 Menus = dao.getMenus();

		return Menus;
	}

	@Override
	public void ajouterMenu(MenuP menu) {
		dao.ajouterMenu(menu);
	}

	
	@Override
	public MenuP[] modifieMenu(MenuP menu, int id) throws MenuNotFound {
		MenuP[] menus =dao.ModifiéMenu(menu, id);	
		return menus;
	}

	@Override
	public void supprimeMenu(int menuid) throws MenuNotFound {
		int i =dao.supprimerMenu(menuid);
		if(i==0){
		 throw new MenuNotFound("MENU NOT FOUND !!");	
		}
	}

}
