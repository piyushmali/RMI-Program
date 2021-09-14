import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class CalcServer extends UnicastRemoteObject implements ServerIntf {

	private static final long serialVersionUID = 1L;

	public CalcServer() throws RemoteException{
		super();
	}

	public double add(double d1, double d2) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Addition Done..");
		return d1+d2;
	}

	public double subtract(double d1, double d2) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Subtraction Done..");
		return d1-d2;
	}

	public double multiply(double d1, double d2) throws RemoteException {
		System.out.println("Multiplication Done..");
		return d1*d2;
	}

	public double divide(double d1, double d2) throws RemoteException {
		System.out.println("Division Done..");
		return d1/d2;
	}

	public Date getCurrentTime() throws RemoteException {
		System.out.println("Time retrieved and sent.");
		Date d = new Date(System.currentTimeMillis());
		return d;
	}

	public static void main(String args[]){
		if(args.length<1){
			System.out.println("Usage: java CalcServer <name>");
			return;
		}
		String srvName=args[0];
		System.out.println("URL: rmi://localhost/" + srvName);
		try {
			CalcServer c=new CalcServer();
			Naming.rebind(srvName, c);
		} catch (RemoteException | MalformedURLException e) {
			e.printStackTrace();
		}
	}
}