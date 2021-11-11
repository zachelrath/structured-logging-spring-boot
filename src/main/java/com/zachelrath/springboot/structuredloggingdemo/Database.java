package com.zachelrath.springboot.structuredloggingdemo;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class Database {

    public List<OrderItem> getItemsForOrder(String orderNumber) {
        return Arrays.asList(OrderItem.builder()
            .id("1234")
            .description("Very comfy chair")
            .sku("chair-blue")
            .build());
    }

}
