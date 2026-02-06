class Solution {
    public long maxSumTrionic(int[] nums) {

        // Use ARRAYLIST for o(1) random access and since we goona insert at last - O(1) insertion
        List<Trend> ll = new ArrayList<>(); // stores arr of size 3 .. st, end, trend(inc or dec)


        int j=1;

        while(j < nums.length){

            if(nums[j-1] == nums[j]){
                j++;
                continue;
            }

            char dir = nums[j-1] < nums[j] ? 'U' : 'D'; 

            if(ll.size() == 0){
                Trend curr = new Trend(j-1, j, dir, nums[j-1]); // THINK OF en HERE
                curr.add(j, nums[j]);

                ll.add( curr ) ;
            }

            else{
                Trend ongoing= ll.get(ll.size() - 1);

                // check of last entry had same trend and that it really is a continuation

                if(ongoing.dir == dir && ongoing.en == j-1){

                    ongoing.add(j, nums[j]);

                }

                else{
                    Trend curr = new Trend(j-1, j, dir, nums[j-1]); // THINK OF en HERE
                    curr.add(j, nums[j]);

                    ll.add( curr ) ;
                }
            }

            j++;


        }

        // for(int val : nums)System.out.print(val+ " ");
        // System.out.println();




        long ans = Long.MIN_VALUE;

        for(int i = 1; i<ll.size()-1; i++){

            Trend prev = ll.get(i-1);
            Trend curr = ll.get(i);
            Trend next = ll.get(i+1);

            if(
                (prev.dir == 'U' && next.dir == 'U' && curr.dir == 'D')
                && (prev.en == curr.st && curr.en == next.st)
                ){
                    long st_sum = prev.getSuf(nums);
                    long mid_sum = curr.sum - nums[curr.st] - nums[curr.en];
                    long en_sum = next.getPre();

                    long sum = st_sum + mid_sum + en_sum;

                    

                    ans = Math.max(ans, sum);
                }
        }

        // System.out.println(ll);


        return ans;
    }

    class Trend{
        int st;
        int en;
        char dir;

        long sum;
        long best_pre;
        long best_suf;

        boolean calculated_suf;


        Trend(int s, int e, char d, int val){
            st = s;
            en = e;
            dir = d;
            best_pre = val;
            sum = val;
        }

        public void add(int idx, int val){
            en = idx;
            sum += val;

            if(st + 1 == idx) best_pre = sum;
            else best_pre = Math.max(best_pre, sum);
        }

        public long getPre(){
            return this.best_pre;
        }

        public long getSuf(int[]arr){

            if(calculated_suf) return this.best_suf;

            long sum = arr[en] + arr[en-1];
            long suf = sum;

            for(int i=en-2; i>=st; i--){
                sum += arr[i];
                suf = Math.max(suf, sum);
            }

            this.best_suf = suf;
            calculated_suf = true;
            return this.best_suf;
        }

        @Override
        public String toString(){
            return "s:" +st + " e:" + en + " pre:" + best_pre +   " suf:" + best_suf + " sum:"+ sum + "\n";
        }

    }
}

// -2
// -4 - (-1) - (-3) = 0