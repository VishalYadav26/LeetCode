// Easy
// You are given an integer array nums of length n, 
// and an integer array queries of length m.

// Return an array answer of length m where answer[i] is the maximum size of a subsequence that you can take from nums such that the sum of its elements is less than or equal to queries[i].
// A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

// Example 1:

// Input: nums = [4,5,2,1], queries = [3,10,21]
// Output: [2,3,4]

// Explanation: 
// We answer the queries as follows:
// - The subsequence [2,1] has a sum less than or equal to 3. 
// It can be proven that 2 is the maximum size of such a subsequence, 
// so answer[0] = 2.
// - The subsequence [4,5,1] has a sum less than or equal to 10. 
// It can be proven that 3 is the maximum size of such a subsequence, 
// so answer[1] = 3.
// - The subsequence [4,5,2,1] has a sum less than or equal to 21. 
// It can be proven that 4 is the maximum size of such a subsequence, 
// so answer[2] = 4.

// Example 2:
// Input: nums = [2,3,4,5], queries = [1]
// Output: [0]

// Explanation: 
// The empty subsequence is the only subsequence that has a sum less than or equal to 1, 
// so answer[0] = 0.
 
// Constraints:
// n == nums.length
// m == queries.length
// 1 <= n, m <= 1000
// 1 <= nums[i], queries[i] <= 106
  
// Solution
class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        
        int len = nums.length;
        int[] preSum = new int[len];
        preSum[0] = nums[0];
        
        for (int i = 1; i < len; i++) {
            preSum[i] = preSum[i - 1] + nums[i];    
        }
        
        int lenQ = queries.length;
        int[] ans = new int[lenQ];
        
        for (int j = 0; j < lenQ; j++) {
            ans[j] = binarySearch(preSum, queries[j]);
        }
        
        return ans;
    }
    
    private int binarySearch(int[] preSum, int target) {
        int l = 0;
        int r = preSum.length - 1;
        
        while (l < r - 1) {
            int m = l + (r - l) / 2;
            
            if (preSum[m] <= target) {
                l = m;
            }
            else {
                r = m - 1;
            }
        }
        
        if (preSum[l] > target) {
            return 0;
        }
        
        return preSum[r] <= target ? r + 1 : l + 1;
    }
}
// TC: O(n + m * lgn); SC: O(n)
// n is the length of nums, m is the length of queries.
// Success
// Details 
// Runtime: 8 ms, faster than 73.77% of Java online submissions for Longest Subsequence With Limited Sum.
// Memory Usage: 48.6 MB, less than 80.62% of Java online submissions for Longest Subsequence With Limited Sum.
