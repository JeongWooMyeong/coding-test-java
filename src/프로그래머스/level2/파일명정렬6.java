package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 파일명정렬6 {

    static ArrayList<Files> fileList;
    static class Files implements Comparable<Files>{
        String name;
        String head;
        int number;
        String tail;
        int idx;

        public Files(String name, String head, int number, String tail, int idx){
            this.name = name;
            this.head = head;
            this.number = number;
            this.tail = tail;
            this.idx = idx;
        }

        public int compareTo(Files other){
            if(this.head.equals(other.head)){
                if(this.number == other.number){
                    return this.idx - other.idx;
                }
                return this.number - other.number;
            }

            return this.head.compareTo(other.head);
        }

    }

    public static String[] solution(String[] files){

        fileList = new ArrayList<>();

        int startIdx = 0;
        for(String file : files){
            String name = file;
            int idx = 0;
            while(idx < file.length() && !Character.isDigit(file.charAt(idx))){
                idx++;
            }
            String head = file.substring(0, idx).toLowerCase();
            int numstart = idx;
            while(idx < file.length() && Character.isDigit(file.charAt(idx))){
                idx++;
            }
            int number = Integer.parseInt(file.substring(numstart, idx));

            String tail = file.substring(idx);

            fileList.add(new Files(name, head, number, tail, startIdx));
            startIdx++;

        }

        Collections.sort(fileList);
        String[] answer = new String[fileList.size()];
        for(int i=0;i<fileList.size();i++){
            answer[i] = fileList.get(i).name;
        }

        return answer;

    }

    public static void main(String[] args) throws Exception{
        String[] str = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};

        System.out.println(Arrays.toString(solution(str)));
    }

}
