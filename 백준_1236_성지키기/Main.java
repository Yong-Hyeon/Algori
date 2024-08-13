package 백준_1236_성지키기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] row = new boolean[N];
        boolean[] cul = new boolean[M];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                if(str.charAt(j) == 'X'){
                    row[i] = true;
                    cul[j] = true;
                }
            }
        }

        int result = 0;
        for(int i = 0; i < N; i++){
            if(row[i]){
                continue;
            }
            for(int j = 0; j < M; j++){
                if(!cul[j] || j == M - 1){
                    result++;
                    row[i] = true;
                    cul[j] = true;
                    break;
                }
            }
        }

        for(int i = 0; i < M; i++){
            if(cul[i]){
                continue;
            }
            for(int j = 0; j < N; j++){
                if(!row[j] || j == N - 1){
                    result++;
                    row[j] = true;
                    cul[i] = true;
                    break;
                }
            }
        }

        sb.append(result).append("\n");
        System.out.println(sb);
    }
}
