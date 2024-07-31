package com.Ecommerce_website.Orders.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="orders")
public class Ordermodel {
    @Id
    private Integer orderid;
    private Long order_price;
    private String shipping_address;
    private String billing_address;
    private String payment_method;
    private int order_quantity;
    private String order_status;
    private LocalDate order_date;
    private LocalDate delivery_date;

    @PrePersist
    protected void onCreate() {
        if (order_status == null) {
            order_status = "pending";
        }
        if (order_date == null) {
            order_date = LocalDate.now();
        }
        if (delivery_date == null) {
            delivery_date = LocalDate.now().plusDays(7);
        }
    }
    public static int generateNumericID() {
        Random random = new Random();
        // Generate a random number between 10000000 and 99999999 (inclusive)
        return random.nextInt(90000000) + 10000000;
    }
    public void generateId() {
        if (this.orderid == null) {
            this.orderid = generateNumericID();
        }
    }
    public void calculateOrderPrice(Long unitPrice) {
        this.order_price = unitPrice * this.order_quantity;
    }
}