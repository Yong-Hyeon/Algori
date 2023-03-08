package 백준_1261_알고스팟;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        result = Integer.MAX_VALUE;
        int[][] map = new int[N][M];
        for(int i = 0; i < N; i++){
            String[] str = br.readLine().split("");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(str[j]);
            }
        }



        System.out.println(result);
    }

    /*
    방문체크해서 방문 했으면 안간다. 근데 방문했어도 지금장소 + 다음장소 값이 다음장소에 저장된 값보다 작으면 간다.
    dp[now] + 1 < dp[next] 같은 느낌으로.
     */
    static void dfs(int N, int M, int r, int c){

    }
}
