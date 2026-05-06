package 프로그래머스.level2;

import java.util.*;
import java.io.*;

/*
근데 이방식은 파일명 형식으로 주어졌을때만 제대로 동작
다른 경우에서는 동작 안하므로 다른 방식으로 변경해야함
 */

public class 파일명정렬 {
    static ArrayList<File> filesList;

    static class File implements Comparable<File>{
        String name;
        String head;
        int number;
        String tail;

        public File(String name, String head, int number, String tail){
            this.name = name;
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

        public int compareTo(File other){
            if(this.head.toUpperCase().equals(other.head.toUpperCase())){
                if(this.number == other.number){
                    return 0;
                }
                return this.number - other.number;
            }


            return this.head.toUpperCase().compareTo(other.head.toUpperCase());
        }

    }

    public static String[] solution(String[] files){
        filesList = new ArrayList<>();

        for(String file : files){
            String[] f = file.split("\\.");
            String head = "";
            String num = "";

            for(int i=0;i<f[0].length();i++){
                if(!Character.isLetter(f[0].charAt(i))){
                    num += f[0].charAt(i);
                }else{
                    head += f[0].charAt(i);
                }
            }

            String tail = f[1];

            filesList.add(new File(file, head, Integer.parseInt(num), tail));

        }

        Collections.sort(filesList);
        String[] answer = new String[filesList.size()];

        for(int i=0;i<filesList.size();i++){
            answer[i] = filesList.get(i).name;
        }


        return answer;
    }

    public static void main(String[] args) throws Exception{
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};

        System.out.println(Arrays.toString(solution(files)));
    }

}
