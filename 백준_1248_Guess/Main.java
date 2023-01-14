package 백준_1248_Guess;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        char[] input = br.readLine().toCharArray();
        char[][] S = new char[N][N];
        int cnt = 0;
        for(int i = 0; i < N; i++){
            for(int j = i; j < N; j++){
                S[i][j] = input[cnt++];
            }
        }
        int[] select = new int[N];
        dfs(S, N, 0, select, sb);

        System.out.println(sb);
    }

    static void dfs(char[][] S, int N, int cnt, int[] select, StringBuilder sb){
        if (sb.length() > 0){
            return;
        }
        if(cnt == N){
            for(int i = 0; i < N; i++){
                sb.append(select[i]).append(" ");
            }
            return;
        }

        for(int i = -10; i <= 10; i++){
            select[cnt] = i;

            if(check(S, cnt, select)){
                dfs(S, N, cnt + 1, select, sb);
            }
        }
    }

    static boolean check(char[][] S, int cnt, int[] select){
        for(int j = 0; j <= cnt; j++){
            int sum = 0;
            for(int k = j; k <= cnt; k++){
                sum += select[k];
            }
            if(sum > 0 && S[j][cnt] != '+'){
                break;
            }
            if(sum == 0 && S[j][cnt] != '0'){
                break;
            }
            if(sum < 0 && S[j][cnt] != '-'){
                break;
            }

            if(j == cnt){
                return true;
            }
        }
        return false;
    }
}
