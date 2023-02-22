package com.nurlan.searchrestapi.impl;

import com.nurlan.searchrestapi.dto.ProductDto;
import com.nurlan.searchrestapi.entity.Product;
import com.nurlan.searchrestapi.exception.ProductNotFoundException;
import com.nurlan.searchrestapi.repository.ProductRepository;
import com.nurlan.searchrestapi.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductDto> searchProducts(String query) {
        List<Product> productList = productRepository.searchProducts(query);
        return productList.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        return productList.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto findProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found. Id: " + id));
        return modelMapper.map(product, ProductDto.class);
    }

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        productRepository.save(modelMapper.map(productDto, Product.class));
        return productDto;
    }


    @Override
    public String deleteProductById(Long id) {
        productRepository.deleteById(id);
        return "Product deleted. Id: " + id;
    }
}
