package com.coherentsolutions.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class CategoryFactory {
    private static final Map<String, Supplier<Category>> Categories_Map = new HashMap<String, Supplier<Category>>() {{
        put("Clothes", Clothes::new);
        put("Electronics", Electronics::new);
        put("Toys", Toys::new);
     }};
 public static Category createCategory (String name) {
     return Categories_Map.getOrDefault(name, null).get();
 }
}
