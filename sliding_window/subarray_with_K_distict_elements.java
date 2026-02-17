class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        // exactly K = atMost(K) - atMost(K-1)
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int i = 0;                     // left pointer
        int count = 0;                 // result
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int j = 0; j < nums.length; j++) {  // right pointer
            
            // add current element
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            // shrink window if distinct > k
            while (map.size() > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                
                // if frequency becomes 0 remove it
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }

            // count all valid subarrays ending at j
            count += (j - i + 1);
        }

        return count;
    }
}
