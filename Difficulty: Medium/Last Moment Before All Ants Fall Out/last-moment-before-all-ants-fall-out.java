class Solution {
    /**
     * Calculates the time when the last ant falls off a plank of length n.
     * 
     * @param n     The length of the plank (0 to n)
     * @param left  Positions of ants moving left
     * @param right Positions of ants moving right
     * @return The time when the last ant falls off the plank
     */
    public int getLastMoment(int n, int[] left, int[] right) {
        // Find maximum distance for ants moving left (from their position to left edge)
        int maxLeftDistance = 0;
        for (int position : left) {
            maxLeftDistance = Math.max(maxLeftDistance, position);
        }
        
        // Find maximum distance for ants moving right (from their position to right edge)
        int maxRightDistance = 0;
        for (int position : right) {
            maxRightDistance = Math.max(maxRightDistance, n - position);
        }
        
        // The last ant to fall will be the one with the maximum distance to travel
        return Math.max(maxLeftDistance, maxRightDistance);
    }
}