package cn.nju.example;

public class S67_StringToInt{
    public static void main(String[] args) {
        test("1");
        test("123");
        test("+50");
        test("-17");
        test("+-1");
        test("2147483647");
        test("-2147483648");
        test("15341351531135");
        test("-15341351531135");
        test("13425a312");
        test("0");
        test("");
        test(null);
    }

    private static void test(String s){
        int[] ans = StringToInt(s);
        if(ans[0]==1){
            System.out.println(s+"--->"+ans[1]);
        }
        else{
            System.out.println(s+" is not a int number.");
        }
    }

    public static int[] StringToInt(String s){
        //第0位表示是否为有效的int数字，0表示无效 1表示有效，第1位存放答案
        int[] res = new int[2];
        if(s==null || s.length()==0){
            return res;
        }
        char first = s.charAt(0);
        if(first=='+'){
            StringToIntCore(s.substring(1), false, res);
        }
        else if(first=='-'){
            StringToIntCore(s.substring(1), true, res);
        }
        else{
            StringToIntCore(s, false, res);
        }

        return res;
    }

    private static void StringToIntCore(String s,boolean minus,int[] res){
        long num = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c<='9' && c>='0'){
                if(minus){
                    num = num*10 - (c-'0');
                }
                else{
                    num = num*10 + (c-'0');
                }
                
                if(num<Integer.MIN_VALUE || num>Integer.MAX_VALUE){
                    return;
                }
            }
            else{
                return;
            }
        }
        res[0] = 1;
        res[1] = (int)num;
    }
}