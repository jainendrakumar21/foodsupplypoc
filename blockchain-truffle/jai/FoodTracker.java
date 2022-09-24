package jai;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple5;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class FoodTracker extends Contract {
    public static final String BINARY = "0x6080604052600160005534801561001557600080fd5b50610db9806100256000396000f3fe608060405234801561001057600080fd5b50600436106100625760003560e01c80631b7fe6b614610067578063557217f8146100855780635d1ca631146100b5578063b74defed146100d3578063cb2ba12e146100ef578063f753e8b01461011f575b600080fd5b61006f610153565b60405161007c9190610543565b60405180910390f35b61009f600480360381019061009a91906106b8565b610159565b6040516100ac9190610543565b60405180910390f35b6100bd610187565b6040516100ca9190610543565b60405180910390f35b6100ed60048036038101906100e89190610752565b6101a4565b005b610109600480360381019061010491906106b8565b610317565b6040516101169190610543565b60405180910390f35b61013960048036038101906101349190610821565b61033f565b60405161014a959493929190610944565b60405180910390f35b60005481565b6002818051602081018201805184825260208301602085012081835280955050505050506000915090505481565b600080600081548092919061019b906109db565b91905055905090565b600060405180606001604052804281526020018481526020018360078111156101d0576101cf6108cd565b5b815250905060006101e087610317565b90506000808211156102155760018281548110610200576101ff610a23565b5b90600052602060002090600602019050610237565b6001808160018154018082558091505003906000526020600020906006020190505b878160010190816102489190610c5e565b508681600201908161025a9190610c5e565b508581600301908161026c9190610c5e565b50838160040160006101000a81548160ff02191690836007811115610294576102936108cd565b5b021790555080600501839080600181540180825580915050600190039060005260206000209060030201600090919091909150600082015181600001556020820151816001015560408201518160020160006101000a81548160ff02191690836007811115610306576103056108cd565b5b021790555050505050505050505050565b60006002826040516103299190610d6c565b9081526020016040518091039020549050919050565b6001818154811061034f57600080fd5b906000526020600020906006020160009150905080600001549080600101805461037890610a81565b80601f01602080910402602001604051908101604052809291908181526020018280546103a490610a81565b80156103f15780601f106103c6576101008083540402835291602001916103f1565b820191906000526020600020905b8154815290600101906020018083116103d457829003601f168201915b50505050509080600201805461040690610a81565b80601f016020809104026020016040519081016040528092919081815260200182805461043290610a81565b801561047f5780601f106104545761010080835404028352916020019161047f565b820191906000526020600020905b81548152906001019060200180831161046257829003601f168201915b50505050509080600301805461049490610a81565b80601f01602080910402602001604051908101604052809291908181526020018280546104c090610a81565b801561050d5780601f106104e25761010080835404028352916020019161050d565b820191906000526020600020905b8154815290600101906020018083116104f057829003601f168201915b5050505050908060040160009054906101000a900460ff16905085565b6000819050919050565b61053d8161052a565b82525050565b60006020820190506105586000830184610534565b92915050565b6000604051905090565b600080fd5b600080fd5b600080fd5b600080fd5b6000601f19601f8301169050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b6105c58261057c565b810181811067ffffffffffffffff821117156105e4576105e361058d565b5b80604052505050565b60006105f761055e565b905061060382826105bc565b919050565b600067ffffffffffffffff8211156106235761062261058d565b5b61062c8261057c565b9050602081019050919050565b82818337600083830152505050565b600061065b61065684610608565b6105ed565b90508281526020810184848401111561067757610676610577565b5b610682848285610639565b509392505050565b600082601f83011261069f5761069e610572565b5b81356106af848260208601610648565b91505092915050565b6000602082840312156106ce576106cd610568565b5b600082013567ffffffffffffffff8111156106ec576106eb61056d565b5b6106f88482850161068a565b91505092915050565b61070a8161052a565b811461071557600080fd5b50565b60008135905061072781610701565b92915050565b6008811061073a57600080fd5b50565b60008135905061074c8161072d565b92915050565b600080600080600060a0868803121561076e5761076d610568565b5b600086013567ffffffffffffffff81111561078c5761078b61056d565b5b6107988882890161068a565b955050602086013567ffffffffffffffff8111156107b9576107b861056d565b5b6107c58882890161068a565b945050604086013567ffffffffffffffff8111156107e6576107e561056d565b5b6107f28882890161068a565b935050606061080388828901610718565b92505060806108148882890161073d565b9150509295509295909350565b60006020828403121561083757610836610568565b5b600061084584828501610718565b91505092915050565b600081519050919050565b600082825260208201905092915050565b60005b8381101561088857808201518184015260208101905061086d565b60008484015250505050565b600061089f8261084e565b6108a98185610859565b93506108b981856020860161086a565b6108c28161057c565b840191505092915050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602160045260246000fd5b6008811061090d5761090c6108cd565b5b50565b600081905061091e826108fc565b919050565b600061092e82610910565b9050919050565b61093e81610923565b82525050565b600060a0820190506109596000830188610534565b818103602083015261096b8187610894565b9050818103604083015261097f8186610894565b905081810360608301526109938185610894565b90506109a26080830184610935565b9695505050505050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b60006109e68261052a565b91507fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff8203610a1857610a176109ac565b5b600182019050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052603260045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b60006002820490506001821680610a9957607f821691505b602082108103610aac57610aab610a52565b5b50919050565b60008190508160005260206000209050919050565b60006020601f8301049050919050565b600082821b905092915050565b600060088302610b147fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff82610ad7565b610b1e8683610ad7565b95508019841693508086168417925050509392505050565b6000819050919050565b6000610b5b610b56610b518461052a565b610b36565b61052a565b9050919050565b6000819050919050565b610b7583610b40565b610b89610b8182610b62565b848454610ae4565b825550505050565b600090565b610b9e610b91565b610ba9818484610b6c565b505050565b5b81811015610bcd57610bc2600082610b96565b600181019050610baf565b5050565b601f821115610c1257610be381610ab2565b610bec84610ac7565b81016020851015610bfb578190505b610c0f610c0785610ac7565b830182610bae565b50505b505050565b600082821c905092915050565b6000610c3560001984600802610c17565b1980831691505092915050565b6000610c4e8383610c24565b9150826002028217905092915050565b610c678261084e565b67ffffffffffffffff811115610c8057610c7f61058d565b5b610c8a8254610a81565b610c95828285610bd1565b600060209050601f831160018114610cc85760008415610cb6578287015190505b610cc08582610c42565b865550610d28565b601f198416610cd686610ab2565b60005b82811015610cfe57848901518255600182019150602085019450602081019050610cd9565b86831015610d1b5784890151610d17601f891682610c24565b8355505b6001600288020188555050505b505050505050565b600081905092915050565b6000610d468261084e565b610d508185610d30565b9350610d6081856020860161086a565b80840191505092915050565b6000610d788284610d3b565b91508190509291505056fea264697066735822122018ece1d5aa9748003bd1e1414ff6484000d2f36b4b5e491f219349e6dbc985c264736f6c63430008110033";

    public static final String FUNC_BATCHIDSERVICEREQUESTINDEXID = "batchIdServiceRequestIndexId";

    public static final String FUNC_IDTRACKER = "idTracker";

    public static final String FUNC_SERVICEREQUESTARRAY = "serviceRequestArray";

    public static final String FUNC_GETID = "getId";

    public static final String FUNC_FINDSERVICEREQUESTINDEXID = "findServiceRequestIndexId";

    public static final String FUNC_CREATESERVICEREQUEST = "createServiceRequest";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected FoodTracker(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected FoodTracker(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected FoodTracker(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected FoodTracker(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<BigInteger> batchIdServiceRequestIndexId(String param0) {
        final Function function = new Function(FUNC_BATCHIDSERVICEREQUESTINDEXID, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> idTracker() {
        final Function function = new Function(FUNC_IDTRACKER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Tuple5<BigInteger, String, String, String, BigInteger>> serviceRequestArray(BigInteger param0) {
        final Function function = new Function(FUNC_SERVICEREQUESTARRAY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint8>() {}));
        return new RemoteFunctionCall<Tuple5<BigInteger, String, String, String, BigInteger>>(function,
                new Callable<Tuple5<BigInteger, String, String, String, BigInteger>>() {
                    @Override
                    public Tuple5<BigInteger, String, String, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple5<BigInteger, String, String, String, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> getId() {
        final Function function = new Function(
                FUNC_GETID, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> findServiceRequestIndexId(String batchId) {
        final Function function = new Function(FUNC_FINDSERVICEREQUESTINDEXID, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(batchId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> createServiceRequest(String batchId, String reference_id, String packageId, BigInteger weight, BigInteger status) {
        final Function function = new Function(
                FUNC_CREATESERVICEREQUEST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(batchId), 
                new org.web3j.abi.datatypes.Utf8String(reference_id), 
                new org.web3j.abi.datatypes.Utf8String(packageId), 
                new org.web3j.abi.datatypes.generated.Uint256(weight), 
                new org.web3j.abi.datatypes.generated.Uint8(status)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static FoodTracker load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new FoodTracker(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static FoodTracker load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new FoodTracker(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static FoodTracker load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new FoodTracker(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static FoodTracker load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new FoodTracker(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<FoodTracker> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(FoodTracker.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<FoodTracker> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(FoodTracker.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<FoodTracker> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(FoodTracker.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<FoodTracker> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(FoodTracker.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
