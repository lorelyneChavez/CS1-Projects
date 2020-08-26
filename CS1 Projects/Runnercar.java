public class RunnerCar{
  public static void main(String args[]){

  Car c1 = new Car();
  c1.color = "Green";
  c1.make = "Ford";
  c1.model = "Mustang";
  c1.fuelType = "Gasoline";
  System.out.println(c1.color);
  System.out.println(c1.make);
  System.out.println(c1.model);
  System.out.println(c1.fuelType);
  System.out.println();

  Car c2 = new Car();
  c2.color = "Red";
  c2.make = "Toyota";
  c2.model = "Prius";
  c2.fuelType = "Electricity";
  System.out.println(c2.color);
  System.out.println(c2.make);
  System.out.println(c2.model);
  System.out.println(c2.fuelType);
  System.out.println();

  Car c3 = new Car();
  c3.color = "Blue";
  c3.make = "Volkswagon";
  c3.model = "Golf";
  c3.fuelType = "Deisel";
  System.out.println(c3.color);
  System.out.println(c3.make);
  System.out.println(c3.model);
  System.out.println(c3.fuelType);
  System.out.println();
  }
}
