class Solution {
    public int maxProfit(int[] prices) {
        int stock = 0;
        int profit = 0;
        int i = 1;

        while(i<prices.length){

            while( i<prices.length && prices[i] <= prices[i-1]){
                i++;
            }

            stock = prices[i-1];
            if(i==prices.length) return profit;
            i++;

            while( i<prices.length && prices[i-1] <= prices[i] ){
                i++;
            }

            profit += prices[i-1] - stock;
        }

        return profit;
    }
}