class Solution {
    public int findJudge(int N, int[][] trust) {
        if (trust.length < N - 1) return -1;
        boolean[] trusts = new boolean[N];
        int[] trustedBy = new int[N];

        for (int[] t : trust) {
            trusts[t[0] - 1] = true;
            trustedBy[t[1] - 1]++;
        }
        for (int i = 0; i < N; i++) {
            if (!trusts[i] && trustedBy[i] == N - 1) return i + 1;
        }
        return -1;
    }
}