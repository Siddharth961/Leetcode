class Solution {
    public int maxProfit(int[] prices) {
        
        int buy_price = Integer.MAX_VALUE;
        int profit = 0;

        for(int i : prices){

            if( i < buy_price){
                buy_price = i;
            }
            else{
                profit += i - buy_price;
                buy_price = i;
            }
        }

        return profit;
    }
}