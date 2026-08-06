package com.dsa.GreedyApproach;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Knapsack {
    public Knapsack() {
        ArrayList<Bag> bag = new ArrayList<>();
        bag.add(new Bag(100, 20));
        bag.add(new Bag(60, 10));
        bag.add(new Bag(100, 50));
        bag.add(new Bag(200, 50));

        double maxVal = MaximumValue(90, bag);
        System.out.println("Maximum Value : " + maxVal);
    }

    public class Bag{
        private int value;
        private int weight;
        private int fraction;

        public Bag(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.fraction = this.value/this.weight;
        }
    }
    Comparator<Bag> comparator = new Comparator<Bag>() {
        @Override
        public int compare(Bag o1, Bag o2) {
            if(o1.fraction <= o2.fraction)
                return 1;
            else
                return -1;
        }
    };
    public double MaximumValue(int weight, ArrayList<Bag> bag){
        double maxVal = 0;
        bag.sort(comparator);
        int i = 0;
        while(i < bag.size() && weight > 0){
            Bag temp = bag.get(i);
            if(temp.weight <= weight){
                maxVal += temp.value;
                weight -= temp.weight;
            }
            else{
                maxVal += (double) temp.value/((double) temp.weight / weight);
                weight -= temp.weight/ weight;
            }
            i++;
        }
        return maxVal;
    }
}
