package cn.nju.example;

public class S64_SumOf1ton{
    public static void main(String[] args){
        System.out.println(getSum(100));
    }

    public static int getSum(int num){
        int t=0;
        boolean b = (num>0)&&((t=num+getSum(num-1))>0);
        return t;
    }
    
}