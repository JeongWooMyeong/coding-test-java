package 백준.실버.level5;

import java.util.*;

public class 좌표정렬하기 {
    static class position implements Comparable<position>{
        private int x;
        private int y;

        public position(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX(){
            return this.x;
        }

        public int getY(){
            return this.y;
        }

        public int compareTo(position other){
            if(other.x == this.x){
                return this.y - other.y;
            }else {
                return this.x - other.x;
            }

        }



    }

    static int n;
    static ArrayList<position> list = new ArrayList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i=0;i<n;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            list.add(new position(x, y));
        }

        Collections.sort(list);

        for(int i=0;i<n;i++){
            System.out.println(list.get(i).getX() + " " + list.get(i).getY());
        }

    }
}
