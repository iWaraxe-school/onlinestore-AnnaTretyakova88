package com.coherentsolutions;

import com.coherentsolutions.domain.Category;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Category> categoryItems = new ArrayList<Category>();

    public void addCategoryToStore(Category category){
        categoryItems.add(category);
    }

 //   public void printCategoryList (Category category){
 //       System.out.println("Category:" + category);
 //       System.out.println("**********");
 //       for (Category category: categoryItems){System.out.println(category);} }

}
