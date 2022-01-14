package develop.example.product;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name="TB_PRODUCT")
@Getter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productId;
    private String productName;
    private String description;

}
