package salesLease;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContractDataManagerTest {

    @Test
    void getContract() {
        Contract contract = new SalesContract("20241105", "MrUnicorn", "unicornHorn@rainbowexpress.com", "37846|2021|Chevrolet|Silverado|truck|Black|2750|31995.00", true, 35000, 520);
        System.out.println(contract);
    }
}