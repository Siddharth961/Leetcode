class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b)-> Integer.compare(a[0], b[0]));

        // for(int[]i : points) System.out.println(i[0] +" " + i[1]);

        int arrows =0;
        int i = 0;
        int[]temp;
        int min = 0;
        while( i<points.length){

            temp = points[i];
            min = temp[1];

            while(i+1<points.length && temp[1]>=points[i+1][0]){

                if(points[i+1][0]>min) break;
                if(points[i+1][1] < min) min = points[i+1][1];

                if(points[i+1][0] <= min && points[i+1][1] > temp[1]) temp = points[i+1];

                i++; 
            }

            arrows++;
            i++;
        }

        return arrows;
    }
}