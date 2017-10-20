package systemIMP;

import system.ListCommandLivreurPOA;
import system.ListCommandLevel1Package.Command;
import system.ListCommandLevel1Package.CommandNotFound;

public class ListComandLivreurimp extends ListCommandLivreurPOA implements listShare{
	int i =0;
	@Override
	public void livrer(int num) throws CommandNotFound {
		How_to_interact_Commands.livrer(num);
	}

	@Override
	public String consulterAdress(int numdecommand) throws CommandNotFound{
	return	How_to_interact_Commands.consulterAdress(numdecommand);
	}

	@Override
	public int ajouterCommand(Command command) {
		How_to_interact_Commands.ajouterCommand(command);
		return Integer.valueOf(command.numeroDeCommand);
	}

	@Override
	public void supprimeCommand(int commandID) throws CommandNotFound {
		How_to_interact_Commands.supprimerCommand(commandID);
	}
}
