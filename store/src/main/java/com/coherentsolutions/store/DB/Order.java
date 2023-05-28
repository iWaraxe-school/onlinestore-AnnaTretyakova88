package com.coherentsolutions.store.DB;

import com.coherentsolutions.domain.Product;
import com.coherentsolutions.store.Store;
import java.util.ArrayList;
import java.util.List;

public class Order {
    public List<Product> cartList = new ArrayList<>();

    public synchronized Product addItemToCart(){
        Product item = Store.getInstance().selectItemFromStore();
        this.cartList.add(item);
        return item;
    };

    public synchronized void clearCart(){
        this.cartList.clear();
    }


}
