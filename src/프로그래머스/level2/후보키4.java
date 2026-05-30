package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 후보키4 {

    static List<Set<Integer>> candidateKey;

    public static int solution(String[][] relation){
        candidateKey = new ArrayList<>();

        for(int size=1;size<=relation[0].length;size++){
            dfs(0, size, relation, new ArrayList<>());
        }

        return candidateKey.size();

    }

    static void dfs(int idx, int targetSize, String[][] relation, List<Integer> list){
        if(list.size() == targetSize){
            //유일성 검사
            if(!isUnique(list, relation)) return;
            //최소성 검사
            for(Set<Integer> set : candidateKey){
                if(list.containsAll(set)) return;
            }

            candidateKey.add(new HashSet<>(list));
            return;
        }

        for(int i=idx;i<relation[0].length;i++){
            list.add(i);
            dfs(i+1, targetSize, relation, list);
            list.remove(list.size()-1);
        }

    }

    static boolean isUnique(List<Integer> list, String[][] relation){
        Set<String> set = new HashSet<>();

        for(String[] tuple : relation){
            StringBuilder sb = new StringBuilder();
            for(int x : list){
                sb.append(tuple[x]).append("|");
            }
            if(!set.add(sb.toString())) return false;
        }

        return true;
    }

    public static void main(String[] args) throws Exception{
        String relation[][] = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
        System.out.println(solution(relation));
    }

}
