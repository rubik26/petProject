package com.example.application.services.impl;

import com.example.application.repository.ProductRepository;
import com.example.application.model.Image;
import com.example.application.model.Product;
import com.example.application.services.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> listProducts(String name) {
        if (name != null) {
            productRepository.findByName(name);
        }
        return productRepository.findAll();
    }
    public void saveProduct(Product product, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        Image image1 = null;
        Image image2;
        Image image3;
        if(file1.getSize() > 0){
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            product.addImageToProduct(image1);
        }
        if(file2.getSize() > 0){
            image2 = toImageEntity(file2);
            image2.setPreviewImage(false);
            product.addImageToProduct(image2);
        }
        if(file3.getSize() > 0){
            image3 = toImageEntity(file3);
            image3.setPreviewImage(false);
            product.addImageToProduct(image3);
        }
        Product productDb = productRepository.save(product);
        productDb.addImageToProduct(productDb.getImageList().get(0));
        productRepository.save(product);
    }
    private Image toImageEntity(MultipartFile file1) throws IOException {
        Image image = new Image();
        image.setName(file1.getName());
        image.setOriginalFileName(file1.getOriginalFilename());
        image.setContentType(file1.getContentType());
        image.setSize(file1.getSize());
        image.setBytes(file1.getBytes());
        return image;
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }
}
