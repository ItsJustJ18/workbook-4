import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DealershipFileManager {

     public static final String mcQueen = "src/main/resources/inventory.csv";

     public DealershipFileManager(){


     }

    public Dealership getDealership() {

        Dealership dealership = new Dealership();

        //read from CSV file;
        try  {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(mcQueen));

            String line;
            while((line = bufferedReader.readLine()) != null){

                if(line.startsWith("D")) {
                   String[] titleArr = line.split("\\|");

                   dealership.setName(titleArr[0]);
                   dealership.setAddress(titleArr[1]);
                   dealership.setPhoneNumber(titleArr[2]);

                } else {
                    String[] lineArr = line.split("\\|");

                    Vehicle vehicleFromFile = new Vehicle();
                    vehicleFromFile.setVin(Integer.parseInt(lineArr[0]));
                    vehicleFromFile.setYear(Integer.parseInt(lineArr[1]));
                    vehicleFromFile.setMake(lineArr[2]);
                    vehicleFromFile.setModel(lineArr[3]);
                    vehicleFromFile.setVehicleType(lineArr[4]);
                    vehicleFromFile.setColor(lineArr[5]);
                    vehicleFromFile.setOdometer(Integer.parseInt(lineArr[6]));
                    vehicleFromFile.setPrice(Double.parseDouble(lineArr[7]));

                  dealership.getAllVehicles().add(vehicleFromFile);

                }


            }
            bufferedReader.close();

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }


        return dealership;
    }

    public void saveDealership(Dealership dealership) {



    }



}
