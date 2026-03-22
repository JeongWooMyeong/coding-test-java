package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 마법사상어와파이어볼4 {
    static int N, M, K;
    static List<Fireball> fireList = new ArrayList<>();

    static int[] dr = {-1,-1,0,1,1,1,0,-1};
    static int[] dc = {0,1,1,1,0,-1,-1,-1};

    static class Fireball{
        private int r,c,m,s,d;

        public Fireball(int r, int c, int m, int s, int d){
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }

        public int getR(){
            return this.r;
        }

        public int getC(){
            return this.c;
        }

        public int getM(){
            return this.m;
        }

        public int getS(){
            return this.s;
        }

        public int getD(){
            return this.d;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //격자수
        M = Integer.parseInt(st.nextToken());   //파이어볼 개수
        K = Integer.parseInt(st.nextToken());   //횟수

        //1. 파이어볼 정보 입력
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            fireList.add(new Fireball(r,c,m,s,d));
        }

        //2. 파이어볼 이동 및 조합
        for(int step=0;step<K;step++){
            move();
            combine();
        }

        //3. 결과 산출
        int sum = 0;
        for(Fireball f : fireList){
            sum += f.m;
        }

        System.out.print(sum);

    }

    static void move(){
        for(Fireball f : fireList){
            f.r = (f.r + dr[f.d]*f.s % N + N) % N;
            f.c = (f.c + dc[f.d]*f.s % N + N) % N;
        }
    }

    //이동 했을시 같은 좌표 map으로 묶어서 합산 후 새로운 list 생성
    static void combine(){
        Map<String, List<Fireball>> map = new HashMap<>();
        for(Fireball f : fireList){
            String key = f.r + "," + f.c;
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(f);
        }

        List<Fireball> newList = new ArrayList<>();

        for(List<Fireball> list : map.values()){
            int sumM = 0; int sumS = 0;
            boolean allEven = true; boolean allOdd = true;

            if(list.size() == 1){
                newList.add(list.get(0));
            }else {
                for (Fireball f : list) {
                    sumM += f.m;
                    sumS += f.s;

                    if(f.d % 2 == 0) allEven = false;
                    else allOdd = false;

                }

                int newM = sumM / 5;
                if(newM == 0) continue;
                int newS = sumS / list.size();

                int[] dirs = (allEven || allOdd) ? new int[]{0,2,4,6} : new int[]{1,3,5,7};

                for(int d : dirs){
                    newList.add(new Fireball(list.get(0).r, list.get(0).c, newM, newS, d));
                }

            }



        }

        fireList = newList;

    }

}
