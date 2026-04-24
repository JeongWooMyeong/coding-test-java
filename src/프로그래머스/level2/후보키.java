package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 후보키 {
    static List<Set<Integer>> candidate = new ArrayList<>();

    public static int solution(String[][] relation){
        for(int size=1;size<=relation[0].length;size++){
            dfs(relation, new ArrayList<>(), size, 0);
        }

        return candidate.size();
    }

    static void dfs(String[][] relation, List<Integer> list , int targetSize, int start){
        if(list.size() == targetSize){
            //유일성 검사
            if(!isUnique(relation, list)) return;

            //최소성 검사
            for(Set<Integer> key : candidate){
                if(list.containsAll(key)) return;
            }

            candidate.add(new HashSet<>(list));
            return;
        }

        for(int i=start;i<relation[0].length;i++){
            list.add(i);
            dfs(relation, list, targetSize, i+1);
            list.remove(list.size()-1);
        }

    }

    static boolean isUnique(String[][] relation, List<Integer> list){
        Set<String> seen = new HashSet<>();
        for(String[] tuple : relation){
            StringBuilder sb = new StringBuilder();

            for(int i : list){
                sb.append(tuple[i]).append("|");
            }

            if(!seen.add(sb.toString())) return false;

        }
        return true;
    }


    public static void main(String[] args) throws Exception{
        String relation[][] = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
        System.out.println(solution(relation));
    }

}
