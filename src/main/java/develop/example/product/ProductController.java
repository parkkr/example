package develop.example.product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = {"상품관리API"})
@RequestMapping(value = "/products/v1")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping(value = "/product")
    @ApiOperation(value = "상품등록")
    public void saveProduct(){
        productService.saveProduct();

    }

    @GetMapping(value = "/products")
    @ApiOperation(value = "상품전체조회")
    public List<Product> getProductList(){
        return productService.findAll();
    }

}
