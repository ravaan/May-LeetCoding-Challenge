class Solution {
    public int firstUniqChar(String s) {
        int[] set = new int[26];
        for (char c : s.toCharArray()) {
            set[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (set[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }
}