package 백준_1268_임시반장정하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][5];
        int[][] result = new int[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int c = 0; c < 5; c++){
            for(int i = 0; i < N; i++){
                for(int j = i + 1; j < N; j++){
                    if(map[i][c] == map[j][c]){
                        result[i][j]++;
                        result[j][i]++;
                    }
                }
            }
        }

        int max = 0;
        int maxIdx = 0;
        for(int i = 0; i < N; i++){
            int cnt = 0;
            for(int j = 0; j < N; j++){
                if(result[i][j] > 0){
                    cnt++;
                }
            }
            if(cnt > max){
                max = cnt;
                maxIdx = i;
            }
        }

        sb.append(maxIdx+1);
        System.out.println(sb);
    }

}
