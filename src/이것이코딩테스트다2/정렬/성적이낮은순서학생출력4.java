package 이것이코딩테스트다2.정렬;

import java.util.*;

public class 성적이낮은순서학생출력4 {
    static class student implements Comparable<student>{
        private String name;
        private int score;

        public student(String name, int score){
            this.name = name;
            this.score = score;
        }

        public String getName(){
            return this.name;
        }

        public int getScore(){
            return this.score;
        }

        public int compareTo(student other){
            if(this.score < other.score){
                return -1;
            }
            return 1;
        }

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<student> list = new ArrayList<>();
        for(int i=0;i<n;i++) {
            String name = sc.next();
            int score = sc.nextInt();
            list.add(new student(name, score));
        }

        Collections.sort(list);

        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i).getName() + " ");

        }
    }
}
