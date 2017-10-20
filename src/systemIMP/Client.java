package systemIMP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;

import org.omg.CORBA.ORB;

import system.ListCommandCuisinier;
import system.ListCommandCuisinierHelper;
import system.ListCommandLevel1;
import system.ListCommandLevel1Helper;
import system.ListCommandLivreur;
import system.ListCommandLivreurHelper;
import system.ListMenu;
import system.ListMenuHelper;
import system.ListCommandLevel1Package.Command;
import system.ListCommandLevel1Package.CommandNotFound;
import system.ListMenuPackage.Menu;
import system.ListMenuPackage.MenuNotFound;

public final class Client extends JFrame{

	JPanel pan = new JPanel(),container= new JPanel(),pan7=new JPanel(),pan2=new JPanel(),pan8=new JPanel(),pan3=new JPanel(),iconpanel=new JPanel(),pan6=new JPanel(),pan4 = new JPanel(),pan9=new JPanel();
	JLabel label1 = new JLabel("consulter Menu :");
	JButton button = new JButton("Consulter");
	JLabel label2 = new JLabel("Consulter Pret :");
	JButton button1 = new JButton("Consulter");
	JLabel label3 = new JLabel("Ou faire une :");
	JButton button2 = new JButton("Commande");
	JLabel icon;
	int j =0;
	JLabel label4 = new JLabel("Mot de pass :");
	JTextField txt = new JTextField();
	JLabel label5 = new JLabel("nom :");	
	JTextField txt2 = new JTextField();
	JButton Conct = new JButton("Connecter");
	String  [] str = {"Code","Entrée","plat","Boisson"};
	String [][] exemp = {{"1","salad","frit","RAmi"},{"2","loubya","dela3e","Hamoude bou3elame"},{"3","batikhe","chourba","ifri"},{"4","loubya","betikhe","Hamoude bou3elame"}};
	JTable table = new JTable(exemp,str),table2,table3;
	JLabel label6 = new JLabel("Donnez moi votre Adress Svp !");
	JTextField Adress = new JTextField();
	JLabel label7 = new JLabel("LE Code de la demande :");
	JTextField Code = new JTextField();
	JButton Envoyer = new JButton("Envoyer");
	String auth="ikbal";
	String pseaudo ="ikol1945";
	String [] tab ={"cuisinier","livreur"};
	JComboBox<String> comb = new JComboBox<>(tab);
	JButton Valider = new JButton("Valider") ;
	JButton ModifieMenu = new JButton("Modifie");
	JButton modifieMenu1 = new JButton("Modifie");
	JButton supprimerMenu = new JButton("delete");
	JButton supprimerMenu1 = new JButton("Supprimer");
	JButton ConsulterCommand = new JButton("ConsulterCom");
	JButton ConculterAdress = new JButton("ConsulterAdress");
	JLabel label = new JLabel("NUM de la commande :");
	JTextField txt3 = new JTextField();
	JButton livrer = new JButton("Livrer"),livrer1= new JButton("Livrer");
	JButton Valider2 = new JButton("Valider");
	JLabel label8 = new JLabel(),label9= new JLabel(),label10= new JLabel(),
	label15=new JLabel(), label11=new JLabel(),label12= new JLabel(),label13=new JLabel(),label14=new JLabel();
	JTextField entree=new JTextField(),plat=new JTextField(),boisson=new JTextField(),prix=new JTextField(),id =new JTextField();
	JButton button4 = new JButton("Consulter");
	JTextField txt4 = new JTextField();
	static ListCommandLevel1  command;
	static ListMenu menus;
    static ListCommandCuisinier cuisine;
    static ListCommandLivreur livreur;
	//************************************ CORBA****************************************************************
public static void main(String [] args){
	try{
        ORB orb = ORB.init(args, null);
      /*  org.omg.CORBA.Object NameSer =orb.resolve_initial_references("NameService");
        NamingContext ncxt =NamingContextHelper.narrow(NameSer);*/
        //************************************** 
      /* 
        NameComponent[] ncC = new NameComponent[1];
        ncC[0] = new NameComponent("NCommands","");
        org.omg.CORBA.Object obj1 = ncxt.resolve(ncC);

        NamingContext CommandC = NamingContextHelper.narrow(obj1);
        
        NameComponent[] NCommand = new NameComponent[1];
        NCommand[0] = new NameComponent("objC","");
        
        org.omg.CORBA.Object CommandsR = CommandC.resolve(NCommand);
        command =ListCommandHelper.narrow(CommandsR);*/
        //************************
       BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("Object")));
       
