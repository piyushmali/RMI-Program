package Calculator;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/*
 * @author Piyush Mali
 * Date: 10-09-2021
*/

public class CalcServer {
    public static void main(String args[])
    {
        try
        {
            Registry r=LocateRegistry.createRegistry(1099);
            r.rebind("Calcli", new CalculatorImp());
            System.out.println("Server Ready...");
        }
        catch(Exception e)
        {
           System.err.println("Server is not connected");
        }
    }
    
}
