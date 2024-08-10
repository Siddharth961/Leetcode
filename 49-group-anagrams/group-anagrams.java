class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, Integer> mp = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        int idx = -1;
        
        for(String s : strs){

            char[]arr = s.toCharArray();
            Arrays.sort( arr );

            String str = new String(arr);
            // System.out.println(s);  

            if( !mp.containsKey(str) ){
                mp.put(str, ++idx );
                List<String> al = new ArrayList<>();
                al.add(s);
                ans.add(al);
            }
            else{
                int index = mp.get(str); 
                ans.get(index ).add(s);
            }

        }

        return ans;
    }
}
