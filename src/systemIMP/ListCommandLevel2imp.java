package systemIMP;

import system.ListCommandCuisinierPOA;
import system.ListCommandLevel1Package.Command;
import system.ListCommandLevel1Package.CommandNotFound;

public class ListCommandLevel2imp extends ListCommandCuisinierPOA implements listShare{
    int co =0;
    public ListCommandLevel2imp(){
    	co=How_to_interact_Commands.getnumber();
    }
    @Override
	public void Valide(int numerodeCommand) throws CommandNotFound {
		How_to_interact_Commands.valider(numerodeCommand);
	}

	@Override
	public Command[] getCommands(String type) {
		Command[]	types =How_to_interact_Commands.getCommands(type);
	return types;
	}

	@Override
	public int ajouterCommand(Command command) {
		command.numeroDeCommand=String.valueOf(++co);
		command.etat="NEW";
		How_to_interact_Commands.ajouterCommand(command);
		return Integer.parseInt(command.numeroDeCommand);
	}

	@Override
	public void supprimeCommand(int commandID) throws CommandNotFound {
		How_to_interact_Commands.supprimerCommand(commandID);
	}

	@Override
	public Command consulter(int numrodeCommand) throws CommandNotFound {
		
		Command c=How_to_interact_Commands.consulter(numrodeCommand);
		if(c==null)
         	{
			throw new CommandNotFound();
         	}else {
         	return c;
         	}
		}

}
