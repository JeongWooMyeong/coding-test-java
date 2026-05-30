package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 후보키3 {

    static List<Set<Integer>> candidatesKey;

    public static int solution(String[][] relation){
        candidatesKey = new ArrayList<>();
        //크기별로 튜플 1 , 2 , 3 ~~ 선택하는 경우
        for(int size=1;size<=relation[0].length;size++){
            dfs(new ArrayList<>(), relation, size, 0);
        }

        return candidatesKey.size();
    }

    static void dfs(List<Integer> current, String[][] relation, int targetSize, int idx){
        if(idx == targetSize){
            if(!isUnique(current, relation)) return;

            for(Set<Integer> set : candidatesKey){
                if(current.containsAll(set)) return;
            }

            candidatesKey.add(new HashSet<>(current));
        }

        for(int i=idx;i<relation[0].length;i++){
            current.add(i);
            dfs(current, relation, targetSize, idx+1);
            current.remove(current.size()-1);
        }
    }

    static boolean isUnique(List<Integer> list, String[][] relation){
        Set<String> seen = new HashSet<>();

        for(String[] tuple : relation){
            StringBuilder sb = new StringBuilder();
            for(int x : list){
                sb.append(tuple[x]).append("|");
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
