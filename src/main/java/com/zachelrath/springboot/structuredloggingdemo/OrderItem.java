package com.zachelrath.springboot.structuredloggingdemo;

import lombok.Builder;

@Builder
public class OrderItem {
    public String id;
    public String sku;
    public String description;
    public Integer quantity;
}
