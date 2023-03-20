package com.coherentsolutions.store;

import com.coherentsolutions.domain.Category;
import com.coherentsolutions.domain.CategoryFactory;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

public class RandomStorePopulator {
    Store store;

    public RandomStorePopulator(Store store) {
        this.store = store;
    }

    private Set<Category> createCategorySet() {
        Set<Category> categorySet = new HashSet<>();

        Reflections reflections = new Reflections("com.coherentsolutions.domain");
        Set<Class<? extends Category>> subTypes =
                reflections.getSubTypesOf(Category.class);
        for (Class<? extends Category> subType : subTypes) {
            CategoryFactory categoryFactory = new CategoryFactory();
            String simpleCategoryName = subType.getSimpleName();
            Category category = categoryFactory.createCategory(simpleCategoryName);
            categorySet.add(category);
        }
        return categorySet;
    }

    public void fillByProducts() {
        Set<Category> categorySet = createCategorySet();
        ProductGenerator pg = new ProductGenerator();
        for (Category category : categorySet) {
            for (int i = 0; i < 7; i++) {
                category.addProductToCategory(pg.generateProduct(category.getName()));
            }
            store.addCategoryToStore(category);
        }
    }
}