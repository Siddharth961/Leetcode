class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        dfs(1, triangle);

        List<Integer> al = triangle.get(triangle.size() - 1);

        int min = Integer.MAX_VALUE;

        for(int i : al) min = Math.min(i, min);

        return min;
    }

    public void dfs(int row,  List<List<Integer>> triangle){

        if(row == triangle.size()) return;

        List<Integer> prev = triangle.get(row-1);
        List<Integer> curr = triangle.get(row);

        for(int i=0; i<curr.size(); i++){

            int val = Integer.MAX_VALUE;

            if(i > 0 ) val = prev.get(i-1);
            if(i < prev.size()) val = Math.min( val, prev.get(i));

            curr.set(i, curr.get(i) + val);
        }

        dfs(row + 1, triangle);
        
    }
}