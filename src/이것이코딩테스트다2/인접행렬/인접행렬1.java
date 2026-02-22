package 이것이코딩테스트다2.인접행렬;

import java.util.*;
import java.io.*;

public class 인접행렬1 {

    public static final int INF = Integer.MAX_VALUE;

    //2차원 리스트를 이용해 인접 행렬 표현
    public static int[][] graph = {
            {0, 7, 5},
            {7, 0, INF},
            {5,INF, 0}
    };

    public static void main(String[] args){
        //그래프 출력
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                System.out.println(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
