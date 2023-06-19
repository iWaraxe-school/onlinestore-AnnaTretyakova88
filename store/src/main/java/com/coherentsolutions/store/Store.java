package com.coherentsolutions.store;

import com.coherentsolutions.domain.*;
import com.coherentsolutions.store.DB.Database;
import com.coherentsolutions.store.DB.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Store {
    private static Store singleStore;
    private List<Category> categoryItems = new ArrayList<Category>();

    private Store() {
    }

    public static Store getInstance() {
        if (singleStore == null) {
            singleStore = new Store();
            try {
                RandomStorePopulator populator = new RandomStorePopulator(singleStore);
                populator.fillOutStore(CategoryNames.CLOTHES.name());
                populator.fillOutStore(CategoryNames.TOYS.name());
                populator.fillOutStore(CategoryNames.ELECTRONICS.name());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            return singleStore;
        }
        return singleStore;
    }

    public void addCategoryToStore(Category category) {
        this.categoryItems.add(category);
    }

    public void printStore() {

        System.out.println("AT Store");
        System.out.println("--------------");

        for (Category category : categoryItems) {
            System.out.println(category);
        }
    }

    public static List<Product> getProductsFromDB(String selectProductsQuery) {
        List<Product> allProducts = new ArrayList<>();
        try (Connection dbConnection = DatabaseConnection.getConnection();
             PreparedStatement selectAllProducts = dbConnection.prepareStatement(selectProductsQuery);
             ResultSet allProductsSet = selectAllProducts.executeQuery()) {
            while (allProductsSet.next()) {
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

    public void printSortedProducts() {
        String selectSortedProducts = "SELECT * FROM PRODUCTS ORDER BY NAME ASC";
        List<Product> allProducts = getProductsFromDB(selectSortedProducts);
        for (Product product : allProducts) {
            System.out.println(product);
        }
    }
    public void printTop5Products() {
        String selectSortedProducts = "SELECT * FROM PRODUCTS ORDER BY PRICE DESC LIMIT 5";
        List<Product> allProducts = getProductsFromDB(selectSortedProducts);
        for (Product product : allProducts) {
            System.out.println(product);
        }
    }

    public Product selectItemFromStore() {
        String selectCheapestProduct = "SELECT * FROM PRODUCTS ORDER BY PRICE ASC LIMIT 1";
        List<Product> allProducts = getProductsFromDB(selectCheapestProduct);
        if (!allProducts.isEmpty()) {
            return allProducts.get(0);
        } else {
            throw new RuntimeException("No products found in the database.");
        }
    }
}