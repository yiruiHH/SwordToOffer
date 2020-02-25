package cn.nju.example;

import cn.nju.tool.*;

public class S22_LastK{
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        System.out.println(theLastK(l1,1));
        System.out.println(theLastK(l1,2));
        System.out.println(theLastK(l1,3));
        System.out.println(theLastK(l1,4));
        System.out.println(theLastK(l1,5));
        System.out.println(theLastK(l1,6));
        System.out.println(theLastK(l1,7));
    }

    private static ListNode theLastK(ListNode head,int k){
        if(head==null || k<1){
            throw new IllegalArgumentException("head==null || k<1");
        }

        ListNode p1 = head;
        ListNode p2 = head;
        int count1 = 0;
        while(count1<k-1){
            p1 = p1.next;
            if(p1==null) return null;
            count1++;
        }
        while(p1!=null){
            p1 = p1.next;
            if(p1!=null)
                p2 = p2.next;
        }
        return p2;
    }
}