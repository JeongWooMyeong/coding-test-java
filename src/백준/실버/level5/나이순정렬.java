package 백준.실버.level5;

import java.util.*;

public class 나이순정렬 {
    static class member implements Comparable<member>{
        private int index;
        private int age;
        private String name;

        public member(int index, int age, String name){
            this.index = index;
            this.age = age;
            this.name = name;
        }

        public int getIndex(){
            return this.index;
        }

        public int getAge(){
            return this.age;
        }

        public String getName(){
            return this.name;
        }

        public int compareTo(member other){
            if(other.age == this.age){
                return this.index - other.index;
            }else{
                return this.age - other.age;
            }
        }

    }

    static int n;
    static ArrayList<member> list = new ArrayList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i=0;i<n;i++){
            int index = i;
            int age = sc.nextInt();
            String name = sc.next();

            list.add(new member(index, age, name));

        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<list.size();i++){
            sb.append(list.get(i).getAge()).append(" ").append(list.get(i).getName()).append("\n");
        }

        System.out.println(sb.toString());

    }

}
