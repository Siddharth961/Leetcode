class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Character> q = new LinkedList<>();

        for(int i=0; i<senate.length(); i++){
            q.add(senate.charAt(i));
        }

        int r_count = 0;
        int d_count = 0;

        

        while(r_count*2<q.size() && d_count*2<q.size()){
            while(d_count!=0 && q.peek()=='R'){
                q.remove();
                d_count--;
            }

            while(r_count!=0 && q.peek()=='D'){
                q.remove();
                r_count--;
            }

            if(q.peek()=='R'){
                q.add(q.remove());
                r_count++;
            }

            else if(q.peek()=='D'){
                q.add(q.remove());
                d_count++;
            }
        }

        if(d_count>r_count) return "Dire";
        else return "Radiant";
    }
}