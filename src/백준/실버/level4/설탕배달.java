package 백준.실버.level4;

import java.util.*;
import java.io.*;

public class 설탕배달 {
    static int n;
    static int result = 0;
    static int[] gram = {5, 3};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        result = -1;

        for(int i=n/5;i>=0;i--){
            int remain = n - (i * 5);
            if(remain % 3 == 0){
                result = i + (remain / 3);
                break;
            }
        }
        System.out.print(result);


    }

}
