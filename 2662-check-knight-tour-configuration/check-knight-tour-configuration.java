class Solution {
    public boolean checkValidGrid(int[][] grid) {
       return check(grid,0,0,0);
    }

    public boolean check(int[][]grid, int r, int c, int num){
        if(r<0 || c<0 || r>=grid.length || c>=grid.length) return false;
        if(grid[r][c]!=num) return false;

        if(num== grid.length*grid.length - 1) return true;
        
        boolean a = check(grid, r-2, c+1, num+1);
        boolean b = check(grid, r-1, c+2, num+1);
        boolean c1 = check(grid, r+1, c+2, num+1);
        boolean d = check(grid, r+2, c+1, num+1);
        boolean e = check(grid, r+2, c-1, num+1);
        boolean f = check(grid, r+1, c-2, num+1);
        boolean g = check(grid, r-1, c-2, num+1);
        boolean h = check(grid, r-2, c-1, num+1);

        return a || b || c1 || d || e || f || g || h;
    }
}