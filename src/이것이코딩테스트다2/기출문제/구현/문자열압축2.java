package 이것이코딩테스트다2.기출문제.구현;

import java.util.*;
import java.io.*;

public class 문자열압축2 {
    static int length;
    static String str = "";

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        length = str.length();
        int result = length;

        for(int step=1;step<length;step++){
            String prev = str.substring(0, step);
            int count = 1;
            String compressed = "";

            for(int i=step;i<=length;i += step){
                //이게 자를때 마지막에는 str 마지막 index를 넘어갈 수 있어서 넣어줘야함
                String sub = str.substring(i, Math.min(i+step,length));
                if(prev.equals(sub)){
                    count++;
                }else{
                    compressed += (count >= 2 ? count : "") + prev;
                    prev = sub;
                    count = 1;  //빼먹음
                }
            }
            compressed += (count >= 2 ? count : "") + prev;
            result = Math.min(result, compressed.length());
        }
        System.out.print(result);
    }

}
