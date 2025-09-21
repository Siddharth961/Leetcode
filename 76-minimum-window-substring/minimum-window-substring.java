class Solution {
    public String minWindow(String s, String t) {
        
        HashMap<Character, Integer> freq = new HashMap<>();
        HashMap<Character, List<Integer> > curr = new HashMap<>();

        int size =  0;
        PriorityQueue<Pair> pq = new PriorityQueue<>( (a,b) -> a.idx - b.idx);

        for(int i=0; i<t.length(); i++){
            char c = t.charAt(i);

            freq.put(c , freq.getOrDefault(c, 0) + 1);
            curr.put(c, new LinkedList<>() );
        }

        int ans = Integer.MAX_VALUE;
        int f_i = -1;
        int f_j = -1;

        for(int i=0; i<s.length(); i++){

            char ch = s.charAt(i);

            if(freq.containsKey(ch)){

                size += update(i, ch, freq.get(ch), curr, pq);

                if(size == t.length() ){
                    int idx = get_idx(curr, pq);

                    if( ans > (i - idx + 1) ){
                        ans = i - idx + 1;
                        f_i = idx;
                        f_j = i;
                    }
                }
            }
        }

        return ans == Integer.MAX_VALUE ? "" : s.substring(f_i, f_j + 1);




    }

    public int update(int idx, char c, int tar_freq,  HashMap<Character, List<Integer> > mp, PriorityQueue<Pair> pq){

        List<Integer> ll = mp.get(c);

        int ans = 0;

        if( ll.size() == tar_freq ){
            ll.removeFirst();
            ans--;
        }

        ll.add(idx);
        pq.add( new Pair(idx, c) );
        ans++;

        return ans;
    }

    public int get_idx(HashMap<Character, List<Integer> > mp, PriorityQueue<Pair> pq){

        while(pq.size() > 0){
            Pair p = pq.peek();
            List<Integer> ll = mp.get( p.val);

            if(p.idx == ll.get(0) ) return p.idx;
            else pq.remove();
        }

        return -1;

    }

    public class Pair{
        char val;
        int idx;

        Pair(int i, char c){
            idx = i;
            val = c;
        }
    }
}


// make freq map to know how much of each char is needed
// make curr map Char -> queue it will store latest needed occurences of char
// also maintain variable size while adding elements in curr to see if we have em all
// make priorityqueue it will store all -> old and new - occurences of each target char with idx

// we will get top of pq to get farthest needed char but it needs to be validated
// if first element of queue is the same idx then ok else remove it.. easy finding as queue will be sorted

// so travel s
// on each occurence update curr
// if size reaches t.length() start updating answer
// take top pq element and continue until it validates then update ans s_idx - pq_idx + 1