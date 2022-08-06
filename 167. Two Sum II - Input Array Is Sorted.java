// Medium
// Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, 
// find two numbers such that they add up to a specific target number. 
// Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

// Return the indices of the two numbers, 
// index1 and index2, 
// added by one as an integer array [index1, index2] of length 2.

// The tests are generated such that there is exactly one solution. 
// You may not use the same element twice.

// Your solution must use only constant extra space.

// Example 1:
// Input: numbers = [2,7,11,15], target = 9
// Output: [1,2]

// Explanation: 
// The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
  
// Example 2:
// Input: numbers = [2,3,4], target = 6
// Output: [1,3]

// Explanation: 
// The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
  
// Example 3:
// Input: numbers = [-1,0], target = -1
// Output: [1,2]

// Explanation: 
// The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].

// Constraints:
// 2 <= numbers.length <= 3 * 104
// -1000 <= numbers[i] <= 1000
// numbers is sorted in non-decreasing order.
// -1000 <= target <= 1000
// The tests are generated such that there is exactly one solution.

// Solution
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        
        int left = 0;
        int right = numbers.length - 1;
        
        while (left < right) {
            int temp = numbers[left] + numbers[right];
            
            if (temp == target) {
                ans[0] = left + 1;
                ans[1] = right + 1;
                
                break;
            }
            else if (temp < target) {
                left++;
            }
            else {
                right--;
            }
        }
        
        return ans;
    }
}
// TC: O(n); SC: O(1)
// Success
// Details 
// Runtime: 20 ms, faster than 30.66% of Java online submissions for Multiply Strings.
// Memory Usage: 43.2 MB, less than 48.45% of Java online submissions for Multiply Strings.
