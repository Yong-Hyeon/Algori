package 백준_2638_치즈;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int[][] delta = {{1,0},{0,1},{-1,0},{0,-1}};

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
            }
        }

        boolean[][] isVisited = new boolean[N][M];

        boolean isEnd = false;
        int result = 0;
        while (!isEnd){
            Queue<int[]> queue = new LinkedList<>();
            isVisited = new boolean[N][M];

            for(int i = 0; i < N; i++){
                if(map[i][0] == 0){
                    queue.add(new int[]{i, 0});
                    isVisited[i][0] = true;
                }
                if(map[i][M-1] == 0){
                    queue.add(new int[]{i, M-1});
                    isVisited[i][M-1] = true;
                }
            }

            for(int i = 1; i < M - 1; i++){
                if(map[0][i] == 0){
                    queue.add(new int[]{0, i});
                    isVisited[0][i] = true;
                }
                if(map[N-1][i] == 0){
                    queue.add(new int[]{N-1, i});
                    isVisited[N-1][i] = true;
                }
            }

            while (!queue.isEmpty()){
                int[] now = queue.poll();

                for(int d = 0; d < 4; d++){
                    int nr = delta[d][0] + now[0];
                    int nc = delta[d][1] + now[1];
                    if(nr < 0 || nr >= N || nc < 0 || nc >= M || isVisited[nr][nc] || map[nr][nc] != 0){
                        continue;
                    }
                    queue.add(new int[]{nr, nc});
                    isVisited[nr][nc] = true;
                }
            }
            isEnd = true;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(isVisited[i][j]){
                        continue;
                    }
                    int cnt = 0;
                    if(map[i][j] == 1){
                        for(int d = 0; d < 4; d++){
                            int nr = delta[d][0] + i;
                            int nc = delta[d][1] + j;
                            if(nr < 0 || nr >= N || nc < 0 || nc >= M || isVisited[nr][nc]){
                                cnt++;
                            }
                        }
                        if(cnt >= 2){
                            map[i][j] = 0;
                            isEnd = false;
                        }
                    }
                }
            }
            if(isEnd){
                break;
            }

            result++;
        }

        sb.append(result).append("\n");
        System.out.println(sb);
    }
}
