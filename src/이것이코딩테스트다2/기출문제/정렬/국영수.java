package 이것이코딩테스트다2.기출문제.정렬;

import java.io.*;
import java.util.*;

public class 국영수 {
    static int N;
    static ArrayList<Student> list = new ArrayList<>();

    static class Student implements Comparable<Student>{
        private String name;
        private int math;
        private int english;
        private int korean;

        public Student(String name, int korean, int english, int math){
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        public String getName(){
            return this.name;
        }

        public int getMath(){
            return this.math;
        }

        public int getEnglish(){
            return this.english;
        }

        public int getKorean(){
            return this.korean;
        }

        public int compareTo(Student other){
            if(this.korean == other.korean){
                if(this.english == other.english){
                    if(this.math == other.math){
                        return this.name.compareTo(other.name);
                    }
                    return other.math - this.math;
                }
                return this.english - other.english;
            }

            return other.korean - this.korean;
        }


    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            list.add(new Student(name, korean, english, math));

        }

        Collections.sort(list);

        for(Student x : list){
            System.out.println(x.name);
        }

    }

}
