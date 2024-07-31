package com.Ecommerce_website.Orders.config;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Productmodel {
    @Id
    private int id;
    private String name;
    private String description;
    private double price;
    private String category;
    private String image;
    private int quantity;
}
