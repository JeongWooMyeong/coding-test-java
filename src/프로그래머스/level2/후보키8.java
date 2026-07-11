package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 후보키8 {

    static List<Set<Integer>> candidatesKey;
    static int N;

    public static int solution(String[][] relation){
        N = relation[0].length; //튜플의 개수
        candidatesKey = new ArrayList<>();

        for(int size=1;size<=N;size++) {
            dfs(0, new HashSet<>(), relation, size);
        }
        return candidatesKey.size();

    }

    static void dfs(int start, Set<Integer> set, String[][] relation, int targetSize){
        if(set.size() == targetSize){
            if(!isUnique(set, relation)) return;
            for(Set<Integer> s : candidatesKey){
                if(set.containsAll(s)) return;
            }

            candidatesKey.add(new HashSet<>(set));
        }

        for(int i=start;i<N;i++){
            set.add(i);
            dfs(i+1, set, relation, targetSize);
            set.remove(i);
        }

    }

    static boolean isUnique(Set<Integer> set, String[][] relation){
        Set<String> seen = new HashSet<>();

        for(int i=0;i<relation.length;i++){
            StringBuilder sb = new StringBuilder();
            for(int x : set){
                sb.append(relation[i][x]).append("|");
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
