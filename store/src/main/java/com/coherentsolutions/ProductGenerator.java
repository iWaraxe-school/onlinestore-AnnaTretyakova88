package com.coherentsolutions;

import com.coherentsolutions.domain.CategoryNames;
import com.coherentsolutions.domain.Product;
import com.github.javafaker.Faker;

 public class ProductGenerator {

    Faker faker = new Faker();

    private String toysProduct (CategoryNames TOYS){
        return faker.chuckNorris().fact();
    }
    private String electronicsProduct (CategoryNames ELECTRONICS){
        return faker.rickAndMorty().character();
    }
    private String clothesProduct (CategoryNames CLOTHES){
        return faker.commerce().material();
    }
    private int productPrice(){
        return faker.number().numberBetween(1, 200);
    }
    private double productRate(){
        return faker.number().randomDouble(2,0, 10);
    }
      //      DRAFT
      //  public Product generateProduct(){
     //   Product toys = new Product(toysProduct(CategoryNames.TOYS),productPrice(), productRate());
     //   Product electronics = new Product(toysProduct(CategoryNames.ELECTRONICS),productPrice(), productRate());
     //   Product clothes = new Product(toysProduct(CategoryNames.CLOTHES),productPrice(), productRate());
     // return toys;
     // }
    }

