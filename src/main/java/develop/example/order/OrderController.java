package develop.example.order;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = {"주문관리API"})
@RequestMapping(value = "/orders/v1")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;


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

    /**
     *     void saveOrderProductExternalAllRequired();
     *     void saveOrderProductRequiredAndExternalRequiresNew();
     *     void saveOrderProductRequiredAndExternalRequiredTryCatch();  200
     *     void saveOrderProductRequiredAndExternalRequiredFallback();
     *     void saveOrderProductRequiredAndExternalRequiredNoRollbackFor();
     *     void saveOrderProductRequiredAndExternalRequiredNoRollbackForTryCatch();  200
     *
     *    ===> try-catch가 있어야 200이 떨어지고 저장됨.
     * */

    @PostMapping("/allrequired")
    @ApiOperation(value ="All REQUIRED")
    public void saveOrderProductExternalAllRequired(){
        orderService.saveOrderProductExternalAllRequired();
    }


    @PostMapping("/requiresnew")
    @ApiOperation(value ="EXTERNAL REQUIRES_NEW")
    public void saveOrderProductRequiredAndExternalRequiresNew(){
        orderService.saveOrderProductRequiredAndExternalRequiresNew();
    }

    @PostMapping("/requiredtrycatch")
    @ApiOperation(value ="EXTERNAL REQUIRED TRY-CATCH")
    public void saveOrderProductRequiredAndExternalRequiredTryCatch(){
        orderService.saveOrderProductRequiredAndExternalRequiredTryCatch();
    }

    @PostMapping("/requiredFallback")
    @ApiOperation(value ="EXTERNAL REQUIRED FALLBACK")
    public void saveOrderProductRequiredAndExternalRequiredFallback(){
        orderService.saveOrderProductRequiredAndExternalRequiredFallback();
    }

    @PostMapping("/requirednorollbackfor")
    @ApiOperation(value ="EXTERNAL REQUIRED NOROLLBACKFOR")
    public void saveOrderProductRequiredAndExternalRequiredNoRollbackFor(){
        orderService.saveOrderProductRequiredAndExternalRequiredNoRollbackFor();
    }

    @PostMapping("/requirednorollbackfortrycatch")
    @ApiOperation(value ="EXTERNAL REQUIRED NOROLLBACKFOR TRY-CATCH")
    public void saveOrderProductRequiredAndExternalRequiredNoRollbackForTryCatch(){
        orderService.saveOrderProductRequiredAndExternalRequiredNoRollbackForTryCatch();
    }

    @PostMapping("/requiredproducttrycatch")
    @ApiOperation(value ="PRODUCT TRY-CATCH EXTERNAL REQUIRED")
    public void saveOrderProductTryCatch(){
        orderService.saveOrderProductTryCatch();
    }



    /**************************************************************************************/

    @PostMapping("/order")
    public void saveOrder(){
        orderService.saveOrder();
    }

    @GetMapping("/orders")
    List<Order> getOrderList(){
        return orderService.findAll();
    }

}
