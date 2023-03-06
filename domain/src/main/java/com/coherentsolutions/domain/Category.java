package com.coherentsolutions.domain;

import java.util.ArrayList;
import java.util.List;

 public abstract class Category {
     private final CategoryNames name;
     private List<Product> products;

     public List<Product> getProducts() {
         return products;
     }

     public Category(CategoryNames name) {
         this.name = name;
         this.products = new ArrayList<>();
     }

     public CategoryNames getName() {return name;}
     public void addProductToCategory(Product product) {
         this.products.add(product);
     }

    @Override
    public String toString(){
       StringBuilder categoryString = new StringBuilder();
       categoryString.append("***********\n");
       categoryString.append("Category"+ name + "\n");
       categoryString.append("***********\n");

        for (Product product: products){
           categoryString.append("\t" + product + "\n");}
        return categoryString.toString();
        }

     public void printCategoryProducts(){
         System.out.println("*************");
         System.out.println("Category:" + name );
         System.out.println("*************");

         for(Product product:products){
             System.out.println(product);
         }
     }

 }
