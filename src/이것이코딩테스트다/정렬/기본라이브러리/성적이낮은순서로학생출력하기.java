package 이것이코딩테스트다.정렬.기본라이브러리;

import java.util.*;

class Students{
    String name;
    int score;

    Students(String name, int score){
        this.name = name;
        this.score = score;
    }
}

public class 성적이낮은순서로학생출력하기 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<Students> students = new ArrayList<>();

        //학생 정보 입력
        for(int i=0;i<N;i++){
            String name = sc.next();
            int score = sc.nextInt();
            students.add(new Students(name, score));
        }

        //성적 기준 오름차순 정렬
        students.sort(Comparator.comparingInt(s->s.score));

        //결고출력
        for(Students s : students){
            System.out.print(s.name + " ");
        }

    }
}
