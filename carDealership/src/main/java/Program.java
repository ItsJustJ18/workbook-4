public class Program {

    static final DealershipFileManager  DEALERSHIP_FILE_MANAGER = new DealershipFileManager();
    static Dealership dealership;

    public static void main(String[] args) {

        //run init method to set up the dealership for the app
        init();

        System.out.println(dealership);

    }



private static void init(){
        dealership = DEALERSHIP_FILE_MANAGER.getDealership();
}


}
