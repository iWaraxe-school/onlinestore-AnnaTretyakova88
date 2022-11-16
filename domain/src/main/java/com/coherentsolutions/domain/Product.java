package com.coherentsolutions.domain;

public class Product {
    private String name;
    private Integer price;
    private Float rate;

    public Product (String name, Integer price, Float rate ) {
        this.name=name;
        this.price=price;
        this.rate=rate;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public Integer getPrice() {return price;}
    public void setPrice(Integer price) {this.price = price;}

    public Float getRate() {return rate;}
    public void setRate(Float rate) {this.rate = rate;}

}
