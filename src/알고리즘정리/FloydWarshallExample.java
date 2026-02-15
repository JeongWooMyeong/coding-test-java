package 알고리즘정리;

/*
플로이드 워셜 알고리즘
모든 노드 쌍의 최단 거리 계산
2차원 배열을 이용해 구현
시간 복잡도 O(n^3)
Dab = min(Dab, Dak + Dkb)
 */
import java.util.*;

public class FloydWarshallExample {
    public static final int INF = (int) 1e9;
    public static int n, m;
    public static int[][] graph = new int[501][501];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i=0;i<=n;i++){
            Arrays.fill(graph[i], INF);
        }

        for(int i=1;i<=n;i++){
            graph[i][i] = 0;
        }

        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph[a][b] = Math.min(graph[a][b], c);
        }

        for(int k=1;k<=n;k++){
            for(int a=1;a<=n;a++){
                for(int b=1;b<=n;b++){
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        for(int a=1;a<=n;a++){
            for (int b=1;b<=n;b++){
                if(graph[a][b] == INF) System.out.print("INFINITY ");
                else System.out.print(graph[a][b] + " ");
            }
            System.out.println();
        }
    }
}
