package cn.nju.example;

import java.util.Stack;

public class S30_StackWithMin {
    public static void main(String[] args) {
        
    }

    Stack<Integer> data;

    Stack<Integer> min;

    public S30_StackWithMin(){
        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(int n){
        data.push(n);
        int minNow = n;
        if(!min.empty()){
            minNow = Math.min(minNow,min.peek());
        }
        min.push(minNow);
    }

    public int pop(){
        min.pop();
        return data.pop();
    }

    public int min(){
        return min.peek();
    }
}