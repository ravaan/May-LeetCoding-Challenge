class Solution {

    public int countSquares(int[][] m) {
        int row = m.length;
        int col = m[0].length;
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (m[i][j] == 1 && i > 0 && j > 0) {
                    m[i][j] = Math.min(m[i - 1][j - 1], Math.min(m[i - 1][j], m[i][j - 1])) + 1;

                }
                ans += m[i][j];
            }
        }

        return ans;
    }


}
