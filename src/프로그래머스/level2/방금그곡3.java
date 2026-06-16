package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 방금그곡3 {
    static ArrayList<Song> songList;
    static class Song implements Comparable<Song>{
        String name, music;
        int musiclength, idx;

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
        int idx =0;
        songList = new ArrayList<>();
        m = convert(m);

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
                songList.add(new Song(name, music, musiclength, idx));
            }

            idx++;
        }


        if(songList.isEmpty()) return "(None)";


        Collections.sort(songList);

        return songList.get(0).name;
    }

    static int toMin(String time){
        String[] t = time.split(":");
        int H = Integer.parseInt(t[0]) * 60;
        int M = Integer.parseInt(t[1]);

        return H + M;
    }

    static String convert(String info){
        String result = info.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#","g")
                .replace("A#","a");
        return result;

    }

    public static void main(String[] args) throws Exception{
        String m ="CC#BCC#BCC#BCC#B";
        String[] musicinfos ={"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        System.out.println(solution(m, musicinfos));
    }

}
