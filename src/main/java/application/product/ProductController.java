package application.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import application.amount.AmountRequest;
import application.amount.AmountResponse;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService service;

    @GetMapping()
    public List<ProductResponse> getAll() {
        return this.service.getAll().stream().map(ProductResponse::new).collect(Collectors.toList());
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse addProd(@RequestBody ProductRequest request){
        return new ProductResponse(this.service.createNewProduct(request));
    }

    @GetMapping("/{id}")
    public ProductResponse getProdById(@PathVariable("id") Long id) {
        return new ProductResponse(this.service.getProduct(id));
    }

    @PutMapping("/{id}")
    public ProductResponse addProd(@PathVariable("id") Long id, @RequestBody ProductRequest request){
        return new ProductResponse(this.service.updateProduct(id, request));
    }

    @DeleteMapping("/{id}")
    public void deleteProd(@PathVariable("id") Long id){
        this.service.deleteProduct(id);
    }


    @GetMapping("/{id}/amount")
    public AmountResponse getAmount(@PathVariable("id") Long id){
        return new AmountResponse(this.service.getAmountFromProduct(id));
    }

    @PostMapping("/{id}/amount")
    public AmountResponse addAmount(@PathVariable("id") Long id, @RequestBody AmountRequest request){
        return this.service.addAmountToProduct(id, request);
    }
}

