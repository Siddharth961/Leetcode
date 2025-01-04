class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        boolean[][] visited = new boolean[image.length][image[0].length];
        
        travel(image, sr, sc, color, image[sr][sc], visited);

        return image;
    }

    public void travel(int[][] image, int i, int j, int color, int tar, boolean[][]visited){

        if( visited[i][j] ) return;
        visited[i][j] = true;

        image[i][j] = color;

        if(i-1 >= 0 && image[i-1][j] == tar){
            travel(image, i-1, j, color, tar, visited);
        }

        if(j+1 < image[0].length && image[i][j+1] == tar){
            travel(image, i, j+1, color, tar, visited);
        }

        if(i+1 < image.length && image[i+1][j] == tar){
            travel(image, i+1, j, color, tar, visited);
        }

        if(j-1 >= 0 && image[i][j-1] == tar){
            travel(image, i, j-1, color, tar, visited);
        }
    }
}