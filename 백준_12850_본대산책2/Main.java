package 백준_12850_본대산책2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static long mod;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        long[][] map = {
                {0,1,0,0,0,0,0,1},
                {1,0,1,0,0,0,0,1},
                {0,1,0,1,0,0,1,1},
                {0,0,1,0,1,0,1,0},
                {0,0,0,1,0,1,0,0},
                {0,0,0,0,1,0,1,0},
                {0,0,1,1,0,1,0,1},
                {1,1,1,0,0,0,1,0}};
        mod = 1000000007;
        long[][] result = search(map, N);

        sb.append(result[0][0]).append("\n");
        System.out.println(sb);
    }

    private static long[][] search(long[][] map, int N) {
        if(N == 1){
            return map;
        }

        long[][] matrix = search(map, N / 2);

        matrix = multiMatrix(matrix, matrix);
        if(N % 2 == 1){
            matrix = multiMatrix(matrix, map);
        }

        return matrix;
    }

    private static long[][] multiMatrix(long[][] a, long[][] b) {
        long[][] multi = new long[8][8];
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                for(int k = 0; k < 8; k++){
                    multi[i][j] = (multi[i][j] + a[i][k] * b[k][j]) % mod;
                }
            }
        }

        return multi;
    }
}
