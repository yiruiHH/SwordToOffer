package cn.nju.example;

public class S50_CharOfOnce{
    public static void main(String[] args) {
        System.out.println(getCharOfOnce("aabbccdeefgfg"));
        System.out.println(getCharOfOnce("a"));
        System.out.println(getCharOfOnce("aaa"));
        System.out.println(getCharOfOnce(""));
    }

    private static char getCharOfOnce(String s){
        if(s==null || s.length()==0){
            return '\0';
        }

        int[] times = new int[26];
        for(int i=0;i<s.length();i++){
            times[s.charAt(i)-'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if(times[i]==1){
                return (char)('a'+i);
            }
        }

        return '\0';
    }
}