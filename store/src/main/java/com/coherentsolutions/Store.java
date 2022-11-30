package com.coherentsolutions;

import com.coherentsolutions.domain.Category;
import com.coherentsolutions.domain.CategoryNames;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Category> categoryItems = new ArrayList<Category>();

    public void addCategoryToStore(Category category){
        categoryItems.add(category);
    }

    public void printStore () {

        System.out.println("AT Store");
        System.out.println("--------------");

        for (Category category : categoryItems) {
            System.out.println(category);
        }
    }
}
