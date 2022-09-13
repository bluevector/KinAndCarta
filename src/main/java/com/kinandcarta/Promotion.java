package com.kinandcarta;

import java.util.List;

public interface Promotion {
    public Double applyPromotion(List<Product> products, Double total);
}
