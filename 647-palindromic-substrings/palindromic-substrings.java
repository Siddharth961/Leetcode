class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        int l=0;
        int r=0;

        char[]arr = s.toCharArray();

        for(int i=0; i<arr.length; i++){
            l=i;
            r=i;
            while(l>=0 && r<arr.length){
                if(arr[l]==arr[r]){
                    count++;
                    l--;
                    r++;
                }
                else break;
            }
            l=i;
            r=i+1;
            while(l>=0 && r<arr.length){
                if(arr[l]==arr[r]){
                    count++;
                    l--;
                    r++;
                }
                else break;
            }
        }

        return count;
    }
}