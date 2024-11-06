package salesLease;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class ContractDataManager {

    //getting contract from csv file
    public final String contractReader = "src/main/java/resources/contract.csv";


    //Display contract readings from contract file
    ArrayList<Contract> contracts;


    public void getContract() {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(contractReader));

            String line;
            while (true) {
                if ((line = bufferedReader.readLine()) == null) {
                    break;
                }

                if (line.startsWith("S")) {
                    String[] lineArr = line.split("\\|");

                    Contract contractFromFile = new SalesContract(
                            lineArr[0], lineArr[1], lineArr[2], lineArr[3], Boolean.parseBoolean(lineArr[4]), Double.parseDouble(lineArr[5]), Double.parseDouble(lineArr[6])
                    );
                    contracts.add(contractFromFile);

                } else if (line.startsWith("L")) {
                    String[] lineArr = line.split("\\|");

                    Contract contractFromFile = new LeaseContract(
                            lineArr[0], lineArr[1], lineArr[2], lineArr[3], Double.parseDouble(lineArr[4]), Double.parseDouble(lineArr[5])
                    );

                    contracts.add(contractFromFile);
                } else {
                    System.out.println(" Unrecognized contract identified. Make sure it's either a Sale or Lease contract. ");
                }
            }

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        System.out.println(contracts);
    }

    public void saveContract(Contract contract) {
        //after we get the file to be written, we want it to save to our contract
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/java/resources/contract.csv"));
            bufferedWriter.write(contract.getDate() + "|" + contract.getCustomerName() + "|" + contract.getCustomerEmail()  + "|" + contract.getVehicleSold() + "|" + contract.getTotalPrice()  + "|" + contract.getMonthlyPayment());

            for (Contract v : contract.getAllContracts()) {
                bufferedWriter.write("\n");
                bufferedWriter.write(v.getDate() + "|" + v.getCustomerName() + "|" + v.getCustomerEmail() + "|" + v.getVehicleSold() + "|" + v.getTotalPrice() + "|" + v.getMonthlyPayment());
            }
            System.out.println(contract);
            bufferedWriter.close();

        } catch (Exception exp) {
            System.out.println(exp.getLocalizedMessage());
        }
    }
}



