package com.lx.offer;


import com.lx.TreeNode;

import java.util.LinkedList;

/**
 * @author Werdio丶
 * @since 2021-01-25 16:31:53
 */
public class 二叉树的深度 {

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int maxDepth1(TreeNode root) {
        if (root == null){
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()){
            res++;
            int siz = queue.size();
            for (int i = 0; i < siz; i++) {
                TreeNode n = queue.poll();
                if (n.left != null){
                    queue.offer(n.left);
                }
                if (n.right != null){
                    queue.offer(n.right);
                }
            }
        }
        return res;
    }
}
