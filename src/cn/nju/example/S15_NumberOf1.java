package cn.nju.example;

public class S15_NumberOf1{
    public static void main(String[] args){
        for (int i = -100; i < 100; i++) {
            System.out.println(i+"->"+Integer.toBinaryString(i)+"->"+numsOf1(i));
            System.out.println(i+"->"+Integer.toBinaryString(i)+"->"+numsOf1_2(i));
            System.out.println(i+"->"+Integer.toBinaryString(i)+"->"+numsOf1_3(i));
        }
        System.out.println(Integer.toBinaryString(-100));
        System.out.println(Integer.toBinaryString(-100>>1));
    }

    private static int numsOf1(int n){
        int count = 0;
        long flag = 1;
        for (int i = 0; i < 32; i++) {
            if((n&flag)>0)
                count++;
            flag = flag<<1;
        }
        return count;
    }
    private static int numsOf1_2(int n){
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if(((n>>i)&1)==1)
                count++;
        }
        return count;
    }

    private static int numsOf1_3(int n){
        int count = 0;
        while(n>0){
            count++;
            n = n&(n-1);
        }
        return count;
    }
}