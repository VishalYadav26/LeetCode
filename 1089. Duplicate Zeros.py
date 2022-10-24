# Easy
# Given a fixed-length integer array arr, 
# duplicate each occurrence of zero, 
# shifting the remaining elements to the right.

# Note that elements beyond the length of the original array are not written. 
# Do the above modifications to the input array in place and do not return anything.

# Example 1:
# Input: arr = [1,0,2,3,0,4,5,0]
# Output: [1,0,0,2,3,0,0,4]
  
# Explanation: 
# After calling your function, 
# the input array is modified to: [1,0,0,2,3,0,0,4]
  
# Example 2:
# Input: arr = [1,2,3]
# Output: [1,2,3]
  
# Explanation: 
# After calling your function, 
# the input array is modified to: [1,2,3]
 
# Constraints:
# 1 <= arr.length <= 104
# 0 <= arr[i] <= 9

# Solution
class Solution:
    def duplicateZeros(self, arr: List[int]) -> None:
        """
        Do not return anything, modify arr in-place instead.
        """
        n = len(arr)
        
        def move(arr, n, idx):            
            for i in range(n - 1, idx, -1):
                arr[i] = arr[i - 1]
        
        for i in range(n - 2, -1, -1):
            if arr[i] == 0:
                move(arr, n, i + 1)
                arr[i + 1] = 0
# TC: O(n^2): SC: O(1)
# Accepted
