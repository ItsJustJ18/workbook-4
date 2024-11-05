package salesLease;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ContractDataManager {

    //getting contract from csv file
    public final String contractReader = "src/main/java/resources/contract.csv";


    //Display contract readings from contract file
    ArrayList<Contract> contracts;

    public void saveContract(Contract contract) {
    }

    public Contract getContract() {

        Contract contract = new Contract() {
        try

            {
                BufferedReader bufferedReader = new BufferedReader(contractReader));

                String line;
                while (true) {
                    try {
                        if (!((line = bufferedReader.readLine()) != null)) break;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    if (line.startsWith("S")) {
                        String[] titleArr = line.split("\\|");

                        contract.setDate(titleArr[0]);
                        contract.setCustomerName(titleArr[1]);
                        contract.setCustomerEmail(titleArr[2]);

                    } else {
                        String[] lineArr = line.split("\\|");

                        Contract contractFromFile = new Contract() {

                        }
                        {

                            contractFromFile.setDate((lineArr[0]));
                            contractFromFile.setCustomerName((lineArr[1]));
                            contractFromFile.setCustomerEmail(lineArr[2]);
                            contractFromFile.setVehicleSold(lineArr[3]);
                            contractFromFile.setTotalPrice(Integer.parseInt(lineArr[4]));
                            contractFromFile.setMonthlyPayment(Integer.parseInt(lineArr[5]));

                            contract.getAllContracts().add(contractFromFile);

                        }

                    }


                }
                catch(Exception e){
                System.out.println(e.getLocalizedMessage());
            }


            }
        }

    }
}