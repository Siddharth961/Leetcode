class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {

        if(tickets[k]==0) return 0;

        int cycle = tickets[k];
        int count = 0;
        int time=0;

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<tickets.length; i++){
            q.add(tickets[i]);
        }

        while(cycle>0){

            if(count==k && q.peek()==1)return time+1;

            if(q.peek()>0){
            q.add(q.remove()-1);
            time++;
            }
            else q.add(q.remove());



            count++;
            if(count==tickets.length){
                count=0;
                cycle--;
            }
        }

        return time+k+1;

    }
}
