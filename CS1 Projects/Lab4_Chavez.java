import java.util.Scanner;

public class Lab4_Chavez {
  public static void main(String args[]) {

    Scanner scnr = new Scanner (System.in);

    System.out.println("PLease enter the number of clients.");
    int numClients = scnr.nextInt();

    //Declare all variables needed outside the for loop
    double finalTaxReturn;
    double incomeTaxReturnAvg = 0;
    String histogramLine1 = "";
    String histogramLine2 = "";
    String histogramLine3 = "";
    String histogramLine4 = "";

    //for loop to keep track of clients
    for (int i = 1; i <= numClients; i++) {
      //Asking admin to input all user information
          System.out.println("What is the client number?");
          int clientNumber = scnr.nextInt();

          System.out.println("What is the client's salary?");
          int salary = scnr.nextInt();

          if (salary < 0) {
  	         System.out.println("You've entered an invalid input. Please enter a valid salary.");
  	         salary = scnr.nextInt();
	           }

          double preliminaryTaxReturn;
          if ((salary >= 0) && (salary <= 22000)) {
	           preliminaryTaxReturn = 3000.00;
	           }
          else if ((salary > 22000) && (salary <= 38000)) {
   	           preliminaryTaxReturn = 7500.00;
   	           }
          else if ((salary > 38000) && (salary <= 55000)) {
	           preliminaryTaxReturn = 11000.00;
	           }
          else {
             preliminaryTaxReturn = 16200.00;
             }

          System.out.println("What is your marital status? Pick A, B, or C:");
          System.out.println("A: Single  B: Married  C: Widowed");
          String maritalStatus = scnr.next();
          String kids;

          double f;
          if (maritalStatus.equals("A")) {
                 f = 1.0;
               }
          else if (maritalStatus.equals("B")) {
             System.out.println("Does client " +clientNumber + " have kids? Yes or No?");
                  kids = scnr.next();
                  if (kids.equals("No")) {
                    f = 1.2;
                    }
                  else {
                    f = 1.33;
                    }
                   }
          else {
                 f = 1.42;
               }

          //Computing final tax return for client
          finalTaxReturn = f*preliminaryTaxReturn;
          System.out.println("Client #" + clientNumber+" has a tax return of: "+finalTaxReturn);

          //Gathering information for histogram
          if (finalTaxReturn <= 5000.00) {
            histogramLine1 += '*';
          }
          else if ((finalTaxReturn <= 10000.00) && (finalTaxReturn > 5000)) {
            histogramLine2 += '*';
          }
          else if ((finalTaxReturn <= 15000.00) && (finalTaxReturn > 10000)) {
            histogramLine3 += '*';
          }
          else {
            histogramLine4 += '*';
          }

          //Computing the addition of all final tax returns for all clients
          incomeTaxReturnAvg += finalTaxReturn;

      }
      //Printing average income tax return
      System.out.println("Income Tax Return ($) average is: " + incomeTaxReturnAvg/numClients);
      System.out.println("Today's Tac Return histogram is:");
      System.out.println("$0 - $ 5,000: " +histogramLine1);
      System.out.println("$5,001 - $10,000:" +histogramLine2);
      System.out.println("$10,001 - $15,000:" +histogramLine3);
      System.out.println("Above $15,000:" +histogramLine4);
    }
  }
