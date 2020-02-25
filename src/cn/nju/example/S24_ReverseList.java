package cn.nju.example;

import cn.nju.tool.ListNode;

public class S24_ReverseList{
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

        System.out.println(reverseList(l1));
    }

    private static ListNode reverseList(ListNode head){
        if(head==null) return null;

        ListNode pre = null;
        ListNode mid = head;
        ListNode last = head.next;
        while(mid!=null){
            mid.next = pre;
            pre = mid;
            mid = last;
            if(last!=null)
                last = last.next;
        }
        return pre;
    }
}