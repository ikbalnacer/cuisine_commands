package system.ListCommandCuisinierPackage;


/**
* system/ListCommandCuisinierPackage/CommandsHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from system.idl
* jeudi 8 janvier 2015 19 h 17 CET
*/

public final class CommandsHolder implements org.omg.CORBA.portable.Streamable
{
  public system.ListCommandLevel1Package.Command value[] = null;

  public CommandsHolder ()
  {
  }

  public CommandsHolder (system.ListCommandLevel1Package.Command[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = system.ListCommandCuisinierPackage.CommandsHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    system.ListCommandCuisinierPackage.CommandsHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return system.ListCommandCuisinierPackage.CommandsHelper.type ();
  }

}
