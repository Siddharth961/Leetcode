class Solution {
    public int minOperations(String s) {
        
        char min = 'z';
        char max = 'a';

        boolean sorted = true;

        for(int i=0; i<s.length(); i++){

            char c = s.charAt(i);
            
            min = (char)Math.min(min, c);
            max = (char)Math.max(max, c);

            if( i > 0){
                if(s.charAt(i-1) > c) sorted = false;
            }
        }

        if(sorted) return 0;

        boolean min_at_start = s.charAt(0) == min;
        boolean max_at_start = s.charAt(0) == max;
        boolean min_at_end = s.charAt( s.length() - 1 ) == min;
        boolean max_at_end = s.charAt( s.length() - 1) == max;

        if(min_at_start || max_at_end) return 1;

        boolean min_in_mid = false;
        boolean max_in_mid = false;

        for(int i=1; i<s.length()-1; i++){

            if(s.charAt(i) == min) min_in_mid = true;
            if(s.charAt(i) == max) max_in_mid = true;

        }

        if(min_in_mid || max_in_mid) return 2;

        if(s.length() == 2) return -1;

        return 3;
    }
}

// possible answers

// 0 -> if already sorted
// 1 -> (if idx 0 is smallest || if idx n-1 is largest) then select rest of string and sort 
// 2 -> we need to put smallest at idx0 or largest at idx n-1 .. then we can solve rest in 1 step 
//      if any of them are not in opposite ends then we can select a str containg either and sort it
//      eg -> curr str ( ....(smallest).. ) after step one -> ( (smallest)...... )
// 
// 3 -> if str is like ( (largest)........(smallest) ) then first we need to covert it like 
//      ( (largest)..(smallest).. ) then do the 2 step process

// -1 -> if str is of size 2 and is like ( (largest)(smallest) )

