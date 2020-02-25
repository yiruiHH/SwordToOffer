package cn.nju.example;

public class S58_ReverseString{
    public static void main(String[] args) {
        S58_ReverseString obi = new S58_ReverseString();
        System.out.println(obi.reverseSentence("I am a student."));
        System.out.println(obi.reverseSentence("Want to make a difference? So do we. Step in to explore the wealth of career opportunities and take your career to the next level."));

        for (int i = 0; i < 10; i++) {
            System.out.println(obi.leftRotateString("123456789", i));
        }
        
        
    }

    private String reverseSentence(String s){
        if(s==null || s.length()==0) return s;

        char[] chars = s.toCharArray();

        int l = 0;
        int r = chars.length-1;
        while(l<r){
            char c = chars[l];
            chars[l] = chars[r];
            chars[r] = c;

            r--;
            l++;
        }
        System.out.println(String.valueOf(chars));

        l=0;
        for(int i=0;i<chars.length;i++){
            if(i==chars.length-1 || chars[i+1]==' '){
                r=i;
                while(l<r){
                    char c = chars[l];
                    chars[l] = chars[r];
                    chars[r] = c;

                    r--;
                    l++;
                }
                l=i+2;
            }
        }

        return String.valueOf(chars);
    }

    private String leftRotateString(String s, int n){
        if(s==null || s.length()==0) return s;

        char[] chars = s.toCharArray();

        if(n<0 || n>s.length())
            throw new IllegalArgumentException("invalid input");
        
        if(n==0) return s;
        //翻转前 n 位
        reverse(chars, 0, n-1);
        //翻转之后的
        reverse(chars, n, chars.length-1);
        //翻转整个
        reverse(chars, 0, chars.length-1);

        return String.valueOf(chars);

    }

    private void reverse(char[] chars, int l, int r){
        while(l<r){
            char c = chars[l];
            chars[l] = chars[r];
            chars[r] = c;

            r--;
            l++;
        }
    }
}