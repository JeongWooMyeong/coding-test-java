package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 마법사상어와파이어볼 {
    //격자 크기 N, 파이어볼 개수 M, 이동 횟수 K
    static int N, M, K;

    //8방향 이동 벡터 (상, 우상, 우, 우하, 하, 좌하, 좌, 좌상)
    static int[] dr = {-1, -1,0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    //현재 존재하는 모든 파이어볼을 담는 리스트
    static List<Fireball> fireballs = new ArrayList<>();

    //파이어볼 클래스; 위치 (r,c) 질량 m, 속력 s, 방향 d
    static class Fireball{
        int r, c, m, s, d;
        Fireball(int r, int c, int m, int s, int d){
            this.r = r; this.c = c; this.m = m; this.s = s; this.d = d;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //입력 처리
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        //초기 파이어볼 정보 입력
        for(int i=0;i<M;i++){
            int r = sc.nextInt()-1; // 문제는 1-index, 코드에서는 0-index로 변환
            int c = sc.nextInt()-1;
            int m = sc.nextInt();   //질량
            int s = sc.nextInt();   //속력
            int d = sc.nextInt();   //방향
            fireballs.add(new Fireball(r,c,m,s,d));

        }

        // K번 반복 : 이동 -> 합치기 / 분리
        for(int step=0;step<K;step++){
            move();
            combine();
        }

        int answer = 0;
        for(Fireball f : fireballs) answer += f.m;
        System.out.println(answer);

    }

    // 1. 이동 단계
    static void move(){
        for(Fireball f : fireballs){
            //방향 d 에 따라 속련 s만큼 이동
            //트로이드 격자이므로 N으로 나눈 나머지 로 좌표 처리
            f.r = (f.r + dr[f.d]*f.s % N + N) % N;
            f.c = (f.c + dc[f.d]*f.s % N + N) % N;
        }
    }

    //2. 합치기/분리 단계
    static void combine(){
        //같은 칸에 모인 파이어볼들을 묶기 위해 Map 사용
        Map<String, List<Fireball>> map = new HashMap<>();
        for(Fireball f : fireballs){
            String key = f.r + "," + f.c;   //좌표를 문자열로 묶어서 key로 사용
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(f);
        }

        //새로 만들어질 파이어볼 리스트
        List<Fireball> newList = new ArrayList<>();

        //각 칸에 대해 처리
        for(List<Fireball> list : map.values()){
            if(list.size() == 1){
                newList.add(list.get(0));
            }else{
                int sumM = 0, sumS = 0;
                boolean allEven=true, allOdd =true;

                for(Fireball f : list){
                    sumM += f.m;
                    sumS += f.s;
                    //방향이 모두 짝수인지 모두 홀수인지 체크
                    if(f.d % 2 == 0) allOdd = false;
                    else allEven = false;
                }

                //새 질량 = 합쳐진 질량 / 5
                int newM = sumM / 5;
                if(newM == 0) continue; //질량이 0이면 소멸
                //새 속력 = 합쳐진 속력 합 / 개수
                int newS = sumS / list.size();

                //새 방향 결정
                int[] dirs = (allEven || allOdd) ? new int[]{0,2,4,6} : new int[]{1,3,5,7};

                //4개의 파이어볼로 분리
                for(int d : dirs){
                    newList.add(new Fireball(list.get(0).r, list.get(0).c, newM, newS, d));
                }

            }
        }
        fireballs = newList;    //새 리스트로 갱신
    }

}

