import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

/**
 * @author Nilesh Akhade
 * Server Interface, this defines services that must be provided by class which implement it
 */
public interface ServerIntf extends Remote {

	double add(double d1,double d2) throws RemoteException;
	double subtract(double d1,double d2) throws RemoteException;
	double multiply(double d1,double d2) throws RemoteException;
	double divide(double d1,double d2) throws RemoteException;
	Date getCurrentTime() throws RemoteException;
}