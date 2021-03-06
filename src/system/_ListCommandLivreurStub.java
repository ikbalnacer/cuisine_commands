package system;


/**
* system/_ListCommandLivreurStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from system.idl
* jeudi 8 janvier 2015 19 h 17 CET
*/


//****************************
public class _ListCommandLivreurStub extends org.omg.CORBA.portable.ObjectImpl implements system.ListCommandLivreur
{

  public void livrer (int num) throws system.ListCommandLevel1Package.CommandNotFound
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("livrer", true);
                $out.write_long (num);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:system/ListCommandLevel1/CommandNotFound:1.0"))
                    throw system.ListCommandLevel1Package.CommandNotFoundHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                livrer (num        );
            } finally {
                _releaseReply ($in);
            }
  } // livrer

  public String consulterAdress (int numdecommand) throws system.ListCommandLevel1Package.CommandNotFound
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("consulterAdress", true);
                $out.write_long (numdecommand);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:system/ListCommandLevel1/CommandNotFound:1.0"))
                    throw system.ListCommandLevel1Package.CommandNotFoundHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return consulterAdress (numdecommand        );
            } finally {
                _releaseReply ($in);
            }
  } // consulterAdress

  public int ajouterCommand (system.ListCommandLevel1Package.Command command)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("ajouterCommand", true);
                system.ListCommandLevel1Package.CommandHelper.write ($out, command);
                $in = _invoke ($out);
                int $result = $in.read_long ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return ajouterCommand (command        );
            } finally {
                _releaseReply ($in);
            }
  } // ajouterCommand

  public void supprimeCommand (int commandID) throws system.ListCommandLevel1Package.CommandNotFound
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("supprimeCommand", true);
                $out.write_long (commandID);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:system/ListCommandLevel1/CommandNotFound:1.0"))
                    throw system.ListCommandLevel1Package.CommandNotFoundHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                supprimeCommand (commandID        );
            } finally {
                _releaseReply ($in);
            }
  } // supprimeCommand

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:system/ListCommandLivreur:1.0", 
    "IDL:system/ListCommandLevel1:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _ListCommandLivreurStub
