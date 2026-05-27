package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 불량사용자8 {

    static Set<Set<String>> sets;
    static boolean[] visited;

    public static int solution(String[] user_id, String[] banned_id){
        sets = new HashSet<>();
        visited = new boolean[user_id.length];

        dfs(0, user_id, banned_id, new HashSet<>());

        return sets.size();
    }

    static void dfs(int idx, String[] userid, String[] banid, Set<String> set){
        if(idx == banid.length){
            sets.add(new HashSet<>(set));
            return;
        }

        for(int i=0;i<userid.length;i++){
            if(!visited[i] && match(userid[i], banid[idx])){
                visited[i] = true;
                set.add(userid[i]);
                dfs(idx+1, userid, banid, set);
                visited[i] = false;
                set.remove(userid[i]);
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
