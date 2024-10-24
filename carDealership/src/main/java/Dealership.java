import java.util.ArrayList;
import java.util.List;

public class Dealership {
    //global variable for the user from the programmer
   // String user;
    //Dealership is represented as name, address, and phoneNumber
    private String name;
    private String address;
    private String phoneNumber;

    //Get Arraylist of cars from the inventory csv file
    public ArrayList<Vehicle> inventory;

    //"mcQueen" is the shortcut containing the src file for inventory file
   // public static final String mcQueen = "src/main/resources/inventory.csv";
public Dealership(){

}

    public Dealership(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void addVehicles(Vehicle vehicle) {
        inventory.add(vehicle);

}

public void removeVehicle(Vehicle v){
    inventory.remove(v);
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max){
    List<Vehicle> byPrice = new ArrayList<>();

    //logic as needed

        for(Vehicle v: inventory){
            if(v.price < max && v.price > min){
                byPrice.add(v);
            }
        }


    return byPrice;

    }

    public List<Vehicle> getVehiclesByMakeAndModel(String make, String model){
        List<Vehicle> byMandM = new ArrayList<>();

        //logic as needed


        return byMandM;

    }
    public List<Vehicle> getVehiclesByYear(int min, int max){
        List<Vehicle> byYear = new ArrayList<>();

        //logic as needed


        return byYear;

    }
    public List<Vehicle> getVehiclesByColor(String color){
        List<Vehicle> byColor = new ArrayList<>();

        //logic as needed


        return byColor;

    }
    public List<Vehicle> getVehiclesByOdometer(int min, int max){
        List<Vehicle> byOdometer = new ArrayList<>();

        //logic as needed


        return byOdometer;

    }
    public List<Vehicle> getVehiclesByType(String vehicleType){
        List<Vehicle> byvehicleType = new ArrayList<>();

        //logic as needed


        return byvehicleType;

    }

    public List<Vehicle> getAllVehicles(){
    return this.inventory;
    }

}
