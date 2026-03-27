package 이것이코딩테스트다2.기출문제.그리디;

import java.util.*;
import java.io.*;

public class 곱하기혹은더하기2 {
    static int answer = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        for(int i=0;i<line.length();i++){
            int num = line.charAt(i) - '0';
            if(num == 1 || num == 0 || answer == 0){
                answer += num;
            }else{
                answer *= num;
            }
        }

        System.out.print(answer);
    }

}
