package com.coherentsolutions.store;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.TimeUnit;

@Slf4j

public class ClearingThread implements Runnable {
    private Order order;
    public boolean needRun = true;

    @SneakyThrows
    @Override
    public void run() {
        while (needRun) {
            TimeUnit.MINUTES.sleep(2);
            order.clearCart();
            System.out.println("Cart is empty");
        }
    }

    public void finishRunning(){
        needRun = false;
        }

}
