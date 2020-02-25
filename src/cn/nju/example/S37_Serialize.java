package cn.nju.example;

import cn.nju.tool.TreeNode;

public class S37_Serialize{
    /**
     * Tree model
     *       10
     *      /   \
     *     6    14
     *    /     / \
     *   4     12  16
     * 
     */
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(14);
        TreeNode t4 = new TreeNode(4);
        TreeNode t6 = new TreeNode(12);
        TreeNode t7 = new TreeNode(16);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.left = t6;
        t3.right = t7;

        TreeNode head = t1;
        String s = Serialize(head);
        System.out.println(s);
        TreeNode.preorder_loop(Deserialize(s));
        
    }
    private static String Serialize(TreeNode root){
        String s = serialize(root);
        return s.substring(0, s.length()-1);
    }

    private static String serialize(TreeNode root){
        if(root==null){
            return "$,";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.val+",");
        String l = serialize(root.left);
        String r = serialize(root.right);
        sb.append(l);
        sb.append(r);
        return sb.toString();
    }
    private static int index = 0;
    private static TreeNode Deserialize(String s){
        String[] nums = s.split(",");
        TreeNode root = deserialize(nums);
        index = 0;
        return root;
    }

    private static TreeNode deserialize(String[] nums){
        if(nums[index].equals("$")){
            index++;
            return null;
        }
        int num = Integer.valueOf(nums[index++]);
        TreeNode r = new TreeNode(num);
        r.left = deserialize(nums);
        r.right = deserialize(nums);
        return r;
    }
}