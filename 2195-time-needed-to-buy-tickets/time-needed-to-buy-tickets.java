class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {

        int i=0;
        int time=0;
        while(tickets[k]!=0){

            if(tickets[i]>0){
                tickets[i]--;
                time++;
            }

            if(tickets[k]==0) return time;

            i++;
            if(i==tickets.length) i=0;
        }

        return time;


    }
}
