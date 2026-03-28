package 이것이코딩테스트다2.기출문제.구현;

import java.io.*;
import java.util.*;

public class 문자열재정렬2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        List<Character> list = new ArrayList<>();
        int sum = 0;

        for(int i=0;i<line.length();i++){
            char s = line.charAt(i);
            if(Character.isLetter(s)){
                list.add(s);
            }else{
                sum += s - '0';
            }
        }

        Collections.sort(list);
        //String result = "";
        StringBuilder sb = new StringBuilder();

        for(Character x : list) {
            //result += x;
            sb.append(x);

        }

        sb.append(sum);

        System.out.print(sb);


    }
}
