package com.dsa.SlidingWindow_TwoPointer;

import java.util.ArrayList;

public class FruitsInABasket {

    public static void main(String[] args) {
        int[] fruits = {1, 2, 1};
        System.out.println(getMaxFruits(fruits));
    }

    public static int getMaxFruits(int[] fruits) {
        ArrayList<Integer> basket1 = new ArrayList<>();
        ArrayList<Integer> basket2 = new ArrayList<>();
        int i = 0;
        int j = 0;
        int max = 0;
        while(j < fruits.length) {
            if(basket1.contains(fruits[j])){
                basket1.add(fruits[j]);
                j++;
            }
            else if(basket2.contains(fruits[j])){
                basket2.add(fruits[j]);
                j++;
            }
            else if(basket1.isEmpty()){
                basket1.add(fruits[j]);
                j++;
            }
            else if(basket2.isEmpty()){
                basket2.add(fruits[j]);
                j++;
            }
            else {
                max = Math.max(max, basket1.size() + basket2.size());
                if(basket1.contains(fruits[i]))
                    basket1.clear();
                if(basket2.contains(fruits[i]))
                    basket2.clear();
                i++;
            }
        }
        return Math.max(max, basket1.size() + basket2.size());
    }
}
