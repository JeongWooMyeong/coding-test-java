package 이것이코딩테스트다2.기출문제.구현;

import java.util.*;
import java.io.*;

public class 문자열압축3 {
    static String str = "";
    static int length = 0;
    static int answer = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        length = str.length();
        answer = length;

        //압축 몇글자로 할것인지
        for(int step=1;step<=length;step++){
            String prev = str.substring(0, step);
            int count = 1;  //첫번째 prev 선택해쓰므로
            String compressed = "";

            for(int i=step;i<length;i+=step){
                String sub = str.substring(i, Math.min(i+step,length)); //마지막 자르는 숫자 안나오고 넘길 수 있으므로
                if(prev.equals(sub)){
                    count++;
                }else{
                    compressed += (count >= 2 ? count : "") + prev;
                    count = 1;
                    prev = sub;
                }
            }
            //마지막은 비교대상 없으므로 for문 끝나고 한번 더 처리
            compressed += (count >= 2 ? count : "") + prev;
            answer = Math.min(answer, compressed.length());
        }
        System.out.print(answer);
    }


}
