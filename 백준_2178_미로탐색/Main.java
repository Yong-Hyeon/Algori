package 백준_2178_미로탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] delta = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        boolean[][] isVisited = new boolean[N][M];

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0});
        isVisited[0][0] = true;
        int cnt = 1;
        boolean isEnd = false;
        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();

                if (now[0] == N - 1 && now[1] == M - 1) {
                    isEnd = true;
                    break;
                }

                for (int d = 0; d < 4; d++) {
                    int nr = now[0] + delta[d][0];
                    int nc = now[1] + delta[d][1];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= M || isVisited[nr][nc]) {
                        continue;
                    }
                    if(map[nr][nc] == 0){
                        continue;
                    }
                    queue.add(new int[]{nr,nc});
                    isVisited[nr][nc] = true;
                }
            }
            if (isEnd){
                break;
            }
            cnt++;
        }


        System.out.println(cnt);
    }

}
