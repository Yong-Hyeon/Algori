package 백준_1799_비숍;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Point{
        int r;
        int c;

        Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static int max;
    static int[][] delta = {{-1,-1},{1,1},{-1,1},{1,-1}};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
            }
        }

        max = 0;

        blackSearch(map, N, 0, 0, 0);
        int result = max;

        max = 0;
        whiteSearch(map, N, 0, 1, 0);

        result += max;

        sb.append(result).append("\n");
        System.out.println(sb);
    }

    private static void blackSearch(int[][] map, int N, int r, int c, int cnt) {
        max = Math.max(max, cnt);
        if(c >= N){
            r++;
            c = r % 2 == 0 ? 0 : 1;
        }
        if(r >= N){
            return;
        }

        if(check(map, N, r, c)){
            map[r][c] = 2;
            blackSearch(map, N, r, c + 2, cnt + 1);
            map[r][c] = 1;
        }
        blackSearch(map, N, r, c + 2, cnt);
    }

    private static void whiteSearch(int[][] map, int N, int r, int c, int cnt) {
        max = Math.max(max, cnt);
        if(c >= N){
            r++;
            c = r % 2 == 0 ? 1 : 0;
        }
        if(r >= N){
            return;
        }

        if(check(map, N, r, c)){
            map[r][c] = 2;
            whiteSearch(map, N, r, c + 2, cnt + 1);
            map[r][c] = 1;
        }
        whiteSearch(map, N, r, c + 2, cnt);
    }

    private static boolean check(int[][] map, int N, int r, int c) {
        if(map[r][c] != 1){
            return false;
        }
        for(int d = 0; d < 4; d++){
            int cnt = 1;
            while (true){
                int nr = r + delta[d][0] * cnt;
                int nc = c + delta[d][1] * cnt;
                cnt++;
                if(nr < 0 || nr >= N || nc < 0 || nc >= N){
                    break;
                }
                if(map[nr][nc] == 2){
                    return false;
                }
            }
        }

        return true;
    }
}
