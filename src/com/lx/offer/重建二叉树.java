package com.lx.offer;

import com.lx.CreateUtil;
import com.lx.TreeNode;

/**
 * @author Werdio丶
 * @since 2021-02-02 10:05:16
 */
public class 重建二叉树 {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildCore(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private static TreeNode buildCore(int[] preorder, int i, int j, int[] inorder, int m, int n) {
        if(i > j || m > n){
            return null;
        }
        TreeNode root = new TreeNode(preorder[i]);
        for (int k = m; k <= n; k++) {
            if (preorder[i] == inorder[k]){
                root.left = buildCore(preorder, i + 1, k - m + i, inorder, m, k - 1);
                root.right = buildCore(preorder, k - m + i + 1, j, inorder, k + 1, n);
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] prev = {1, 2, 3};
        int[] in = {3, 2, 1};
        TreeNode treeNode = buildTree(prev, in);
        CreateUtil.printTree(treeNode);
    }
}
