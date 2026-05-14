package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 방금그곡 {
    static Map<String, Song> map;
    static List<Song> list;

    static class Song implements Comparable<Song>{
        int diff;   //시간 차이
        String name;
        String title;

        public Song(int diff, String name, String title){
            this.diff = diff;
            this.name = name;
            this.title = title;
        }

        public int compareTo(Song other){
            if(this.diff == other.diff){
                return 0;
            }
            //return other.name.compareTo(this.name);
            return other.diff - this.diff;
        }

    }

    public static String solution(String m, String[] musicinfos){
        map = new HashMap<>();
        list = new ArrayList<>();
        m = convert(m);

        for(String music : musicinfos){
            String[] mus = music.split(",");
            int start = toSec(mus[0]);
            int end = toSec(mus[1]);
            String title = mus[2];
            String name = convert(mus[3]);
            char[] namearr = name.toCharArray();
            String totalname = "";
            int diff = end - start;
            //시간동안 나온 악보 총 total 구하기
            for(int i=0;i<diff;i++){
                totalname += namearr[i % namearr.length];
            }

            if(totalname.contains(m)){
                /*if(!map.containsKey(title)){
                    map.put(title, new Song(diff, totalname, title));
                }*/
                list.add(new Song(diff, totalname, title));
            }

        }

        //if(map.isEmpty()) return "(None)";
        if(list.isEmpty()) return "(None)";

        //List<Song> songs = new ArrayList<>(map.values());
        //Collections.sort(songs);
        Collections.sort(list);

        return list.get(0).title;

    }

    static int toSec(String time){
        String[] times = time.split(":");
        int H = Integer.parseInt(times[0]) * 60;
        int M = Integer.parseInt(times[1]);

        return H + M;
    }

    static String convert(String s){
        return s.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a");
    }

    public static void main(String[] args) throws Exception{
        String m = "ABC";
        String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(solution(m, musicinfos));
    }

}
