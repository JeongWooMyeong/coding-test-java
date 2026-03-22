package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 마법사상어와파이어볼3 {
    static int N, M, K;
    static ArrayList<Fireball> list = new ArrayList<>();
    //8가지 방향 대각선까지 포함
    static int[] dr = {-1,1,0,0,-1,-1,-1,1};
    static int[] dc = {0,0,-1,1,1,1,-1,-1};

    static class Fireball{
        private int r, c, m, s, d;


        public Fireball(int r, int c, int m, int s, int d){
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        //파이어볼 정보 입력
        for(int i=0;i<M;i++){
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list.add(new Fireball(r,c,m,s,d));
        }
        //이동 횟수
        for(int step=0;step<K;step++){
            move();
            combine();
        }

        int answer = 0;
        for(Fireball f : list){
            answer += f.m;
        }

        System.out.println(answer);

    }

    //이동
    static void move(){
        for(Fireball f : list){
            f.r = (f.r + dr[f.d]*f.s % N + N) % N;
            f.c = (f.c + dc[f.d]*f.s % N + N) % N;
        }
    }

    //결합
    static void combine(){
        Map<String, List<Fireball>> map = new HashMap<>();
        for(Fireball f : list){
            String key = f.r + "," + f.c;
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(f);
        }

        List<Fireball> newList = new ArrayList<>();
        boolean allEven = true;  boolean allOdd = true;

        for(List<Fireball> list : map.values()){
            if(list.size() == 1){
                newList.add(list.get(0));
            }else{
                int sumS = 0;
                int sumM = 0;

                for(Fireball f : list){
                    sumS += f.s;
                    sumM += f.m;
                    //방향이 모두 홀수인지 짝수인지 판별
                    if(f.d % 2 == 0) allOdd = false;
                    else allEven = false;
                }

                int newM = sumM / 5;
                if(newM == 0) continue;

                int newS = sumS / list.size();

                int[] dirs = (allEven || allOdd) ? new int[]{2,4,6,8} : new int[]{1,3,5,7};

                for(int d : dirs){
                    newList.add(new Fireball(list.get(0).r, list.get(0).c, newM, newS, d));
                }

            }
        }

    }
    
}
