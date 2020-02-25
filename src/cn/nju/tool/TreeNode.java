package cn.nju.tool;

import java.util.Stack;

public class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(){}

    public TreeNode(int v){
        this.val = v;
    }


    /**
     * Tree model
     *       10
     *      /   \
     *     6    14
     *    / \   / \
     *   4   8 12  16
     * 
     */
    public static void main(String[] args){
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

        //前序遍历
        System.out.println("preorder:");
        TreeNode.preorder_recurse(head);
        System.out.println();
        TreeNode.preorder_loop(head);
        System.out.println();

        //中序遍历
        System.out.println("inorder:");
        TreeNode.inorder_recurse(head);
        System.out.println();
        TreeNode.inorder_loop(head);
        System.out.println();

        //后序遍历
        System.out.println("postorder:");
        TreeNode.postorder_recurse(head);
        System.out.println();
        TreeNode.postorder_loop(head);
        System.out.println();
    }

    public static void preorder_recurse(TreeNode head){
        if(head==null) return;
        System.out.print(head.val+" ");
        preorder_recurse(head.left);
        preorder_recurse(head.right);
    }

    public static void preorder_loop(TreeNode head){
        if(head==null) return;
        Stack<TreeNode> s = new Stack<>();
        s.push(head);
        while(!s.empty()){
            TreeNode cur = s.pop();
            System.out.print(cur.val+" ");
            if(cur.right!=null)
                s.push(cur.right);
            if(cur.left!=null)
                s.push(cur.left);
        }
    }

    public static void inorder_recurse(TreeNode head){
        if(head==null) return;
        inorder_recurse(head.left);
        System.out.print(head.val+" ");
        inorder_recurse(head.right);
    }

    public static void inorder_loop(TreeNode head){
        if(head==null) return;
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = head;
        while(cur!=null || !s.empty()){
            while(cur!=null){
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            System.out.print(cur.val+" ");
            cur = cur.right;
            //System.out.print(cur);
        }
    }

    public static void postorder_recurse(TreeNode head){
        if(head==null) return;
        postorder_recurse(head.left);
        postorder_recurse(head.right);
        System.out.print(head.val+" ");
    }

    public static void postorder_loop(TreeNode head){
        if(head==null) return;
        Stack<TreeNode> s = new Stack<>();
        s.push(head);
        TreeNode cur = null;
        TreeNode pre = null;
        while(!s.empty()){
            cur = s.peek();
            if((cur.left==null && cur.right==null) || (pre!=null && (pre==cur.left || pre==cur.right))){
                System.out.print(cur.val+" ");
                s.pop();
                pre = cur;
            }
            else{
                if(cur.right!=null)
                    s.push(cur.right);
                if(cur.left!=null)
                    s.push(cur.left);
            }
        }
    }
}