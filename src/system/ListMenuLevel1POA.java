package system;


/**
* system/ListMenuLevel1POA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from system.idl
* jeudi 8 janvier 2015 19 h 17 CET
*/


//**********************
public abstract class ListMenuLevel1POA extends org.omg.PortableServer.Servant
 implements system.ListMenuLevel1Operations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("getMenu", new java.lang.Integer (0));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // system/ListMenuLevel1/getMenu
       {
         system.ListMenuLevel1Package.MenuP $result[] = null;
         $result = this.getMenu ();
         out = $rh.createReply();
         system.ListMenuLevel1Package.MenusHelper.write (out, $result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:system/ListMenuLevel1:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public ListMenuLevel1 _this() 
  {
    return ListMenuLevel1Helper.narrow(
    super._this_object());
  }

  public ListMenuLevel1 _this(org.omg.CORBA.ORB orb) 
  {
    return ListMenuLevel1Helper.narrow(
    super._this_object(orb));
  }


} // class ListMenuLevel1POA
