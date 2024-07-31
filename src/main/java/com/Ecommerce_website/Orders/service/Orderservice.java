package com.Ecommerce_website.Orders.service;

import com.Ecommerce_website.Orders.model.Ordermodel;
import com.Ecommerce_website.Orders.repository.Orderrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Orderservice {

    @Autowired
    private Orderrepo orderrepo;

    public Optional<Ordermodel> getorderbyid(Integer orderid) {
        return orderrepo.findById(orderid);
    }

    public void deleteorder(Integer orderid) {
        System.out.println(orderid+" "+"cancelled");
        orderrepo.deleteById(orderid);
    }

    public Ordermodel updateorderstatus(Integer orderid, String orderStatus) {
        // Retrieve the order from the repository
        Optional<Ordermodel> orderOptional = orderrepo.findById(orderid);
        Ordermodel order = orderOptional.get();
        order.setOrder_status(orderStatus);
        System.out.println(orderid+" "+order.getOrder_status());
        return orderrepo.save(order);

    }

    public Ordermodel placeorder(Ordermodel ordermodel) {
        ordermodel.generateId();
        return orderrepo.save(ordermodel);
    }

    public List<Ordermodel> getallorders() {
        return orderrepo.findAll();
    }
}
