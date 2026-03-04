package 백준.실버.level5;

import java.util.*;

public class 영화감독숌 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int last = 666;
        int count = 0;
        int answer = 0;
        while(true){
            if(String.valueOf(last).contains("666")){
                count++;
                if(count == n){
                    answer = last;
                    break;
                }
            }
            last++;
        }

        System.out.println(answer);
    }
}