       String str = in.readLine();
       org.omg.CORBA.Object obj1 = orb.string_to_object(str);
       str = in.readLine();
       org.omg.CORBA.Object obj2 = orb.string_to_object(str);
        str = in.readLine();
       org.omg.CORBA.Object obj3 = orb.string_to_object(str);
       command = ListCommandLevel1Helper.narrow(obj2);
       cuisine =ListCommandCuisinierHelper.narrow(obj2);
       livreur =ListCommandLivreurHelper.narrow(obj1);
        menus = ListMenuHelper.narrow(obj3);
        
        Client c = new Client();
          }catch(Exception e){
              e.printStackTrace();
                          }
}
//*************************************************\\Graphics//***********************************///

public  Client(){
	this.setTitle("Application");
	this.setSize(468,370);  	
        this.setLocationRelativeTo(null);
	this.setResizable(false);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initpage();
    try {
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
	} catch (Exception e) {

		e.printStackTrace();
	} 
    this.setVisible(true);     	
}
public void initpage(){	
	pan.add(label1);
	pan.add(button);
	button.addActionListener(new ConsulterMListner());
	pan.add(label2);
	pan.add(button1);
	button1.addActionListener(new consulterPretListener());
	pan.add(label3);
	pan.add(button2);
	Conct.addActionListener(new ConnectListner());
	comb.addActionListener(new comListner());
	//icon 
	icon = new JLabel(new ImageIcon("D:\\weclcome.png"));
	iconpanel.setLayout(new BorderLayout());
	iconpanel.add(icon);
	button2.addActionListener(new CommandListner());
	pan.setBackground(Color.WHITE);
	pan.setBorder(BorderFactory.createTitledBorder("Espace Client"));
	pan.setPreferredSize(new Dimension(230,130));
	pan2.setBackground(Color.WHITE);
	pan2.setPreferredSize(new Dimension(400,80));
	JScrollPane p = new JScrollPane(table);
	pan2.add(p);
	pan2.setPreferredSize(new Dimension(200,90));
	pan3.setBackground(Color.WHITE);
	pan3.setPreferredSize(new Dimension(220,130));	
	txt.setPreferredSize(new Dimension(120,20));
	pan3.add(label5);
	pan3.add(txt);
	txt2.setPreferredSize(new Dimension(120,20));
	pan3.add(label4);
	pan3.add(txt2);
    pan3.add(Conct);
	pan3.setBorder(BorderFactory.createTitledBorder("si vous etes un employer ,identifie SVp"));		
	container.add(iconpanel,BorderLayout.NORTH);
	container.add(pan3,BorderLayout.WEST);
	container.add(pan,BorderLayout.CENTER);
	container.setBackground(Color.WHITE);
	ModifieMenu.addActionListener(new ModifieMenuListenr());
	supprimerMenu.addActionListener(new supprimeMenuListener());
	this.getContentPane().add(container,BorderLayout.CENTER);	
	this.getContentPane().add(pan2,BorderLayout.SOUTH);
}class consulterPretListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		pan2.removeAll();
		Command[] tab =cuisine.getCommands("PRET");
		String [][] str = new String [tab.length][3] ;
		for (int i = 0; i < tab.length; i++) {
			str[i][0]=tab[i].numeroDeCommand;
			str[i][1]=tab[i].adressDeCommand;
			str[(i)][2]=tab[i].codeMenu;		
		}		
		String [] title = {"Numero de Command","Adress","Code"};
		table3 = new JTable(str,title);
		JScrollPane p = new JScrollPane(table3);
		pan2.add(p);	
		pan2.revalidate();	
	}
}

