package one.digitalinnovation.saleapi.exception;

public class ProviderNotFoundExecption extends Exception {
    public ProviderNotFoundExecption(Long id) {
        super("Provider not found with ID " + id);
    }
}
