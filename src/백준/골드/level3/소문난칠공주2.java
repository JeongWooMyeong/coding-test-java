package 백준.골드.level3;

import java.util.*;
import java.io.*;

public class 소문난칠공주2 {
    static char[][] map = new char[5][5];
    static int N = 5;
    static int answer = 0;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<N;i++){
            String line = br.readLine();
            for(int j=0;j<N;j++){
                map[i][j] = line.charAt(j);
            }
        }
        //인덱스, 선택된 리스트에 대해서 요구하는 조건 충족하는지 확인 후 만족하면 answer++;
        dfs(0, new ArrayList<>());

        System.out.print(answer);

    }

    static void dfs(int idx, List<Integer> selected){
        //종료 조건
        if(selected.size() == 7){
            if(check(selected)) answer++;
            return;
        }
        //idx 넘어갈 수 있으므로
        if(idx >= 25) return;

        //한칸 선택 햇을떄
        selected.add(idx);
        dfs(idx+1, selected);
        selected.remove(selected.size()-1);
        //한칸 선택 안햇을때
        dfs(idx+1, selected);

    }

    //선택된 7명이 조건을 만족하는지 확인
    static boolean check(List<Integer> selected){
        int sCount = 0;
        for(int pos : selected){
            //x, y 합쳐진 idx를 x,y로 나눔
            int x = pos / 5;
            int y = pos % 5;
            if(map[x][y] == 'S') sCount++;
        }
        if(sCount < 4) return false;

        //만족하면 선택된 selected에 대하여 bfs 시행
        boolean[] visited = new boolean[7];
        Queue<Integer> q = new ArrayDeque<>();
        visited[0] = true;
        q.offer(0);
        int isConnected = 1; //선택

        while(!q.isEmpty()){
            int cur = q.poll();

            int x = selected.get(cur) / 5;
            int y = selected.get(cur) % 5;

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue; // 보드 범위 체크 해야한
                int nextPos = nx * 5 + ny;

                for(int j=0;j<7;j++){
                    if(!visited[j] && selected.get(j) == nextPos){
                        visited[j] = true;
                        isConnected++;
                        q.offer(j);
                    }
                }


            }

        }

        return isConnected == 7;

    }

}
