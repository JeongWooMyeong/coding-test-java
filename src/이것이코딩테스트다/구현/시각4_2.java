package 이것이코딩테스트다.구현;

import java.util.*;
import java.io.*;

public class 시각4_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //시간 입력
        String hour = "";
        String min = "";
        String second = "";
        String result = "";
        int cnt = 0;

        for(int i=0;i<(N+1);i++){
            hour = i + "";
            for(int j=0;j<60;j++){
                min = j + "";
                for(int k=0;k<60;k++){
                    second = k + "";
                    result = hour + min + second;
                    if(result.contains("3")){
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);



    }
}
