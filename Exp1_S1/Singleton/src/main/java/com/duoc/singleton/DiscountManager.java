
package com.duoc.singleton;

public class DiscountManager {
    private static DiscountManager instance;

    private DiscountManager() {
        
    }

    public static DiscountManager getInstance() {
        if (instance == null) {
            instance = new DiscountManager();
        }
        return instance;
    }

    public double calculateDiscountPercentage(int quantity) {
        if (quantity >= 3 && quantity <= 5) {
            return 5.0;
        } else if (quantity >= 6 && quantity <= 9) {
            return 7.0;
        } else if (quantity >= 10) {
            return 10.0;
        }
        return 0.0;
    }


}