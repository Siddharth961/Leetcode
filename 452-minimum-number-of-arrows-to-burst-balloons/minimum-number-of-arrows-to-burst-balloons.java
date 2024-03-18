class Solution {
    public int findMinArrowShots(int[][] points) {
        // Arrays.sort(points, (a,b)-> Integer.compare(a[0], b[0]));
        quickSort(points, 0, points.length-1);

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

     private void quickSort(int[][] arr, int low, int high) {
        if (low >= high) return;

        random(arr, low, high);

        int i = (low - 1);
        for (int j = low; j <= high; j++) if (arr[j][1] < arr[high][1]) {
            swap(arr, j, ++i);
        }
        swap(arr, high, ++i);

        quickSort(arr, low, i - 1);
        quickSort(arr, i + 1, high);
    }

    private void random(int[][] arr, int low, int high) {
        int mid = low + (high - low) / 2;
        swap(arr, mid, high);
    }

    private void swap(int[][] arr, int x, int y) {
        if (x == y) return;
        int[] temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}