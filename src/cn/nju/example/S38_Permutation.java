package cn.nju.example;

import java.util.ArrayList;
import java.util.List;

public class S38_Permutation{
    public static void main(String[] args) {
        List<Character> list = new ArrayList<>();
        permutation("a",list);
        System.out.println();
        list.clear();
        permutation("ab",list);
        System.out.println();
        list.clear();
        permutation("abc",list);
        System.out.println();
        list.clear();
        permutation("abcd",list);
        System.out.println();
    }

    private static void permutation(String s,List<Character> list){
        if(s==null || s.length()==0){
            System.out.print(list+" ");
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
            String newsString = s.substring(0, i)+s.substring(i+1, s.length());
            permutation(newsString,list);
            list.remove(list.size()-1);
        }

    }
}