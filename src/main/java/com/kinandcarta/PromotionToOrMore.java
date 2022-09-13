package com.kinandcarta;

import java.util.List;

public class PromotionToOrMore implements Promotion {


    @Override
    public Double applyPromotion(List<Product> products, Double total) {
        Double discount = 0.00;


        /**
         * get the no of waterBottleProducts
         * if waterBottle products > 2
         *      get the subtotal of all other products excluding bottles and add to
         *      the subtotal of total price of bottles with price 22.99 (discounted price)
         *
         *      get the discount by subtracting subtotal with original total
         *
         */
        long waterBottlesCount = products.stream().filter(product -> product.getId().equals("001")).count();

        /**
         *
         */
        if( waterBottlesCount >= 2){
            Double subTotal = products.stream().filter(product -> !product.getId().equals("001")).mapToDouble(product -> product.getPrice()).sum();
            subTotal = subTotal + (waterBottlesCount * 22.99);
            discount = total - subTotal;
        }

        return discount;
    }
}
