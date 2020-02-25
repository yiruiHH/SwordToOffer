package cn.nju.example;

import java.util.Stack;

public class S09_CQueue<E> {
    private Stack<E> s1;
    private Stack<E> s2;

    public S09_CQueue(){
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void appendTail(E e){
        s1.push(e);
    }

    public E deleteHead(){
        if(s2.empty()){
            while(!s1.empty()){
                s2.push(s1.pop());
            }
        }

        if(s2.empty()){
            return null;
        }

        return s2.pop();
    }

    public static void main(String[] args){
        S09_CQueue<Integer> q = new S09_CQueue<>();
        q.appendTail(1);
        q.appendTail(2);
        q.appendTail(3);

        System.out.println(q.deleteHead());
        System.out.println(q.deleteHead());
        System.out.println(q.deleteHead());
        System.out.println(q.deleteHead());
    }
}