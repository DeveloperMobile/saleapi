package one.digitalinnovation.saleapi.exception;

public class ClientNotFoundExecption extends Exception {
    public ClientNotFoundExecption(Long id) {
        super("Client not found with ID " + id);
    }
}
