package cn.nju.tool;

public class TreeNodeWithParent extends TreeNode{
    public TreeNodeWithParent left;
    public TreeNodeWithParent right;
    public TreeNodeWithParent parent;

    public TreeNodeWithParent(){}

    public TreeNodeWithParent(int val){
        super(val);
    }
}