package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 불량사용자2 {
    static Set<Set<String>> result;

    public static int solution(String[] user_id, String[] banned_id){
        result = new HashSet<>();

        dfs(0, user_id, banned_id, new HashSet<>());

        return result.size();
    }

    static void dfs(int idx, String[] user_id, String[] banned_id, Set<String> selected){
        if(idx == banned_id.length){
            result.add(new HashSet<>(selected));
            return;
        }

        for(String userid : user_id){
            if(!selected.contains(userid) && match(userid, banned_id[idx])){
                selected.add(userid);
                dfs(idx+1, user_id, banned_id, selected);
                selected.remove(userid);
            }
        }
    }

    static boolean match(String userid, String banid){
        if(userid.length() != banid.length()) return false;
        for(int i=0;i<userid.length();i++){
            if(banid.charAt(i) == '*') continue;
            if(userid.charAt(i) != banid.charAt(i)) return false;
        }

        return true;
    }


    public static void main(String[] args) throws Exception{
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"*rodo", "*rodo", "******"};

        System.out.println(solution(user_id, banned_id));
    }

}
