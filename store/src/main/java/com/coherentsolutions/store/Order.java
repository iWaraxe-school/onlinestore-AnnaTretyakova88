package com.coherentsolutions.store;

import com.coherentsolutions.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class Order {
    public List<Product> cartSet = new ArrayList<>();

    public Product addItemToCart(){
        Product item = Store.getInstance().selectItemFromStore();
        this.cartSet.add(item);
        return item;
    };

    public void clearCart(){
        this.cartSet.clear();
    }

}
