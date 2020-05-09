class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        if (num == 2) return false;

        int low = 2;
        int high = num / 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long sqr = (long) mid * (long) mid;
            if (sqr == num) return true;
            if (sqr > num) high = mid - 1;
            if (sqr < num) low = mid + 1;
        }
        return false;
    }
}

