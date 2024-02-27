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
    int diameter = 0;
    private int Height(TreeNode root) {

        if (root == null) return 0; 

        int leftHeight = Height(root.left);
        int rightHeight = Height(root.right);

        int currDiameter = leftHeight + rightHeight + 1;
        diameter = Math.max(diameter, currDiameter);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        Height(root);
        return diameter - 1;
    }
}