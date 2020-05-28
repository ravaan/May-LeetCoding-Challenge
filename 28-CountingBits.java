class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        if (num == 0) return ans;
        ans[1] = 1;
        if (num == 1) return ans;
        for (int i = 2; i <= num; i++) {
            int lastN = ans[i >> 1];
            if (i % 2 == 0) ans[i] = lastN;
            else ans[i] = lastN + 1;
        }

        return ans;
    }
}


// 1 2 3 4 5 6 7
// 1 1 2 1 2 2 3

// 110
// 11
// 111
// 11