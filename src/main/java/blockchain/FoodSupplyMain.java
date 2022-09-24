package blockchain;

import java.math.BigInteger;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;

public class FoodSupplyMain {
	// Contact address been taken from deployed contract

	private static final String CONTRACT_ADDRESS = "0x2C5d71E15aCFC87453f99b0AfE478ba6B5c63415";

	private static final String ADMIN_PRIVATE_KEY = "0x9672eb3e6890371f6cc4e100b3838fec4288c3d765ccd2bc8d8cdf3f0cb978a7";

	public static void main(String[] args) throws Exception {
		
		Web3j web3 = Web3j.build(new HttpService("http://127.0.0.1:8545"));
		
        ContractGasProvider gasProvider;

        gasProvider = new DefaultGasProvider();
        
        //System.out.println(web3.ethGetWork());


        //Accessing to passport service as admin and creating new passport for JOHN_ACCOUNT

        Credentials credentials = Credentials.create(ADMIN_PRIVATE_KEY);
        
        FoodTracker foodtracker = FoodTracker.load(CONTRACT_ADDRESS, web3, credentials, gasProvider);
        
        BigInteger weight = new BigInteger("50");
        BigInteger status = new BigInteger("1"); 
        
        foodtracker.createServiceRequest("2", "2", "2",weight,status).send();
        
        
        
        
        
	}

}
