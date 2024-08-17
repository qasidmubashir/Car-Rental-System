import java.util.ArrayList;
import java.util.Scanner;

class Car{
    private String carID;
    private String brand;
    private String model;
    private double baseRentPerDay;
    private boolean isAvailable;  //if car is available for rent

  public Car(String carID, String brand, String model, double baseRentPerDay){
      this.carID = carID;
      this.brand = brand;
      this.model = model;
      this.baseRentPerDay = baseRentPerDay;
      this.isAvailable = true;

  }

  public String getCarID(){
      return carID;
  }
  public String getBrand(){
        return brand;
    }
  public String getModel(){
        return model;
    }


    public double calculatePrice(int rentalDays){
      return baseRentPerDay * rentalDays;
    }

    public boolean isAvailable(){
      return isAvailable;
    }

    public void rent(){
      isAvailable = false;
    }

    public void returnCar(){
      isAvailable = true;
    }
}


class Customer{
    private String customerID;
    private String name;


    public Customer(String customerID, String name){
        this.customerID = customerID;
        this.name = name;
    }

    public String getCustomerID(){
        return customerID;
    }
    public String getName(){
        return name;
    }
}


class Rental{
    private Car car;
    private Customer customer;
    private int days;

    public Rental(Car car, Customer customer, int days){
        this.car = car;
        this.customer = customer;
        this.days = days;
    }

    public Car getCar(){
        return car;
    }

    public Customer getCustomer(){
        return customer;
    }

    public int getDays(){
        return days;
    }
}

class CarRentalSystem{
   private ArrayList<Car> cars;
   private ArrayList<Customer> customers;
   private ArrayList<Rental> rentals;

   public CarRentalSystem(){
       cars = new ArrayList<>();
       customers = new ArrayList<>();
       rentals = new ArrayList<>();
   }

   public void addCar(Car car){
       cars.add(car);
   }


   public void addCustomer(Customer customer){
       customers.add(customer);
   }

   public void rentCar(Car car, Customer customer, int days){
      if(car.isAvailable()){
          car.rent();
          rentals.add(new Rental(car,customer,days));
      }
      else{
          System.out.println("Sorry, Car is not available for rent");
      }
    }

    public void returnCar(Car car){
       Rental rentalToRemove = null;
       for(Rental rental : rentals){
           if(rental.getCar() == car){
               rentalToRemove = rental;
               break;
           }
       }

       if(rentalToRemove != null){
           rentals.remove(rentalToRemove);
           car.returnCar();
//           System.out.println("Car returned successfully");
       }
       else{
           System.out.println("Car was nor rented");
       }
    }

    public void menu(){
       Scanner scanner = new Scanner(System.in);

       while(true) {
           System.out.println("===== CAR RENTAL SYSTEM =====");
           System.out.println("1. Rent a car");
           System.out.println("2. Return a car");
           System.out.println("3. Exit");
           System.out.println("Enter your choice:");


           int choice = scanner.nextInt();
           scanner.nextLine(); //consume next line

           if (choice == 1) {
               System.out.println("\n=== Rent a car ===\n");
               System.out.println("Enter your name: ");
               String customerName = scanner.nextLine();

               System.out.println("Available Cars");
               for (Car car : cars) {
                   if (car.isAvailable()) {
                       System.out.println(car.getCarID() + " - " + car.getBrand() + " - " + car.getModel());
                   }
               }

               System.out.println("\nEnter the carID you want to rent: ");
               String carID = scanner.nextLine();

               System.out.println("Enter the number of days of rental: ");
               int rentalDays = scanner.nextInt();
               scanner.nextLine();

               Customer newCustomer = new Customer("CUS" + (customers.size() + 1), customerName);
               addCustomer(newCustomer);

               Car selectedCar = null;
               for (Car car : cars) {
                   if (car.getCarID().equals(carID) && car.isAvailable()) {
                       selectedCar = car;
                       break;
                   }
               }

               if (selectedCar != null) {
                   double totalPrice = selectedCar.calculatePrice(rentalDays);
                   System.out.println("\n === Rental Information ===\n");
                   System.out.println("CustomerID: " + newCustomer.getCustomerID());
                   System.out.println("Customer Name: " + newCustomer.getName());
                   System.out.println("Car: " + selectedCar.getBrand() + " " + selectedCar.getModel());
                   System.out.println("Rental days: " + rentalDays);
                   System.out.printf("Total Price: $%.2f%n", totalPrice);

                   System.out.println("\nConfirm rental (Y/N):  ");
                   String confirm = scanner.nextLine();

                   if (confirm.equalsIgnoreCase("Y")) {
                       rentCar(selectedCar, newCustomer, rentalDays);
                       System.out.println("\nCar rented Successfully");
                   } else {
                       System.out.println("\nRental cancelled");
                   }
               } else {
                   System.out.println("Invalid car selection or car not available for rent");
               }
           } else if (choice == 2) {
               System.out.println("\n== Return a Car ==\n");
               System.out.print("Enter the car ID you want to return: ");
               String carId = scanner.nextLine();

               Car carToReturn = null;
               for (Car car : cars) {
                   if (car.getCarID().equals(carId) && !car.isAvailable()) {
                       carToReturn = car;
                       break;
                   }
               }

               if (carToReturn != null) {
                   Customer customer = null;
                   for (Rental rental : rentals) {
                       if (rental.getCar() == carToReturn) {
                           customer = rental.getCustomer();
                           break;
                       }
                   }

                   if (customer != null) {
                       returnCar(carToReturn);
                       System.out.println("Car returned successfully by " + customer.getName());
                   } else {
                       System.out.println("Car was not rented or rental information is missing.");
                   }
               } else {
                   System.out.println("Invalid car ID or car is not rented.");
               }
           } else if (choice == 3) {
               break;
           } else {
               System.out.println("Invalid choice. Please enter a valid option.");
           }
       }
        System.out.println("\nThank you for using the Car Rental System!");
    }
}



public class main {
    public static void main(String[] args) {
        CarRentalSystem rentalSystem = new CarRentalSystem();

        Car car1 = new Car("C001", "Toyota", "Camry", 60.0); // Different base price per day for each car
        Car car2 = new Car("C002", "Honda", "Accord", 70.0);
        Car car3 = new Car("C003", "Mahindra", "Thar", 150.0);
        rentalSystem.addCar(car1);
        rentalSystem.addCar(car2);
        rentalSystem.addCar(car3);

        rentalSystem.menu();
    }}
