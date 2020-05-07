/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int px, py, lx, ly, x, y;

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        this.x = x;
        this.y = y;
        dfs(root, 0);
        boolean ans = false;
        if (lx == ly && px != py) {
            ans = true;
        }
        return ans;
    }

    public void dfs(TreeNode node, int level) {
        if (node == null) return;

        if (node.left != null) {
            if (node.left.val == x) {
                px = node.val;
                lx = level + 1;
            }
            if (node.left.val == y) {
                py = node.val;
                ly = level + 1;
            }
        }

        if (node.right != null) {
            if (node.right.val == x) {
                px = node.val;
                lx = level + 1;
            }
            if (node.right.val == y) {
                py = node.val;
                ly = level + 1;
            }
        }

        dfs(node.left, level + 1);
        dfs(node.right, level + 1);

    }
}