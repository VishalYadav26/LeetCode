// Easy
// Given the root of a binary tree, 
// return the postorder traversal of its nodes' values.

// Example 1:
// Input: root = [1,null,2,3]
// Output: [3,2,1]

// Example 2:
// Input: root = []
// Output: []

// Example 3:
// Input: root = [1]
// Output: [1]
 
// Constraints:
// The number of the nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100
 
// Follow up: 
// Recursive solution is trivial, 
// could you do it iteratively?
  
// Solution
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        
        postorderHelper(root, ans);
        
        return ans;
    }
    
    private void postorderHelper(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        
        postorderHelper(root.left, ans);
        postorderHelper(root.right, ans);
        ans.add(root.val);
    }
}
// TC: O(n); SC: O(height)
// Success
// Details 
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Postorder Traversal.
// Memory Usage: 40.6 MB, less than 89.62% of Java online submissions for Binary Tree Postorder Traversal.
