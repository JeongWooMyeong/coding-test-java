package 백준.실버.level1;

import java.util.*;

public class 스타트와링크3 {
    static int n;
    //N/2는 스타트팀, 나머지 링크팀
    //스타트팀의 능력치와 링크팀의 능력치의 차이를 최소 (Math.min과 Math.abs 사용)
    //sij + sji 능력치계산
    //능력치 계산 메서드 및 스타트팀 및 링크팀 정하는 메서드 필요
    //n x n 으로 구성
    //start 팀 구분 flag 1차원으로도 충분 한명의 사람이 
    static boolean[] visited;
    //
    static int[][] arr;
    //능력치 차이 최소값
    static int minDiff = Integer.MAX_VALUE;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        visited = new boolean[n];
        //각 사람의 능력치에 대한 입력
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = sc.nextInt();
            }
        }

        teamselect(0, 0);
        System.out.println(minDiff);

    }

    public static void teamselect(int idx, int count){
        if(count == n/2){
            //능력치 계산
            calculate();
            return;
        }
        //배열이기 때문에 종료 조건 명시
        if(idx >= n) return;

        //스타트 팀일때
        visited[idx] = true;
        teamselect(idx+1, count+1);
        //스타트 팀 아닐때..
        visited[idx] = false;
        teamselect(idx+1, count);
    }

    public static void calculate(){
        int start =0, link = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(visited[i] && visited[j]){
                    start += arr[i][j] + arr[j][i];
                }else if(!visited[i] && !visited[j]){
                    link += arr[i][j] + arr[j][i];
                }
            }
        }
        minDiff = Math.min(minDiff, Math.abs(start - link));
    }

}
