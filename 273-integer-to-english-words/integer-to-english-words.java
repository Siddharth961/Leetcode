class Solution {
    String[] digitString = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] teenString = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen","Eighteen", "Nineteen"};
    String[] tenString = new String[]{"","","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public String numberToWords(int num) {
        if(num == 0) return "Zero";

        return solve(num);
    }

    public String solve(int num){

        if(num < 10){
            return digitString[num];
        }
        if(num<20){
            return teenString[num % 10];
        }
        if(num<100){
            return tenString[num / 10] + (num%10 != 0 ? " " + digitString[num % 10] : "");
        }
        if(num < 1000){
            return digitString[num/100] + " Hundred" + (num%100 != 0 ? " " + solve(num % 100) : "");
        }
        if(num < 1000000){
            return solve(num/1000) + " Thousand" + (num%1000 != 0 ? " " + solve(num % 1000) : "");
        }
        if(num < 1000000000){
            return solve(num/1000000) + " Million" + (num%1000000 != 0 ? " " + solve(num % 1000000) : "");

        }

        return solve(num/1000000000) + " Billion" + (num%1000000000 != 0 ? " " + solve(num % 1000000000) : "");


    }
}