import java.util.Scanner;

public class Lab3_Chavez {
  public static void main(String args[]) {

    Scanner scnr = new Scanner (System.in);

    System.out.println("What is your current annual salary?");
    int salary = scnr.nextInt();

    System.out.println("What is your annual performance rating?");
    System.out.println("Excellent, Good, or Poor?");
    String rating = scnr.next();

    int num;
    double percentRaise;

    if (rating.equals("Excellent")) {
      num = 1;
      percentRaise = 6.0;
    }
    else if (rating.equals("Good")) {
      num = 2;
      percentRaise = 4.0;
    }
    else {
      num = 3;
      percentRaise = 1.5;
    }

    percentRaise = (percentRaise/100)*salary;
    double updatedSalary = salary + percentRaise;

    System.out.print("Congratulations! Your new salary is $"+updatedSalary);
    System.out.print(" that includes a raise of $"+percentRaise+ ", based on");
    System.out.print(" your annual performance rating as \""+rating+"\".");

  }

}
