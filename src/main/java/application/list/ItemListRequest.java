package application.list;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ItemListRequest {

    private long productId;
    private int amount;
}