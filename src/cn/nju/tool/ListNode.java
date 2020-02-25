package cn.nju.tool;

public class ListNode{
    public int val;
    public ListNode next;

    public ListNode(int v){
        this.val = v;
    }

    public String toString(){
        StringBuffer b = new StringBuffer();
        b.append(this.val+"->");
        if(this.next!=null){
            b.append(this.next.toString());
        }
        else{
            b.append("null");
        }
            
        return b.toString();
    }
    
}