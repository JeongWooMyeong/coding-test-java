package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 후보키5 {

    static List<Set<Integer>> candidatesKey;
    static boolean[] visited;
    static int n;

    public static int solution(String[][] relation){
        n = relation[0].length;
        candidatesKey = new ArrayList<>();
        visited = new boolean[n];

        for(int size=1;size<=n;size++){
            dfs(0, new HashSet<>(), relation, size);
        }

        return candidatesKey.size();
    }

    static void dfs(int idx, Set<Integer> set, String[][] relation, int targetSize){
        if(idx == targetSize){
            //유일성 검사
            if(!isUnique(set, relation)) return;
            //최소성 검사
            for(Set<Integer> s : candidatesKey){
                if(set.containsAll(s)) return;
            }

            candidatesKey.add(new HashSet<>(set));

        }

        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i] = true;
                set.add(i);
                dfs(idx+1, set, relation, targetSize);
                visited[i] = false;
                set.remove(i);
            }
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
