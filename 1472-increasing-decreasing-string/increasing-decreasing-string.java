class Solution {
    public String sortString(String s) {
        TreeMap<Character, Integer> tm = new TreeMap<>();

        for(char c : s.toCharArray()){
            if(tm.containsKey(c)==true){
                tm.put(c, tm.get(c)+1);
            }

            else tm.put(c,1);
        }

        char[]arr = new char[tm.size()];
        int i=0;

        for(char c : tm.keySet()){
            arr[i] = c;
            i++;
        }       

      
        StringBuilder ans = new StringBuilder();       

        while(ans.length()!=s.length()){

            for( i=0; i<arr.length; i++){
                if(tm.get(arr[i])==0) continue;
                ans.append(arr[i]);
                tm.put(arr[i], tm.get(arr[i])-1);

            }
            for( i=arr.length-1; i>=0; i--){
                if(tm.get(arr[i])==0) continue;
                ans.append(arr[i]);
                tm.put(arr[i], tm.get(arr[i])-1);

            }
        }
        return ans.toString();
    }
}