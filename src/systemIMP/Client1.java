package systemIMP;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.naming.Context;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;

import system.ListCommandCuisinier;
import system.ListCommandCuisinierHelper;
import system.ListCommandLevel1;
import system.ListCommandLevel1Helper;
import system.ListCommandLivreur;
import system.ListCommandLivreurHelper;
import system.ListMenu;
import system.ListMenuHelper;
import system.ListMenuLevel1;
import system.ListMenuLevel1Helper;
import system.ListCommandLevel1Package.Command;
import system.ListCommandLevel1Package.CommandNotFound;
import system.ListMenuLevel1Package.MenuP;
import system.ListMenuPackage.MenuNotFound;

public class Client1 extends JFrame {
	CardLayout card = new CardLayout();
	String [] tab = {"auth","Cuisiner","livreur"};
	JPanel pan1 = new JPanel(),pan2=new JPanel(),pan3=new JPanel(),pan4 =new JPanel(),container = new JPanel() 
	, espaceClient = new JPanel(),Client_prog=new JPanel();
	JLabel label1 =new JLabel(new ImageIcon("D:\\weclcome.png"));
	JButton connecter = new JButton("Connecter"),Valider = new JButton("Valider"),ConsulterCom=new JButton("commands")
	,modifie=new JButton("Modifié_M"),delete = new JButton("Delete_M"),ConsAdress =new JButton("ConsultAdress")
	,livrer = new JButton("Livrer"), consulterMenuB=new JButton("Consulter"),consulterPret=new JButton("Consulter")
	,command = new JButton("Commande");
	JLabel Pseaudo = new JLabel("Nom : "),motDepass = new JLabel("mot de pass : "),consulterMenu = new JLabel("Consulter Menu : ")
	,ConsulterPret = new JLabel("Consulter Pret : "),oufaire =new JLabel("Ou faire une : ");
	JTextField pseaudoTxt = new JTextField(),motdepassTxt = new JTextField();
	String [] tabCombo = {"Cuisinier","Livreur"};
	JComboBox<String> combo = new JComboBox<String>(tabCombo);
	String [] menuname ={"ID","Entrée","Plat","Boisson","Prix"};
	String [][] a_recuperer={};
	String  [] CommandTitle ={"NumeroDeCommand","ID_Menu"};
	String [][] commanddate ={};
	JTable tableCommand = new JTable(commanddate,CommandTitle);
	String [] tabChoise={"table","Command","Adress","Livrer","Valider","Modifié","Delete",
			"tableCommand","addMenu","suppCommand","Consulter"};
	//Client-prog
	JPanel tablepan = new JPanel(),Commandpan = new JPanel(),AdressPan=new JPanel(),Livrerpan =new JPanel(),ValiderPan=new JPanel()
	,Modifiépan = new JPanel(),deletepan=new JPanel(),commandpan=new JPanel();;
	JLabel label2 =new JLabel("votre Adress SVP!"),label3=new JLabel("ID de la Commande"),
	label4=new JLabel("Entrée : "),label5=new JLabel("plat : "),label6=new JLabel("Boisson : "),label7=new JLabel("Prix : ")
	,label8=new JLabel("ID DE menu que voulez vous Modifier ");
	JTextField txt =new JTextField(),txt1=new JTextField(),txt2 =new JTextField(),txt3=new JTextField(),
			txt4 =new JTextField(),txt5=new JTextField(),txt6 =new JTextField(),txt7=new JTextField();
	JTextField entrée =new JTextField(),plat =new JTextField(),boisson =new JTextField(),prix=new JTextField(),Id=new JTextField();
	JButton Commander = new JButton("Commander"),adress =new JButton("consulter");
	JTable   tableaff = new JTable(a_recuperer,menuname);
    JButton valider2=new JButton("valider"),delete2 = new JButton("Delete"),modifie2=new JButton("Modifie")
    ,livrer1 = new JButton("Livrer");
    JLabel validerlabel = new JLabel("Num de la commande que vous voulez valider :"),deletelabel = new JLabel("Num de la commande que vous voulez supprimer :")
    ,livrerlabel = new JLabel("Num de la commande que vous voulez livrer :"),consulterAdresslabel = new JLabel("Consulter Adress")
    ,afficherAdress = new JLabel(),
     last_time = new JLabel("kekeek");
    //************************
    JOptionPane jop1=null;
    JButton addmenu = new JButton(" Add menu ");
    JLabel entreemenu = new JLabel("Entree : ");
    JLabel platmenu = new JLabel("plat : ");
    JLabel boissonmenu = new JLabel("boisson : ");
    JLabel prixmenu = new JLabel("prix  : ");
    JTextField txtentree = new JTextField();
    JTextField txtplat = new JTextField();
    JTextField txtboisson = new JTextField();
    JTextField txtprix = new JTextField();
    JButton submit = new JButton("Submit");
    JPanel addmenupan = new JPanel();
    //********************
    JLabel labelsupprimComman = new JLabel(" supprime Command : ");
    JButton supprimCommand = new JButton(" supprime");
    JButton supprimCommand1 = new JButton(" supprime  ");
    JLabel numlabCommand = new JLabel("num_Command : ");
    JLabel adrLabCommand = new JLabel(" votre Adress  : ");
    JTextField txtnumCommand = new JTextField();
    JTextField txtAdrs = new JTextField();
    JPanel suppCompan = new JPanel();
    /**  command part :p  **/
    JLabel consult_Command = new JLabel(" le Numero SVP : ");
    JTextField consulte_Command_txt = new JTextField();
    JButton consult_Command_B = new JButton("Consulter");
    JPanel  consult_pan = new JPanel();
    
