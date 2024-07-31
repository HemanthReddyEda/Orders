package com.Ecommerce_website.Orders.repository;

import com.Ecommerce_website.Orders.model.Ordermodel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface Orderrepo extends JpaRepository<Ordermodel, Integer> {

}
