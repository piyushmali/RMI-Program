import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;

public class CalcClient {
	ServerIntf srv;
	
	public CalcClient(String serverURL){
		try {
			srv=(ServerIntf)Naming.lookup(serverURL);
			System.out.println("Connected with " + serverURL);
			//Now we can do whatever with srv
			startConsole();
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			System.out.println("Error while connecting remote rmi server.");
			e.printStackTrace();
		}
	}
	
	void startConsole(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Console Interface Ready..");
		while(true){
			try {
				String cmd=br.readLine();
				if(cmd.equalsIgnoreCase("EXIT")){
					break;
				}else if(cmd.equalsIgnoreCase("TIME")){
					Date d = srv.getCurrentTime();
					System.out.println("Reply: " + d);
					continue;
				}
				//multiple params
				String param[]=cmd.split(" ");
				if(param.length<3){
					System.out.println("Syntax: <OPERATION> <OP1> <OP2>");
					continue;
				}
				double d1= Double.parseDouble(param[1]);
				double d2= Double.parseDouble(param[2]);
				
				if(param[0].equalsIgnoreCase("ADD")){
					System.out.println("Reply: " + srv.add(d1, d2) );
				}else if(param[0].equalsIgnoreCase("SUB")){
					System.out.println("Reply: " + srv.subtract(d1, d2) );
				}else if(param[0].equalsIgnoreCase("MUL")){
					System.out.println("Reply: " + srv.multiply(d1, d2) );
				}else if(param[0].equalsIgnoreCase("DIV")){
					System.out.println("Reply: " + srv.divide(d1, d2) );
				}else{
					System.out.println("Unknow command\n Commands: ADD,MUL,DIV,SUB" );
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}//while
		
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]){
		if(args.length<1){
			System.out.println("Usage: java CalcClient <ServerURL>");
			return;
		}
		String serverURL=args[0];
		new CalcClient(serverURL);
	}
}