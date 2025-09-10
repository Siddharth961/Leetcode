class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String> > mp = new HashMap();

        String freq ;

        for(String s : strs){

            freq = freqStr(s);

            if( !mp.containsKey(freq)){

                mp.put(freq, new LinkedList<>() );
            }

            mp.get(freq).add(s);

            
        }

        List<List<String>> ans = new LinkedList<>();

        for( var e : mp.values()){
            ans.add( e );
        }

        return ans;
    }

    public String freqStr( String s){

        int[]freq = new int[26];

        for(int i=0; i<s.length(); i++){
            freq[ s.charAt(i) - 'a' ]++;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<26; i++){
            if(freq[i] > 0){

                sb.append((char)('a' + freq[i]));
                sb.append(i);
            }
        }

        // System.out.println(sb);

        return sb.toString();
    }
}