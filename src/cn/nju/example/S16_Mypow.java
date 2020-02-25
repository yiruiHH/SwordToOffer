package cn.nju.example;

public class S16_Mypow{
    public static void main(String[] args){
        System.out.println(pow(2,5));
        System.out.println(pow(1,1));
        System.out.println(pow(5,0));
        System.out.println(pow(3,3));
        System.out.println(pow(3.5,3));
        System.out.println(pow(2,-1));
        System.out.println(pow(-2,-1));
        System.out.println(pow(-2,5));
        System.out.println(pow(0.0,-1));
    }

    private static double pow(double base, int exponent){
        if(Math.abs(base-0.0)<0.00001 && exponent<0){
            throw new IllegalArgumentException("Invalid input.");
        }

        int absExponent = exponent<0 ? -exponent : exponent;

        double res = power(base, absExponent);

        if(exponent<0)
            res = 1.0/res;
        return res;
    }

    private static double power(double base, int absExponent){
        if(absExponent==0)
            return 1;
        if(absExponent==1)
            return base;
        
        double res = power(base, absExponent>>1);

        res *= res;
        if((absExponent & 1)==1)
            res *= base;
        return res;
    }
}