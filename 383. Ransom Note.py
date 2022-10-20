# Easy
# Given two strings ransomNote and magazine, 
# return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

# Each letter in magazine can only be used once in ransomNote.

# Example 1:
# Input: ransomNote = "a", magazine = "b"
# Output: false
  
# Example 2:
# Input: ransomNote = "aa", magazine = "ab"
# Output: false
  
# Example 3:
# Input: ransomNote = "aa", magazine = "aab"
# Output: true
 
# Constraints:
# 1 <= ransomNote.length, magazine.length <= 105
# ransomNote and magazine consist of lowercase English letters.

# Solution
class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        cnt_mgz = Counter(magazine)

        for c in ransomNote:
            if c in cnt_mgz:
                cnt_mgz[c] -= 1
                
                if cnt_mgz[c] < 0:
                    return False
            else:
                return False
                
        return True
# TC: O(n); SC: O(n)
# Accepted
