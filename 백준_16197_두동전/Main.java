package 백준_16197_두동전;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int min;
    static int[][] delta = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        int[][] coin = new int[2][2];
        int coinCnt = 0;
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'o'){
                    coin[coinCnt][0] = i;
                    coin[coinCnt++][1] = j;
                }
            }
        }
        min = 11;
        dfs(N, M, map, coin, 0);
        if(min == 11){
            System.out.println(-1);
        }else{
            System.out.println(min);
        }
    }

    private static void dfs(int N, int M, char[][] map, int[][] coin, int cnt) {
        if(cnt >= min || cnt > 10){
            return;
        }


        int coin1R = coin[0][0];
        int coin1C = coin[0][1];
        int coin2R = coin[1][0];
        int coin2C = coin[1][1];

        for(int d = 0; d < 4; d++){
            int moveCheck = 0;
            int fallCheck = 0;
            int nr1 = coin1R + delta[d][0];
            int nc1 = coin1C + delta[d][1];
            int nr2 = coin2R + delta[d][0];
            int nc2 = coin2C + delta[d][1];

            if(nr1 >= N || nr1 < 0 || nc1 >= M || nc1 < 0){
                fallCheck++;
            }
            if(nr2 >= N || nr2 < 0 || nc2 >= M || nc2 < 0){
                fallCheck++;
            }

            if(fallCheck == 1){
                min = Math.min(min, cnt+1);
                return;
            }
            if(fallCheck == 2){
                continue;
            }

            if(map[nr1][nc1] == '#'){
                nr1 = coin1R;
                nc1 = coin1C;
                moveCheck++;
            }
            if(map[nr2][nc2] == '#'){
                nr2 = coin2R;
                nc2 = coin2C;
                moveCheck++;
            }

            if(moveCheck == 2){
                continue;
            }

            coin[0][0] = nr1;
            coin[0][1] = nc1;
            coin[1][0] = nr2;
            coin[1][1] = nc2;
            dfs(N,M,map,coin,cnt + 1);
            coin[0][0] = coin1R;
            coin[0][1] = coin1C;
            coin[1][0] = coin2R;
            coin[1][1] = coin2C;
        }

    }

}
