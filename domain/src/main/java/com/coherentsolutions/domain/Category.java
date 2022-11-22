package com.coherentsolutions.domain;

import java.util.ArrayList;
import java.util.List;

 public abstract class Category {
     private final String name;
     private List<Product> products;

     public Category(String name) {
         this.name = name;
         this.products = new ArrayList<Product>();
     }

     public String getName() {return name;}
     public void addProductToCategory(Product product) {
         products.add(product);
     }

     public void printCategoryProducts(){
         System.out.println("*********");
         System.out.println("Category:" + name );
         System.out.println("*********");

         for(Product product:products){
             System.out.println(product);
         }
     }

 }
