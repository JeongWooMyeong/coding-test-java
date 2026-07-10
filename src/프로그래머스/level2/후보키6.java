package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 후보키6 {

    static List<Set<Integer>> candidatesKey;
    static boolean[] visited;
    static int n;

    public static int solution(String[][] relation){
        candidatesKey = new ArrayList<>();
        visited = new boolean[relation[0].length];
        n = relation[0].length;

        for(int size=1;size<=n;size++) {
            dfs(0, new HashSet<>(), relation, size);
        }

        return candidatesKey.size();

    }

    static void dfs(int idx, Set<Integer> set, String[][] relation, int targetSize){
        if(set.size() == targetSize){
            if(!isUnique(set, relation)) return;
            for(Set<Integer> s : candidatesKey){
                if(set.containsAll(s)) return;
            }
            candidatesKey.add(new HashSet<>(set));

            return;
        }
        //순열 조합
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
            String path = "";
            for(int x : set){
                path += relation[i][x] + "|";
            }

            if(!seen.add(path)) return false;
        }

        return true;
    }

    public static void main(String[] args) throws Exception{
        String relation[][] = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
        System.out.println(solution(relation));
    }

}
