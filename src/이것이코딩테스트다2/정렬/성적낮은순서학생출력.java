package 이것이코딩테스트다2.정렬;

import java.util.*;

class student implements Comparable<student>{
    private String name;
    private int score;

    student(String name, int score){
        this.name = name;
        this.score = score;
    }

    public String getName(){
        return this.name;
    }

    public int getScore(){
        return this.score;
    }

    @Override
    public int compareTo(student other){
        if(this.score < other.score){
            return -1;
        }
        return 1;
    }

}

public class 성적낮은순서학생출력 {
    static int n;
    static ArrayList<student> list = new ArrayList<>();
    static student stud;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i=0;i<n;i++){
            String name = sc.next();
            int score = sc.nextInt();

            stud = new student(name, score);
            list.add(stud);
        }

        Collections.sort(list);

        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i).getName() + " ");
        }

    }
}
