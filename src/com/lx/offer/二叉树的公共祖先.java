package com.lx.offer;

import com.lx.TreeNode;

/**
 * @author Werdio丶
 * @since 2021-01-27 17:23:39
 */
public class 二叉树的公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null){
            return null;
        }
        // 在后序遍历中找到了 p 和 q，说明 root 就是他们的公共祖先
        if (left != null && right != null){
            return root;
        }
        // 有一个没有找到，说明他们俩个在 root 的同一个方向，所以本身就是公共结点
        return left == null ? right : left;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root){
            return root;
        }
        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);

        if (left == null){
            return right;
        }

        if (right == null){
            return left;
        }

        return root;
    }
}
