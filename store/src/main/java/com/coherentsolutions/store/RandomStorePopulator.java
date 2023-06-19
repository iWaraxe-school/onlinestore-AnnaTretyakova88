package com.coherentsolutions.store;
import com.coherentsolutions.domain.Category;
import com.coherentsolutions.domain.Product;
import com.coherentsolutions.store.DB.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class RandomStorePopulator {
    Store store;
    Connection dbConnection = DatabaseConnection.getConnection();
    Set<Category> categorySet = new HashSet<>();

    public RandomStorePopulator(Store store) throws SQLException {
        this.store = store;
    }

    public void fillOutStore(String categoryName) throws SQLException {

        String insertCategoryQuery = "INSERT INTO CATEGORIES(NAME) VALUES (?)";
        String insertProductQuery = "INSERT INTO PRODUCTS(NAME, PRICE, RATE, CATEGORY_ID) VALUES (?,?,?,?)";

        try (PreparedStatement insertCategory = dbConnection.prepareStatement(insertCategoryQuery);
             PreparedStatement insertProduct = dbConnection.prepareStatement(insertProductQuery)) {
            // add category
            int j = 1;
            for (Category category : categorySet) {
                insertCategory.setString(1, categoryName);
                insertCategory.executeUpdate();
                //add products
                for (int i = 0; i < 10; i++) {
                    ProductGenerator generator = new ProductGenerator();
                    Product randomProduct = generator.generateProduct(category.getName());
                    insertProduct.setString(1, randomProduct.getName());
                    insertProduct.setInt(2, randomProduct.getPrice());
                    insertProduct.setDouble(3, randomProduct.getRate());
                    insertProduct.setInt(4, j);
                    insertProduct.executeUpdate();
                    category.addProductToCategory(randomProduct);
                }
                categorySet.add(category);
                System.out.println("Category" + category.getName() + "with products successfully added.");
                j++;
            }

        } catch (SQLException error) {
            System.err.println("Adding Category is failed" + error.getMessage());
            error.printStackTrace();
        }
    }

}
