package develop.example.product;

import java.util.List;

public interface ProductService {
    /**
     * OrderController -> OrderService -> ProductService -> ExternalService
     * case
     * 1. all REQUIRED
     * 2. ExternalService REQUIRES_NEW
     * 3. ExternalService REQUIRED, try-catch
     * 4. ExternalService REQUIRED, fallback
     * 5. ExternalService noRollbackFor
     * 6. ExternalService noRollbackFor, try-catch
     * */

    void saveProductExResourceRequired();
    void saveProductExResourceRequiresNew();
    void saveProductExResourceRequiredTryCatch();
    void saveProductExResourceRequiredFallback();
    void saveProductExResourceRequiredNoRollbackFor();
    void saveProductExResourceRequiredNoRollbackForTryCatch();



    void saveProduct();
    List<Product> findAll();

    void saveProductWithRequiresNew();
    void saveProductWithNested();
    void saveProductWithRequiredAndTryCatch();

}