class comListner implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		pan6.removeAll();
		System.out.println(((JComboBox<String>)e.getSource()).getSelectedIndex());
		if(((JComboBox<String>)e.getSource()).getSelectedIndex()==0){
		pan6.setPreferredSize(new Dimension(210,100));
		pan6.add(Valider );
		pan6.add(ConsulterCommand);
		pan6.add(ModifieMenu);
		ModifieMenu.setPreferredSize(new Dimension(80,20));
		supprimerMenu.setPreferredSize(new Dimension(100,20));
		pan6.add(supprimerMenu);
		}else{
		    pan6.setPreferredSize(new Dimension(213,50));
			ConculterAdress.setPreferredSize(new Dimension(100,15));
			ConculterAdress.addActionListener(new AdressListener());
			ConculterAdress.setPreferredSize(new Dimension(100,20));
			pan6.add(ConculterAdress);
			livrer.addActionListener(new livrerListener());
			livrer.setPreferredSize(new Dimension(80,20));
			pan6.add(livrer);
		}
		pan6.revalidate();
	}
	}
      class livrerListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
    	  pan2.removeAll();
  		pan2.add(label9);
  		txt4.setPreferredSize(new Dimension(100,40));
  		pan2.add(txt4);
  		livrer1.addActionListener(new livrer1Listener());
  		pan2.add(livrer1);
  		pan8.setPreferredSize(new Dimension(460,50));
  		pan8.setBackground(Color.WHITE);
  		pan2.add(label10);
  		pan2.add(pan8);
  		pan2.revalidate();
      }
      }
      class livrer1Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
		try {
			livreur.livrer(Integer.valueOf(txt4.getText()));
			txt4.setText("");
		} catch (NumberFormatException e) {
		label10.setText(e.getMessage());
		} catch (CommandNotFound e) {
			label10.setText(e.getMessage());
		}
		}}
      
      class ModifieMenuListenr implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
		pan2.removeAll();
		label11 = new  JLabel("Entrée    : ");
		entree.setPreferredSize(new Dimension(150,25));
		label12=new JLabel("plat      : ");
		plat.setPreferredSize(new Dimension(170,25));
		label13=new JLabel("boisson      : ");
		boisson.setPreferredSize(new Dimension(170,25));
		label14=new JLabel("Prix         : ");
		prix.setPreferredSize(new Dimension(150,25));
		label15=new JLabel("id de menu que voulez vous modifier :");
		id.setPreferredSize(new Dimension(100,25));
		pan2.add(label11);
		pan2.add(entree);
		pan2.add(label12);
		pan2.add(plat);
		pan2.add(label13);
		pan2.add(boisson);
		pan2.add(label14);
		pan9.setPreferredSize(new Dimension(400,50));
		pan9.setBackground(Color.WHITE);
		pan2.add(prix);
		pan2.add(label15);
		pan2.add(id);
		pan2.add(modifieMenu1);
		pan2.add(pan9);
		modifieMenu1.addActionListener(new modifieMenu());
		pan2.revalidate();
		}
      }
      
      class modifieMenu implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				menus.modifieMenu(new Menu(entree.getText(),plat.getText(),boisson.getText(),prix.getText(),"0"),Integer.valueOf(id.getText()));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (MenuNotFound e) {
				e.printStackTrace();
			}
		}
      }
      
      class supprimeMenuListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			pan2.removeAll();
			label11 = new  JLabel("numero de la menu que voulez vous supprimer  : ");
			entree.setPreferredSize(new Dimension(200,25));
			pan2.add(label14);
			pan9.setPreferredSize(new Dimension(400,50));
			pan9.setBackground(Color.WHITE);
			pan2.add(pan9);
			pan2.add(supprimerMenu1);
			supprimerMenu1.addActionListener(new supprimeMenulistener());
			pan2.revalidate();
		}
      }
      
      class supprimeMenulistener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
		
		}
      }
        
      class AdressListener implements ActionListener{
	    @Override
	    public void actionPerformed(ActionEvent arg0) {
		pan2.removeAll();
		pan2.add(label9);
		txt4.setPreferredSize(new Dimension(100,40));
		pan2.add(txt4);
		pan2.add(button4);
		button4.addActionListener(new Button4Listener());
		pan8.setPreferredSize(new Dimension(460,50));
		pan8.setBackground(Color.WHITE);
		pan2.add(label10);
		pan2.add(pan8);
		pan2.revalidate();
	}
}
class Button4Listener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String str = txt4.getText();
		int j=0;
		try{
			 j = Integer.parseInt(str);
		}catch(Exception e){
			txt4.setText(e.getMessage());
		}
		try{
		label10.setText(livreur.consulterAdress(j));
		}catch(Exception e){
			txt4.setText("NOT_FOUND");
			label10.setText("");
		}
		
	}
}
class ConsulterMListner implements ActionListener{
	@Override
    public void actionPerformed(ActionEvent arg0) {
		pan2.removeAll();
		JScrollPane p = new JScrollPane(table);
		pan2.add(p);
		getContentPane().add(pan2,BorderLayout.SOUTH);
		pan2.revalidate();	
	}  	
}


