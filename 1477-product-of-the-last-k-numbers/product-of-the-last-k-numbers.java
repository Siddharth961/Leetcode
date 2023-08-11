
class ProductOfNumbers {

    ArrayList<Integer> arr = new ArrayList<Integer>();
    int pro=1;


    public ProductOfNumbers() {
        arr.add(1);
    }
    
    public void add(int num) {
        if(num==0){
            arr = new ArrayList<>();
            pro =  1;
            return;
        }
        pro = pro*num;
        arr.add(pro);
    }
    
    public int getProduct(int k) {

        if(arr.size()<k) return 0;

        else if(arr.size()==k) return pro;
        
        else{
        int idx = arr.size()-k-1; 
        return pro/arr.get(idx);
        }

        
    }
}


/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */