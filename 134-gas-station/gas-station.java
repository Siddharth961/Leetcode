class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int temp=0;
        int g = 0;
        for(int i=0; i<gas.length; i++){

            int count  = gas.length;
            int j=i;
            g=0;

            while(count>0){
                if(j==gas.length)j=0;

                g += gas[j]-cost[j];
                count--;
                j++;
                
                if(g<=0){
                    
                 break;}
            }

            if(count==0 && g>=0)return i;

            
        }

        return -1;
    }
}