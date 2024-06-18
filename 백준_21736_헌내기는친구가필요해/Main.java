package 백준_21736_헌내기는친구가필요해;

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

        char[][] map = new char[N][M];
        int r = 0;
        int c = 0;

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                char ch = str.charAt(j);
                map[i][j] = ch;
                if(ch == 'I'){
                    r = i;
                    c = j;
                }
            }
        }

        int meetCnt = 0;
        boolean[][] isVisited = new boolean[N][M];
        isVisited[r][c] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r,c});

        int[][] delta = {{0,1},{1,0},{0,-1},{-1,0}};

        while (!queue.isEmpty()){
            int[] now = queue.poll();

            for(int d = 0; d < 4; d++){
                int nr = now[0] + delta[d][0];
                int nc = now[1] + delta[d][1];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M || isVisited[nr][nc] || map[nr][nc] == 'X'){
                    continue;
                }
                queue.add(new int[]{nr,nc});
                isVisited[nr][nc] = true;
                if(map[nr][nc] == 'P'){
                    meetCnt++;
                }
            }
        }

        if(meetCnt == 0){
            sb.append("TT").append("\n");
        }else{
            sb.append(meetCnt).append("\n");
        }

        System.out.println(sb);
    }
}
