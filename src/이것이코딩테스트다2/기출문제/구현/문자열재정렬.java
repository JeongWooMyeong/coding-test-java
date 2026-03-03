package 이것이코딩테스트다2.기출문제.구현;

import java.util.*;
import java.io.*;

public class 문자열재정렬 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        ArrayList<String> list = new ArrayList<>();
        int sum = 0;
        for(int i=0;i<str.length();i++){
            char ab = str.charAt(i);
            if(Character.isLetter(ab)){
                list.add(ab+"");
            }else{
                sum += ab - '0';
            }
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<list.size();i++){
            sb.append(list.get(i));
        }

        System.out.println(sb.append(sum));


    }
}
