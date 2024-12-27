class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int ans = 0;
        int count = 1;

        for(int i=citations.length - 1; i>=0; i--){

            if( citations[i] >= count){
                ans = Math.min(count, citations[i]);
                System.out.println(ans);
                count++;
            }
            else return ans;
        }

        return ans;


    }
}