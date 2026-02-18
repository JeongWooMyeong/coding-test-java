package 이것이코딩테스트다.기출문제.크루스칼최소신장트리;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Edgess implements Comparable<Edgess>{
    private int distance;
    private int nodeA;
    private int nodeB;

    public Edgess(int distance, int nodeA, int nodeB){
        this.distance = distance;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

    public int getDistance(){
        return this.distance;
    }

    public int getNodeA(){
        return this.nodeA;
    }

    public int getNodeB(){
        return this.nodeB;
    }

    //거리가 짧은 것이 높은 우선순위를 가지도록 설정
    @Override
    public int compareTo(Edgess other){
        if(this.distance < other.distance){
            return -1;
        }
        return 1;
    }
}


public class 어두운길 {
    //노드의 개수와 간선의 개수
    public static int n, m;
    public static int[] parent = new int[200001];   //부모 테이블 초기화하기
    //모든 간선을 담으 리스트와, 최종 비용을 담을 변수
    public static ArrayList<Edgess> Edgesss = new ArrayList<>();
    public static int result = 0;

    //특정 원소가 속한 집합을 찾기
    public static int findParent(int x){
        //루트 노드가 아니라면, 루트 노드를 찾을 떄까지 재귀적으로 호출
        if(x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    //두 원소가 속한 집합을 합치기
    public static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);
        if(a<b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        //부모 테이블 상에서, 부모를 자기 자신으로 초기화
        for(int i=1;i<=n;i++){
            parent[i] = i;
        }

        //모든 간선에 대한 정보 입력 받기
        for(int i=0;i<m;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            Edgesss.add(new Edgess(z, x, y));
        }

        //간선을 비용순으로 정렬
        Collections.sort(Edgesss);
        int total = 0;  //전체 가로등 비용

        //간선을 하나씩 확인하며
        for(int i=0;i<Edgesss.size();i++){
            int cost = Edgesss.get(i).getDistance();
            int a = Edgesss.get(i).getNodeA();
            int b = Edgesss.get(i).getNodeB();
            total += cost;
            //사이클이 발생하지 않는 경우에만 집합에 포함
            if(findParent(a) != findParent(b)){
                unionParent(a, b);
                result += cost;
            }
        }

        System.out.println(total - result);
    }
}
