package Calculator;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author Piyush Mali
 * Date: 10-09-2021
 */
public class CalcClient {
    public static void main(String args[])
    {
        int num1,num2,sum,sub,mul;
        float div;
        Scanner s=new Scanner(System.in);
        System.out.println("Please Enter hte follwing options only\n");
        System.out.println("Enter + for Addition \n");
        System.out.println("Enter - for Subtraction \n");
        System.out.println("Enter * for Multiplication \n");
        System.out.println("Enter / for division \n");
        System.out.println("Enter % for Remainder \n");
        System.out.println("Enter q for Quit \n");
        try
        {
           CalcInterface c=(CalcInterface)Naming.lookup("//localhost/Calcli");
           //basic java program for menu driven
           char choice;
           System.out.println("Enter your opiton\n");
           choice=s.next().charAt(0);
           System.out.println("Enter the first number");
           num1=s.nextInt();
            System.out.println("Enter the second number");
           num2=s.nextInt();
           switch(choice)
           {
               case '+':
                   sum=c.add(num1, num2);
                   System.out.println("Sum of"+num1+"and"+num2+"is="+sum);
                   break;
               case '-':
                   sub=c.sub(num1, num2);
                   
                   break;
               case 'q':
                   System.exit(0);
                   break;
                default:
                    System.err.println("pleas enter only +,-,*,/ or %");
                    break;
                               
           
           }
        }
        catch(Exception e)
        {
            System.err.println("Exception"+e+"Raised");
        }
    }
    
}
