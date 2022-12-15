package com.coherentsolutions.store;

import com.coherentsolutions.domain.Category;
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
            Category category = null;
            try {
                category = subType.getConstructor().newInstance();
                categorySet.add(category);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }

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