class Solution {
    public double maxAverageRatio(int[][] classes, int extras) {
        
        PriorityQueue<Pair> pq = new PriorityQueue(Collections.reverseOrder());

        for(int[]arr : classes){
            pq.add(new Pair(arr[0], arr[1] ) );
        }
        // for(Pair p : pq){
        //     System.out.println( p.num + " " + p.den + " " + p.ratioDiff);
        // }

        while(extras > 0){
            Pair p = pq.remove();

            p.num += 1;
            p.den += 1;

            p.ratioDiff = ((p.num + 1) / (p.den + 1)) - (p.num/p.den);

            pq.add(p);

            extras--;
        }

        double ans = 0;

        for(Pair p : pq){
            ans += p.num/p.den;
        }

        return ans/classes.length;
    }

    public class Pair implements Comparable<Pair>{
        double num;
        double den;
        double ratioDiff;

        Pair(double n, double d){
            num = n;
            den = d;
            ratioDiff = ( (n+1)/(d+1) ) - (n/d);
        }

        @Override
        public int compareTo(Pair p2){

            return Double.compare(this.ratioDiff , p2.ratioDiff);

        }
    }
}