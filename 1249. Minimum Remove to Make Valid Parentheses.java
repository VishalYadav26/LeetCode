// Medium

// Given a string s of '(' , ')' and lowercase English characters. 

// Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

// Formally, a parentheses string is valid if and only if:

// It is the empty string, contains only lowercase characters, or
// It can be written as AB (A concatenated with B), where A and B are valid strings, or
// It can be written as (A), where A is a valid string.
 
// Example 1:
// Input: s = "lee(t(c)o)de)"
// Output: "lee(t(c)o)de"
// Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.

// Example 2:
// Input: s = "a)b(c)d"
// Output: "ab(c)d"

// Example 3:
// Input: s = "))(("
// Output: ""
// Explanation: An empty string is also valid.

// Example 4:
// Input: s = "(a(b(c)d)"
// Output: "a(b(c)d)"
 
// Constraints:
// 1 <= s.length <= 10^5
// s[i] is one of  '(' , ')' and lowercase English letters.

// #1, Using a Stack and String Builder
class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> indexesToRemove = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    indexesToRemove.add(i);
                }
                else {
                    stack.pop();
                }
            }
        }
        
        while (!stack.isEmpty()) {
            indexesToRemove.add(stack.pop());
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            if (!indexesToRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();
    }
}

// Success
// Details 
// Runtime: 52 ms, faster than 13.52% of Java online submissions for Minimum Remove to Make Valid Parentheses.
// Memory Usage: 52.3 MB, less than 5.08% of Java online submissions for Minimum Remove to Make Valid Parentheses.
