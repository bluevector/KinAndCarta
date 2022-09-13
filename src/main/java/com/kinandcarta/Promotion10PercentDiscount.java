package com.kinandcarta;

import java.util.List;

public class Promotion10PercentDiscount implements Promotion{

    @Override
    public Double applyPromotion(List<Product> products, Double total) {
        Double discount = 0.00;

        /**
         * get the discount amount
         */
        if(total > 75.00){
            discount =  total * 0.10;
        }

        return discount;
    }
}
