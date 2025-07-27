class Solution {
    public int countHillValley(int[] nums) {
        int hills = 0;
        int valleys = 0;


        ArrayList<Integer> al = new ArrayList<>();

        for(int i=1; i<nums.length; i++){

            if(nums[i-1] != nums[i] ){
                al.add(nums[i-1]);
            }
        }
        al.add(nums[nums.length-1]);

        for(int i=1; i<al.size() - 1; i++){

            int prev = al.get(i-1);
            int next = al.get(i+1);
            int curr = al.get(i);

            if( prev < curr && curr > next) hills++;
            if( prev > curr && curr < next) valleys++;
        }


        return hills + valleys;
    }
}