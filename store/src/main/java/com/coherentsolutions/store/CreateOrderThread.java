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
        long startTime = System.nanoTime();
        TimeUnit.SECONDS.sleep(i);
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        this.order.addItemToCart();
        System.out.println("Item\t" + this.order.addItemToCart().getName() +"\t"+ "added to cart in " + elapsedTime + " nanoseconds.");


    }
}
