package com.Ecommerce_website.Orders.feignclient;

import com.Ecommerce_website.Orders.config.Productmodel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="product-catalog", url="http://localhost:8082")
public interface Productclient {
    Productmodel getproductbyid(@PathVariable("id") Integer id);
}
