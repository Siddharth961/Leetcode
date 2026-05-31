class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        
        long p_mass = mass;
        Arrays.sort(asteroids);

        for(int val : asteroids){
            if(p_mass < val) return false;
            p_mass += val;
        }

        return true;
    }
}