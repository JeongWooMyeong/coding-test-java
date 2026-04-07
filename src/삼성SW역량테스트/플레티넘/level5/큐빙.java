package 삼성SW역량테스트.플레티넘.level5;

import java.util.*;
import java.io.*;

public class 큐빙 {
    static char[][][] cube;
    static int T, n;
    static char[] colors = {'w', 'y', 'r', 'o', 'g', 'b'};

    //U 윗면, D 아랫면 F 앞면, B 뒷면 L 왼쪽면, R 오른쪽면
    //0, 1, 2, 3, 4, 5;
    // + 시계 - 반시계
    static void initCube(){
        cube = new char[6][3][3];

        for(int k=0;k<6;k++){
            char[][] cu = cube[k];
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    cu[i][j] = colors[k];
                }
            }
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        //테스트 케이스마다 주어지므로 초기 큐브로 지정해두고 해야한다.
        while(T-- > 0){
            initCube();
            //큐브 돌린횟수
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++) {
                String cmd = st.nextToken();
                rotate(cmd);
            }

            //윗면 출력
            sb.append(printUp());
            

        }

        System.out.print(sb);

    }

    static void rotate(String cmd){
        char face = cmd.charAt(0);  //U,D,F,B,L,R;
        char dir = cmd.charAt(1);   //+, -

        switch(face){
            case 'U' : rotateU(dir); break;
            case 'D' : rotateD(dir); break;
            case 'F' : rotateF(dir); break;
            case 'B' : rotateB(dir); break;
            case 'L' : rotateL(dir); break;
            case 'R' : rotateR(dir); break;
        }


    }
    //자기자신 회전
    static char[][] rotateFace(char[][] face, char dir){
        char[][] newFace = new char[3][3];
        if(dir == '+'){
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    newFace[j][3-1-i] = face[i][j];
                }
            }
        }else{
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    newFace[3-1-j][i] = face[i][j];
                }
            }
        }
        return newFace;
    }

    //윗면 회전
    static void rotateU(char dir){
        //U면 자체 회전
        cube[0] = rotateFace(cube[0], dir);
        //방향이 +이면 시계 방향
        if(dir == '+'){
            char[] temp = cube[2][0].clone();//윗줄
            cube[2][0] = cube[5][0].clone();    //앞 -> 왼
            cube[5][0] = cube[3][0].clone();    //왼 -> 뒤
            cube[3][0] = cube[4][0].clone();
            cube[4][0] = temp;
        }else{
            char[] temp = cube[2][0].clone();
            cube[2][0] = cube[4][0].clone();
            cube[4][0] = cube[3][0].clone();
            cube[3][0] = cube[5][0].clone();
            cube[5][0] = temp;
        }
    }

    static void rotateD(char dir){
        cube[1] = rotateFace(cube[1], dir);
        if(dir == '+'){

            char[] temp = cube[2][2].clone();
            cube[2][2] = cube[4][2].clone();
            cube[4][2] = cube[3][2].clone();
            cube[3][2] = cube[5][2].clone();
            cube[5][2] = temp;

        }else{
            char[] temp = cube[2][2].clone();
            cube[2][2] = cube[5][2].clone();
            cube[5][2] = cube[3][2].clone();
            cube[3][2] = cube[4][2].clone();
            cube[4][2] = temp;

        }
    }

    static void rotateF(char dir){
        cube[2] = rotateFace(cube[2], dir);
        if(dir == '+'){
            char[] temp = cube[0][2].clone();
            for(int i=0;i<3;i++) cube[0][2][i] = cube[4][2-i][2];
            for(int i=0;i<3;i++) cube[4][i][2] = cube[1][0][i];
            for(int i=0;i<3;i++) cube[1][0][i] = cube[5][2-i][0];
            for(int i=0;i<3;i++) cube[5][i][0] = temp[i];
        }else{
            char[] temp = cube[0][2].clone();
            for(int i=0;i<3;i++) cube[0][2][i] = cube[5][i][0];
            for(int i=0;i<3;i++) cube[5][i][0] = cube[1][0][2-i];
            for(int i=0;i<3;i++) cube[1][0][i] = cube[4][i][2];
            for(int i=0;i<3;i++) cube[4][i][2] = temp[2-i];

        }
    }

    // 뒷면 회전
    static void rotateB(char dir){
        cube[3] = rotateFace(cube[3], dir);
        if(dir == '+'){
            char[] temp = cube[0][0].clone();
            for(int i=0;i<3;i++) cube[0][0][i] = cube[5][i][2];
            for(int i=0;i<3;i++) cube[5][i][2] = cube[1][2][2-i];
            for(int i=0;i<3;i++) cube[1][2][i] = cube[4][i][0];
            for(int i=0;i<3;i++) cube[4][i][0] = temp[2-i];
        }else{
            char[] temp = cube[0][0].clone();
            for(int i=0;i<3;i++) cube[0][0][i] = cube[4][2-i][0];
            for(int i=0;i<3;i++) cube[4][i][0] = cube[1][2][i];
            for(int i=0;i<3;i++) cube[1][2][i] = cube[5][2-i][2];
            for(int i=0;i<3;i++) cube[5][i][2] = temp[i];
        }
    }

    // 왼쪽면 회전
    static void rotateL(char dir){
        cube[4] = rotateFace(cube[4], dir);
        if(dir == '+'){
            char[] temp = new char[3];
            for(int i=0;i<3;i++) temp[i] = cube[0][i][0];
            for(int i=0;i<3;i++) cube[0][i][0] = cube[3][2-i][2];
            for(int i=0;i<3;i++) cube[3][i][2] = cube[1][2-i][0];
            for(int i=0;i<3;i++) cube[1][i][0] = cube[2][i][0];
            for(int i=0;i<3;i++) cube[2][i][0] = temp[i];
        }else{
            char[] temp = new char[3];
            for(int i=0;i<3;i++) temp[i] = cube[0][i][0];
            for(int i=0;i<3;i++) cube[0][i][0] = cube[2][i][0];
            for(int i=0;i<3;i++) cube[2][i][0] = cube[1][i][0];
            for(int i=0;i<3;i++) cube[1][i][0] = cube[3][2-i][2];
            for(int i=0;i<3;i++) cube[3][i][2] = temp[2-i];
        }
    }

    // 오른쪽면 회전
    static void rotateR(char dir){
        cube[5] = rotateFace(cube[5], dir);
        if(dir == '+'){
            char[] temp = new char[3];
            for(int i=0;i<3;i++) temp[i] = cube[0][i][2];
            for(int i=0;i<3;i++) cube[0][i][2] = cube[2][i][2];
            for(int i=0;i<3;i++) cube[2][i][2] = cube[1][i][2];
            for(int i=0;i<3;i++) cube[1][i][2] = cube[3][2-i][0];
            for(int i=0;i<3;i++) cube[3][i][0] = temp[2-i];
        }else{
            char[] temp = new char[3];
            for(int i=0;i<3;i++) temp[i] = cube[0][i][2];
            for(int i=0;i<3;i++) cube[0][i][2] = cube[3][2-i][0];
            for(int i=0;i<3;i++) cube[3][i][0] = cube[1][2-i][2];
            for(int i=0;i<3;i++) cube[1][i][2] = cube[2][i][2];
            for(int i=0;i<3;i++) cube[2][i][2] = temp[i];
        }
    }

    static String printUp() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(cube[0][i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }



}
