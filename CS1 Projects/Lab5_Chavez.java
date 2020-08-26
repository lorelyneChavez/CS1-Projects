import java.io.File;
import java.util.Scanner;
public class Lab5_Chavez {

  public static void main (String args []) throws Exception {

    File ufile = new File ("employee.txt");
    Scanner sc = new Scanner (ufile);
    Scanner input = new Scanner (System.in);

    int l = 0;
    String[] fileLine = new String[4];
//Read each line in user.txt
    while (sc.hasNextLine ()) {
      String text = sc.nextLine();

//Store each line of user.txt
    if (l == 0) {fileLine[0] = text;}
    if (l == 1) {fileLine[1] = text;}
    if (l == 2) {fileLine[2] = text;}
    if (l == 3) {fileLine[3] = text;}
      l ++;
    }

//Program Begins
    System.out.println("Welcome to UTEP!");
    System.out.print("\t Username: ");
    String username = input.nextLine();
    System.out.print("\t Password: ");
    String password = input.nextLine();

//Check if credentials are correct using a for loop
    for (int i = 0; i < 2; i++) {
      System.out.println("");
        if ((username.equals(fileLine[0]) && password.equals(fileLine[1]))) {
          break;
          }
        else if ((username.equals(fileLine[2]) && password.equals(fileLine[3]))) {
          break;
          }
        else {
          System.out.println("Welcome to Utep!");
          System.out.println("Sorry, you have entered invalid credentials. Try again.");
          System.out.print("\t Username: ");
          username = input.nextLine();
          System.out.print("\t Password: ");
          password = input.nextLine();
          }
      }
    if (!((username.equals(fileLine[0]) && password.equals(fileLine[1])) || (username.equals(fileLine[2]) && password.equals(fileLine[3])))) {
      System.out.println("");
      System.out.print("Sorry, you are temporarily blocked from the platform. ");
      System.out.println("Please try again in a couple of hours.");
      System.exit(0);
      }
      
//Credentials were successful
    System.out.println("Welcome " + username + "!");
    System.out.println("Menu:");
    System.out.println("\t 1. Account");
    System.out.println("\t 2. Payroll");
    System.out.println("\t 3. Attendance Report");
    System.out.println("\t 4. Service Desk");
    String choice = input.nextLine();

    if ((choice.equalsIgnoreCase("Account")) || (choice.equals("1"))) {
      System.out.println("Welcome to Account!");
      }
    else if ((choice.equalsIgnoreCase("Payroll")) || (choice.equals("2"))) {
      System.out.println("Welcome to Payroll!");
      }
    else if ((choice.equalsIgnoreCase("Attendance Report")) || (choice.equals("3"))) {
      System.out.println("Welcome to Attendance Report!");
      }
    else if ((choice.equalsIgnoreCase("Service Desk")) || (choice.equals("4"))) {
      System.out.println("Welcome to Service Desk!");
      }
    else {
      System.out.println("Sorry, you have entered an invalid option.");
    }

    }
  }
