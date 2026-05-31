class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        int n = asteroids.length;
        long temp = mass;
        for(int i = 0; i < n; i++){
            if(temp < asteroids[i]){
                return false;
            }
            temp += asteroids[i];
        }
        return true;
    }
}