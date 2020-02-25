package cn.nju.example;

public class S44_DigitAtIndex{
    public static void main(String[] args) {
        System.out.println(digitAtIndex(0));
        System.out.println(digitAtIndex(1));
        System.out.println(digitAtIndex(9));
        System.out.println(digitAtIndex(10));
        System.out.println(digitAtIndex(189));
        System.out.println(digitAtIndex(190));
        System.out.println(digitAtIndex(1000));
        System.out.println(digitAtIndex(1001));
        System.out.println(digitAtIndex(1002));
    }

    private static int digitAtIndex(int index){
        if(index<0)
            return -1;
        int digits = 1;
        while(true){
            int nums = numOfdigits(digits);
            if(index < (digits * nums))
                return digitAtIndex(index, digits);
            index -= (digits*nums);
            digits++;
        }
    }

    private static int numOfdigits(int digit){
        if(digit==1)
            return 10;
        else{
            return 9 * powOf10(digit-1);
        }
    }

    private static int digitAtIndex(int index, int digit){
        int nums = index / digit;
        int yushu = index % digit;

        int num = powOf10(digit-1) + nums;
        String s = String.valueOf(num);
        return s.charAt(yushu)-'0';
    }

    private static int powOf10(int n){
        if(n==0)
            return 0;
        int res = 1;
        while(n>0){
            res *= 10;
            n--;
        }
        return res;
    }
}