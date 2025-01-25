package 백준_1531_투명;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[101][101];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int startR = Integer.parseInt(st.nextToken());
            int startC = Integer.parseInt(st.nextToken());
            int endR = Integer.parseInt(st.nextToken());
            int endC = Integer.parseInt(st.nextToken());

            for(int r = startR; r <= endR; r++){
                for(int c = startC; c <= endC; c++){
                    map[r][c] = map[r][c] + 1;
                }
            }
        }

        int result = 0;
        for(int i = 1; i <= 100; i++){
            for(int j = 1; j <= 100; j++){
                if(map[i][j] > M){
                    result++;
                }
            }
        }

        System.out.println(result);
    }

}
