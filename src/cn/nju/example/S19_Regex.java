package cn.nju.example;

public class S19_Regex{
    public static void main(String[] args) {
        System.out.println(match("aaa","a*"));
        System.out.println(match("aaa","a.a"));
        System.out.println(match("aaa","ab*ac*a"));
        System.out.println(match("aaa","aa.a"));
        System.out.println(match("aaa","ab*a"));
    }
    
    private static boolean match(String s, String p){
        if(s==null || p==null)
            return false;
        return match_core(s, p);
    }

    private static boolean match_core(String s, String p){
        if(s.length()==0 && p.length()==0)
            return true;
        if(s.length()*p.length()==0)
            return false;

        if(p.length()>1 && p.charAt(1)=='*'){
            if(s.charAt(0)==p.charAt(0) || p.charAt(0)=='.'){
                return match_core(s.substring(1), p.substring(2)) ||
                       match_core(s.substring(1), p) ||
                       match_core(s, p.substring(2));
            }
            else{
                return match_core(s, p.substring(2));
            }
        }
        else{
            if(s.charAt(0)==p.charAt(0) || p.charAt(0)=='.'){
                return match_core(s.substring(1), p.substring(1));
            }
        }
        return false;
    }
}