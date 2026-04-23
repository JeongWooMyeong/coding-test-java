package 프로그래머스.level1;

import java.util.*;
import java.io.*;

public class 체육복4 {

    public static int solution(int n, int[] lost, int[] reserve){
        int answer = 0;
        int[] clothes = new int[n+1];
        Arrays.fill(clothes, 1);

        for(int l : lost){
            clothes[l] -= 1;
        }

        for(int r : reserve){
            clothes[r] += 1;
        }

        for(int i=1;i<=n;i++){
            if(clothes[i] == 0){
                if(i > 1 && clothes[i-1] > 1){
                    clothes[i] += 1;
                    clothes[i-1] -= 1;
                }else if(i < n && clothes[i+1] > 1){
                    clothes[i] += 1;
                    clothes[i+1] -= 1;
                }
            }
        }

        for(int i=1;i<=n;i++){
            if(clothes[i] >= 1) answer++;
        }


        return answer;
    }

    public static void main(String[] args) throws Exception{
        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {3};

        System.out.println(solution(n, lost, reserve));

    }

}
