package cn.nju.example;

import cn.nju.tool.ListNode;

public class S25_MergeList{
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(8);

        l1.next = l3;
        l2.next = l4;
        l3.next = l5;
        l4.next = l6;
        l5.next = l7;
        l6.next = l8;

        System.out.println(mergeList(l1, l2));
        System.out.println(mergeList(l1, null));
        System.out.println(mergeList(null, null));
    }

    private static ListNode mergeList(ListNode l1, ListNode l2){
        if(l1==null && l2==null) return null;
        if(l1==null) return l2;
        if(l2==null) return l1;

        ListNode l0 = new ListNode(0);
        ListNode temp = l0;
        ListNode p1 = l1;
        ListNode p2 = l2;

        while(p1!=null || p2!=null){
            if(p1==null){
                temp.next = p2;
                break;
            }
            if(p2==null){
                temp.next = p1;
                break;
            }
            else{
                if(p1.val<p2.val){
                    temp.next = p1;
                    temp = temp.next;
                    p1 = p1.next;
                }
                else{
                    temp.next = p2;
                    temp = temp.next;
                    p2 = p2.next;
                }
            }
        }
        return l0.next;
    }
}