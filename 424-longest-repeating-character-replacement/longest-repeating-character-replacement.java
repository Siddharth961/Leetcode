class Solution {
    public int characterReplacement(String s, int k) {

        int i=0;
        int j=0;
        int count = 0;

        int max = 0;

        char[]arr = s.toCharArray();
        
        for(char c = 'A'; c<='Z'; c++){

            i=0;
            j=0;
            count = 0;

            while(j<arr.length){

                // if(arr[j]=='A') j++
                if( arr[j] != c){
                    count ++;

                    while(count > k){
                        if(arr[i] != c) count--;
                        i++; 
                    }
                }

                max = Math.max( max, j-i+1);
                j++;
            }
            max = Math.max( max, j-i);

        }

        return max;
    }
}