package system.ListCommandLevel1Package;

/**
* system/ListCommandLevel1Package/CommandHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from system.idl
* jeudi 8 janvier 2015 19 h 17 CET
*/

public final class CommandHolder implements org.omg.CORBA.portable.Streamable
{
  public system.ListCommandLevel1Package.Command value = null;

  public CommandHolder ()
  {
  }

  public CommandHolder (system.ListCommandLevel1Package.Command initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = system.ListCommandLevel1Package.CommandHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    system.ListCommandLevel1Package.CommandHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return system.ListCommandLevel1Package.CommandHelper.type ();
  }

}