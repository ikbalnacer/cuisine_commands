package systemIMP;

import java.util.Properties;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManager;

public class Serveur {
 
public static void main(String [] args){
    
	try{	
		DAO_Factory.charger();
		DAO_Factory.getConnection("food", "ikbal", "ikol1945");
	    Properties pr = new Properties();
	    pr.put("port","1500");
	    pr.put("host","127.0.0.1");

	    ORB orb = ORB.init(args,pr);
	  System.out.println("yes 1");
		POA poaroot = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
		POAManager manager =poaroot.the_POAManager();
	     
		NamingContext ncxt =NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
	     
        ListComandLivreurimp listcommand = new ListComandLivreurimp();
	    org.omg.CORBA.Object obj1ref = poaroot.servant_to_reference(listcommand);
        ListCommandLevel2imp CommandLevel2 = new ListCommandLevel2imp();
        org.omg.CORBA.Object obj2ref= poaroot.servant_to_reference(CommandLevel2);
        ListMenuIMP menus = new ListMenuIMP();
        org.omg.CORBA.Object obj3ref= poaroot.servant_to_reference(menus);
        System.out.println("yes 2");
              
                NameComponent[] nc = new NameComponent[1];
                nc[0] = new NameComponent("comand1","");
		
                NameComponent[] nc1 = new NameComponent[1];
                nc1[0]=new NameComponent("comand2","");
                
                NameComponent[] nc2 = new NameComponent[1];
                nc2[0] = new NameComponent("Menus","");
                System.out.println("yes 3");     
                NamingContext c1 =ncxt.bind_new_context(nc);
                NamingContext c2 =ncxt.bind_new_context(nc1);
                NamingContext c3 =ncxt.bind_new_context(nc2);
                
                NameComponent[] Commands1 = new NameComponent[1];
                Commands1[0] = new NameComponent("Com1","");
                c2.bind(Commands1,obj1ref);
                
                NameComponent[] Commands2 = new NameComponent[1];
                Commands2[0] = new NameComponent("Com2","");
                c1.bind(Commands2,obj2ref);
             
                NameComponent[] NMenu = new NameComponent[1];
                System.out.println("yes 5");
                NMenu[0] = new NameComponent("Obj3","");
                System.out.println("yes 6");
                c3.bind(NMenu,obj3ref);
                System.out.println("yes 7");
                manager.activate();
  
                orb.run();	        
	}catch(Exception e){
		
		e.printStackTrace();
	}
	
}
}
/*  ListComandLivreurimp listcommand = new ListComandLivreurimp();
org.omg.CORBA.Object obj1 = poaroot.servant_to_reference(listcommand);
 ListCommandLevel2imp CommandLevel2 = new ListCommandLevel2imp();
 org.omg.CORBA.Object obj2= poaroot.servant_to_reference(CommandLevel2);
 String obj2ref = orb.object_to_string(obj2);
 ListMenuIMP menus = new ListMenuIMP();
 org.omg.CORBA.Object obj3= poaroot.servant_to_reference(menus);
 String obj3ref = orb.object_to_string(obj3);
 
 PrintStream out = new PrintStream(new FileOutputStream("Object"));
 out.println(obj1);
 out.println(obj2ref);
 out.println(obj3ref);
 out.close();*/