package cn.nju.example;

public class S62_LastRemaining{
    public static void main(String[] args) {
        System.out.println(new S62_LastRemaining().getLastRemaining(5, 3));
    }

    private int getLastRemaining(int n, int m){
        if(n<1 || m<1) return -1;

        int last = 0;
        for(int i=2;i<=n;i++){
            last = (last+m)%i;
        }

        return last;
    }
}