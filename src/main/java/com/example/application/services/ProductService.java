package com.example.application.services;

import com.example.application.model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    List<Product> listProducts(String name);
    void saveProduct(Product product, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException;
    void deleteProduct(int id);
    Product getProductById(int id);
}
