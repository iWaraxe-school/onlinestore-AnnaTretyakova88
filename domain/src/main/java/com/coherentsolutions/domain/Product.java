package com.coherentsolutions.domain;

public class Product {
    private String name;
    private Integer price;
    private Double rate;

    private Product () {
    }
    public static ProductBuilder builder(){
        return new Product().new ProductBuilder();
    }
    public class ProductBuilder {
        private String name;
        private Integer price;
        private Double rate;

        public ProductBuilder setName(final String name){
            this.name = name;
            return this;
        }
        public ProductBuilder setPrice(final Integer price){
            this.price = price;
            return this;
        }
        public ProductBuilder setRate(final Double rate){
            this.rate = rate;
            return this;
        }
        public Product build (){
            Product.this.name = this.name;
            Product.this.price = this.price;
            Product.this.rate = this.rate;
            return Product.this;

        }
    }

    public String getName() {return name;}
    public Integer getPrice() {return price;}
    public Double getRate() {return rate;}

    @Override
    public String toString() {
        return String.format("Name: %s , Price: %s , Rate: %s", name, price, rate);
    }
}
