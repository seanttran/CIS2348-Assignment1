import java.util.Scanner;
import java.io.*;
public class Bank {
    public static void main(String[] args) throws IOException {
        //creates new file every time program is restarted
        PrintWriter pw = new PrintWriter("Transactions.txt");
        Scanner input = new Scanner(System.in);
        double bal = 1000.00;
        int counter = 0;
        double n;
        System.out.println("Welcome to CIS-2348 Banking System!");
        while (bal >= 0) {
            FileWriter fwriter = new FileWriter("Transactions.txt", true);
            PrintWriter outfile = new PrintWriter(fwriter);
            File infile = new File("/Users/Sean/IdeaProjects/Assignment-1/Transactions.txt");
            Scanner inp = new Scanner(infile);
            System.out.println("1. Display balance\n2. Deposit amount\n3. Withdraw amount\nEnter your option in a number:");
            String choice = "yes";
            int d = input.nextInt();
            if (d == 1) {
                while (inp.hasNext()) {
                    String summary = inp.nextLine();
                    System.out.println(summary);
                }
                System.out.println("Would you like another transaction(y/n)?");
                choice = input.next();
                if (choice.equals("no")||(choice.equals("n"))){
                    System.exit(0); }
                input.close();
            }
            if (d == 2) {
                counter++;
                System.out.println("How much would you like to deposit?");
                n = input.nextDouble();
                bal = bal + n;
                outfile.println(counter + "       Deposit     " + n + "$   " + bal + "$");
                outfile.close();
                System.out.println("Deposit     " + n + "$" + "   " + bal + "$");
                System.out.println("Would you like another transaction?(y/n)");
                choice = input.next();
                if (choice.equals("no")||(choice.equals("n"))){
                    System.exit(0); }
            }
            if (d == 3) {
                System.out.println("How much would you like to withdraw?");
                n = input.nextDouble();
                if (n > bal) {
                    System.out.println("Transaction cannot be processed due to insufficient funds!"); }
                else {
                    counter++;
                    bal = bal - n;
                    outfile.println(counter + "       Withdraw    " + n + "$   " + bal + "$");
                    outfile.close();
                    System.out.println("Withdraw     " + n + "$" + "   " + bal + "$");
                    System.out.println("Would you like another transaction(y/n)?");
                    choice = input.next();
                    if (choice.equals("no")||(choice.equals("n"))){
                        System.exit(0); }
                }
            }
        }
    }
}







