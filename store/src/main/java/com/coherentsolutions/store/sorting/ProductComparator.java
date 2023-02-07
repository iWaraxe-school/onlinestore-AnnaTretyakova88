package com.coherentsolutions.store.sorting;

import com.coherentsolutions.domain.Product;
import java.util.Comparator;
import java.util.Map;

public class ProductComparator {
    Comparator<Product> productComparator ;
    Comparator<Product> generalComparator ;
    int i = 1;

    public Comparator<Product> buildComparator(Map<String, SortingOptions> sortingMap) {

        for (Map.Entry<String, SortingOptions> entry : sortingMap.entrySet()) {
            String sortParam = entry.getKey();
            switch (sortParam) {
                case "name":
                    productComparator = Comparator.comparing(Product::getName, String::compareToIgnoreCase);
                    break;
                case "price":
                    productComparator = Comparator.comparing(Product::getPrice);
                    break;
                case "rate":
                    productComparator = Comparator.comparing(Product::getRate);
                    break;
            }
            SortingOptions order = entry.getValue();
            if (order.equals(SortingOptions.DESC)) {
                productComparator = productComparator.reversed();
            }
            return productComparator;
        }
        if (i == 1) {
            generalComparator = productComparator;
        }
        else {
            generalComparator = generalComparator.thenComparing(productComparator);
        }
        i++;
        return generalComparator;
    }
}