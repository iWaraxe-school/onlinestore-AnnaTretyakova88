package com.coherentsolutions.store;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CreateOrderThread implements Runnable {
    public Order order = new Order();
    @SneakyThrows
    @Override
    public void run() {
        int i = (int) (1 + Math.random()*29);
        TimeUnit.SECONDS.sleep(i);
        this.order.addItemToCart();
        System.out.println("Item" + this.order.addItemToCart().getName() + "added to cart");
    }
}
