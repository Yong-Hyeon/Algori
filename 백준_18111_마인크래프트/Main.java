package 백준_18111_마인크래프트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int min;
    static int resultHeight;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int sum = B;
        min = Integer.MAX_VALUE;
        resultHeight = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                sum += num;
            }
        }
        int maxHeight = sum / (N * M);

        for(int i = maxHeight; i >= 0; i--){
            flat(map, N, M, i);
        }


        System.out.println(min + " " + resultHeight);
    }

    private static void flat(int[][] map, int N, int M, int maxHeight) {
        int time = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                time += maxHeight >= map[i][j] ? (maxHeight - map[i][j]) : (map[i][j] - maxHeight) * 2;
                if(time >= min){
                    return;
                }
            }
        }
        resultHeight = maxHeight;
        min = Math.min(min, time);

    }
}
