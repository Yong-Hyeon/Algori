package 백준_16234_인구이동;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] delta = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] isVisited = new boolean[N][N];

        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> save = new LinkedList<>();
        boolean isMoved = true;
        int result = 0;
        while (isMoved){
            isMoved = false;
            isVisited = new boolean[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(isVisited[i][j]){
                        continue;
                    }
                    queue.add(new int[]{i,j});
                    save.add(new int[]{i,j});
                    isVisited[i][j] = true;
                    int sum = map[i][j];
                    while (!queue.isEmpty()){
                        int[] now = queue.poll();

                        for(int d = 0; d < 4; d++){
                            int nr = now[0] + delta[d][0];
                            int nc = now[1] + delta[d][1];

                            if(nr < 0 || nr >= N || nc < 0 || nc >= N || isVisited[nr][nc]){
                                continue;
                            }

                            if(Math.abs(map[now[0]][now[1]] - map[nr][nc]) >= L && Math.abs(map[now[0]][now[1]] - map[nr][nc]) <= R){
                                queue.add(new int[]{nr,nc});
                                save.add(new int[]{nr,nc});
                                sum += map[nr][nc];
                                isVisited[nr][nc] = true;
                                isMoved = true;
                            }
                        }
                    }

                    int size = save.size();

                    while (!save.isEmpty()){
                        int[] now = save.poll();
                        map[now[0]][now[1]] = sum / size;
                    }

                }
            }
            if(isMoved){
                result++;
            }
        }
        System.out.println(result);

    }



}
