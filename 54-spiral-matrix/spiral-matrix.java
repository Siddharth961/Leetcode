class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> al = new ArrayList<>();

        int rs = 0;
        int cs = 0;
        int re = matrix.length-1;
        int ce = matrix[0].length-1;

        int total = (re+1)*(ce+1);
        int count = 0;

        while(count< total &&  rs<=re && cs <= ce){

            if(count < total){
                for(int i=cs; i<=ce; i++){
                    al.add(matrix[rs][i]);
                    count++;
                }

            }
            rs++;

            if(count < total){
                for(int i=rs; i<=re; i++){
                    al.add(matrix[i][ce]);
                    count++;
                }

            }
            ce--;

            if(count < total){
                for(int i=ce; i>=cs; i--){
                    al.add(matrix[re][i]);
                    count++;
                }

            }
            re--;

            if(count < total){
                for(int i=re; i>=rs; i--){
                    al.add(matrix[i][cs]);
                    count++;
                }

            }
            cs++;
        }

        return al;
    }
}