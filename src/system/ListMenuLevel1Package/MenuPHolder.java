package system.ListMenuLevel1Package;

/**
* system/ListMenuLevel1Package/MenuPHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from system.idl
* jeudi 8 janvier 2015 19 h 17 CET
*/

public final class MenuPHolder implements org.omg.CORBA.portable.Streamable
{
  public system.ListMenuLevel1Package.MenuP value = null;

  public MenuPHolder ()
  {
  }

  public MenuPHolder (system.ListMenuLevel1Package.MenuP initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = system.ListMenuLevel1Package.MenuPHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    system.ListMenuLevel1Package.MenuPHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return system.ListMenuLevel1Package.MenuPHelper.type ();
  }

}
