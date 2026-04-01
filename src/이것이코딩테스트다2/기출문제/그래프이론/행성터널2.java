package 이것이코딩테스트다2.기출문제.그래프이론;

import java.util.*;
import java.io.*;

public class 행성터널2 {
    static int N;
    static ArrayList<Point> pointList = new ArrayList<>();
    static ArrayList<Edge> edges = new ArrayList<>();
    static int[] parent;

    static class Point{
        int x,y,z, index;
        public Point(int index, int x, int y, int z){
            this.index = index;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static class Edge implements Comparable<Edge>{
        private int a;
        private int b;
        private int cost;

        public Edge(int a, int b, int cost){
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        public int getA(){
            return this.a;
        }

        public int getB(){
            return this.b;
        }

        public int getCost(){
            return this.cost;
        }

        public int compareTo(Edge other){
            return this.cost - other.cost;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        parent = new int[N];

        for(int i=0;i<N;i++){
            parent[i] = i;
        }
        // 좌표 Point 구조체에 list로 담는다.
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            pointList.add(new Point(i, x, y, z));

        }
        //pointList를 x,y,z 좌표에 대해서 정렬한 후 인접한 좌표들만 구한다
        pointList.sort(Comparator.comparingInt(p -> p.x));
        for(int i=0;i<N-1;i++){
            Point p1 = pointList.get(i);
            Point p2 = pointList.get(i+1);
            int cost = Math.min(Math.abs(p1.x-p2.x), Math.min(Math.abs(p1.y-p2.y), Math.abs(p1.z-p2.z)));
            edges.add(new Edge(p1.index,p2.index, cost));
        }

        //y좌표 정렬
        pointList.sort(Comparator.comparingInt(p -> p.y));
        for(int i=0;i<N-1;i++){
            Point p1 = pointList.get(i);
            Point p2 = pointList.get(i+1);
            int cost = Math.min(Math.abs(p1.x-p2.x), Math.min(Math.abs(p1.y-p2.y), Math.abs(p1.z-p2.z)));
            edges.add(new Edge(p1.index,p2.index, cost));
        }

        //z좌표 정렬
        pointList.sort(Comparator.comparingInt(p->p.z));
        for(int i=0;i<N-1;i++){
            Point p1 = pointList.get(i);
            Point p2 = pointList.get(i+1);
            int cost = Math.min(Math.abs(p1.x-p2.x), Math.min(Math.abs(p1.y-p2.y), Math.abs(p1.z-p2.z)));
            edges.add(new Edge(p1.index,p2.index, cost));
        }

//        //좌표 list에 for문 돌려서 비용 구한다
//        for(int i=0;i<pointList.size();i++){
//            Point p1 = pointList.get(i);
//            for(int j=i+1;j<pointList.size();j++){
//                Point p2 = pointList.get(j);
//                int cost = Math.min(Math.abs(p1.x-p2.x), Math.min(Math.abs(p1.y-p2.y), Math.abs(p1.z-p2.z)));
//                edges.add(new Edge(i,j,cost));
//            }
//        }
        Collections.sort(edges);

        int result = 0;
        //구한 간선에 대한 크루스칼 알고리즘 적용한다.
        for(int i=0;i<edges.size();i++){
            int a = edges.get(i).getA();
            int b = edges.get(i).getB();
            int cost = edges.get(i).getCost();

            if(findParent(a) != findParent(b)){
                result += cost;
                union(a,b);
            }

        }

        System.out.print(result);
    }

    static int findParent(int x){
        if(parent[x] == x) return x;
        else return parent[x] = findParent(parent[x]);
    }

    static void union(int x, int y){
        int a = findParent(x);
        int b = findParent(y);

        if(b>a) parent[b] = a;
        else parent[a] = b;

    }

}
