class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        for(char c : s.toCharArray()) mp.put(c, mp.getOrDefault(c,0)+1);

        StringBuilder sb = new StringBuilder();

        for(char c : order.toCharArray()){
            while(mp.getOrDefault(c,0)>0){
                sb.append(c);
                mp.put(c, mp.get(c)-1);
            }
        }

        for(var e : mp.entrySet()){
            int count = e.getValue();
            while(count>0){
                sb.append(e.getKey());
                count--;
            }

        }

        return sb.toString();
    }
}