package cn.nju.example;

import java.util.ArrayList;
import java.util.List;

import cn.nju.tool.TreeNode;

public class S34_SumOfPath{
    /**
     * Tree model
     *       10
     *      /   \
     *     6     5
     *    / \   / \
     *  11   8 12  16
     * 
     */
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(11);
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

        findPath(head, 27);
    }

    private static void findPath(TreeNode root, int sum){
        if(root==null) return;
        List<Integer> ans = new ArrayList<>();
        findPath(root, sum, ans);
    }

    private static void findPath(TreeNode root, int sum,List<Integer> list){
        if(sum<0) return;
        if(root==null) return;
        list.add(root.val);
        if((sum-root.val)==0){
            System.out.println(list);
            list.remove(list.size()-1);
            return;
        }
        findPath(root.left, sum-root.val, list);
        findPath(root.right, sum-root.val, list);
        list.remove(list.size()-1);
        
    }
}