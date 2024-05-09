class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int candi1 = 0;
        int candi2 = 1;
        int count1 = 0;
        int count2 = 0;

        for(int i : nums){
            if( i==candi1 ){
                count1++;
            }
            else if(i==candi2){
                count2++;
            }
            else if( count1==0 ){
                candi1 = i;
                count1 = 1;
            }
            else if( count2==0 ){
                candi2 = i;
                count2 = 1;
            }
            else{
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for(int i : nums){
            if(i==candi1) count1++;
            if(i==candi2) count2++;
        }

        List<Integer> al = new ArrayList<>();
        if(count1 > (nums.length/3)) al.add(candi1);
        if(count2 > (nums.length/3)) al.add(candi2);

        return al;
    }
}