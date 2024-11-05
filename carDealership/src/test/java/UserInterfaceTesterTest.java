import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;

class UserInterfaceTesterTest {

    Scanner scanner = new Scanner(System.in);

    //testDealerScreenDisplaysCorrectly
    @org.junit.jupiter.api.Test

    void dealerScreen() {
        UserInterfaceTester userInterfaceTester = new UserInterfaceTester();
        userInterfaceTester.dealerScreen();
        System.setIn(System.in);
    }

    //testCarPriceDisplaysCorrectAmount
    @org.junit.jupiter.api.Test
    void carPrice() {
    }

    //testMileageAbleToBeFound
    @org.junit.jupiter.api.Test
    void mileageOnCar() {
    }

    //testCarTypeCanBeFound
    @org.junit.jupiter.api.Test
    void placeCarType() {
    }

    //testColorDisplaysCorrectly
    @org.junit.jupiter.api.Test
    void colorWanted() {
    }

    //testMakeAndModelCanBeFound
    @org.junit.jupiter.api.Test
    void makeAndModel() {
    }

    //testVehiclesDisplayCorrectly
    @org.junit.jupiter.api.Test
    void displayVehicles() {
    }

    //testVehiclesCanBeAdded
    @org.junit.jupiter.api.Test
    void addVehicleInfo() {
    }
}