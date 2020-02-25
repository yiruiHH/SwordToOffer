package cn.nju.example;

public class S20_Numeric{
    public static void main(String[] args){
        System.out.println(isNumeric("+100"));
        System.out.println(isNumeric("5e2"));
        System.out.println(isNumeric("-123"));
        System.out.println(isNumeric("3.1416"));
        System.out.println(isNumeric("-1E-16"));
        System.out.println(isNumeric("12e"));
        System.out.println(isNumeric("1a3.14"));
        System.out.println(isNumeric("1.2.3"));
        System.out.println(isNumeric("+-5"));
        System.out.println(isNumeric("12e+5.4"));
    }

    private static boolean isNumeric(String s){
        if(s==null || s.length()==0)
            return false;
        boolean hasSign = false;
        boolean hasdot = false;
        boolean hasE = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c=='+' || c=='-'){
                if(!hasSign){
                    hasSign = true;
                    continue;
                }
                else return false;
            }
            if(c=='.'){
                if(hasE) return false;
                if(!hasdot){
                    hasdot = true;
                    continue;
                }
                else{
                    return false;
                }
            }
            if(c=='e' || c=='E'){
                if(i==s.length()-1) return false;
                if(!hasE){
                    hasE = true;
                    hasSign = false;
                    continue;
                }
                else return false;
            }
            if(c>='0' && c<='9'){
                continue;
            }
            return false;
        }

        return true;
    }
}