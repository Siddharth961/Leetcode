class Solution {
    public class Pair{
        char val;
        int freq;

        Pair(char v, int f){
            val = v;
            freq = f;
        }
    }
    public String reorganizeString(String s) {
        
        int[]freq = new int[26];

        int max = 0;

        for(int i=0; i<s.length(); i++){

            int idx = s.charAt(i) - 'a';
            freq[ idx ]++;

            // max = Math.max(max, freq[idx] );
        }

        // if(max > s.length()/2) return "";

        PriorityQueue<Pair> pq = new PriorityQueue<>( (a,b) -> b.freq - a.freq);

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<26; i++){
           if(freq[i] > 0) pq.add( new Pair( (char)('a' + i), freq[i] ) );

        }

        while(pq.size() > 1){
            Pair p1 = pq.remove();
            Pair p2 = pq.remove();

            sb.append(p1.val);
            sb.append(p2.val);

            p1.freq--;
            p2.freq--;

            if(p1.freq > 0) pq.add(p1);
            if(p2.freq > 0) pq.add(p2);
        }

        if(pq.size() > 0){
            Pair p = pq.remove();

            if(p.freq > 1) return "";

            sb.append(p.val);
        }

        return sb.toString();

    }
}