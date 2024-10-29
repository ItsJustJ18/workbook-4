
import java.util.Scanner;


public class UserInterface {
    //String decision is used to determine the userInput
    public static String decision;
    //Scanner for the program to determine userInput
    static Scanner userInput;

    public static void main(String[] args) {
        //Using a while loop in order to send user through screens and options

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

            decision = userInput.nextLine();
        }
        switch (decision) {
            //if user wants a vehicle no matter the type between a certain price range
            case 1:
                decision = "1";
                System.out.println(" Please enter a minimum and maximum amount that you will spend on a car. ");
                double carPrice = Double.parseDouble(userInput.nextLine());
                System.out.print(" Here are the vehicles that are in your requested price range: ");

                break;
            case 2:

                decision = "2";
                System.out.println(" Enter a year for the car you would like. ");
                int carYear = int.
                System.out.println("The vehicles below are what meets your needs: ");
                System.out.print(carYear);
                break;

            case 3:
                decision = "3";
                System.out.println(" ");


            default:
                System.out.println(" The input you have provided is incorrect, please try a valid input. ");
                break;
        }

    }
}
