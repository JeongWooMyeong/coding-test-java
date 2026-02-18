package 알고리즘정리;

import java.util.*;

class UnionFind{
    int[] parent;
    int[] rank;

    public UnionFind(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;  //처음엔 자기 자신이 루트
            rank[i] = 0;    //초기 랭크는 0
        }
    }

    //경로 압축 적용된 find()
    public int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);    //루트까지 올라가면서 부모를 루트로 직접 연결
        }
        return parent[x];
    }

    //랭크 기반 병합
    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if(rootX == rootY) return;   //이미 같은 집합이면 아무것도 안함

        if(rank[rootX] < rank[rootY]){
            parent[rootX] = rootY;  //랭크가 낮은 트리를 높은 트리에 붙임
        }else if(rank[rootX] > rank[rootY]){
            parent[rootY] = rootX;
        }else{
            parent[rootY] = rootX;  //랭크가 같으면 한쪽을 루트로 하고
            rank[rootX]++;  //루트의 랭크를 1 증가
        }
    }

    //디버깅 용  각 노드의 부모 출력
    public void printParents(){
        for(int i=0;i<parent.length;i++){
            System.out.println("노드" + i + " -> 부모 " + parent[i]);
        }
    }
}

public class UnionFindExample {
    public static void main(String[] args){
        UnionFind uf = new UnionFind(6);

        //집합 병힙
        uf.union(0, 1);
        uf.union(1, 2);
        uf.union(3, 4);

        System.out.println("초기상태:");
        uf.printParents();

        //find 호출로 경로 압축 발생
        System.out.println("\nfind(2) 호출 후 : ");
        uf.find(2); //2 -> 루트까지 올라가면서 부모 갱신
        uf.printParents();

        //추가 병합
        uf.union(2, 3);

        System.out.println("\n최종상태:");
        uf.printParents();
    }
}
