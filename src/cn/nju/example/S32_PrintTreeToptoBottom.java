package cn.nju.example;

import java.util.Deque;
import java.util.LinkedList;

import cn.nju.tool.TreeNode;

public class S32_PrintTreeToptoBottom{
    /**
     * Tree model
     *       10
     *      /   \
     *     6    14
     *    / \   / \
     *   4   8 12  16
     * 
     */
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(14);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(8);
        TreeNode t6 = new TreeNode(12);
        TreeNode t7 = new TreeNode(16);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        TreeNode head = t1;

        printToptoBottom(head);
    }

    private static void printToptoBottom(TreeNode root){
        if(root==null) return;

        Deque<TreeNode> dq = new LinkedList<>();
        dq.add(root);
        while(!dq.isEmpty()){
            TreeNode temp = dq.pollFirst();
            System.out.print(temp.val+" ");
            if(temp.left!=null)
                dq.add(temp.left);
            if(temp.right!=null)
                dq.add(temp.right);
        }
    }
}