package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 후보키2 {
    static List<Set<Integer>> candidateKey;

    public static int solution(String[][] relation){
        candidateKey = new ArrayList<>();
        //후보키 사이즈별로 dfs 돌리기
        for(int size=1;size<=relation[0].length;size++){
            dfs(relation, new ArrayList<>(), size, 0);
        }

        return candidateKey.size();
    }

    static void dfs(String[][] relation, List<Integer> current, int targetSize, int start){
        if(current.size() == targetSize){
            //유일성 체크 -> 모든 튜플에 대해 유일하게 식별되어야 한다.
            if(!isUnique(relation, current)) return;

            for(Set<Integer> set : candidateKey){
                if(current.containsAll(set)) return;
            }

            candidateKey.add(new HashSet<>(current));
        }


        for(int i=start;i<relation[0].length;i++){
            current.add(i);
            dfs(relation, current, targetSize, i+1);
            current.remove(current.size()-1);
        }

    }

    static boolean isUnique(String[][] relation, List<Integer> list){
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
