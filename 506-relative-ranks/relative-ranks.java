class Solution {
    public String[] findRelativeRanks(int[] score) {
        HashMap<Integer, Integer>mp = new HashMap<>();

        for(int i=0; i<score.length; i++) mp.put(score[i], i);

        Arrays.sort(score);

        String[] rank = new String[score.length];

        int count = score.length;


        for( int i: score){

            if(count==1) rank[mp.get(i)] =  "Gold Medal";
            else if(count==2)  rank[mp.get(i)] =  "Silver Medal";
            else if(count==3) rank[mp.get(i)] = "Bronze Medal";
            else rank[mp.get(i)] = count+"";
            count--;
        }

        return rank;


    }
}