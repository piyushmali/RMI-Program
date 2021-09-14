package Calculator;

import java.rmi.*;

/**
 *
 * @author Piyush Mali
 * Date: 10-09-2021
 */
public interface CalcInterface extends Remote {
  public int add(int x, int y) throws RemoteException; 
  public int sub(int x, int y) throws RemoteException;
  public int div(int x, int y) throws RemoteException;
  public int mul(int x, int y) throws RemoteException;
  public int rem(int x, int y) throws RemoteException;
}
