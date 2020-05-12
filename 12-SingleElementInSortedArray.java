class Solution {
    public int singleNonDuplicate(int[] nums) {
        int ans = nums[0];
        boolean flag = false;
        // XOR all nums
        for (int i : nums) {
            if (flag)
                ans ^= i;
            flag = true;
        }
        return ans;
    }
}