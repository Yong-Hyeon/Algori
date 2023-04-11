package 백준_7562_나이트의이동;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] delta = {{-1,-2},{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2}};
        for(int tc = 1; tc <= T; tc++){
            int L = Integer.parseInt(br.readLine());
            boolean[][] isVisited = new boolean[L][L];
            int[] start = new int[2];
            int[] end = new int[2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());

            Queue<int[]> queue = new LinkedList<>();
            queue.add(start);
            isVisited[start[0]][start[1]] = true;

            boolean isEnd = false;
            int cnt = 0;
            while (!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    int[] now = queue.poll();

                    if(now[0] == end[0] && now[1] == end[1]){
                        isEnd = true;
                        break;
                    }

                    for(int d = 0; d < 8; d++){
                        int nr = now[0] + delta[d][0];
                        int nc = now[1] + delta[d][1];

                        if(nr < 0 || nr >= L || nc < 0 || nc >= L || isVisited[nr][nc]){
                            continue;
                        }
                        queue.add(new int[]{nr,nc});
                        isVisited[nr][nc] = true;
                    }
                }
                if(isEnd){
                    break;
                }
                cnt++;
            }
            System.out.println(cnt);
        }


//        System.out.println();
    }
}
