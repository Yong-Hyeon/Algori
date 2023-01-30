package 백준_10971_외판원순회2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int min;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] isVisited = new boolean[N];
        min = Integer.MAX_VALUE;
        isVisited[0] = true;
        dfs(N, 0, 0, map, isVisited, 0, 0);
        System.out.println(min);
    }

    private static void dfs(int N, int start, int now, int[][] map, boolean[] isVisited, int cnt, int cost) {
        if(cost > min){
            return;
        }
        if (start == now && cost > 0) {
            min = Math.min(min, cost);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (map[now][i] > 0) {
                if (cnt == N - 1 && start == i) {
                    dfs(N, start, i, map, isVisited, cnt + 1, cost + map[now][i]);
                }

                if (!isVisited[i]) {
                    isVisited[i] = true;
                    dfs(N, start, i, map, isVisited, cnt + 1, cost + map[now][i]);
                    isVisited[i] = false;
                }
            }
        }
    }

}
