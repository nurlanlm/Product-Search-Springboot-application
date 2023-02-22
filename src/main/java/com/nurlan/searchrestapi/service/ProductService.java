package com.nurlan.searchrestapi.service;

import com.nurlan.searchrestapi.dto.ProductDto;
import java.util.List;

public interface ProductService {

    List<ProductDto> searchProducts(String query);
    List<ProductDto> getAllProducts();
    ProductDto findProductById(Long id);
    ProductDto addProduct(ProductDto productDto);
    String deleteProductById(Long id);

}
