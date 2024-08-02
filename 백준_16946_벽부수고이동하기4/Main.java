package 백준_16946_벽부수고이동하기4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] delta = {{-1,0},{0,1},{1,0},{0,-1}};

        int[][] map = new int[N][M];
        int[][] dp = new int[N][M];
        int[][] set = new int[N][M];
        int[][] result = new int[N][M];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        boolean[][] isVisited = new boolean[N][M];
        int setCnt = 1;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0 && !isVisited[i][j]){
                    int cnt = 0;
                    Queue<int[]> queue = new LinkedList<>();
                    Queue<int[]> save = new LinkedList<>();
                    queue.add(new int[]{i,j});
                    save.add(new int[]{i,j});
                    isVisited[i][j] = true;
                    cnt++;
                    while (!queue.isEmpty()){
                        int[] now = queue.poll();

                        for(int d = 0; d < 4; d++){
                            int nr = now[0] + delta[d][0];
                            int nc = now[1] + delta[d][1];
                            if(nr < 0 || nr >= N || nc < 0 || nc >= M || isVisited[nr][nc] || map[nr][nc] != 0){
                                continue;
                            }
                            cnt++;
                            isVisited[nr][nc] = true;
                            queue.add(new int[]{nr,nc});
                            save.add(new int[]{nr,nc});
                        }
                    }
                    while (!save.isEmpty()){
                        int[] now = save.poll();
                        dp[now[0]][now[1]] = cnt;
                        set[now[0]][now[1]] = setCnt;
                    }
                    setCnt++;
                }
            }
        }

        boolean[] isUsed = null;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 1){
                    isUsed = new boolean[setCnt];
                    int sum = 1;
                    for(int d = 0; d < 4; d++){
                        int nr = i + delta[d][0];
                        int nc = j + delta[d][1];
                        if(nr < 0 || nr >= N || nc < 0 || nc >= M || isUsed[set[nr][nc]]){
                            continue;
                        }
                        sum += dp[nr][nc];
                        isUsed[set[nr][nc]] = true;
                    }
                    result[i][j] = sum % 10;
                }
                sb.append(result[i][j]);
            }
            sb.append("\n");
        }



        System.out.println(sb);
    }
}
