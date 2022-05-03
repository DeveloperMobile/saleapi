package one.digitalinnovation.saleapi.exception;

public class ProductNotFoundExecption extends Exception {
    public ProductNotFoundExecption(Long id) {
        super("Product not found with ID " + id);
    }
}
