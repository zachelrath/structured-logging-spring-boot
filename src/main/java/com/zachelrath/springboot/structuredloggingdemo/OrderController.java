package com.zachelrath.springboot.structuredloggingdemo;

// Import log4j classes.

import org.apache.logging.log4j.CloseableThreadContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    private static final Logger logger = LogManager.getLogger(OrderController.class);
    private static final Database d = new Database();

    @RequestMapping(
            value = "/order/{retailer}/{orderNumber}/items",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    @ResponseBody
    public List<OrderItem> getOrderItems(
            @PathVariable("orderNumber") @Required String orderNumber,
            @PathVariable("retailer") @Required String retailer) {
        try (final CloseableThreadContext.Instance ignored = CloseableThreadContext
            .put("orderNumber", orderNumber)
            .put("retailer", retailer)) {

            logger.info("Getting items");

            List<OrderItem> orderItems = null;
            try {
                orderItems = d.getItemsForOrder(orderNumber);
            } catch (Exception ex) {
                logger.error("Unable to fetch items from database for order", ex);
                throw ex;
            }

            logger.info("Got items, returning");
            return orderItems;
        }
    }

}
