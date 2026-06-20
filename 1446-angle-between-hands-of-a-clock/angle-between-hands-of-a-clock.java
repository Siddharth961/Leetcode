class Solution {
    public double angleClock(int hour, int minutes) {

        if(hour == 12) hour = 0;
        
        double min_ang = minutes * 6;
        double hour_ang = hour * 30 + (0.5 * minutes);

        double ans =  Math.abs(min_ang - hour_ang);

        return Math.min(ans, Math.max(0, 360.0 - ans));
    }
}