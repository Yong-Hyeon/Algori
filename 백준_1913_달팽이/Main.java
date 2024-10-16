package 백준_1913_달팽이;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        int r = N / 2;
        int c = N / 2;

        int cnt = 1;
        int[][] delta = {{-1, 0},{0, 1},{1, 0},{0, -1}};
        int d = 0;

        int resultR = 0;
        int resultC = 0;

        int start = 1;
        if(start == M){
            resultR = r + 1;
            resultC = c + 1;
        }
        map[r][c] = start++;
        boolean isEnd = false;
        while (true){
            for(int j = 0; j < 2; j++){
                for(int i = 0; i < cnt; i++){
                    r += delta[d][0];
                    c += delta[d][1];
                    if(r < 0 || r >= N || c < 0 || c >= N){
                        isEnd = true;
                        break;
                    }
                    if(start == M){
                        resultR = r + 1;
                        resultC = c + 1;
                    }
                    map[r][c] = start++;
                }
                if(isEnd){
                    break;
                }
                d = (d + 1) % 4;
            }
            if(isEnd){
                break;
            }
            cnt++;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(resultR).append(" ").append(resultC);
        System.out.println(sb);
    }
}
