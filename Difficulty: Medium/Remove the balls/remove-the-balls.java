class Solution {
    public int findLength(int[] color, int[] radius) {
        int top = -1;

        for (int i = 0; i < color.length; i++) {
            if (top >= 0 && color[top] == color[i] && radius[top] == radius[i]) {
                top--; 
            } else {
                top++; 
                color[top] = color[i];   
                radius[top] = radius[i]; 
            }
        }

        return top + 1; 
    }
}