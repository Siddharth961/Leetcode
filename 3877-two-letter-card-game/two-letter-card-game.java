class Solution {
    public int score(String[] cards, char x) {

        int both = 0;
        int left = 0;
        int right = 0;

        int left_max = 0;
        int right_max = 0;

        HashMap<String , Integer> freq = new HashMap<>();

        for(String s : cards){

            if(s.charAt(0) == x && s.charAt(1) == x){
                both++;
            }
            else if(s.charAt(0) == x){
                left++;

                int val = freq.getOrDefault(s, 0) + 1;

                if( left_max < val){
                    left_max = val;
                }

                freq.put( s, val );
            }
            else if(s.charAt(1) == x) {
                right++;

                int val = freq.getOrDefault(s, 0) + 1;

                if( right_max < val){
                    right_max = val;
                }

                freq.put( s, val );
            }

        }

        int pairs = 0;

        int remaining = 0;

        int[]arr = calc(left_max, left);
        pairs += arr[0];
        remaining += arr[1];
        System.out.println(remaining);

        arr = calc(right_max, right);
        pairs += arr[0];
        remaining += arr[1];

        System.out.println(remaining);

        int more_pairs = Math.min(remaining, both);


        remaining -= more_pairs;
        both -= more_pairs;

        int val = pairs;

        while(val > 0 && both > 1){
            pairs += 1;
            both -= 2;
            val--;

        }

        return pairs + more_pairs;

    }

    public int[] calc(int max, int total){

        int others = total - max;

        int pairs = 0;
        int remaining = 0;

        if( max > others){
            pairs += others;

            remaining = total - others*2;
        }
        else{
            pairs = total / 2;
            remaining = total % 2;
        }

        return new int[]{pairs, remaining};
    }
}