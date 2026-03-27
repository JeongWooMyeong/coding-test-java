package 백준.실버.level4;

import java.util.*;
import java.io.*;

public class 게임을만든동준이 {
    static int N;
    static int[] game;
    static int result = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        game = new int[N];

        for(int i=0;i<N;i++){
            game[i] = Integer.parseInt(br.readLine());
        }

        for(int i=game.length-2;i>=0;i--){
            if(game[i] >= game[i+1]){
                int newScore = game[i+1] - 1;
                result += game[i] - newScore;
                game[i] = newScore;
            }
        }

        System.out.print(result);

    }

}
