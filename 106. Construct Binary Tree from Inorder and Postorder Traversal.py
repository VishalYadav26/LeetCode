# Medium
# Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, 
# construct and return the binary tree.

# Example 1:
# Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
# Output: [3,9,20,null,null,15,7]
  
# Example 2:
# Input: inorder = [-1], postorder = [-1]
# Output: [-1]
 
# Constraints:
# 1 <= inorder.length <= 3000
# postorder.length == inorder.length
# -3000 <= inorder[i], postorder[i] <= 3000
# inorder and postorder consist of unique values.
# Each value of postorder also appears in inorder.
# inorder is guaranteed to be the inorder traversal of the tree.
# postorder is guaranteed to be the postorder traversal of the tree.

# Solution
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        inorder_idx = {}
        
        for idx, val in enumerate(inorder):
            inorder_idx[val] = idx
        
        def helper(in_left, in_right, post_left, post_right):
            if in_right < in_left:
                return None
            
            root_val = postorder[post_right]
            root_idx = inorder_idx[root_val]
            
            root = TreeNode(root_val)
            root.left = helper(in_left, root_idx - 1, post_left, post_left + root_idx - in_left - 1)
            root.right = helper(root_idx + 1, in_right, post_left + root_idx - in_left, post_right - 1)
            
            return root
        
        return helper(0, len(inorder) - 1, 0, len(postorder) - 1)
            
# TC: O(n); SC: O(height)
# Success
# Details 
# Runtime: 73 ms, faster than 89.55% of Python3 online submissions for Construct Binary Tree from Inorder and Postorder Traversal.
# Memory Usage: 19.2 MB, less than 65.06% of Python3 online submissions for Construct Binary Tree from Inorder and Postorder Traversal.
