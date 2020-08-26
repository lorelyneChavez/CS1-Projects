public class Recursion {
  public static void main (String args[]) {

    hello(10);
  }
  public static void hello (int n) {
    if (n<=0)
      return;
    System.out.println("Hello!");
    hello(n-1);
  }

}
