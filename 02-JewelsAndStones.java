class Solution {
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> jewelSet = new HashSet<>();
        for (char jewel : J.toCharArray()) jewelSet.add(jewel);
        int ans = 0;
        for (char stone : S.toCharArray()) ans += jewelSet.contains(stone) ? 1 : 0;
        return ans;
    }
}` `

// Discuss: https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3317/discuss/608079/Java-Easy-to-Understand-O(S+J)-time-and-O(1)-space-solution
