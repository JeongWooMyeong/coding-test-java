package 이것이코딩테스트다2.기출문제.구현;

import java.util.*;
import java.io.*;

public class 럭키스트레이트2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int num = line.length();
        int num2 = num / 2;

        String one = line.substring(0,num2);
        String two = line.substring(num2);

        int sum = 0;
        int sum2 = 0;

        for(int i=0;i<num2;i++){
            sum += one.charAt(i) - '0';
            sum2 += two.charAt(i) - '0';
        }

        if(sum == sum2){
            System.out.print("LUCKY");
        }else{
            System.out.print("READY");
        }
    }
}
