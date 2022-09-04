# Medium
# Given the root of a binary tree, 
# return the vertical order traversal of its nodes' values. 
# (i.e., from top to bottom, column by column).

# If two nodes are in the same row and column, 
# the order should be from left to right.

# Example 1:
# Input: root = [3,9,20,null,null,15,7]
# Output: [[9],[3,15],[20],[7]]
  
# Example 2:
# Input: root = [3,9,8,4,0,1,7]
# Output: [[4],[9],[3,0,1],[8],[7]]
  
# Example 3:
# Input: root = [3,9,8,4,0,1,7,null,null,null,2,5]
# Output: [[4],[9,5],[3,0,1],[8,2],[7]]
 
# Constraints:
# The number of nodes in the tree is in the range [0, 100].
# -100 <= Node.val <= 100

# Solution
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root == None:
            return []
        
        dist_map = {}
        dist_map = defaultdict(list)
        node_dist = {}
        queue = []
        
        node_dist[root] = 0
        dist_map[0] = [root]
        queue.append(root)
        
        while len(queue) > 0:
            cur = queue.pop(0)
            cur_dist = node_dist[cur]
            
            if cur.left != None:
                left_dist = cur_dist - 1
                node_dist[cur.left] = left_dist
                dist_map[left_dist].append(cur.left)
                queue.append(cur.left)
            
            if cur.right != None:
                right_dist = cur_dist + 1
                node_dist[cur.right] = right_dist
                dist_map[right_dist].append(cur.right)
                queue.append(cur.right)
            
        sorted_map = sorted(dist_map.items())
        
        ans = []
        
        for tup in sorted_map:
            temp = []
            
            for node in tup[1]:    
                temp.append(node.val)
            
            ans.append(temp)
        
        return ans
                
# TC: O(nlgn); SC: O(n)
# Success
# Details 
# Runtime: 67 ms, faster than 17.34% of Python3 online submissions for Binary Tree Vertical Order Traversal.
# Memory Usage: 14 MB, less than 33.67% of Python3 online submissions for Binary Tree Vertical Order Traversal.
