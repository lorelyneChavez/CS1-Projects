import java.util.Scanner;

public class MethodActivity5 {
  public static void main (String args[]){
  Scanner scnr = new Scanner(System.in);

    System.out.println("Please input 3 numbers.");
    double avg = 0.0;
    double a = scnr.nextInt();
    double b = scnr.nextInt();
    double c = scnr.nextInt();

    average(a,b,c,avg);
    System.out.print("The average value is: ");
    System.out.println(average(a,b,c, avg));
  }

  public static double average(double a, double b, double c, double avg){
    avg = ((a + b + c)/3);
    return avg;
  }
}
