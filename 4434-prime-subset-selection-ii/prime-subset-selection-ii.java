class Solution {
    public List<Integer> maxPrimeSubset(int n, int s) {

        boolean[]prime = new boolean[n+1];
        Arrays.fill(prime, true);
        prime[0] = false;
        if( n>0 ) prime[1] = false;


        for(int i=2; i*i <= n; i++){

            if( prime[i] == true){

                for(int j=i*i; j<=n; j += i){
                    prime[j] = false;
                }
            }
        }

        List<Integer> prime_list = new ArrayList<>();

        for(int i=2; i<=n; i++){
            if(prime[i]) prime_list.add(i);
        }

        Data ans = get_ans(0, s, prime_list);

        // System.out.println(ans.list);
        return ans.list;

    }

    // i 168
    // lsf size - 168
    // ssf - 1000
    // first element - 1000

    Data[][]dp = new Data[169][1001]; 

    public Data get_ans(int i, int s, List<Integer> prime_list){

        if( i == prime_list.size() || s - prime_list.get(i) < 0){
            return new Data();
        }

        if(dp[i][s] != null) return new Data( dp[i][s] );



        // take

        int val = prime_list.get(i);
        
        Data take = get_ans(i+1, s - val, prime_list);
        take.add(val); // appending current element at start

        // no take

        Data no_take = get_ans(i+1, s, prime_list);

        Data ans;

        if( take.sum() > no_take.sum() ){
            ans = take;
        }
        else if( take.sum() < no_take.sum() ){
            ans = no_take;
        }

        else{

            // both have max sum

            // second check is their size

            // third check is lexico smaller which will be - " take " by default 
            // as no_take will have next element greater than current ( as primes list is sorted)
            // or if does not take ANY more element it will have less elements .. so in that case "take" wins again

            ans = take.size() <= no_take.size() ? take : no_take;
        }

        dp[i][s] = new Data( ans );

        return ans;

    }

    // class to hold return data from each recursion
    public class Data{
        List<Integer> list;
        int sum;
        
        Data(){
            list = new LinkedList<>();
            sum = 0;
        }

        // constructor to create a hard copy of another DATA object
        Data( Data d ){
            list = new LinkedList<>( d.list );
            sum = d.sum;
        }

        public int size(){
            return list.size();
        }

        public void add( int val ){
            list.add(0, val);
            sum += val;
        }

        public int sum(){
            return this.sum;
        }

        
    }
}