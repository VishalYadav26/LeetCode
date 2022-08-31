// Medium
// Given an integer array nums, 
// return the length of the longest strictly increasing subsequence.

// A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. 
// For example, 
// [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

// Example 1:
// Input: 
// nums = [10,9,2,5,3,7,101,18]
// Output: 
// 4
  
// Explanation: 
// The longest increasing subsequence is [2,3,7,101], 
// therefore the length is 4.
  
// Example 2:
// Input: 
// nums = [0,1,0,3,2,3]
// Output: 
// 4
  
// Example 3:
// Input: 
// nums = [7,7,7,7,7,7,7]
// Output: 
// 1
 
// Constraints:
// 1 <= nums.length <= 2500
// -104 <= nums[i] <= 104
  
// Solution 1
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int ans = 1;
        
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                else {
                    dp[i] = Math.max(dp[i], 1);
                }
            }
            
            ans = Math.max(ans, dp[i]);
        }
        
        return ans;
    }
}
// TC: O(n^2); SC: O(n)
// Success
// Details 
// Runtime: 98 ms, faster than 16.47% of Java online submissions for Longest Increasing Subsequence.
// Memory Usage: 44.7 MB, less than 34.69% of Java online submissions for Longest Increasing Subsequence.

// Solution 2
class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] maxGreater = new int[len];
        maxGreater[len - 1] = 1;
        int glbMax = 1;
        
        for (int i = len - 2; i >= 0; i--) {
            int nMax = 1;
            int rawMax = 1;
            
            for (int j = i + 1; j < len; j++) {
                if (nums[j] > nums[i]) {
                    int temp = rawMax + maxGreater[j];
                    nMax = Math.max(nMax, temp);
                }
            }
            
            maxGreater[i] = nMax;
            glbMax = Math.max(glbMax, nMax);
        }
        
        return glbMax;
    }
}
// TC: O(n^2); SC: O(n);
// Success
// Details 
// Runtime: 64 ms, faster than 62.16% of Java online submissions for Longest Increasing Subsequence.
// Memory Usage: 44 MB, less than 79.45% of Java online submissions for Longest Increasing Subsequence.
