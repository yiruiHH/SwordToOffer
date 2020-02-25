package cn.nju.example;

public class S65_Add{
    public static void main(String[] args) {
        System.out.println(add(5, 17));
    }

    public static int add(int n1, int n2){
        int sum = 0;
        int carry = 0;
        do{
            sum = n1 ^ n2;
            carry = (n1 & n2) << 1;
            n1 = sum;
            n2 = carry;
        }while(n2!=0);

        return sum;
    }
}