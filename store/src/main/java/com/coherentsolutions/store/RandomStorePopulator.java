package com.coherentsolutions.store;

import com.coherentsolutions.domain.Category;
import com.coherentsolutions.domain.CategoryNames;
import com.coherentsolutions.domain.Product;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class RandomStorePopulator {
    Store store;
    Database db = Database.getInstance();
    Set<Category> categorySet = new HashSet<>();

    public RandomStorePopulator(Store store) {
        this.store = store;
    }

    public void fillOutStore(CategoryNames categoryName) throws SQLException {

        String insertCategoryQuery = "INSERT INTO CATEGORIES(NAME) VALUES (?)";
        String insertProductQuery = "INSERT INTO PRODUCTS(NAME, PRICE, RATE, CATEGORY_ID) VALUES (?,?,?,?)";

        try { int j = 1;
            PreparedStatement insertCategory = db.dbConnection.prepareStatement(insertCategoryQuery);
            PreparedStatement insertProduct = db.dbConnection.prepareStatement(insertProductQuery);
            // add category
            for (Category category : categorySet) {
                insertCategory.setString(1, categoryName.name());
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
                }
                System.out.println("Category" + category.getName() + "with products successfully added.");
                j++;
            }

        } catch (SQLException error){
            System.err.println("Adding Category is failed" + error.getMessage());
        }
        db.dbConnection.close();
    }
}

   // private Set<Category> createCategorySet() {
       //Set<Category> categorySet = new HashSet<>();


//        Reflections reflections = new Reflections("com.coherentsolutions.domain");
//        Set<Class<? extends Category>> subTypes =
//                reflections.getSubTypesOf(Category.class);
//        for (Class<? extends Category> subType : subTypes) {
//            CategoryFactory categoryFactory = new CategoryFactory();
//            String simpleCategoryName = subType.getSimpleName();
//            Category category = categoryFactory.createCategory(simpleCategoryName);
//            categorySet.add(category);
//        }
//        return categorySet;

//    public void fillByProducts() {
//        Set<Category> categorySet = createCategorySet();
//        ProductGenerator pg = new ProductGenerator();
//        for (Category category : categorySet) {
//            for (int i = 0; i < 7; i++) {
//                category.addProductToCategory(pg.generateProduct(category.getName()));
//            }
//            store.addCategoryToStore(category);
//        }
//    }
