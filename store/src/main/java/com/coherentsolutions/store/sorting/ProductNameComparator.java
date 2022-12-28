package com.coherentsolutions.store.sorting;

import com.coherentsolutions.domain.Product;
import java.util.Comparator;

public class ProductNameComparator implements Comparator<Product> {

    @Override
    public int compare(Product prod1, Product prod2) {
        return prod1.getName().compareTo(prod2.getName());
    }
}
