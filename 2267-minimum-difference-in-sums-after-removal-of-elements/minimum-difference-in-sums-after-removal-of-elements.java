class Solution {
    public long minimumDifference(int[] nums) {
        PriorityQueue<Long>pq  = new PriorityQueue<>( Collections.reverseOrder() );

        int n = nums.length/3;

        long[]firsthalf = new long[nums.length];

        long sum = 0;

        for(int i=0; i<nums.length; i++){
            
            if(pq.size() < n){
                pq.add( (long)nums[i] );
                sum += nums[i];
            }
            else{
                long val = pq.peek();
                if(nums[i] < val){
                    pq.remove();
                    pq.add( (long)nums[i] );

                    sum = sum + nums[i] - val;
                }
            }

            firsthalf[i] = sum;

        }

        long[]secondhalf = new long[nums.length];

        sum = 0;
        pq = new PriorityQueue();

        for(int i=nums.length-1; i>=0; i--){
            
            if(pq.size() < n){
                pq.add( (long)nums[i] );
                sum += nums[i];
            }
            else{
                long val = pq.peek();
                if(nums[i] > val){
                    pq.remove();
                    pq.add( (long)nums[i] );

                    sum = sum + nums[i] - val;
                }
            }

            secondhalf[i] = sum;

        }

        // for(int i: firsthalf) System.out.print(i+ " ");
        // System.out.println();
        // for(int i: secondhalf) System.out.print(i+ " ");
        long min = Long.MAX_VALUE;

        for(int i=n-1; i<2*n; i++){

            min = Math.min(min, firsthalf[i] - secondhalf[i+1] );
        }

        return min;


    }
}