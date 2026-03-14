package 백준.브론즈.level3;

import java.util.*;
import java.io.*;

public class ACM호텔 {
    static int t;
    static int[][] hotel;
    static int width;
    static int height;
    static int select;
    static ArrayList<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for(int k=0;k<t;k++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            height = Integer.parseInt(st.nextToken());
            width = Integer.parseInt(st.nextToken());
            select = Integer.parseInt(st.nextToken());
            int floor = 0;
            int count = 0;
            for(int i=0;i<width;i++){
                floor = (i+1);
                for(int j=0;j<height;j++){
                    //list.add(floor);
                    if(count == select){
                        sb.append(floor).append("\n");
                        break;
                    }
                    floor += 100;
                    count++;
                }
                if(count == select){
                    break;
                }
            }
        }

        System.out.print(sb);

    }

}
