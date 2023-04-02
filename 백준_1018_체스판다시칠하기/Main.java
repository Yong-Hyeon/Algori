package 백준_1018_체스판다시칠하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = str.charAt(j);
            }
        }
        char[][] board1 = new char[8][8];
        char[][] board2 = new char[8][8];

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(i % 2 == 0){
                    if(j % 2 == 0){
                        board1[i][j] = 'W';
                        board2[i][j] = 'B';
                    }else{
                        board1[i][j] = 'B';
                        board2[i][j] = 'W';
                    }
                }else{
                    if(j % 2 == 0){
                        board1[i][j] = 'B';
                        board2[i][j] = 'W';
                    }else{
                        board1[i][j] = 'W';
                        board2[i][j] = 'B';
                    }
                }
            }
        }

        int result = Integer.MAX_VALUE;

        for(int i = 0; i <= N - 8; i++){
            for(int j = 0; j <= M - 8; j++){
                int cnt1 = 0;
                int cnt2 = 0;
                for(int r = 0; r < 8; r++){
                    for(int c = 0; c < 8; c++){
                        if(map[i+r][j+c] != board1[r][c]){
                            cnt1++;
                        }
                        if(map[i+r][j+c] != board2[r][c]){
                            cnt2++;
                        }
                    }
                }
                result = Math.min(result, Math.min(cnt1, cnt2));
            }
        }

        System.out.println(result);
    }
}
