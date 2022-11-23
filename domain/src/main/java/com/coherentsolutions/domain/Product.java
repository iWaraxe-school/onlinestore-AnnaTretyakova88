package com.coherentsolutions.domain;

public class Product {
    private final String name;
    private final Integer price;
    private final Double rate;

    public Product (String name, Integer price, Double rate ) {
        this.name=name;
        this.price=price;
        this.rate=rate;
    }

    public String getName() {return name;}
    public Integer getPrice() {return price;}
    public Double getRate() {return rate;}

}
