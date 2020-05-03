class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] c = new int[26];
        for(char s: magazine.toCharArray()){
            c[s -'a']++;
        }
        for( char s: ransomNote.toCharArray()){
            c[s  - 'a']--;
            if( c[s  - 'a'] < 0) return false;
        }
        return true;
    }
}