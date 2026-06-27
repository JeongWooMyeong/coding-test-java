package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 방금그곡4 {

    static List<Song> songList;
    static class Song implements Comparable<Song>{
        String name;
        int musiclength;
        String music;
        int idx;

        public Song(String name, int musiclength, String music, int idx){
            this.name = name;
            this.musiclength = musiclength;
            this.music = music;
            this.idx = idx;
        }

        public int compareTo(Song other){

            if(this.musiclength == other.musiclength){
                return this.idx - other.idx;
            }

            return other.musiclength - this.musiclength;
        }

    }

    public static String solution(String m, String[] musicinfos){
        songList = new ArrayList<>();
        m = convert(m);

        int idx = 0;
        for(String info : musicinfos){
            String[] arr = info.split(",");
            int start = toMin(arr[0]);
            int end = toMin(arr[1]);
            int musiclength = end - start;
            String name = arr[2];
            String akbo = convert(arr[3]);
            String music = "";
            for(int i=0;i<musiclength;i++){
                music += akbo.charAt(i%akbo.length());
            }

            if(music.contains(m)){
                songList.add(new Song(name,musiclength,music,idx));
            }

            idx++;
        }

        if(songList.isEmpty()) return "(None)";

        Collections.sort(songList);

        return songList.get(0).name;

    }

    static int toMin(String time){
        String[] arr = time.split(":");
        int H = Integer.parseInt(arr[0]) * 60;
        int M = Integer.parseInt(arr[1]);

        return H + M;
    }

    static String convert(String str){
        str = str.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#","g")
                .replace("A#", "a");

        return str;
    }

    public static void main(String[] args) throws Exception{
        String m ="CC#BCC#BCC#BCC#B";
        String[] musicinfos ={"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        System.out.println(solution(m, musicinfos));
    }

}
