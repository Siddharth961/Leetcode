class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        
        Pair[]map_val = new Pair[nums.length];

        for(int i=0; i<nums.length; i++){
            map_val[i] = new Pair(get_map_val(nums[i], mapping), nums[i]);
            // System.out.print(map_val[i].a + " ");
            
        }

        Pair.sort(map_val);
        for(int i=0; i<nums.length; i++){
            nums[i] = map_val[i].b;
        }

        return nums;
    }

    public class Pair{
        int a;
        int b;

        Pair( int a, int b){
            this.a = a;
            this.b = b;
        }

        static void sort(Pair[]arr){
            Comparator<Pair> comparator = new Comparator<>(){
                @Override
                public int compare(Pair p1, Pair p2){
                    return p1.a- p2.a;
                }
            };
        Arrays.sort(arr, comparator);
        }
    }

    public int get_map_val(int n, int[]mapping){

        if(n==0) return mapping[0];

        int pow = 1;
        int ans = 0;

        int val = 0;

        while(n>0){
            val = mapping[n%10] * pow ;
            ans = val + ans;

            pow *= 10;
            n /= 10;
        }

        return ans;

    }
}