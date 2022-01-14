package develop.example.order;

import develop.example.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final ProductService productService;

    public void saveOrderProductExternalAllRequired() {
        try{
            saveOrderWithRequired();
            productService.saveProductExResourceRequired();
        }catch(Exception e){
            System.out.println("@@@ saveOrderProductExternalAllRequired e.getMessage() = " + e.getMessage());
            e.printStackTrace();

        }

    }

    public void saveOrderProductRequiredAndExternalRequiresNew() {
        try{
            saveOrderWithRequired();
            productService.saveProductExResourceRequiresNew();
        }catch(Exception e){
            System.out.println("@@@ saveOrderProductRequiredAndExternalRequiresNew e.getMessage() = " + e.getMessage());
            e.printStackTrace();

        }

    }

    public void saveOrderProductRequiredAndExternalRequiredTryCatch() {
        try{
            saveOrderWithRequired();
            productService.saveProductExResourceRequiredTryCatch();
        }catch(Exception e){
            System.out.println("@@@ saveOrderProductRequiredAndExternalRequiredTryCatch e.getMessage() = " + e.getMessage());
            e.printStackTrace();

        }

    }

    public void saveOrderProductRequiredAndExternalRequiredFallback() {
        try{
            saveOrderWithRequired();
            productService.saveProductExResourceRequiredFallback();
        }catch(Exception e){
            System.out.println("@@@ saveOrderProductRequiredAndExternalRequiredFallback e.getMessage() = " + e.getMessage());
            e.printStackTrace();

        }

    }

    public void saveOrderProductRequiredAndExternalRequiredNoRollbackFor() {
        try{
            saveOrderWithRequired();
            productService.saveProductExResourceRequiredNoRollbackFor();
        }catch(Exception e){
            System.out.println("@@@ saveOrderProductRequiredAndExternalRequiredNoRollbackFor e.getMessage() = " + e.getMessage());
            e.printStackTrace();

        }

    }

    public void saveOrderProductRequiredAndExternalRequiredNoRollbackForTryCatch() {
        try{
            saveOrderWithRequired();
            productService.saveProductExResourceRequiredNoRollbackForTryCatch();
        }catch(Exception e){
            System.out.println("@@@ saveOrderProductRequiredAndExternalRequiredNoRollbackForTryCatch e.getMessage() = " + e.getMessage());
            e.printStackTrace();

        }

    }

    public void saveOrderProductTryCatch() {
        try{
            saveOrderWithRequired();
            productService.saveProductWithRequiredAndTryCatch();
        }catch(Exception e){
            System.out.println("@@@ saveOrderProductTryCatch e.getMessage() = " + e.getMessage());
            e.printStackTrace();

        }

    }


    /*******************************************************************************************/

    public void saveOrderWithRequired() {
        Order order = new Order();
        order.setOrderItem("order1");
        order.setDescription("saveOrderWithRequired");
        orderRepository.save(order);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveOrderWithRequiresNew() {
        Order order = new Order();
        order.setOrderItem("order2");
        order.setDescription("saveOrderWithRequiresNew");
        orderRepository.save(order);
    }

    @Transactional(propagation = Propagation.NESTED)
    public void saveOrderWithNested() {
        Order order = new Order();
        order.setOrderItem("order3");
        order.setDescription("saveOrderWithNested");
        orderRepository.save(order);
    }



    /**************************************************************************************/

    public void saveOrder() {
        Order order = new Order();
        order.setOrderItem("order1");
        order.setDescription("test");
        orderRepository.save(order);

    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }



}
