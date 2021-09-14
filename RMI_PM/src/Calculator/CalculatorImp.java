package Calculator;
import java.rmi.RemoteException;
import java.rmi.server.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/*
 * @author Piyush Mali
 * Date: 10-09-2021
*/ 

public class CalculatorImp extends UnicastRemoteObject implements CalcInterface {
    public CalculatorImp() throws RemoteException
    {
    }
    @Override
    public int add(int x, int y) throws RemoteException {
       return(x+y); 
    }
    @Override
    public int sub(int x, int y) throws RemoteException {
      return(x-y);
    }
    @Override
    public int mul(int x, int y) throws RemoteException {
     return(x*y);
    }
    @Override
    public int div(int x, int y) throws RemoteException {
    return(x/y);
    }

    @Override
    public int rem(int x, int y) throws RemoteException {
        return(x%y);
    }

}
