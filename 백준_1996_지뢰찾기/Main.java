package 백준_1996_지뢰찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[][] delta = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
        char[][] map = new char[N][N];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = str.charAt(j);
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                int sum = 0;
                if(map[i][j] != '.'){
                    sb.append("*");
                    continue;
                }
                for(int d = 0; d < 8; d++){
                    int nr = i + delta[d][0];
                    int nc = j + delta[d][1];
                    if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == '.'){
                        continue;
                    }
                    sum += (map[nr][nc] - '0');
                }
                if(sum >= 10){
                    sb.append("M");
                }else{
                    sb.append(sum);
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
