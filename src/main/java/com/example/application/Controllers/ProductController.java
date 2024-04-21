package com.example.application.Controllers;

import com.example.application.model.Product;
import com.example.application.services.impl.ProductServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class ProductController {
    private final ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String products(@RequestParam(name = "name", required = false) String name, Model model){
        model.addAttribute("products", productService.listProducts(name));
        return "products";
    }
    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable int id, Model model){
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("images", product.getImageList());

        return "product-info";
    }
    @PostMapping("/product/create")
    public String createProduct(@RequestParam("file1")MultipartFile file1,
                                @RequestParam("file2")MultipartFile file2,
                                @RequestParam("file3")MultipartFile file3,
                                @ModelAttribute Product product) throws IOException {
        productService.saveProduct(product, file1, file2, file3);
        return "redirect:/";
    }
    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
        return "redirect:/";
    }
}
