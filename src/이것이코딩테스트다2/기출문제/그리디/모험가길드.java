package 이것이코딩테스트다2.기출문제.그리디;

import java.util.*;

public class 모험가길드 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] scary = new int[n];
        for(int i=0;i<n;i++){
            scary[i] = sc.nextInt();    //공포도 입력
        }

        Arrays.sort(scary); //공포도 오름차순 정렬

        int cnt = 0;
        int result = 0;
        for(int i=0;i<scary.length;i++){
           int x =scary[i];
           cnt++;
           if(cnt == x){
               result += 1;
               cnt = 0;
           }

        }


        System.out.println(result);
    }

}
