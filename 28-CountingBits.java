class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        if (num == 0) return ans;

        Map<Integer, Integer> bitMap = new HashMap<Integer, Integer>();

        for (int i = num; i >= 0; i--) {
            int n = i;
            int count = 0;
            while (n > 0) {
                if (bitMap.containsKey(n)) {
                    count += bitMap.get(n);
                    break;
                }
                if ((n & 1) == 1) count++;
                n = n >> 1;
            }
            ans[i] = count;
        }

        return ans;
    }