    JComboBox<String> comb1=new JComboBox<String>(tabCombo);
    static ListCommandLevel1  commands;
	static ListMenu menus;
    static ListCommandCuisinier cuisine;
    static ListCommandLivreur livreur;
    static ListMenuLevel1 menusLevel1;
	public Client1(){
		this.setTitle("APPLICATION");
		this.setSize(480,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		initpage();
		this.setVisible(true);
	}
    public static void main(String [] args){
    	Properties pr = new Properties();
	    pr.put("port","1500");
	    pr.put("host","localhost");
    	ORB orb = ORB.init(args, pr);
    	try {
    		NamingContext nameservice = NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
    		 NameComponent[] ncC = new NameComponent[1];
             ncC[0] = new NameComponent("comand1","");
             NamingContext c1  =  NamingContextHelper.narrow(nameservice.resolve(ncC));
          
             NameComponent[] ncC1 = new NameComponent[1];
             ncC1[0]=new NameComponent("comand2","");
             NamingContext c2  =  NamingContextHelper.narrow(nameservice.resolve(ncC1));
             
             
             NameComponent[] ncC2 = new NameComponent[1];
             ncC2[0] = new NameComponent("Menus","");
             NamingContext c3  =  NamingContextHelper.narrow(nameservice.resolve(ncC2));

             NameComponent[] Commands1 = new NameComponent[1];
             Commands1[0] = new NameComponent("Com1","");
		     livreur =ListCommandLivreurHelper.narrow(c2.resolve(Commands1));
		     commands = ListCommandLevel1Helper.narrow(c2.resolve(Commands1));

             NameComponent[] Commands2 = new NameComponent[1];
             Commands2[0] = new NameComponent("Com2","");
		     cuisine =ListCommandCuisinierHelper.narrow(c1.resolve(Commands2));
             
             NameComponent[] NMenu = new NameComponent[1];
             NMenu[0] = new NameComponent("Obj3","");
             menus = ListMenuHelper.narrow(c3.resolve(NMenu));
		     menusLevel1=ListMenuLevel1Helper.narrow(c3.resolve(NMenu));    
		  
		     /*	BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("Object")));
			   String str = in.readLine();
		       org.omg.CORBA.Object obj1 = orb.string_to_object(str);
		       str = in.readLine();
		       org.omg.CORBA.Object obj2 = orb.string_to_object(str);
		       str = in.readLine();
		       org.omg.CORBA.Object obj3 = orb.string_to_object(str);*/
		     
		} catch (Exception e) {
			e.printStackTrace();
		}
	Client1 c = new Client1();
     }
    public void initpage(){
    	pan1.setLayout(card);
    	pan1.setPreferredSize(new Dimension(200,150));
    	///Connecter
    	pan2.add(Pseaudo);
    	pseaudoTxt.setPreferredSize(new Dimension(100,20));
    	pan2.add(pseaudoTxt);
    	pan2.add(motDepass);
    	motdepassTxt.setPreferredSize(new Dimension(100,20));
        pan2.add(motdepassTxt);
        pan2.add(connecter);
        pan2.setBorder(BorderFactory.createTitledBorder("Espace Employer..."));
        ///Cuisinier
        pan3.setPreferredSize(new Dimension(200,120));
        pan3.add(comb1);
        JPanel pan11 = new JPanel();
        pan3.add(pan11);
        pan11.setPreferredSize(new Dimension(20,10));
        pan3.add(ConsulterCom);
        ConsulterCom.addActionListener(new consulterCommands());
        ConsulterCom.setPreferredSize(new Dimension(100,25));
        pan3.add(Valider);
        Valider.addActionListener(new validerListener());
        Valider.setPreferredSize(new Dimension(75,25));
        pan3.add(modifie);
        modifie.addActionListener(new ModifieListener());
        modifie.setPreferredSize(new Dimension(85,25));
        pan3.add(delete);
        pan3.add(addmenu);
        delete.setPreferredSize(new Dimension(85,25));
        delete.addActionListener(new deleteListener());
        pan3.setBorder(BorderFactory.createTitledBorder("Cuisinier..."));
        //Livreur
        pan4.add(combo);
        pan4.add(ConsAdress);
        ConsAdress.addActionListener(new consulterAdress());
        pan4.add(livrer);
        livrer.addActionListener(new livrerListener());
        ConsAdress.setPreferredSize(new Dimension(112,25));
        pan4.setBorder(BorderFactory.createTitledBorder("Livreur..."));
        
        //ajouter au container de l'espace Employer
        pan1.add(pan2,tab[0]);
        pan1.add(pan3,tab[1]);
        pan1.add(pan4,tab[2]);
        
        //Espace Client
        espaceClient.setPreferredSize(new Dimension(250,150));
        espaceClient.add(consulterMenu);
        espaceClient.add(consulterMenuB);
        espaceClient.add(ConsulterPret);
        espaceClient.add(consulterPret);
        espaceClient.add(oufaire);
        espaceClient.add(command);
        espaceClient.add(labelsupprimComman);
        espaceClient.add(supprimCommand);
        supprimCommand.addActionListener(new afficher_supprim_Listener());
        espaceClient.setBorder(BorderFactory.createTitledBorder("Espace Client.."));
        
        // User-programe
        // il faut recuperer les Menus et apres restorer
        Client_prog.setPreferredSize(new Dimension(480,250));
        Client_prog.setLayout(card);
        //******
        MenuP[] tab = menus.getMenu();
		a_recuperer=new String [tab.length][5];
		for (int i = 0; i < tab.length; i++) {
				a_recuperer[i][0]=tab[i].id;
				a_recuperer[i][1]=tab[i].entrée;
				a_recuperer[i][2]=tab[i].plat;
				a_recuperer[i][3]=tab[i].boisson;
				a_recuperer[i][4]=tab[i].prix;
		}
		tableaff=new JTable(a_recuperer,menuname);
		tablepan.removeAll();
		tablepan.add(new JScrollPane(tableaff));
		//**********
        
        tablepan.add(new JScrollPane(tableaff));
        Client_prog.add(tablepan,tabChoise[0]);
        
        Commandpan.add(label2);
        txt.setPreferredSize(new Dimension(80,20));
        Commandpan.add(txt);
        txt1.setPreferredSize(new Dimension(80,20));
        Commandpan.add(label3);
        Commandpan.add(txt1);
        Commandpan.add(Commander);
        Client_prog.add(Commandpan,tabChoise[1]);
        
        consult_pan.add(consult_Command);
   	    consulte_Command_txt.setPreferredSize(new Dimension(200,20));
   	    consult_pan.add(consulte_Command_txt);
   	    consult_Command_B.addActionListener(new consulte_Command_Listener());
   	    consult_pan.add(consult_Command_B);
        Client_prog.add(consult_pan,tabChoise[10]);
   	    
        AdressPan.add(consulterAdresslabel);
        txt2.setPreferredSize(new Dimension(150,20));
        AdressPan.add(txt2);
        AdressPan.add(adress);
        AdressPan.add(afficherAdress);
        Client_prog.add(AdressPan,tabChoise[2]);
        Livrerpan.add(livrerlabel);
        txt3.setPreferredSize(new Dimension(150,20));
        Livrerpan.add(txt3);
        Livrerpan.add(livrer1);
        
        Client_prog.add(Livrerpan,tabChoise[3]);
        ValiderPan.add(validerlabel);
        txt4.setPreferredSize(new Dimension(140,20));
        ValiderPan.add(txt4);
        ValiderPan.add(valider2);
        
        Client_prog.add(ValiderPan,tabChoise[4]);
        Modifiépan.add(label4);
        entrée.setPreferredSize(new Dimension(100,20));
        Modifiépan.add(entrée);
        Modifiépan.add(label5);
        plat.setPreferredSize(new Dimension(100,20));
        Modifiépan.add(plat);
        Modifiépan.add(label6);
        boisson.setPreferredSize(new Dimension(100,20));
        Modifiépan.add(boisson);
        Modifiépan.add(label7);
        prix.setPreferredSize(new Dimension(100,20));
        Modifiépan.add(prix);
        Modifiépan.add(label8);
        Id.setPreferredSize(new Dimension(100,20));
        Modifiépan.add(Id);
        Modifiépan.add(modifie2);
        
        Client_prog.add(Modifiépan,tabChoise[5]);
        deletepan.add(deletelabel);
        txt5.setPreferredSize(new Dimension(130,20));
        deletepan.add(txt5);
        deletepan.add(delete2);
        
        Client_prog.add(deletepan,tabChoise[6]);
        commandpan.add(new JScrollPane(tableCommand));
        Client_prog.add(commandpan,tabChoise[7]);
        
        addmenu.addActionListener(new affiche_add_menu());
        txtentree.setPreferredSize(new Dimension(100,20));
        txtplat.setPreferredSize(new Dimension(100,20));
        txtboisson.setPreferredSize(new Dimension(100,20));
        txtprix.setPreferredSize(new Dimension(80,20));
        addmenupan.add(entreemenu);
         addmenupan.add(txtentree);
          addmenupan.add(platmenu);
           addmenupan.add(txtplat);
            addmenupan.add(boissonmenu);
             addmenupan.add(txtboisson);
              addmenupan.add(prixmenu);
         addmenupan.add(txtprix);
        addmenupan.add(submit);
       
         submit.addActionListener(new submitListner());
         Client_prog.add(addmenupan,tabChoise[8]);
         
    	suppCompan.add(numlabCommand);
    	suppCompan.add(txtnumCommand);
    	txtnumCommand.setPreferredSize(new Dimension(100,20));
    	suppCompan.add(adrLabCommand);
    	suppCompan.add(txtAdrs);
    	txtAdrs.setPreferredSize(new Dimension(140,20));
    	suppCompan.add(supprimCommand1);
    	supprimCommand1.addActionListener( new supprimeCommandListner());
    	Client_prog.add(suppCompan,tabChoise[9]);
    	
    			
        /// ajoute les listener a chaque boutton :p
        connecter.addActionListener(new connecterListener());
        combo.addActionListener(new combListener());
        comb1.addActionListener(new comb1Listener());
        consulterMenuB.addActionListener(new consulterMenuListener());
        consulterPret.addActionListener(new consulterPretListener());
        command.addActionListener(new CommandsListener());
        Commander.addActionListener(new ajouterCommandListener());
        ConsulterCom.addActionListener(new commands1Listener() );
        valider2.addActionListener(new valider1Listener());
        modifie2.addActionListener(new modifie_m_Listener());
        delete2.addActionListener(new delete_Menu_Listener());
        adress.addActionListener(new conuslter_Adress_Listener());
        livrer1.addActionListener(new livrer1Listener());
        
        container.add(label1,BorderLayout.NORTH);
        container.add(pan1,BorderLayout.WEST);
        container.add(espaceClient,BorderLayout.EAST);
        container.add(Client_prog,BorderLayout.SOUTH);
        this.getContentPane().add(container);
    }
    
    class connecterListener implements ActionListener{
    	@Override
    	public void actionPerformed(ActionEvent e){
    	card.show(pan1, tab[1]);
    	}
    }
    class combListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
		      int i =combo.getSelectedIndex();
		      if(i==0){
		    	  card.show(pan1, tab[1]);
		      }else{
		    	  card.show(pan1, tab[2]);
		      }
		}
	}
    class comb1Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			int i =comb1.getSelectedIndex();
		      if(i==0){
		    	  card.show(pan1, tab[1]);
		      }else{
		    	  card.show(pan1, tab[2]);
		      }
		}
	}
    
    class consulterMenuListener implements ActionListener {
    	public void actionPerformed(ActionEvent e ){
    		MenuP[] tab = menus.getMenu();
    		a_recuperer=new String [tab.length][5];
    		for (int i = 0; i < tab.length; i++) {
					a_recuperer[i][0]=tab[i].id;
					a_recuperer[i][1]=tab[i].entrée;
					a_recuperer[i][2]=tab[i].plat;
					a_recuperer[i][3]=tab[i].boisson;
					a_recuperer[i][4]=tab[i].prix;
			}
    		tableaff=new JTable(a_recuperer,menuname);
    		tablepan.removeAll();
    		tablepan.add(new JScrollPane(tableaff));
    		tablepan.revalidate();
            card.show(Client_prog ,tabChoise[0]);
    	}
    }
    
    class consulterPretListener implements ActionListener{
     public void actionPerformed(ActionEvent e ){ 
 		card.show(Client_prog ,tabChoise[10]);
     }
    }
    
    class CommandsListener implements ActionListener{
        public void actionPerformed(ActionEvent e ){
           
    		card.show(Client_prog ,tabChoise[1]);
       	}
    }
    class consulterCommands implements ActionListener{
    	 public void actionPerformed(ActionEvent e ){
     		card.show(Client_prog ,tabChoise[7]);
        	}
    }
    class consulterAdress implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
		    card.show(Client_prog, tabChoise[2]);	
		}
    }
    class livrerListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
		card.show(Client_prog,tabChoise[3]);
		}	
    }
    class validerListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			card.show(Client_prog, tabChoise[4]);
		}
    }
    class ModifieListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
		card.show(Client_prog,tabChoise[5]);
		}	
    }
    class deleteListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
		card.show(Client_prog,tabChoise[6]);
		}	
    }
    
   class afficher_supprim_Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
		card.show(Client_prog,tabChoise[9]);
		}	
   }
   class affiche_add_menu implements ActionListener{
   	public void actionPerformed(ActionEvent arg0) {
		card.show(Client_prog,tabChoise[8]);
       }	
   }
   
    class ajouterCommandListener implements ActionListener{
    	public void actionPerformed(ActionEvent arg0) {
    	int i =cuisine.ajouterCommand(new Command("",txt.getText(),txt1.getText(),""));
    	txt.setText("");
    	txt1.setText("");
    	
    	JOptionPane.showMessageDialog(null, "votre numero est "+i, "Information", JOptionPane.INFORMATION_MESSAGE);
        }	
    }
   
    
    class valider1Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
		  try {
			cuisine.Valide(Integer.valueOf(txt4.getText()));
			txt4.setText("");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (CommandNotFound e) {
			txt4.setText("");
			JOptionPane.showMessageDialog(null, "Your action is failed , check again ", "WARNING", JOptionPane.WARNING_MESSAGE);

		}    
		}
    }
    
    class commands1Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
		 Command[] tab = cuisine.getCommands("NEW");
		 commanddate= new String [tab.length][2];
		 for (int i = 0; i < tab.length; i++) {
    		 commanddate[i][0]=tab[i].numeroDeCommand;
    		 commanddate[i][1]=tab[i].codeMenu;
		     }
		 tableCommand = new JTable(commanddate,CommandTitle);
		    commandpan.removeAll();
		    commandpan.add(new JScrollPane(tableCommand));
		    commandpan.revalidate();
		    
	 		card.show(Client_prog ,tabChoise[7]);
		}	
    }
    
    class modifie_m_Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
		  MenuP m = new MenuP(entrée.getText(),plat.getText(),boisson.getText(),prix.getText(),Id.getText());
		try {
			menus.modifieMenu(m,Integer.valueOf(Id.getText()));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		  Id.getText();
		  entrée.getText();
		  plat.getText();
		  boisson.getText();
		  prix.getText();
		}	
    }
    
    class delete_Menu_Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				menus.supprimeMenu(Integer.valueOf(txt5.getText()));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (MenuNotFound e) {
				txt5.setText("");
				JOptionPane.showMessageDialog(null, "Your action is failed , check again ", "WARNING", JOptionPane.WARNING_MESSAGE);
			}
		} 	
    }
    class conuslter_Adress_Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
		 	afficherAdress.setText(livreur.consulterAdress(Integer.valueOf(txt2.getText())));
			} catch (NumberFormatException e) {
				txt2.setText("");
			} catch (CommandNotFound e) {
			txt2.setText("");
			JOptionPane.showMessageDialog(null, "Your action is failed , check again ", "WARNING", JOptionPane.WARNING_MESSAGE);
			}
		}	
    }
    
    class livrer1Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
		try {
			livreur.livrer(Integer.valueOf(txt3.getText()));
			txt3.setText("");
		} catch (NumberFormatException e) {
			txt2.setText("");
			} catch (CommandNotFound e) {
			txt2.setText("");
			JOptionPane.showMessageDialog(null, "Your action is failed , check again ", "WARNING", JOptionPane.WARNING_MESSAGE);
		}	
		}
    }
    class supprimeCommandListner implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
		 	try {
				commands.supprimeCommand(Integer.valueOf(txtnumCommand.getText()));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (CommandNotFound e) {
			txtnumCommand.setText("");
			JOptionPane.showMessageDialog(null, "Your action is failed , check again ", "WARNING", JOptionPane.WARNING_MESSAGE);
			}
			txtnumCommand.setText("");
		}	
    }
    
    class  submitListner implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {			
		menus.ajouterMenu(new MenuP(txtentree.getText(), txtplat.getText(), txtboisson.getText(),txtprix.getText(),"0"));
		txtentree.setText("");
		txtplat.setText("");
		txtboisson.setText("");
		txtprix.setText("");
		}
    }
    
    class consulte_Command_Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
		try {
			Command c =cuisine.consulter(Integer.valueOf(consulte_Command_txt.getText()));
			JOptionPane.showMessageDialog(null, "Votre command est : "+	c.codeMenu+" et son etat : "+c.etat, "Information",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (CommandNotFound e) {
		JOptionPane.showMessageDialog(null, "Your action is failed , check again ", "WARNING", JOptionPane.WARNING_MESSAGE);
		}
		consulte_Command_txt.setText("");
		}
		
    }
}
