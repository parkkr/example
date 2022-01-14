package develop.example.product;

import develop.example.external.ExternalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ExternalService externalService;

    public void saveProductExResourceRequired() {
        Product product = new Product();
        product.setProductName("product1");
        product.setDescription("saveProductWithRequired");

        externalService.getExResourceWithRequired();
        productRepository.save(product);
    }

    public void saveProductExResourceRequiresNew() {
        Product product = new Product();
        product.setProductName("product1");
        product.setDescription("saveProductExResourceRequiresNew");

        externalService.getExResourceWithRequiresNew();
        productRepository.save(product);
    }

    public void saveProductExResourceRequiredTryCatch() {
        Product product = new Product();
        product.setProductName("product1");
        product.setDescription("saveProductExResourceRequiredTryCatch");

        externalService.getExResourceWithRequiredTryCatch();
        productRepository.save(product);
    }

    public void saveProductExResourceRequiredFallback() {
        Product product = new Product();
        product.setProductName("product1");
        product.setDescription("saveProductExResourceRequiredFallback");

        externalService.getExResourceWithRequiredFallback();
        productRepository.save(product);
    }

    public void saveProductExResourceRequiredNoRollbackFor() {
        Product product = new Product();
        product.setProductName("product1");
        product.setDescription("saveProductExResourceRequiredNoRollbackFor");

        externalService.getExResourceWithRequiredNoRollbackFor();
        productRepository.save(product);
    }

    public void saveProductExResourceRequiredNoRollbackForTryCatch() {
        Product product = new Product();
        product.setProductName("product1");
        product.setDescription("saveProductExResourceRequiredNoRollbackForTryCatch");

        externalService.getExResourceWithRequiredNoRollbackForTryCatch();
        productRepository.save(product);
    }

    /**
     * ProductService에서 ExternalService try-catch
     * */
    public void saveProductWithRequiredAndTryCatch() {
        Product product = new Product();
        product.setProductName("product4");
        product.setDescription("saveProductWithRequiredAndTryCatch");

        try{
            externalService.getExResourceWithRequired();
        }catch(Exception e){
            System.out.println("saveProductWithRequiredAndTryCatch e.getMessage() = " + e.getMessage());
            e.printStackTrace();
        }

        productRepository.save(product);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveProductWithRequiresNew() {
        Product product = new Product();
        product.setProductName("product2");
        product.setDescription("saveProductWithRequiresNew");

        externalService.getExResourceWithRequired(); //외부API조회(exception발생위치)
        productRepository.save(product);
    }

    @Transactional(propagation = Propagation.NESTED)
    public void saveProductWithNested() {
        Product product = new Product();
        product.setProductName("product3");
        product.setDescription("saveProductWithNested");

        externalService.getExResourceWithRequired(); //외부API조회(exception발생위치)
        productRepository.save(product);
    }



    /**************************************************************************************/

    public void saveProduct() {
        Product product = new Product();
        product.setProductName("ppp");
        product.setDescription("product description");

        externalService.getExResourceWithRequired(); //외부API조회(exception발생위치)
        productRepository.save(product);

    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }


}
