package 백준_1261_알고스팟;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Algo implements Comparable<Algo>{
        int r,c,cnt;

        Algo(int r, int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Algo o) {
            return this.cnt - o.cnt;
        }
    }
    static int result;
    static int[][] delta = {{1,0},{0,1},{-1,0},{0,-1}};
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
        PriorityQueue<Algo> pq = new PriorityQueue<>();
        boolean[][] isVisited = new boolean[N][M];

        pq.add(new Algo(0,0,0));
        isVisited[0][0] = true;
        int result = 0;
        while (!pq.isEmpty()){
            Algo now = pq.poll();

            if(now.r == N -1 && now.c == M - 1){
                result = now.cnt;
                break;
            }

            for(int i = 0; i < 4; i++){
                int nr = now.r + delta[i][0];
                int nc = now.c + delta[i][1];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M || isVisited[nr][nc]){
                    continue;
                }
                pq.add(new Algo(nr,nc,now.cnt + map[nr][nc]));
                isVisited[nr][nc] = true;
            }
        }
        System.out.println(result);
    }

}
