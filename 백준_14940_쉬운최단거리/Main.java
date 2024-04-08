package 백준_14940_쉬운최단거리;

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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        boolean[][] isVisited = new boolean[n][m];
        int[][] delta = {{0,1},{1,0},{0,-1},{-1,0}};
        int[] start = new int[2];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                int num = Integer.parseInt(st.nextToken());
                if(num == 2){
                    start[0] = i;
                    start[1] = j;
                }
                map[i][j] = num;
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        isVisited[start[0]][start[1]] = true;
        int[][] result = new int[n][m];

        int cnt = 0;

        while (!queue.isEmpty()){
            int size = queue.size();
            cnt++;
            for(int i = 0; i < size; i++){
                int[] now = queue.poll();
                for(int d = 0; d < 4; d++){
                    int nr = now[0] + delta[d][0];
                    int nc = now[1] + delta[d][1];
                    if(nr < 0 || nr >= n || nc < 0 || nc >= m || isVisited[nr][nc] || map[nr][nc] != 1){
                        continue;
                    }
                    isVisited[nr][nc] = true;
                    queue.add(new int[]{nr,nc});
                    result[nr][nc] = cnt;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(isVisited[i][j]){
                    sb.append(result[i][j]).append(" ");
                }else{
                    if(map[i][j] == 1){
                        sb.append(-1).append(" ");
                    }else{
                        sb.append(0).append(" ");
                    }
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
