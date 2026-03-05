package 백준.실버.level1;

import java.util.*;

public class 스타트와링크 {
    static int N;   //전체 사람 수
    static int[][] S;   //능력치 행렬
    static boolean[] visited;   //스타트 팀에 포함 여부 체크
    static int minDiff = Integer.MAX_VALUE; //최소 능력치 차이를 저장

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();   //사람 수 입력
        S = new int[N][N];  //능력치 행렬 초기화
        visited = new boolean[N];   //방문 여부 배열 초기화

        //능력치 행렬 입력
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                S[i][j] = sc.nextInt();
            }
        }

        //DFS로 팀 조합 생성 시작
        dfs(0, 0);

        //최소 차이 출력
        System.out.println(minDiff);
    }

    //dfs : 스타트 팀을 구성하는 조합을 만드는 함수
    //idx : 현재 사람 번호, count : 스타트 팀에 포함된 인원 수
    static void dfs(int idx, int count){
        //스타트 팀이 N/2명이 되면 능력치 차이를 계산
        if(count == N / 2){
            calcDiff();
            return;
        }

        //모든 사람을 확인 했으면 종료
        if(idx >= N) return;

        //현재 idx를 스타트 팀에 포함시킴
        visited[idx] = true;
        dfs(idx + 1, count + 1);

        //포함하지 않고 넘어감 (링크 팀으로 간주)
        visited[idx] = false;
        dfs(idx + 1, count);
    }

    //두 팀의 능력치 차이를 계산하는 함수
    static void calcDiff(){
        int start = 0;  //스타트 팀 능력치 합
        int link = 0;   //링크 팀 능력치 합

        //모든 사람 쌍(i, j)을 확인
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                //둘다 스타트 팀에 속하면 스타트 능력치에 더함
                if(visited[i] && visited[j]){
                    start += S[i][j] + S[j][i];
                }
                //둘 다 링크 팀에 속하면 링크 능력치에 더함
                else if(!visited[i] && !visited[j]){
                    link += S[i][j] + S[j][i];
                }
            }
        }

        minDiff = Math.min(minDiff, Math.abs(start - link));
    }
}
