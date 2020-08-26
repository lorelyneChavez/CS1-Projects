public class Car {
  String color;
  String make;
  String model;
  String fuelType;
  int currentSpeed;
  String vin;

  //getter for vin
  String getVin(){
    return vin;
  }

  //setter for vin
  void setVin(String s) {
    //is the vin 9 digits?
    //is it suitable for a car?

    vin = s;
  }

  String getColor() {
    return color;
  }

  Car () {
  }

  Car (String c) {
    color = c;
  }

  Car (String m, String c, String model, String v) {
    make = m;
    color = c;
    this.model = model;
    vin = v;
  }

  public void honk(int n) {
    for (int i = 0; i < n; i++)
      System.out.println("Honking");
  }
  public void breaking() {
    currentSpeed--;
  }
  public void accelerate() {
    currentSpeed++;
  }
}
