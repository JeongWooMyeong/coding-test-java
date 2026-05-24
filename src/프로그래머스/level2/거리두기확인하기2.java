package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 거리두기확인하기2 {
    static ArrayList<int[]> peopleList;
    static int n,m;
    static char[][] map;

    public static int[] solution(String[][] places){

        int[] answer = new int[places.length];
        int idx = 0;
        for(String[] p : places) {

            peopleList = new ArrayList<>();
            n = p.length;
            m = p[0].length();

            map = new char[n][m];

            for(int i=0;i<n;i++){
                String line = p[i];
                for(int j=0;j<m;j++){
                    map[i][j] = line.charAt(j);
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 'P') {
                        peopleList.add(new int[]{i, j});
                    }
                }
            }

            boolean found = false;
            for (int i = 0; i < peopleList.size(); i++) {
                for (int j = i+1; j < peopleList.size(); j++) {
                    if (i == j) continue;
                    int x1 = peopleList.get(i)[0];
                    int y1 = peopleList.get(i)[1];
                    int x2 = peopleList.get(j)[0];
                    int y2 = peopleList.get(j)[1];
                    int length = Math.abs(x2 - x1) + Math.abs(y2 - y1);

                    if (length == 2) {
                        int minY = (y1+y2) / 2;
                        int minX = (x1+x2) / 2;

                        if (x1 == x2) {
                            if (map[x1][minY] != 'X') {
                                answer[idx++] = 0;
                                found = true;
                                break;
                            }
                        } else if (y1 == y2) {
                            if (map[minX][y1] != 'X') {
                                answer[idx++] = 0;
                                found = true;
                                break;
                            }
                        } else {
                            if (map[x1][y2] != 'X' || map[x2][y1] != 'X') {
                                answer[idx++] = 0;
                                found = true;
                                break;
                            }
                        }
                    } else if(length == 1) {
                        answer[idx++] = 0;
                        found = true;
                        break;
                    }

                }
                if(found) break;
            }

            if(!found) answer[idx++] = 1;


        }
        return answer;
    }

    public static void main(String[] arsgs) throws Exception{
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        System.out.println(Arrays.toString(solution(places)));
    }

}
