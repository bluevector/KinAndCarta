package com.kinandcarta;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class CheckoutTest{

    List<Product> testItems1 = new ArrayList<>();
    List<Promotion> promotions = new ArrayList<>();

    Product waterBottle;
    Product hoodie;
    Product stickerSet;

    Checkout checkout;

    @Before
    public void setup(){
        waterBottle = new Product("001", "Water Bottle", 24.95);
        hoodie = new Product("002", "Hoodie", 65.00);
        stickerSet = new Product("003", "Sticker Set", 3.99);

        Promotion promotionToOrMore = new PromotionToOrMore();
        Promotion promotion10PercentDiscount = new Promotion10PercentDiscount();


        promotions.add(promotionToOrMore);
        promotions.add(promotion10PercentDiscount);

    }


    /**
     * Items: 0001,0001,0002,0003
     * Total Price: £103.47
     */

    @Test
    public void scanTest1(){
        checkout = new Checkout(promotions);

        testItems1.add(waterBottle);
        testItems1.add(waterBottle);
        testItems1.add(hoodie);
        testItems1.add(stickerSet);

        checkout.scan(testItems1);

        Double total = checkout.total();

        Assert.assertEquals("Total mismatch", OptionalDouble.of(103.47), OptionalDouble.of(total));


    }

    /**
     * Items: 0001,0001,0001
     * Total Price: £68.97
     */
    @Test
    public void scanTest2(){
        checkout = new Checkout(promotions);

        testItems1.add(waterBottle);
        testItems1.add(waterBottle);
        testItems1.add(waterBottle);

        checkout.scan(testItems1);

        Double total = checkout.total();

        Assert.assertEquals("Total mismatch", OptionalDouble.of(68.97), OptionalDouble.of(total));


    }

    /**
     * Items: 0002,0002,0003
     * Total Price: £120.59
     */
    @Test
    public void scanTest3(){
        checkout = new Checkout(promotions);

        testItems1.add(hoodie);
        testItems1.add(hoodie);
        testItems1.add(stickerSet);

        checkout.scan(testItems1);

        Double total = checkout.total();

        Assert.assertEquals("Total mismatch", OptionalDouble.of(120.59), OptionalDouble.of(total));


    }

}
