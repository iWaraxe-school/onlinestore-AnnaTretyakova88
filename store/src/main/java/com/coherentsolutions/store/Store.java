package com.coherentsolutions.store;

import com.coherentsolutions.domain.Category;
import com.coherentsolutions.domain.CategoryNames;
import com.coherentsolutions.domain.Product;
import com.coherentsolutions.store.DB.Database;
import com.coherentsolutions.store.DB.DatabaseConnection;
import com.coherentsolutions.store.sorting.ProductComparator;
import com.coherentsolutions.store.sorting.XMLParser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Store {
    private static Store singleStore;
    private Store (){};

    public static Store getInstance(){
        if (singleStore == null) {
            singleStore = new Store();
            try {
                RandomStorePopulator populator = new RandomStorePopulator(singleStore);
                populator.fillOutStore(CategoryNames.CLOTHES);
                populator.fillOutStore(CategoryNames.TOYS);
                populator.fillOutStore(CategoryNames.ELECTRONICS);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

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
    public List<Product> getProductsFromDB (String selectProductsQuery) {
        List<Product> allProducts = new ArrayList<>();
        try (Connection dbConnection = DatabaseConnection.getConnection();
             PreparedStatement selectAllProducts = dbConnection.prepareStatement(selectProductsQuery);
             ResultSet allProductsSet = selectAllProducts.executeQuery()) {
            while(allProductsSet.next()){
                Product product = Product.builder()
                        .setName(allProductsSet.getString("NAME"))
                        .setRate(allProductsSet.getDouble("RATE"))
                        .setPrice(allProductsSet.getInt("PRICE"))
                        .build();
                allProducts.add(product);
            }
        } catch (SQLException error) {
            System.err.println("SQL error occurs while getting products" + error.getMessage());
            error.printStackTrace();
        }
        return allProducts;
    }
    public void printSortedProducts (){
        String selectSortedProducts = "SELECT * FROM PRODUCTS ORDER BY NAME ASC";
        List<Product> allProducts = getProductsFromDB(selectSortedProducts);
        for (Product product: allProducts) {
            System.out.println(product);
        }
    }
    public void printTopProducts (){
        String selectSortedProducts = "SELECT * FROM PRODUCTS ORDER BY PRICE DESC LIMIT 5";
        List<Product> allProducts = getProductsFromDB(selectSortedProducts);
        for (Product product: allProducts) {
            System.out.println(product);
        }
    }

    public Product selectItemFromStore(){
        String selectRandomProduct = "SELECT * FROM PRODUCTS LIMIT 1";
        List<Product> allProducts = getProductsFromDB(selectRandomProduct);
                return allProducts.get(1);
    }
}
