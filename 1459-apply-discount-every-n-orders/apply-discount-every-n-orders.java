class Cashier {

    HashMap<Integer, Integer> mp = new HashMap<>();
    int n=0;
    int max = 0;
    int dis = 0;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        for(int i=0; i<products.length; i++){
            mp.put(products[i] , prices[i]);
        }

        max = n;
        dis = discount;

    }
    
    public double getBill(int[] product, int[] amount) {
        double bill = 0.0;

        for(int i=0; i<product.length; i++){
            
            bill += amount[i]*mp.get(product[i]);
        }
        n++;

        if(n==max){
            bill -= (bill*dis)/100;
            n=0;
        }

        return bill;

    }
}

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj.getBill(product,amount);
 */