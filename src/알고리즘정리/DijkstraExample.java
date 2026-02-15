package 알고리즘정리;
/*
다익스트라 알고리즘 (Dijkstra)
한 출발점에서 다른 모든 노드까지의 최단 거리 계산
우선순위 큐 (PriorityQueue)를 활용하면 효율적
O(ElogV)
 */
import java.util.*;

class Node implements Comparable<Node>{
    int index;
    int distance;

    public Node(int index, int distance){
        this.index = index;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node other){
        return this.distance - other.distance;
    }
}

public class DijkstraExample {
    public static final int INF = (int)1e9;
    public static int n,m, start;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static int[] d;

    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int dist = node.distance;
            int now = node.index;

            if(d[now] < dist) continue;
            for(Node next : graph.get(now)){
                int cost = d[now] + next.distance;
                if(cost < d[next.index]){
                    d[next.index] = cost;
                    pq.offer(new Node(next.index, cost));
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        d = new int[n+1];
        Arrays.fill(d, INF);

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Node(b, c));
        }

        dijkstra(start);

        for(int i=1;i<=n;i++){
            if(d[i] == INF) System.out.println("INFINITY");
            else System.out.println(d[i]);
        }

    }
}
