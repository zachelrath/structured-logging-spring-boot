package com.zachelrath.springboot.structuredloggingdemo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemLog {
    private Integer totalSize;
    private List<OrderItem> items;
    public ItemLog(List<OrderItem> items) {
        this.items = items;
        this.totalSize = items.size();
    }
}
