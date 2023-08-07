class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {

        int a=tickets[k];
        int time=0;
        for(int i=0; i<tickets.length; i++){
            if(i<k){
                if(tickets[i]>=a) time += a;
                else time += tickets[i];
            }
            else if(i==k) time += a;
            else{
                if(tickets[i]>=a) time += a-1;
                else time += tickets[i];
            }

        }

        return time;


    }
}
