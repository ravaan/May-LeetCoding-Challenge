class Solution {
    boolean[][] visited;
    int[][] ans;
    int r, c;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        r = image.length;
        c = image[0].length;
        visited = new boolean[r][c];
        ans = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++)
                ans[i][j] = image[i][j];
        }
        helper(sr, sc, newColor, image[sr][sc], image);
        return ans;
    }

    public void helper(int x, int y, int val, int sVal, int[][] image) {
        if (!isValid(x, y)) return;
        if (visited[x][y]) return;
        visited[x][y] = true;
        if (sVal != image[x][y]) {
            ans[x][y] = image[x][y];
            return;
        }
        ans[x][y] = val;
        helper(x + 1, y, val, sVal, image);
        helper(x, y + 1, val, sVal, image);
        helper(x - 1, y, val, sVal, image);
        helper(x, y - 1, val, sVal, image);
    }

    public boolean isValid(int x, int y) {
        if (x >= r || x < 0) return false;
        if (y >= c || y < 0) return false;
        return true;
    }
}