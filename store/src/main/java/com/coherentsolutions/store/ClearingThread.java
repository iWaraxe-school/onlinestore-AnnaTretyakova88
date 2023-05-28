package com.coherentsolutions.store;
import com.coherentsolutions.store.DB.Order;
import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.TimeUnit;

@Slf4j

public class ClearingThread implements Runnable {
    private Order order;
    public boolean needRun = true;


    @Override
    public void run() {
        while (needRun) {
            try {
                TimeUnit.MINUTES.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            order.clearCart();
            System.out.println("Cart is empty");
        }
    }

    public void finishRunning(){
        needRun = false;
        }
}


