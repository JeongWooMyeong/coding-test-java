package 알고리즘정리2;

import java.util.*;

/*
N개의 도시를 방문하는 모든 경로를 탐색하라 -> 순열
 */

public class PermutationExample2 {
    static int[] arr = {1, 2, 3};
    static boolean[] visited = new boolean[arr.length];
    static int[] result = new int[2];

    public static void main(String[] args){
        perm(0);
    }

    static void perm(int depth){
        if(depth == result.length){
            System.out.println(Arrays.toString(result));
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(!visited[i]){
                visited[i] = true;
                result[depth] = arr[i];
                perm(depth + 1);
                visited[i] = false;
            }
        }
    }
}
