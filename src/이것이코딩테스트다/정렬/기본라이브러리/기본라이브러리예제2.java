package 이것이코딩테스트다.정렬.기본라이브러리;

import java.util.*;

class Student{
    String name;
    int score;

    Student(String name, int score){
        this.name = name;
        this.score = score;
    }
}

public class 기본라이브러리예제2 {
    public static void main(String[] args){
        List<Student> students = new ArrayList<>();
        students.add(new Student("홍길동", 90));
        students.add(new Student("이순신", 77));
        students.add(new Student("강감찬", 85));

        //점수를 기준으로 오름 차순 정렬
        students.sort((a,b) -> Integer.compare(a.score, b.score));

        //결과 출력
        for(Student s : students){
            System.out.println(s.name + " " + s.score);
        }
    }
}
