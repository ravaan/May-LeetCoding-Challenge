class Solution {
    public boolean checkStraightLine(int[][] c) {
        int x0 = c[0][0], y0 = c[0][1], x1 = c[1][0], y1 = c[1][1];
        int diffX = x1 - x0;
        int diffY = y1 - y0;
        for (int[] a : c) {
            if (diffX * (a[1] - y1) != diffY * (a[0] - x1))
                return false;
        }
        return true;
    }
}