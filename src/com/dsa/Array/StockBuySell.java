package com.dsa.Array;

public class StockBuySell {
    public StockBuySell() {
        int[] prices = {7,1,3,5,2,8};
        buySell(prices);
    }

    public void buySell(int[] stk){
        int min = stk[0];
        int cost = stk[0];
        int profit = 0;
        int sellingCost = stk[0];

        for(int i = 1; i < stk.length ;i++){
            cost = stk[i] - min;
            if(profit < cost){
                profit = cost;
                sellingCost = stk[i];
            }
            if(stk[i] < min)
                min = stk[i];
        }

        System.out.println("Buying Cost: "+ min);
        System.out.println("Profit: "+ profit);
        System.out.println("Selling Cost: "+ sellingCost);
    }
}
