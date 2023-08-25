class Solution {
    public int findJudge(int n, int[][] trust) {
        HashSet<Integer>st = new HashSet<>();

        for(int i=1; i<=n; i++) st.add(i);
       
        for(int i=0; i<trust.length; i++){
            if(trust[i][0] != trust[i][1]) st.remove(trust[i][0]);
        }
        int ans = -1;

        for( var e : st){
            ans = e;                    
        }

        if(ans==-1) return ans;

        int count=0;

        for(int i=0; i<trust.length; i++){
            if(trust[i][1] == ans) count++;
        }

        if(count==n || count == n-1) return ans;

        return -1;
    }
}