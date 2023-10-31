package 백준_1307_마방진;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[][] magicSquare = new int[N][N];

        if(N % 2 == 1){
            oddMagicSquare(N, magicSquare);
        }else{
            if(N % 4 == 0){
                evenMagicSquare(N, magicSquare);
            }else{
                oddMagicSquare(N / 2, magicSquare);
                swap(N / 2, magicSquare);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sb.append(magicSquare[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void evenMagicSquare(int n, int[][] magicSquare) {
        boolean[][] isChecked = new boolean[n][n];

        for(int i = 0; i < n; i+=4){
            for(int j = 0; j < n; j+=4){
                for(int t = 0; t < 4; t++){
                    isChecked[i+t][j+t] = true;
                    isChecked[i+t][j+3-t] = true;
                }
            }
        }
        int cnt = 1;
        int max = n * n + 1;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(isChecked[i][j]){
                    magicSquare[i][j] = cnt;
                }else{
                    magicSquare[i][j] = max - cnt;
                }
                cnt++;
            }
        }
    }

    private static void swap(int n, int[][] magicSquare) {
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n/2; j++){
                int temp = magicSquare[i][j];
                magicSquare[i][j] = magicSquare[i+n][j];
                magicSquare[i+n][j] = temp;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n/2 - 1; j++){
                int temp = magicSquare[i][N-1-j];
                magicSquare[i][N-1-j] = magicSquare[i+n][N-1-j];
                magicSquare[i+n][N-1-j] = temp;
            }
        }

        int half = n / 2;
        int temp = magicSquare[half][half];
        int leftTemp = magicSquare[half][half-1];
        magicSquare[half][half] = magicSquare[half+n][half];
        magicSquare[half][half-1] = magicSquare[half+n][half-1];
        magicSquare[half+n][half] = temp;
        magicSquare[half+n][half-1] = leftTemp;

    }
    private static void oddMagicSquare(int n, int[][] magicSquare) {
        int max = n * n;
        int r = 0;
        int c = n / 2;

        for(int i = 1; i < max + 1; i++){
            magicSquare[r][c] = i;
            if(n != N){
                magicSquare[r + n][c + n] = i + max * 1;
                magicSquare[r][c + n] = i + max * 2;
                magicSquare[r + n][c] = i + max * 3;
            }
            int nr = r - 1;
            int nc = c + 1;
            if(nr < 0 && nc >= n){
                nr = r + 1;
                nc = c;
            }else if(nr < 0){
                nr = nr + n;
            }else if(nc >= n){
                nc = nc - n;
            }
            if(magicSquare[nr][nc] != 0){
                nr = r + 1;
                nc = c;
            }
            r = nr;
            c = nc;
        }
    }

}
