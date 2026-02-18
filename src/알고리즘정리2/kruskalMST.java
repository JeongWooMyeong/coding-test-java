package 알고리즘정리2;
/*
신장 트리 (Spanning Tree)
- 연결 그래프에서 모든 정점을 포함하면서 사이클이 없는 부분 그래프
- 정점 수가 V개라면 간선수는 항상 V-1
- 여러개의 신장 트리가 존재할 수 있음
최소 신장 트리 (MST, Minimum Spanning Tree)
- 신장 트리 중에서 간선들의 가중치 합이 최소인 트리
- 도로망 설계 (최소 비용으로 모든 도시 연결)
- 네트워크 구축 (최소 비용ㅇ으로 모든 컴퓨터 연결)
크루스칼 알고리즘 (Kruskal's Algorithm)
- 모든 간선을 가중치 기준으로 오름차순 정렬
- 작은 간선부터 하나씩 선택
- 사이클이 생기지 않으면 포함 (Union-Find 사용)
- V-1 간선이 선택되면 종료
 */
import java.util.*;

class Edge implements Comparable<Edge>{
    //간선의 시작 정점 (src), 끝 정점 (dest), 가중치 (weight)
    int src, dest, weight;

    public Edge(int src, int dest, int weight){
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
    //간선 정렬 기준 : 가중치 오름차순
    @Override
    public int compareTo(Edge other){
        return this.weight - other.weight;
    }
}

class UnionFind{
    //parent : 각 노드의 부모, rank : 트리 높이 (union 시 효율적 병합 위해 사용)
    int[] parent, rank;

    public UnionFind(int n){
        parent = new int[n];
        rank = new int[n];
        //초기에는 모든 노드가 자기 자신을 부모로 가짐
        for(int i=0;i<n;i++) parent[i] = i;
    }

    public int find(int x){
        if(parent[x] != x){
            //경로 압축 (Path Compression) : 루트까지 바로 연결
            parent[x] = find(parent[x]);    //경로 압축
        }
        return parent[x];
    }

    public boolean union(int x, int y){
        int rootX = find(x), rootY = find(y);
        //같은 집합이면 사이클 발생 -> 간선 추가하지 않음
        if(rootX == rootY) return false;

        if(rank[rootX] < rank[rootY]) parent[rootX] = rootY;
        else if(rank[rootX] > rank[rootY]) parent[rootY] = rootX;
        else{
            parent[rootY] = rootX;
            rank[rootX]++;
            //높이가 같으면 한쪽을 루트로 하고 rank 증가
        }
        //두 집합을 성공적으로 합쳤음을 의미
        return true;
    }
}

public class kruskalMST {
    public static void main(String[] args){
        //정점개수
        int V = 4;  //정점 개수
        //간선들을 저장할 리스트
        List<Edge> edges = new ArrayList<>();

        //그래프 간선 추가 (src, dest, weight)
        edges.add(new Edge(0,1,10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        //크루스칼 알고리즘 실행
        Collections.sort(edges);    //간선 정렬
        UnionFind uf = new UnionFind(V);

        List<Edge> mst = new ArrayList<>();
        for(Edge e : edges){
            //사이클이 생기지 않으면 MST에 추가
            if(uf.union(e.src, e.dest)){
                mst.add(e);
            }
        }

        //결과 출력
        System.out.println("최소 신장 트리 간선:");
        int totalWeight = 0;
        for(Edge e : mst){
            System.out.println(e.src + "-" + e.dest + " : " + e.weight);
            totalWeight += e.weight;
        }
        System.out.println("총 가중치 : " + totalWeight);
    }
}
