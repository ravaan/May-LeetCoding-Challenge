class Solution {
    boolean[][] visited;
    int r, c;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        r = image.length;
        c = image[0].length;
        visited = new boolean[r][c];
        helper(sr, sc, newColor, image[sr][sc], image);
        return image;
    }

    public void helper(int x, int y, int val, int sVal, int[][] image) {
        if (!isValid(x, y)) return;
        if (visited[x][y]) return;
        visited[x][y] = true;
        if (sVal != image[x][y]) return;
        image[x][y] = val;
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