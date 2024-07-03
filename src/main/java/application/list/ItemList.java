package application.list;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import application.cart.ShoppingCart;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor

public class ItemList {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JsonIgnore
    private ShoppingCart cart;

    private long prodId;
    private long amount;
}

