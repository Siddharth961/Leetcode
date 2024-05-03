class Solution {
    public int compareVersion(String version1, String version2) {
        
        String[]a = version1.split("\\.");
        String[]b = version2.split("\\.");
        
        int len = Math.max(a.length, b.length);

        int i=0;
        int j=0;
        int val1=0;
        int val2=0;

        while(i<len && j<len){

            val1=0;            
            val2=0;

            if(i<a.length){
                val1 = Integer.parseInt(a[i]);
                i++;
            }     
            if(j<b.length){
                val2 = Integer.parseInt(b[j]);
                j++;
            }     

            int ans = compare(val1, val2);
            if(ans!=0) return ans;
        }

        return 0;

    }

    public int compare( int a, int b){
        if(a>b) return 1;
        else if(a==b) return 0;
        else return -1;
    }
}