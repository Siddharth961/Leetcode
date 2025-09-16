class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        HashSet<String> visited = new HashSet<>();

        Queue<String> q = new LinkedList<>();

        int level = 1;

        q.add(beginWord);

        while(q.size() > 0){

            // System.out.println(q);

            int size = q.size();

            while(size > 0){

                String s = q.remove();
                size--;

                if( s.equals(endWord) ) return level;

                if( visited.contains(s) ) continue;
                visited.add(s);

                for(String b : wordList){

                    if( !visited.contains(b) && check(s,b) ){
                         q.add(b);
                         
                    }
                }

            }

            level++;
        }

        return 0;
    }

    public boolean check (String s, String b){
        

        int count = 0;
        for(int i=0; i<s.length(); i++){

            if(s.charAt(i) != b.charAt(i) ) count++;

        }        

        return count == 1;
    }
}

// leet lest lost lose lode code