package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 전화번호목록 {

    static int t,n;
    static List<String> list;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(t-- > 0){
            n = Integer.parseInt(br.readLine());
            list = new ArrayList<>();

            for(int i=0;i<n;i++){
                list.add(br.readLine());
            }

            Collections.sort(list);

            boolean found = false;
            for(int i=0;i<n-1;i++){
                if(list.get(i+1).startsWith(list.get(i))){
                    found = true;
                    break;
                }
            }

            if(found) sb.append("NO");
            else sb.append("YES");


            sb.append("\n");

        }

        System.out.println(sb.toString());
    }

}
