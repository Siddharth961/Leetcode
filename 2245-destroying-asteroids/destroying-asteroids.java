class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        
        Arrays.sort(asteroids);

        long size = mass;


        for(int i : asteroids){
            if(size < i) return false;


            size += i;
            // if( size < 0) System.out.println(11);
        }

        return true;
    }
}