package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 단어수학3 {
    static int N;
    static int[] alpa = new int[26];
    static ArrayList<letter> edges = new ArrayList<>();
    static List<String> words = new ArrayList<>();

    static class letter implements Comparable<letter>{
        private int x;
        private int cost;

        public letter(int x, int cost){
            this.x = x;
            this.cost = cost;
        }

        public int getX(){
            return this.x;
        }

        public int getCost(){
            return this.cost;
        }

        public int compareTo(letter other){
            return other.cost - this.cost;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            String line = br.readLine();
            words.add(line);
            for(int j=0;j<line.length();j++){
                int alpanum = line.charAt(j) - 'A';
                alpa[alpanum] += (int) Math.pow(10, line.length() - j - 1);
            }
        }

        for(int i=0;i<alpa.length;i++){
            edges.add(new letter(i, alpa[i]));
        }
        //내림차순
        Collections.sort(edges);

        int num = 9;
        for(int i=0;i<edges.size();i++){
            if(num < 0) break;
            if(edges.get(i).getCost() != 0){
                alpa[edges.get(i).getX()] = num;
                num--;
            }
        }

        int result = 0;
        for(int i=0;i<words.size();i++){
            String str = words.get(i);
            int sum = 0;
            String line = "";
            for(int j=0;j<str.length();j++){
                int a = str.charAt(j) - 'A';
                line += alpa[a] + "";
            }
            sum = Integer.parseInt(line);
            result += sum;
        }

        System.out.print(result);

    }
}
