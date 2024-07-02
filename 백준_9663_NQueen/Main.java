package 백준_9663_NQueen;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] row = new int[N];
        result = 0;
        nQueen(row, 0, N);

        sb.append(result).append("\n");

        System.out.println(sb);
    }

    private static void nQueen(int[] row, int cnt, int N) {
        if(cnt == N){
            result++;
            return;
        }

        for(int col = 0; col < N; col++){
            row[cnt] = col;
            if(canQueen(row, cnt, col)){
                nQueen(row, cnt + 1, N);
            }
        }
    }

    private static boolean canQueen(int[] row, int cnt, int col) {
        for(int i = 0; i < cnt; i++){
            if(row[i] == row[cnt]){
                return false;
            }
            if(Math.abs(i - cnt) == Math.abs(row[i] - row[cnt])){
                return false;
            }
        }

        return true;
    }

}
