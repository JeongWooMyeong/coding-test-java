package 이것이코딩테스트다.기출문제.그리디;

import java.util.*;

public class 볼링공고르기책풀이 {
    public static int n,m;
    //1부터 10까지의 무게를 담을 수 있는 배열
    public static int[] arr = new int[11];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i=0;i<n;i++){
            int x = sc.nextInt();
            arr[x] += 1;
        }

        int result = 0;

        //1부터 m까지의 각 무게에 대하여 처리
        for(int i=1;i<=m;i++){
            n -= arr[i]; //무게가 i인 볼링공의 개수(A가 선택할 수 ㅇㅆ는 개수 제외)
            result += arr[i] * n;
        }

        System.out.println(result);
    }
}
