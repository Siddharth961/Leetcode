public class Pair implements Comparable<Pair>{
    int freq;
    char val;

    Pair(int f, char v){
        freq = f;
        val = v;
    }

    @Override
    public int compareTo( Pair p){
        return this.freq - p.freq;
    }

}

class Solution {


    public String reorganizeString(String s) {
        int[]freq = new int[26];

        PriorityQueue<Pair> pq = new PriorityQueue<>( Collections.reverseOrder() );


        
        for(int i=0; i<s.length(); i++){

            freq[ s.charAt(i) - 'a' ]++;
        }

        for(int i=0; i<26; i++){

            if(freq[i] > 0) pq.add( new Pair(freq[i], (char)('a' + i) ));
        }

        StringBuilder sb = new StringBuilder();

        while(pq.size() > 0){
            Pair p = pq.remove();

            if( sb.length() == 0 || sb.charAt(sb.length() - 1) != p.val){
                sb.append(p.val);
                p.freq--;

                
            }
            else{

                if(pq.size() == 0) return "";

                Pair p2 = pq.remove();
                sb.append(p2.val);
                p2.freq--;

                
               if(p2.freq > 0) pq.add(p2);

            }

            if(p.freq > 0) pq.add(p);
        }

        return sb.toString();


    }
}