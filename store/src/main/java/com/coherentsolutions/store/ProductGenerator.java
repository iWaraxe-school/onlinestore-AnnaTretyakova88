package com.coherentsolutions.store;

import com.coherentsolutions.domain.CategoryNames;
import com.coherentsolutions.domain.Product;
import com.github.javafaker.Faker;

 public class ProductGenerator {

    Faker faker = new Faker();

    private String productName(CategoryNames categoryName){
        if (categoryName == CategoryNames.TOYS)
            return faker.gameOfThrones().character();
        else if (categoryName == CategoryNames.ELECTRONICS)
            return faker.rickAndMorty().character();
        else if (categoryName == CategoryNames.CLOTHES) {
            return faker.commerce().material();}
        else return null;
    }
    private int productPrice(){return faker.number().numberBetween(1, 200);}
    private double productRate(){return faker.number().randomDouble(2,0, 10);}

       public Product generateProduct(CategoryNames categoryName){
        return new Product(
                productName(categoryName),
                productPrice(),
                productRate());
       }

    }

