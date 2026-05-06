package 프로그래머스.level2;

import java.util.*;
import java.io.*;

/*
근데 이방식은 파일명 형식으로 주어졌을때만 제대로 동작
다른 경우에서는 동작 안하므로 다른 방식으로 변경해야함
 */

public class 파일명정렬2 {
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

            int idx = 0;
            while(idx < file.length() && !Character.isDigit(file.charAt(idx))){
                idx++;
            }
            String head = file.substring(0, idx);

            int numstart = idx;
            //다음 문자가 나올때까지 그리고 숫자는 최대 5자리 가능 (미만은 4까지하면 다음 5일때 멈추므로)
            while(idx < file.length() && Character.isDigit(file.charAt(idx)) && idx - numstart < 5){
                idx++;
            }
            String num = file.substring(numstart, idx);

            String tail = file.substring(idx, file.length());



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
