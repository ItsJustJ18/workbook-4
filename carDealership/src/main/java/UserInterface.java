
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
                    8)Exit the Program
                    
                    """);
            decision = user.nextLine();
            Vehicle vehicle = new Vehicle();


        }
        switch (decision) {
            //if user wants a vehicle no matter the type between a certain price range
            case "1":
                //sout text block (follow the workbook)
                //Return method to the switch case
                //Break
                System.out.println(" Please enter a minimum and maximum amount that you will spend on a car. ");
                break;

            case "2":
                //user wants a specific make and model
                System.out.println(" Enter a make for desired car. ");
                String make = user.nextLine();
                System.out.println(" Enter a model for desired car. ");
                String model = user.nextLine();
                break;

            case "3":
                //user wants a year
                System.out.println(" Enter a year to year of what you want in between for a car. ");
                break;

            case "4":
                //user wants a specific color
                System.out.println(" Enter a color you would like your car. ");
                break;

            case "5":
                //user wants a set minimum number of mileage and maximum number
                mileageOnCar(user.nextInt());
                System.out.println(" Enter the minimum and maximum amount of mileage for a car. ");
                break;

            case "6":
                //user wants to enter a vehicle type of their choice
                placeCarType();
                System.out.println(" Enter a car type you would like to see. ");
                break;

            case "7":
                //prints out the whole dealership
                System.out.println(dealership);
                break;

            case "8":
                //Exit Code 0
                System.out.println(" Exiting Program ");
                prevent_leave = false;
                break;

            default:
                //if the user decides to input an option that isn't available
                System.out.println(" The input you have provided is incorrect, please try a valid input. ");
                break;
        }
    }

    private void mileageOnCar(int min, int max) {
        for (Vehicle vehicle : dealership.getVehiclesByOdometer()) {
            if (vehicle.getOdometer() > min && vehicle.getOdometer() < max) {
                System.out.println(dealership);
            }
        }
    }

    public void placeCarType() {
        for (Vehicle vehicle : dealership.getVehiclesByType()) {
            System.out.println(" Here's your car type requested \n" + vehicle);
        }
            System.out.println(dealership);

    }
}
