package fr.doranco.nomad_odyssey.controllers;

import fr.doranco.nomad_odyssey.entities.Product;
import fr.doranco.nomad_odyssey.exceptions.ProductException;
import fr.doranco.nomad_odyssey.requests.CreateProductRequest;
import fr.doranco.nomad_odyssey.responses.ApiResponse;
import fr.doranco.nomad_odyssey.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/products")
public class AdminProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/")
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductRequest request){
        Product product = productService.createProduct(request);

        return new ResponseEntity<Product>(product, HttpStatus.CREATED);
    }

    @DeleteMapping("/{productId}/delete")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Long productId) throws ProductException {

        productService.deleteProduct(productId);
        ApiResponse response = new ApiResponse();
        response.setMessage("product deleted successfully");
        response.setStatus(true);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> findAllProduct(){

        List<Product> products = productService.findAllProducts();

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PutMapping("/{productId}/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product request,
                                                 @PathVariable Long productId) throws ProductException {

        Product product = productService.updateProduct(productId, request);

        return new ResponseEntity<Product>(product, HttpStatus.CREATED);
    }

    @PostMapping("/creates")
    public ResponseEntity<ApiResponse> createMultipleProduct(@RequestBody CreateProductRequest[] requests){

        for(CreateProductRequest product:requests){
            productService.createProduct(product);
        }
        ApiResponse response = new ApiResponse();
        response.setMessage("product deleted successfully");
        response.setStatus(true);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
