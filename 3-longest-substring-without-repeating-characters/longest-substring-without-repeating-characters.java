class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashMap<Character, Integer> mp = new HashMap<>();

        int max = 0;

        char[]arr = s.toCharArray();

        int i=0;
        int j=0;

        while(j < arr.length){
            
            if(mp.containsKey( arr[j] )){
                
                max = Math.max(max, j - i);
                
                int idx = mp.get(arr[j]);
                while(i<=idx ){
                    mp.remove(arr[i]);
                    i++;
                }
            }

            mp.put(arr[j], j);

            j++;
        }
        max = Math.max(max, j - i);
       

        return max;
    }
}