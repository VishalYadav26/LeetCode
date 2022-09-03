# Medium
# Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, 
# construct and return the binary tree.

# Example 1:
# Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
# Output: [3,9,20,null,null,15,7]

# Example 2:
# Input: preorder = [-1], inorder = [-1]
# Output: [-1]
 
# Constraints:
# 1 <= preorder.length <= 3000
# inorder.length == preorder.length
# -3000 <= preorder[i], inorder[i] <= 3000
# preorder and inorder consist of unique values.
# Each value of inorder also appears in preorder.
# preorder is guaranteed to be the preorder traversal of the tree.
# inorder is guaranteed to be the inorder traversal of the tree.

# Solution
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        inorder_idx = {}
        
        for idx, val in enumerate(inorder):
            inorder_idx[val] = idx     
        
        def helper(in_left, in_right, pre_left, pre_right):
            if in_left > in_right:
                return None

            root_val = preorder[pre_left]
            in_idx = inorder_idx[root_val]
            
            root = TreeNode(root_val)

            root.left = helper(in_left, in_idx - 1, pre_left + 1, pre_left + in_idx - in_left)
            root.right = helper(in_idx + 1, in_right, pre_left + in_idx - in_left + 1, pre_right)
            
            return root
        
        return helper(0, len(inorder) - 1, 0, len(preorder) - 1)
    
# TC: O(n); SC: O(height)
# Success
# Details 
# Runtime: 106 ms, faster than 76.90% of Python3 online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
# Memory Usage: 19.1 MB, less than 69.47% of Python3 online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
