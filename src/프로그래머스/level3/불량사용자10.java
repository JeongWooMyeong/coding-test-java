package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 불량사용자10 {

    static boolean[] visited;
    static Set<Set<String>> sets;
    static int n;

    public static int solution(String[] user_id, String[] banned_id){
        n = user_id.length;
        visited = new boolean[n];
        sets = new HashSet<>();

        dfs(0, new HashSet<>(), user_id, banned_id);

        return sets.size();


    }

    static void dfs(int idx, Set<String> set, String[] user_id, String[] banned_id){
        if(idx == banned_id.length){
            sets.add(new HashSet<>(set));
            return;
        }

        for(int i=0;i<user_id.length;i++){
            if(!visited[i] && match(user_id[i], banned_id[idx])){
                visited[i] = true;
                set.add(user_id[i]);
                dfs(idx+1, set, user_id, banned_id);
                visited[i] = false;
                set.remove(user_id[i]);
            }
        }

    }

    static boolean match(String a, String b){
        if(a.length() != b.length()) return false;
        for(int i=0;i<a.length();i++){
            if(b.charAt(i) == '*') continue;
            if(a.charAt(i) != b.charAt(i)) return false;
        }

        return true;
    }

    public static void main(String[] args) throws Exception{
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "*rodo", "******", "******"};
        System.out.println(solution(user_id, banned_id));
    }

}
