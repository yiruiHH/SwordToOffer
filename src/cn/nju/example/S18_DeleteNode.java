package cn.nju.example;

import cn.nju.tool.ListNode;

public class S18_DeleteNode{
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        System.out.println(l1);
        deleteNode(l1, l2);
        System.out.println(l1);
        deleteNode(l1, l4);
        System.out.println(l1);
        deleteNode(l1, l1);
        System.out.println(l1);
    }

    public static void deleteNode(ListNode head, ListNode tobeDelete){
        if(head==null || tobeDelete==null)
            return;
        
        if(tobeDelete.next==null){
            ListNode temp = head;
            while(temp.next!=tobeDelete){
                temp = temp.next;
            }
            temp.next = null;
            tobeDelete = null;
            return;
        }
        
        tobeDelete.val = tobeDelete.next.val;
        tobeDelete.next = tobeDelete.next.next;
        
    }
}