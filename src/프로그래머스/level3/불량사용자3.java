package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 불량사용자3 {
    static Set<Set<String>> list;

    public static int solution(String[] user_id, String[] banned_id){
        int answer = 0;
        list = new HashSet<>();

        dfs(0, user_id, banned_id, new HashSet<>());
        return list.size();
    }

    static void dfs(int idx, String[] user_id, String[] banned_id, Set<String> selected){
        if(idx == banned_id.length){
            //selected는 add, remove 되기 때문에 꼬일 수 있어서 새로운 set에 넣어줘야함
            list.add(new HashSet<>(selected));
            return;
        }

        for(String userid : user_id){
            if(!selected.contains(userid) && match(userid, banned_id[idx])){
                selected.add(userid);
                dfs(idx + 1, user_id, banned_id, selected);
                selected.remove(userid);
            }
        }

    }

    static boolean match(String userid, String banid){
        if(userid.length() != banid.length()) return false;
        for(int i=0;i<userid.length();i++){
            if(banid.charAt(i) == '*') continue;
            if(banid.charAt(i) != userid.charAt(i)) return false;
        }

        return true;
    }


    public static void main(String[] args) throws Exception{
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "abc1**"};

        System.out.println(solution(user_id, banned_id));
    }
}
