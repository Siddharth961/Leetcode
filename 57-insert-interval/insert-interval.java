class Solution {
    public int[][] insert(int[][] inter, int[] newIn) {
        ArrayList<int[]> al = new ArrayList<>();
        boolean merged = false;

        int i=0;
        while(i<inter.length){
            if(merged==false && newIn[1]<inter[i][0]){ // new interval occurs completely before start of this interval
                al.add(newIn);
                merged=true;
            }
            if(merged==false && newIn[0]<inter[i][0] && newIn[1]>= inter[i][0]){ // new interval starts before this interval but overlaps with it
                inter[i][0] = newIn[0];
                inter[i][1] = inter[i][1]>newIn[1] ? inter[i][1] : newIn[1];

            }

            if(newIn[0] >= inter[i][0] && newIn[0]<= inter[i][1] && merged==false){ // new interval starts somewhere between this interval
                inter[i][1] = inter[i][1]>newIn[1] ? inter[i][1] : newIn[1];

                merged =  true;
            }
 
            int[]temp = inter[i]; 

            while(i+1<inter.length && inter[i+1][0] <= temp[1]){
                
                temp[1] = temp[1] < inter[i+1][1] ? inter[i+1][1] : temp[1]; // next interval starts somewhere between this interval
                
                if(newIn[0] >= temp[0] && newIn[0]<= temp[0] && merged==false){ // new interval starts somewhere between this interval
                    temp[1] =  temp[1]>newIn[1] ? temp[1] : newIn[1] ;
                    merged = true;
                }

                i++;
            }

            al.add(temp);
            
            i++;
        }

        if(merged==false)al.add(newIn); // in case array size is zero or new interval is to be added seperately in last

        int[][]ans = new int[al.size()][2];
        i=0;

        for(var e : al){
            ans[i][0] = e[0];
            ans[i][1] = e[1];
            i++;
        }
        return ans;
    }
}