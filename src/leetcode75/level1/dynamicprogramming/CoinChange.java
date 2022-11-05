package leetcode75.level1.dynamicprogramming;

public class CoinChange {

    public int change(int amount, int[] coins) {
        return recursive(coins, amount);
    }
    
        private int recursive(int[] coins, int amount) {
            if (amount < 0) {
                return 0;
            }
            
            if (amount == 0) {
                return 1;
            }
            int count = 0;
            
            for (int coin : coins) {
                count += recursive(coins, amount- coin);
            }
            return count;
        }
}
