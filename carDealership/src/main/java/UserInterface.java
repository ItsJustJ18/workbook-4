
import java.util.Scanner;


public class UserInterface {
    //String decision is used to determine the userInput
    public static String decision;
    //Scanner for the program to determine userInput
    Scanner user =  new Scanner(System.in);

    static final DealershipFileManager DEALERSHIP_FILE_MANAGER = new DealershipFileManager();
    static Dealership dealership;

    private void init() {
        dealership = DEALERSHIP_FILE_MANAGER.getDealership();
    }

    public void dealerScreen() {

        //run init method to set up the dealership for the app
        init();

        System.out.println(dealership);

        boolean prevent_leave = true;
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
                //user wants a specific year
                System.out.println(" Enter a year for the car you would like. ");
                break;
            case "4":
                //user wants a specific color
                System.out.println(" Enter a color you would like your car. ");
                break;
            case "5":
                //user wants a set minimum number of mileage and maximum number
                System.out.println(" Enter the minimum and maximum amount of mileage for a car. ");
                break;
            case "6":

                placeCarType();
                System.out.println(" Enter a car type you would like to see. ");
                break;
            case "7":
                System.out.println(dealership);
            default:
                System.out.println(" The input you have provided is incorrect, please try a valid input. ");
                break;
        }
    }
    public void placeCarType() {
        //for (Vehicle vehicle)

    }
    public void carPrice() {


    }
}