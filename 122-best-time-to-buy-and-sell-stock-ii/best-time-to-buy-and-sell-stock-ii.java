class Solution {
    public int maxProfit(int[] prices) {
        int stock = prices[0];
        int profit = 0;
        int i = 1;

        while(i<prices.length){

            if(prices[i] < stock){
                stock = prices[i];

            }

            else{
                profit += prices[i] - stock;
                stock = prices[i];
            }

            i++;
        }

        return profit;
    }
}