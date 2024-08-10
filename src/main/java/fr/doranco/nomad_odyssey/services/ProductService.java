package fr.doranco.nomad_odyssey.services;

import fr.doranco.nomad_odyssey.entities.Product;
import fr.doranco.nomad_odyssey.exceptions.ProductException;
import fr.doranco.nomad_odyssey.requests.CreateProductRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    public Product createProduct(CreateProductRequest request);

    public void deleteProduct(Long productId) throws ProductException;

    public Product updateProduct(Long productId, Product request) throws ProductException;

    public Product findProductById(Long id) throws ProductException;

    public List<Product> findProductByCategory(String category);

    public Page<Product> getAllProduct(String category, List<String>colors, List<String>sizes, Integer minPrice,
                                       Integer maxPrice, Integer minDiscount, String sort, String stock,
                                       Integer pageNumber, Integer pageSize);

    List<Product> findAllProducts();
}
