package com.coherentsolutions.store;

import com.coherentsolutions.domain.Category;
import com.coherentsolutions.domain.Product;
import com.coherentsolutions.store.sorting.ProductComparator;
import com.coherentsolutions.store.sorting.XMLParser;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Store {
    private static Store singleStore;
    private Store (){};

    public static Store getInstance(){
        if (singleStore == null) {
            singleStore = new Store();
            RandomStorePopulator populator = new RandomStorePopulator(singleStore);
            populator.fillByProducts();
            return singleStore;
        }
        return singleStore;
    };

    private List<Category> categoryItems = new ArrayList<Category>();

    public void addCategoryToStore(Category category){
        this.categoryItems.add(category);
    }

    public void printStore () {

        System.out.println("AT Store");
        System.out.println("--------------");

        for (Category category : categoryItems) {
            System.out.println(category);
        }
    }
    public List<Product> getAllProducts (){
        List<Product> allProducts = new ArrayList<>();
        for (Category category: categoryItems) {
            allProducts.addAll(category.getProducts());
        }
        return allProducts;
    }
    public void printSortedProducts (){
        List<Product> allProducts = getAllProducts();
        allProducts.sort(ProductComparator.buildComparator(XMLParser.readAndParseXML()));
        for (Product product: allProducts) {
            System.out.println(product);
        }
    }
    public void printTopProducts (){
        List<Product> allProducts = getAllProducts();
        allProducts.sort(Comparator.comparing(Product::getPrice).reversed());
        allProducts.stream()
                .limit(5)
                .forEach(System.out::println);
    }
}
