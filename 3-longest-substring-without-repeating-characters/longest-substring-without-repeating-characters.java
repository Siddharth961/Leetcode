class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int[]pos= new int[95]; // for digits alphas space and symbols
        Arrays.fill(pos,-1);


        int max = 0;

        char[]arr = s.toCharArray();

        int i=0;
        int j=0;

        while(j < arr.length){
            
            if( pos[ arr[j]-' ' ] != -1){
                
                max = Math.max(max, j - i);
                
                int idx = pos[ arr[j]-' ' ];
                while(i<=idx ){
                    pos[ arr[j]-' ' ] = -1;
                    i++;
                }
            }

            pos[ arr[j]-' ' ] = j;

            j++;
        }
        max = Math.max(max, j - i);
       

        return max;
    }
}