package 백준.골드.level5;

import java.io.*;
import java.util.*;

public class 톱니바퀴 {
    static Deque<Integer>[] gears = new Deque[4];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0;i<4;i++){
            String line = br.readLine();
            gears[i] = new ArrayDeque<>();
            for(char c : line.toCharArray()){
                gears[i].add(c - '0');
            }
        }

        int k = Integer.parseInt(br.readLine());
        while(k-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(st.nextToken()) - 1; //0 - index;
            int dir = Integer.parseInt(st.nextToken()); //1 시게 -1 반시계

            rotateWithPropagation(gearNum, dir);
        }

        //점수 계싼
        int score = 0;
        for(int i=0;i<4;i++){
            if(gears[i].peekFirst() == 1){
                score += (1 << i);
            }
        }
        System.out.println(score);
    }

    static void rotateWithPropagation(int gearNum, int dir){
        int[] dirs = new int[4];
        dirs[gearNum] = dir;

        //왼쪽 전파
        for(int i=gearNum;i>0;i--){
            if(getRight(gears[i-1]) != getLeft(gears[i])){
                dirs[i-1] = -dirs[i];
            }else break;
        }

        //오른쪽 전파
        for(int i=gearNum;i<3;i++){
            if(getRight(gears[i]) != getLeft(gears[i+1])){
                dirs[i+1] = -dirs[i];
            }
        }

        //실제 회전
        for(int i=0;i<4;i++){
            if(dirs[i] == 1) rotateClockwise(gears[i]);
            else if(dirs[i] == -1) rotateCounterClockwise(gears[i]);
        }
    }

    static int getLeft(Deque<Integer> gear){
        return gear.stream().skip(6).findFirst().get();
    }

    static int getRight(Deque<Integer> gear){
        return gear.stream().skip(2).findFirst().get();
    }

    static void rotateClockwise(Deque<Integer> gear){
        gear.addFirst(gear.pollLast());
    }

    static void rotateCounterClockwise(Deque<Integer> gear){
        gear.addLast(gear.pollFirst());
    }

}
