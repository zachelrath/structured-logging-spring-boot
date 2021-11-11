package com.zachelrath.springboot.structuredloggingdemo;

import java.util.Arrays;
import java.util.List;

public class Database {

    public List<OrderItem> getItemsForOrder(String orderNumber) {
        return Arrays.asList(OrderItem.builder()
            .id("1234")
            .description("Very comfy chair")
            .sku("chair-blue")
            .build());
    }

}
