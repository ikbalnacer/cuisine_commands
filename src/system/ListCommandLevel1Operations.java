package system;


/**
* system/ListCommandLevel1Operations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from system.idl
* jeudi 8 janvier 2015 19 h 17 CET
*/


//*****************
public interface ListCommandLevel1Operations 
{
  int ajouterCommand (system.ListCommandLevel1Package.Command command);
  void supprimeCommand (int commandID) throws system.ListCommandLevel1Package.CommandNotFound;
} // interface ListCommandLevel1Operations
