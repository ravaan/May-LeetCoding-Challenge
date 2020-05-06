class Solution {

    Map<Integer, Integer> map;

    public int majorityElement(int[] nums) {
        int len = nums.length;
        map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n))
                map.put(n, map.get(n) + 1);
            else
                map.put(n, 1);
        }

        for (Map.Entry<Integer, Integer> n : map.entrySet())
            if (n.getValue() > len / 2) return n.getKey();
        return 0;
    }
}