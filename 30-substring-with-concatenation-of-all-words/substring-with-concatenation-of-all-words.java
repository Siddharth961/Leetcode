class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> mp = new HashMap<>();

        for(String str : words) mp.put(str, mp.getOrDefault(str, 0) + 1);

        int len = words.length * words[0].length();

        List<Integer>al = new LinkedList<>();

        for(int i=0; i< s.length() - len + 1; i++){

            if( validate(i, words[0].length(), len, s, mp) ) al.add(i);
        }

        return al;

    }

    public boolean validate(int idx, int size, int len, String s, HashMap<String, Integer> mp){

        int i = idx;

        HashMap<String, Integer> curr = new HashMap<>();


        while( i < idx + len){
            String str = s.substring(i,  i+size);

            curr.put(str, curr.getOrDefault(str, 0) + 1);

            i = i+size;


        }


        for( var k : mp.keySet() ){

            if( !curr.containsKey(k)) return false;

        // System.out.println(len + "  " + curr + " " + s.length() + " " + mp);
            if(!Objects.equals(mp.get(k), curr.get(k)) ) return false;
        }

        return true;
    }
}

// 1. make freq array of words
// 2. do sliding window on s wiht fixed window size of total chars in words
//    while sliding window maintain track of elements, at each step check if curr freq array matches tar freq  array

// 3. whenever freq matches check if string in window is valid, split string in words.length equal parts, check if all strings of words are present in it

// if yess add i to answer

// functions

// - slidingWindow 
//     - O(n) - 10^4
//     - return ans list of indices
//     - calls freqMatch, stringValidation

// - freqMatch
//     - O(1)
//     - returns whether freq matches

// - stringValidation
//     - O( words.length * words[i] ) - 5000*30 - 10^4

// total -> 10^8