package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 방금그곡2 {

    static ArrayList<Song> songList;

    static class Song implements Comparable<Song>{
        String name;
        String music;
        int musiclength;
        int idx;

        public Song(String name, String music, int musiclength, int idx){
            this.name = name;
            this.music = music;
            this.musiclength = musiclength;
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

        int songidx = 0;
        for(String musics : musicinfos){
           String[] marr = musics.split(",");
           int start = toMin(marr[0]);
           int end = toMin(marr[1]);
           String name = marr[2];
           String akbos = convert(marr[3]);
           char[] akbo = akbos.toCharArray();
           int akbolen = akbo.length;
           int musiclength = end - start;
           String music = "";
           for(int i=0;i<musiclength;i++){
                music += akbo[i % akbolen];
           }

           if(music.contains(m)){
               songList.add(new Song(name, music, musiclength, songidx));
           }

           songidx++;

        }

        if(songList.isEmpty()) return "(None)";

        Collections.sort(songList);

        return songList.get(0).name;

    }

    static String convert(String m){
        m = m.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#","g")
                .replace("A#", "a");
        return m;
    }

    static int toMin(String time){
        String[] t = time.split(":");
        int H = Integer.parseInt(t[0]) * 60;
        int M = Integer.parseInt(t[1]);

        return H+M;
    }

    public static void main(String[] args) throws Exception{
        String m ="CC#BCC#BCC#BCC#B";
        String[] musicinfos ={"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        System.out.println(solution(m, musicinfos));
    }

}
