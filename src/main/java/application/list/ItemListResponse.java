package application.list;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class ItemListResponse {

    private Long productId;
    private Long amount;

    public ItemListResponse(Long prodId, Long amount) {
        this.productId = prodId;
        this.amount = amount;
    }
}