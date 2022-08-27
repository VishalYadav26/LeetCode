// Easy
// Given a string s, 
// reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

// Example 1:
// Input: s = "Let's take LeetCode contest"
// Output: "s'teL ekat edoCteeL tsetnoc"
  
// Example 2:
// Input: s = "God Ding"
// Output: "doG gniD"
 
// Constraints:
// 1 <= s.length <= 5 * 104
// s contains printable ASCII characters.
// s does not contain any leading or trailing spaces.
// There is at least one word in s.
// All the words in s are separated by a single space.
 
// Solution
class Solution {
    public String reverseWords(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pollFirst());
                }
                
                sb.append(' ');     
                
                continue;
            }
            
            stack.offerFirst(s.charAt(i));
        }
        
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }
    
        return sb.toString();
    }
}
// TC: O(n); SC: O(n)
// Success
// Details 
// Runtime: 21 ms, faster than 36.09% of Java online submissions for Reverse Words in a String III.
// Memory Usage: 42.6 MB, less than 96.15% of Java online submissions for Reverse Words in a String III.
