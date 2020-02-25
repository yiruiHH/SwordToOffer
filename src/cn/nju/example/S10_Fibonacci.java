package cn.nju.example;

public class S10_Fibonacci{
    public static void main(String[] args){
        for (int i = 0; i <= 50; i++) {
            System.out.print(fibonacci(i)+" ");
        }
    }

    private static long fibonacci(int n){
        if(n<=0) return 0;
        if(n==1) return 1;
        long a = 0;
        long b = 1;
        long ans = 0;
        for(int i=2;i<=n;i++){
            ans = a+b;
            a = b;
            b = ans;
        }
        return ans;
    }
}