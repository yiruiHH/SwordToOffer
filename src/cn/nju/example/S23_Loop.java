package cn.nju.example;

import cn.nju.tool.ListNode;

public class S23_Loop{
    /**
     *    ListNode loop model
     *               ----------------
     *               |              |  
     *     1 -> 2 -> 3 -> 4 -> 5 -> 6
     */
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
        l6.next = l3;

        System.out.println(EntryNodeOfLoop(l1).val);
    }

    private static ListNode EntryNodeOfLoop(ListNode head){
        if(head==null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(slow.next!=null && fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast)
                break;
        }
        if(slow!=fast)  //链表中不存在环路
            return null;
        fast = slow.next;
        int count = 1;
        while(slow!=fast){
            fast = fast.next;
            count++;
        }
        slow = head;
        fast = head;
        while(count>0){
            fast = fast.next;
            count--;
        }
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}