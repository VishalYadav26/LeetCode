// Hard
// Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, 
// or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

// Design an algorithm to serialize and deserialize a binary tree. 
// There is no restriction on how your serialization/deserialization algorithm should work. 
// You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

// Clarification: 
// The input/output format is the same as how LeetCode serializes a binary tree. 
// You do not necessarily need to follow this format, 
// so please be creative and come up with different approaches yourself.

// Example 1:
// Input: root = [1,2,3,null,null,4,5]
// Output: [1,2,3,null,null,4,5]

// Example 2:
// Input: root = []
// Output: []
 
// Constraints:
// The number of nodes in the tree is in the range [0, 104].
// -1000 <= Node.val <= 1000
  
// Solution
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // String s = new String("");
        StringBuilder sb = new StringBuilder();
        serHelper(root, sb);
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] sArr = data.split(",");
        List<String> sList = new LinkedList<>(Arrays.asList(sArr));
        
        return deserHelper(sList);
    }
    
    private void serHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            
            return;
        }
        
        sb.append(root.val);
        sb.append(",");
        serHelper(root.left, sb);
        serHelper(root.right, sb);
    }
    
    private TreeNode deserHelper(List<String> sArr) {
        if (sArr.get(0).equals("null")) {
            sArr.remove(0);
            
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.valueOf(sArr.get(0)));
        sArr.remove(0);
        
        root.left = deserHelper(sArr);
        root.right = deserHelper(sArr);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

// TC: ser, O(n); deser, O(n); SC: ser, O(n); deser, O(n)
// Success
// Details 
// Runtime: 19 ms, faster than 66.03% of Java online submissions for Serialize and Deserialize Binary Tree.
// Memory Usage: 51.7 MB, less than 67.52% of Java online submissions for Serialize and Deserialize Binary Tree.
