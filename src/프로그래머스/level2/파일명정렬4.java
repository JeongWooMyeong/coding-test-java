package 프로그래머스.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
입력 순서 유지 return 0으로 해도 상관없지만
확실하게 하려면 index 하나 추가해서
들어온 순으로 나오게 하는게 좋음
 */

public class 파일명정렬4 {
    static ArrayList<File> fileList;

    static class File implements Comparable<File>{
        String name;
        String head;
        int number;
        String tail;
        int index;

        public File(String name, String head, int number, String tail, int index){
            this.name = name;
            this.head = head;
            this.number = number;
            this.tail = tail;
            this.index = index;
        }

        public int compareTo(File other){

            if(this.head.toUpperCase().equals(other.head.toUpperCase())){
                if(this.number == other.number) return this.index - other.index;
                return this.number - other.number;
            }
            return this.head.toUpperCase().compareTo(other.head.toUpperCase());
        }

    }

    public static String[] solution(String[] files){
        fileList = new ArrayList<>();

        int fileindex = 0;
        for(String file : files){
            int idx = 0;

            while(idx < file.length() && !Character.isDigit(file.charAt(idx))){
                idx++;
            }
            String head = file.substring(0, idx);
            int numstart = idx;
            while(idx < file.length() && Character.isDigit(file.charAt(idx))) {
                idx++;
            }
            int number = Integer.parseInt(file.substring(numstart, idx));
            String tail = file.substring(idx);

            fileList.add(new File(file, head, number, tail, fileindex));
            fileindex++;

        }

        Collections.sort(fileList);
        String[] answer = new String[fileList.size()];

        int idx = 0;
        for(File f : fileList){
            answer[idx] = f.name;
            idx++;
        }

        return answer;

    }

    public static void main(String[] args) throws Exception{
        String[] str = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};

        System.out.println(Arrays.toString(solution(str)));
    }

}
