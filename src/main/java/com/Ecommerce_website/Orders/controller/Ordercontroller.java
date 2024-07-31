package com.Ecommerce_website.Orders.controller;

import com.Ecommerce_website.Orders.config.Productmodel;
import com.Ecommerce_website.Orders.model.Ordermodel;
import com.Ecommerce_website.Orders.service.Orderservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class Ordercontroller {
    @Autowired
    private Orderservice orderservice;

    @PostMapping("/placeorder")
    public Ordermodel placeorder(@RequestBody Ordermodel ordermodel){
        return orderservice.placeorder(ordermodel);
    }
    @GetMapping("/getorder/{iD}")
    public Optional<Ordermodel> getorderbyid(@PathVariable("iD") Integer orderid){
        return orderservice.getorderbyid(orderid);
    }
    @PutMapping("/updateorder/{orderid}/{status}")
    public Ordermodel updateorderstatus(@PathVariable("orderid") Integer orderid,@PathVariable("status") String order_status){
        return orderservice.updateorderstatus(orderid,order_status);
    }
    @DeleteMapping("/cancelorder/{orderid}")
    public void deleteorder(@PathVariable("orderid") Integer orderid){
        orderservice.deleteorder(orderid);
    }
    @GetMapping("/getallorders")
    public List<Ordermodel> getallorders(){
        return orderservice.getallorders();
    }
}
