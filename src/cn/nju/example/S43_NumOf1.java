package cn.nju.example;

public class S43_NumOf1{
    public static void main(String[] args) {
        System.out.println(numOf1(-10)); // 0
        System.out.println(numOf1(0)); // 0
        System.out.println(numOf1(1)); // 1
        System.out.println(numOf1(5)); // 1
        System.out.println(numOf1(10)); // 2
        System.out.println(numOf1(20)); // 12
        System.out.println(numOf1(55)); // 16
        System.out.println(numOf1(99)); // 20
        System.out.println(numOf1(10000)); // 4001
        System.out.println(numOf1(21345)); // 18821
    }

    private static int numOf1(int n){
        if(n<=0)
            return 0;
        String s = String.valueOf(n);
        return numOf1(s);
    }

    private static int numOf1(String n){
        if(n==null || n.length()==0)
            return 0;
        if(n.length()==1){
            if(n.equals("0"))
                return 0;
            return 1;
        }
        int len = n.length();
        int numOf1 = 0;
        int firstNum = n.charAt(0)-'0';
        int num = Integer.valueOf(n);
        if(firstNum==0)
            return 0;
        if(firstNum==1){
            numOf1 = num - firstNum*powOf10(len-1) +1;
        }
        else{
            numOf1 = powOf10(len-1);
        }

        numOf1 += firstNum * (len-1) * powOf10(len-2);

        return numOf1 + numOf1(n.substring(1));
    }

    private static int powOf10(int n){
        int res = 1;
        while(n>0){
            res *= 10;
            n--;
        }
        return res;
    }
}