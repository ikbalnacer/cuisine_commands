package system.ListMenuLevel1Package;


/**
* system/ListMenuLevel1Package/MenusHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from system.idl
* jeudi 8 janvier 2015 19 h 17 CET
*/

abstract public class MenusHelper
{
  private static String  _id = "IDL:system/ListMenuLevel1/Menus:1.0";

  public static void insert (org.omg.CORBA.Any a, system.ListMenuLevel1Package.MenuP[] that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static system.ListMenuLevel1Package.MenuP[] extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = system.ListMenuLevel1Package.MenuPHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_sequence_tc (0, __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (system.ListMenuLevel1Package.MenusHelper.id (), "Menus", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static system.ListMenuLevel1Package.MenuP[] read (org.omg.CORBA.portable.InputStream istream)
  {
    system.ListMenuLevel1Package.MenuP value[] = null;
    int _len0 = istream.read_long ();
    value = new system.ListMenuLevel1Package.MenuP[_len0];
    for (int _o1 = 0;_o1 < value.length; ++_o1)
      value[_o1] = system.ListMenuLevel1Package.MenuPHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, system.ListMenuLevel1Package.MenuP[] value)
  {
    ostream.write_long (value.length);
    for (int _i0 = 0;_i0 < value.length; ++_i0)
      system.ListMenuLevel1Package.MenuPHelper.write (ostream, value[_i0]);
  }

}
