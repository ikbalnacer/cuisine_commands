package system;


/**
* system/ListCommandLevel1POA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from system.idl
* jeudi 8 janvier 2015 19 h 17 CET
*/


//*****************
public abstract class ListCommandLevel1POA extends org.omg.PortableServer.Servant
 implements system.ListCommandLevel1Operations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("ajouterCommand", new java.lang.Integer (0));
    _methods.put ("supprimeCommand", new java.lang.Integer (1));
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
       case 0:  // system/ListCommandLevel1/ajouterCommand
       {
         system.ListCommandLevel1Package.Command command = system.ListCommandLevel1Package.CommandHelper.read (in);
         int $result = (int)0;
         $result = this.ajouterCommand (command);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 1:  // system/ListCommandLevel1/supprimeCommand
       {
         try {
           int commandID = in.read_long ();
           this.supprimeCommand (commandID);
           out = $rh.createReply();
         } catch (system.ListCommandLevel1Package.CommandNotFound $ex) {
           out = $rh.createExceptionReply ();
           system.ListCommandLevel1Package.CommandNotFoundHelper.write (out, $ex);
         }
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:system/ListCommandLevel1:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public ListCommandLevel1 _this() 
  {
    return ListCommandLevel1Helper.narrow(
    super._this_object());
  }

  public ListCommandLevel1 _this(org.omg.CORBA.ORB orb) 
  {
    return ListCommandLevel1Helper.narrow(
    super._this_object(orb));
  }


} // class ListCommandLevel1POA
