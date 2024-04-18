package com.example.application.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;
    @Column(columnDefinition = "text")
    private String description;
    @Column
    private int price;
    @Column
    private String city;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,
    mappedBy = "product")
    private List<Image> imageList = new ArrayList<>();
    private int previewImageId;
    private LocalDateTime dataCreated;
    @PrePersist
    public void init(){
        dataCreated = LocalDateTime.now();
    }
    public void addImageToProduct(Image image){
        image.setProduct(this);
        imageList.add(image);

    }

    public Product() {

    }
}