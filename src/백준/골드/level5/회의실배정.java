package 백준.골드.level5;

import java.util.*;

public class 회의실배정 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] meetings = new int[n][2];

        for(int i=0;i<n;i++){
            meetings[i][0] = sc.nextInt();  //시작 시간
            meetings[i][1] = sc.nextInt();  //끝나는 시간
        }

        //끝나는 시간 기준으로 정렬, 같으면 시작 시간 기준
        Arrays.sort(meetings, (a,b) ->{
            if(a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int count = 0;
        int end = 0;
        for(int i=0;i<n;i++){
            if(meetings[i][0] >= end){
                end = meetings[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
