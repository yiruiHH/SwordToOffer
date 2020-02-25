package cn.nju.example;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

public class S59_2_MaxQueue<E>{
    public static void main(String[] args) {
        S59_2_MaxQueue<Integer> q = new S59_2_MaxQueue<>(null);
        q.push(5);
        System.out.println(q.max());
        q.push(2);
        System.out.println(q.max());
        q.push(3);
        System.out.println(q.max());
        q.push(2);
        System.out.println(q.max());
        q.poll();
        System.out.println(q.max());
    }

    public S59_2_MaxQueue(Comparator<? super E> comparator){
        max = new LinkedList<>();
        data = new LinkedList<>();
        currentIndex = 0;
        this.comparator = comparator;
    }

    @SuppressWarnings("unchecked")
    public void push(E e){
        if(this.comparator==null){
            Comparable<? super E> key = (Comparable<? super E>) e;
            while(!max.isEmpty() && key.compareTo(max.getLast().number)>=0){
                max.removeLast();
            }
        }
        else{
            while(!max.isEmpty() && comparator.compare(e,max.getLast().number)>=0){
                max.removeLast();
            }
        }
        
        InnerData innerData = new InnerData(e,currentIndex++);
        data.addLast(innerData);
        max.addLast(innerData);
    }

    public E poll(){
        if(data.isEmpty()){
            return null;
        }
        if(max.getFirst().index==data.getFirst().index){
            max.removeFirst();
        }

        return data.pollFirst().number;
    }

    public E max(){
        if(max.isEmpty()){
            return null;
        }
        return max.getFirst().number;
    }

    private final Comparator<? super E> comparator;
    private Deque<InnerData> max;
    private Deque<InnerData> data;
    private int currentIndex;


    class InnerData{
        public E number;
        public int index;

        public InnerData(E e, int i){
            number = e;
            index = i;
        }
    }
}