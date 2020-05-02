class Solution {
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> jewelSet = new HashSet<>();
        for (char jewel : J.toCharArray()) jewelSet.add(jewel);
        int ans = 0;
        for (char stone : S.toCharArray()) ans += jewelSet.contains(stone) ? 1 : 0;
        return ans;
    }
}` `