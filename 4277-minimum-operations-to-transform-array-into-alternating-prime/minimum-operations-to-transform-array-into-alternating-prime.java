class Solution {
    HashSet<Integer> primes = new HashSet<>();
    public int minOperations(int[] nums) {

        int ops = 0;

        for(int i=0; i<nums.length; i++){

            if( i % 2 == 0 ){

                // if(isPrime(nums[i]) ) continue;

                while( isPrime(nums[i] ) == false){
                    nums[i]++;
                    ops++;
                }
            }

            else{
                while( isPrime(nums[i] ) == true){
                    nums[i]++;
                    ops++;
                }
            }
        }

        return ops;
        
    }

    public boolean isPrime(int val){

        if(val == 1) return false;

        if(primes.contains(val)) return true;

        for(int i=2; i*i <= val; i++){
            if(val % i == 0) return false;
        }

        primes.add(val);

        return true;
    }
}