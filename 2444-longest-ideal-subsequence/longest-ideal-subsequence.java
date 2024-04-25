class Solution {
    public int longestIdealString(String s, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();

       

        char[]arr = s.toCharArray();

        int[]dp = new int[arr.length];

        int ans = 0;

        for(int i=0; i<arr.length; i++){
            
            if(i==0){
                mp.put( arr[i]-'a', i);
                dp[i]++;

            }

            else{
                int x = arr[i] - 'a';
                int count = k;

                int val = 0;

                while(count>= -k){

                    if(mp.containsKey( x + count)){
                        
                        val = Math.max(val, dp[mp.get(x+count)]);
                    }

                    count--;
                }

                dp[i] = val+1;
                mp.put(x, i);

            }
            ans = Math.max(ans, dp[i]);
        }

        
        return ans;
    }
}