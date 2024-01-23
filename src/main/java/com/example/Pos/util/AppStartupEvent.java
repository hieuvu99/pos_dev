package com.example.Pos.util;

import java.util.Date;
import java.util.List;

import com.example.Pos.business.ProductService;
import com.example.Pos.data.Product;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private final ProductService productService;

    public AppStartupEvent(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        List<Product> reservations = this.productService.getAllProduct();
        reservations.forEach(System.out::println);
    }
}
