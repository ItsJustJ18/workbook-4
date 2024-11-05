import salesLease.Contract;

import java.io.*;

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
         //after we get the file to be written, we want it to save to our dealership
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(mcQueen));
            bufferedWriter.write(dealership.getName()+"|"+dealership.getAddress()+"|"+dealership.getPhoneNumber());

            for(Vehicle v: dealership.getAllVehicles()){
                bufferedWriter.write("\n");
                bufferedWriter.write(v.getVin()+"|"+v.getYear()+"|"+v.getMake()+"|"+v.getModel()+"|"+v.getVehicleType()+"|"+v.getColor()+"|"+v.getOdometer()+"|"+v.getPrice());
            }
            System.out.println(dealership);
            bufferedWriter.close();

        } catch (Exception exp) {
            System.out.println(exp.getLocalizedMessage());
        }
    }
}




