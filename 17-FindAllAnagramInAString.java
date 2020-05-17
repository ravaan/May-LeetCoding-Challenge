class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int ls = s.length();
        int lp = p.length();
        ArrayList<Integer> ans = new ArrayList<>();

        if (ls < lp) return ans;

        int[] pCount = new int[26];
        int[] count = new int[26];

        for (char ch : p.toCharArray()) pCount[ch - 'a']++;
        int i = 0;
        while (i < ls) {
            if (i >= lp) {
                if (Arrays.equals(pCount, count))
                    ans.add(i - lp);
                count[s.charAt(i - lp) - 'a']--;
            }
            count[s.charAt(i) - 'a']++;
            i++;
        }
        if (Arrays.equals(pCount, count))
            ans.add(i - lp);
        return ans;
    }

//    public boolean isSame(int[] x, int[] y) {
//        int sum = 0;
//        for (int i = 0; i < 26; i++) {
//            if (x[i] != y[i])
//                return false;
//            sum += x[i];
//            if (sum == lp) return true;
//        }
//        return true;
//    }
}