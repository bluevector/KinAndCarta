package com.kinandcarta;

import java.text.DecimalFormat;
import java.util.List;


public class Checkout {
    private List<Promotion> promotions;

    private Double total;
    private Double savings;

    public Checkout(List<Promotion> promotions){
        this.promotions = promotions;
    }

    /**
     * Savings is calculated using each promotion
     * savings is applied on total and total price is reduced with each promotion
     * subsequent promotions is applied on discounted total
     *
     */
    public void scan(List<Product> items){
        total = items.stream().mapToDouble(product -> product.getPrice()).sum();
        for(Promotion promo : promotions){
            savings = promo.applyPromotion(items, total);
            if(savings <= total){
                total = total -  savings;
            }

        }
    }

    public Double total(){
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.valueOf(df.format(total));
    }


}
