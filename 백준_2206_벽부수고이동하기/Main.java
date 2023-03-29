package 백준_2206_벽부수고이동하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Move implements Comparable<Move>{
        int r;
        int c;
        int cnt;
        boolean isDestroyed;

        public Move(int r, int c, int cnt, boolean isDestroyed) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.isDestroyed = isDestroyed;
        }

        @Override
        public int compareTo(Move o) {
            return this.cnt - o.cnt;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[][][] isVisited = new int[N][M][2];
        int[][] delta = {{1,0},{0,1},{-1,0},{0,-1}};
        for(int i = 0; i < N; i++){
            String[] temp = br.readLine().split("");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }
        int result = -1;
        PriorityQueue<Move> pq = new PriorityQueue<>();
        pq.add(new Move(0,0,1,false));

        while(!pq.isEmpty()){
            Move now = pq.poll();

            if(now.r == N-1 && now.c == M - 1){
                result = now.cnt;
                break;
            }
            for(int d = 0; d < 4; d++){
                int nr = now.r + delta[d][0];
                int nc = now.c + delta[d][1];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M){
                    continue;
                }
                if(now.isDestroyed){
                    if(map[nr][nc] == 0){
                        if(isVisited[nr][nc][1] > now.cnt +1 || isVisited[nr][nc][1] == 0){
                            isVisited[nr][nc][1] = now.cnt + 1;
                            pq.add(new Move(nr,nc, now.cnt + 1, true));
                        }
                    }
                }else{
                    if(map[nr][nc] == 0){
                        if(isVisited[nr][nc][0] == 0){
                            isVisited[nr][nc][0] = now.cnt + 1;
                            isVisited[nr][nc][1] = isVisited[nr][nc][1] == 0?now.cnt + 1:Math.min(isVisited[nr][nc][1], now.cnt+1);
                            pq.add(new Move(nr, nc, now.cnt + 1, false));
                        }
                    }else{
                        if(isVisited[nr][nc][1] > now.cnt + 1 || isVisited[nr][nc][1] == 0){
                            isVisited[nr][nc][1] = now.cnt + 1;
                            pq.add(new Move(nr,nc, now.cnt + 1, true));
                        }
                    }
                }

            }

        }


        System.out.println(result);
    }

}
