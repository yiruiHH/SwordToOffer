package cn.nju.example;

public class S05_ReplaceBlank{
    public static void main(String[] args){
        String s = "We are happy!";
        System.out.println(s);
        char[] arr = new char[20];
        char[] sc = s.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            arr[i] = sc[i];
        }
        System.out.println(sc.length);
        replace(arr,sc.length);
        System.out.println(String.valueOf(arr));
    }

    private static void replace(char[] string, int size){
        if(string==null || string.length==0) return;

        int numOfblanks = 0;
        for(int i=0;i<string.length;i++){
            if(string[i]==' ') numOfblanks++;
        }

        int p1 = size-1;
        int p2 = p1+numOfblanks*2;
        if(p2>=string.length){
            throw new RuntimeException("the array is too small");
        }

        while(p1>=0){
            if(string[p1]!=' '){
                string[p2--] = string[p1--];
            }
            else{
                string[p2] = '0';
                string[p2-1] = '2';
                string[p2-2] = '%';
                p1--;
                p2 = p2-3;
            }
        }
    }
}