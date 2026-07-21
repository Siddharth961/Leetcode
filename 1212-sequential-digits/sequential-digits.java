class Solution {
    List<Integer> ans = new LinkedList<>();
    public List<Integer> sequentialDigits(int low, int high) {
        
        for(int i=1; i<=9; i++) get_ans(i, low, high);

        Collections.sort(ans);

        return ans;
    }

    public void get_ans(int curr, int l, int h){

        // System.out.println(curr);

        if(curr > h) return;

        if(curr >= l) ans.add(curr);

        int last_digit = curr % 10 ;

        if(last_digit != 9) get_ans( curr*10 + last_digit + 1, l, h);
    }


}