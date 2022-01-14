package develop.example.order;

import java.util.List;

public interface OrderService {

    void saveOrder();
    List<Order> findAll();


    void saveOrderProductExternalAllRequired();
    void saveOrderProductRequiredAndExternalRequiresNew();
    void saveOrderProductRequiredAndExternalRequiredTryCatch();
    void saveOrderProductRequiredAndExternalRequiredFallback();
    void saveOrderProductRequiredAndExternalRequiredNoRollbackFor();
    void saveOrderProductRequiredAndExternalRequiredNoRollbackForTryCatch();

    void saveOrderProductTryCatch();



    void saveOrderWithRequired();
    void saveOrderWithRequiresNew();
    void saveOrderWithNested();


}
