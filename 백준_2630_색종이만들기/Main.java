package 백준_2630_색종이만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int white;
    static int blue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
            }
        }

        white = 0;
        blue = 0;

        makeSquare(N, 0, 0, map);

        sb.append(white).append("\n").append(blue).append("\n");

        System.out.println(sb);
    }

    private static void makeSquare(int N, int x, int y, int[][] map) {
        if(N == 1){
            if(map[x][y] == 0){
                white++;
            }else{
                blue++;
            }
            return;
        }
        int first = map[x][y];
        int next = N / 2;

        for(int i = x; i < x + N; i++){
            for(int j = y; j < y + N; j++){
                if(map[i][j] != first){
                    makeSquare(next, x, y, map);
                    makeSquare(next, x + next, y, map);
                    makeSquare(next, x, y + next, map);
                    makeSquare(next, x + next, y + next, map);
                    return;
                }
            }
        }

        if(map[x][y] == 0){
            white++;
        }else{
            blue++;
        }
    }

}
