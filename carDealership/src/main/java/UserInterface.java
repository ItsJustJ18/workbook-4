
import java.util.List;
import java.util.Scanner;


public class UserInterface {

    //String decision is used to determine the userInput
    public static String decision;

    //Scanner for the program to determine userInput
    Scanner user = new Scanner(System.in);

    static final DealershipFileManager DEALERSHIP_FILE_MANAGER = new DealershipFileManager();
    static Dealership dealership;


    //if the boolean is true, dealerScreen keeps going
    boolean prevent_leave = true;

    private void init() {
        dealership = DEALERSHIP_FILE_MANAGER.getDealership();
    }

    public void dealerScreen() {

        //run init method to set up the dealership for the app
        init();

        System.out.println(dealership);


        while (prevent_leave) {

            System.out.print("""
                    FindYourCar Dealership
                    তততততততততততততততত
                    
                    Welcome, how can we help you find your car today?
                    
                    1)Find a car by Price
                    2)Find a car by the Make and Model
                    3)Find a car by the Year
                    4)Find a car by the Color
                    5)Find a car based on the mileage
                    6)Find a car by the Type (Sedan, Muscle, Truck, SUV,....etc)
                    7)See all cars we have available to offer
                    8)Admin Menu
                    9)Exit the Program
                    
                    """);
            decision = user.nextLine();
            Vehicle vehicle = new Vehicle();

            int min;
            int max;


            switch (decision) {
                //if user wants a vehicle no matter the type between a certain price range
                case "1":
                    //sout text block (follow the workbook)
                    //Return method to the switch case
                    //Break

                    min = Integer.parseInt(promptUser("Enter min price"));
                    max = Integer.parseInt(promptUser("Enter max price"));
                    carPrice(min, max);
                    System.out.println(" Please enter a minimum and maximum amount that you will spend on a car. ");
                    break;

                case "2":
                    //user wants a specific make and model
                    System.out.println(" Enter a make for desired car. ");
                    String make = user.nextLine();
                    System.out.println(" Enter a model for desired car. ");
                    String model = user.nextLine();
                    makeAndModel(make,model);
                    break;

                case "3":
                    //user wants a car within a specific range
                    System.out.println(" Enter minimum and maximum years you're interested in");
                     min = Integer.parseInt(promptUser("Enter min year:"));
                     max = Integer.parseInt(promptUser("Enter max year:"));
                    byYear(min, max);
                    break;

                case "4":
                    //user wants a specific color
                    String color = promptUser("What color are you looking for?");
                    colorWanted(color);
                    break;

                case "5":
                    //user wants a set minimum number of mileage and maximum number
                    System.out.println(" Enter the minimum and maximum amount of mileage for a car. ");
                     min = Integer.parseInt(promptUser("Enter min mileage"));
                     max = Integer.parseInt(promptUser("Enter max mileage"));
                    mileageOnCar(min, max);


                    break;

                case "6":
                    //user wants to enter a vehicle type of their choice
                    String type = promptUser(" Enter a car type you would like to see. ");
                    placeCarType(type);
                    break;

                case "7":
                    //prints out the whole dealership
                    System.out.println(dealership);
                    break;

                case "8":
                    adminMenu();
                    break;

                case "9":
                    //Exit Code 0
                    System.out.println(" Exiting Program ");
                    prevent_leave = false;
                    break;

                default:
                    //if the user decides to input an option that isn't available
                    System.out.println(" The input you have provided is incorrect, please try a valid input. ");
                    break;
            }
        } // ends out while loop
    }

    private void byYear(int min, int max) {

        List<Vehicle> results = dealership.getVehiclesByYear(min, max);

       displayVehicles(results);


    }

    public void carPrice(int min, int max) {
        List<Vehicle> results = dealership.getVehiclesByPrice(min, max);
         displayVehicles(results);
    }

    public void mileageOnCar(int min, int max) {
       List<Vehicle> results = dealership.getVehiclesByOdometer(min,max);
       displayVehicles(results);
    }

    public void placeCarType(String type) {
     List<Vehicle> results = dealership.getVehiclesByType(type);
           displayVehicles(results);

    }
    public void colorWanted(String color) {
        List<Vehicle> results = dealership.getVehiclesByColor(color) ;
           displayVehicles(results);
    }

        public void makeAndModel(String make, String model){
         List<Vehicle> results =  dealership.getVehiclesByMakeAndModel(make,model);
         displayVehicles(results);
        }


        // these are our helper methods.
// helps us by allowing us to pass in the print we cant the user to see and return the value they input
    private String promptUser(String prompt){
        System.out.println(prompt);
        return user.nextLine();

    }

    //this method allows us to check to see if a query or a request yields a result (aka an arraylist of vehicles)
    //if it doesn't it print our a notification and  if it does it, prints out the vehicles
    public void displayVehicles(List<Vehicle> cars){

        if(cars.isEmpty()){
            System.out.println("Sorry!No cars fit that description");
        } else {
            for (Vehicle vehicle :cars) {
                System.out.println(vehicle);
            }
        }
    }

    private void adminMenu(){
        String adminPasscode = "CarSales";
        String codeFromUser = promptUser("Please enter passcode");
        boolean passed = true;
        if(adminPasscode.equalsIgnoreCase(codeFromUser)){

                addOrRemoveCarMenu();
                passed = false;

        }

    }

    private void addOrRemoveCarMenu(){
        System.out.println("1) Add car");
        System.out.println("2) Remove Car");

        int choice = Integer.parseInt(promptUser("Would you like to add or remove a car?"));

        switch (choice){
            case 1:
                // add in car info
                dealership.addVehicles(addVehicleInfo());
                DEALERSHIP_FILE_MANAGER.saveDealership(dealership);
                break;

            case 2:
                int vinNo = Integer.parseInt(promptUser("Whats the vin of the vehicle yould like to remove?"));

                List<Vehicle> cars = dealership.getAllVehicles();
                for(Vehicle v:cars){

                    if (v.getVin() == vinNo){
                        dealership.removeVehicle(v);
                        break; //breaks out of if statement once we find car
                    }
                }
               DEALERSHIP_FILE_MANAGER.saveDealership(dealership);
                break; //breaks out of switch case
        }



    }
    public Vehicle addVehicleInfo(){
        //set and requesting input from the user in order to add the vehicle to file

        Vehicle newV = new Vehicle();
        int vin = Integer.parseInt(promptUser(" Enter vehicle vin "));
        newV.setVin(vin);

        int year = Integer.parseInt(promptUser(" Enter year "));
        newV.setYear(year);

        String make = (promptUser(" Enter make of vehicle "));
        newV.setMake(make);

        String model = promptUser(" Enter model of vehicle ");
        newV.setModel(model);

        String vehicleType = promptUser(" Enter the type of the vehicle ");
        newV.setVehicleType(vehicleType);

        String color = promptUser(" Enter the color of the vehicle ");
        newV.setColor(color);

        int odometer = Integer.parseInt(promptUser(" Enter the mileage for the vehicle "));
        newV.setOdometer(odometer);

        double price = Double.parseDouble(promptUser(" Enter the price of the vehicle (in whole numbers) "));
        newV.setPrice(price);

        return newV;

    }

}
