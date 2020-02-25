package cn.nju.example;

import java.util.Stack;
import cn.nju.tool.ListNode;

public class S06_PrintListReversingly{
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        printReversingly(head);
    }

    private static void printReversingly(ListNode head){
        if(head==null) return;
        Stack<ListNode> s = new Stack<>();
        ListNode temp = head;
        while(temp!=null){
            s.push(temp);
            temp = temp.next;
        }
        while(!s.empty()){
            System.out.println(s.pop().val);
        }
    }
}