package cn.nju.example;

public class S12_HasPath{
    public static void main(String[] args){
        char[][] chars = {{'a','b','t','g'},
                          {'c','f','c','s'},
                          {'j','d','e','h'}};
        System.out.println(hasPath(chars, "bfce"));
        System.out.println(hasPath(chars, "abfb"));
        System.out.println(hasPath(chars, "jdeh"));
        System.out.println(hasPath(chars, "acjf"));
        System.out.println(hasPath(chars, "acfc"));
    }

    private static boolean hasPath(char[][] chars, String s){
        if(chars==null || chars.length==0) return false;
        char c = s.charAt(0);
        boolean[][] used = new boolean[chars.length][chars[0].length];
        for(int i=0;i<chars.length;i++){
            for(int j=0;j<chars[0].length;j++){
                if(chars[i][j]==c)
                    if(hasPath_helper(chars, s, i, j,used)) return true;
            }
        }
        return false;
    }

    private static boolean hasPath_helper(char[][] chars, String s, int row, int col, boolean[][] used){
        if(used[row][col]) return false;
        if(s.charAt(0)!=chars[row][col]){
            return false;
        }
        else{
            if(s.length()==1) return true;
            String remain = s.substring(1);
            used[row][col] = true;
            int r = chars.length;
            int c = chars[0].length;
            if(row-1>=0){
                if(hasPath_helper(chars, remain, row-1, col, used)) return true;
            }
            if(row+1<r){
                if(hasPath_helper(chars, remain, row+1, col, used)) return true;
            }
            if(col-1>=0){
                if(hasPath_helper(chars, remain, row, col-1, used)) return true;
            }
            if(col+1<c){
                if(hasPath_helper(chars, remain, row, col+1, used)) return true;
            }
            used[row][col] = false;
        }
        
        return false;
    }
}