class ConnectListner implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
	    pan3.removeAll();
	    pan3.add(comb);
	    pan6.setPreferredSize(new Dimension(210,50));
	    pan6.add(Valider );
	    Valider.addActionListener(new ValiderListener());
		pan6.add(ConsulterCommand);
		ConsulterCommand.addActionListener(new ConCommand());
		pan6.add(ConsulterCommand);
		pan6.add(ModifieMenu);
		pan6.add(supprimerMenu);
		Valider.setPreferredSize(new Dimension(80,20));
        ConsulterCommand.setPreferredSize(new Dimension(120, 20));
		ModifieMenu.setPreferredSize(new Dimension(80,20));
		supprimerMenu.setPreferredSize(new Dimension(100,20));
	    pan6.setBackground(Color.WHITE);
	    pan3.add(pan6);
	    pan3.revalidate();
	}
}

class ValiderListener implements ActionListener{
   
	@Override
public void actionPerformed(ActionEvent e){
		pan2.removeAll();	
		pan2.add(label);
		txt3.setPreferredSize(new Dimension(100,30));
		pan2.add(txt3);
		pan7.setPreferredSize(new Dimension(460,60));
		pan7.setBackground(Color.WHITE);
		pan2.add(Valider2);
		Valider2.addActionListener(new Valider2Listener());
		pan2.add(pan7);
		pan2.revalidate();
	}
}

class Valider2Listener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
	try{
		int i = Integer.parseInt(txt3.getText());
		cuisine.Valide(i);
		txt3.setText("");
	}catch(CommandNotFound e ){
		txt3.setText("NOT_FOUND");
	}
	}
	}

class ConCommand implements ActionListener
       {
	    @Override
		public void actionPerformed(ActionEvent arg0) {
	    pan2.removeAll();
	    Command [] commands = cuisine.getCommands("NEW");
		String [] [] str = new String [commands.length][3];
	    int j =1;
		for (int i = 0; i < commands.length; i++) {
			str[i][0]=commands[i].numeroDeCommand;
			str[i][1]=commands[i].adressDeCommand;
			str[(i)][2]=commands[i].codeMenu;
		}		
		String [] title = {"Numero de Command","Adress","Code"};
		table2 = new JTable(str,title);
		JScrollPane p = new JScrollPane(table2);
		pan2.add(p);	
		pan2.revalidate();	
	}
}   

     class CommandListner implements ActionListener  {
	 @Override
	 public void actionPerformed(ActionEvent arg0) {
		pan2.removeAll();
		Adress.setPreferredSize(new Dimension(280,40));
		pan2.add( label6);
		pan2.add(Adress);
        pan2.add(label7);
        Code.setPreferredSize(new Dimension(40,40));
        pan2.add(Code); 
        pan2.add(Envoyer);
        pan2.add(label8);
        Envoyer.addActionListener(new envoyerListener());
        pan2.revalidate();      
	}
	
	class envoyerListener implements ActionListener{
                @Override
		public void actionPerformed(ActionEvent arg0) {	
			int j =0;
			try{
				 j=command.ajouterCommand(new Command("",Adress.getText(), Code.getText(),""));
			}catch(Exception e){
				Code.setText("NAN");
			}
			Adress.setText("");
			Code.setText("");
			label8.setText("numero :"+j );
		}
	}
}    

}
