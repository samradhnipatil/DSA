package com.dsa.GreedyApproach;

public class MinimumCoins {
    public MinimumCoins() {
        int amount = 87;
        int[] coins = {1,2,5,10,20,50,100,500,1000};

        int count = CountCoins(amount, coins);
        System.out.println("Coins : " + count);
    }

    public int CountCoins(int amount, int[] coins){
        int count = 0;
        int i = 0;
        while(coins[i] < amount)
            i++;
        i--;
        while(amount > 0 && i >= 0){
            int divisor = coins[i];
            count += (amount / divisor);
            amount = amount % coins[i];
            while( i != 0 && amount < coins[i])
                i--;
        }
        return count;
    }
}
