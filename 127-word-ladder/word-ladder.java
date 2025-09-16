class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        HashSet<String> words = new HashSet<>(wordList);

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

                // if( visited.contains(s) ) continue;
                // visited.add(s);

                // for(String b : wordList){

                //     if( !visited.contains(b) && check(s,b) ){
                //          q.add(b);
                         
                //     }
                // }

                for(int i=0; i<s.length(); i++){
                    for( char ch = 'a'; ch<='z'; ch++){

                        String b = s.substring(0,i) + ch + s.substring(i + 1);

                        if( words.contains(b) ){
                            q.add(b);
                            words.remove(b);
                        }
                    }
                }

            }

            level++;
        }

        return 0;
    }
}
    // public boolean check (String s, String b){
        

    //     int count = 0;
    //     for(int i=0; i<s.length(); i++){

    //         if(s.charAt(i) != b.charAt(i) ) count++;

    //     }        

    //     return count == 1;
    // }

//     public List<String> getNeighbors(String word, Set<String> wordSet) {
//         List<String> neighbors = new ArrayList<>();
//         char[] chars = word.toCharArray();

//         for (int i = 0; i < chars.length; i++) {
//             char original = chars[i];

//             for (char c = 'a'; c <= 'z'; c++) {
//                 if (c == original) continue;
//                 chars[i] = c;
//                 String newWord = new String(chars);
//                 if (wordSet.contains(newWord)) {
//                     neighbors.add(newWord);
//                 }
//             }

//             chars[i] = original;
//         }

//         return neighbors;
//     }
// }

// leet lest lost lose lode code