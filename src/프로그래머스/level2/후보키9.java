package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 후보키9 {

    static List<Set<Integer>> candidatesKey;
    static int n;

    public static int solution(String[][] relation){
        n = relation[0].length;
        candidatesKey = new ArrayList<>();

        for(int size=1;size<=n;size++){
            dfs(0, new HashSet<>(), relation, size);
        }

        return candidatesKey.size();
    }

    static void dfs(int start , Set<Integer> set, String[][] relation, int target){
        if(set.size() == target){
            if(!isUnique(set, relation)) return;
            for(Set<Integer> s : candidatesKey){
                if(set.containsAll(s)) return;
            }

            candidatesKey.add(new HashSet<>(set));
            return;

        }

        for(int i=start;i<relation[0].length;i++){
            set.add(i);
            dfs(i+1, set, relation, target);
            set.remove(i);
        }


    }

    static boolean isUnique(Set<Integer> set, String[][] relation){
        Set<String> seen = new HashSet<>();

        for(int i=0;i<relation.length;i++){
            StringBuilder path = new StringBuilder();
            for(int x : set){
                path.append(relation[i][x]).append("|");
            }
            if(!seen.add(path.toString())) return false;
        }

        return true;
    }

    public static void main(String[] args) throws Exception{
        String relation[][] = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
        System.out.println(solution(relation));
    }


}
