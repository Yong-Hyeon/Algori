package 백준_1012_유기농배추;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Cabbage{
        int no;
        int x;
        int y;

        Cabbage(int no, int x, int y){
            this.no = no;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[][] delta = {{1,0},{0,1},{-1,0},{0,-1}};

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            Cabbage[][] map = new Cabbage[M][N];
            boolean[] isChecked = new boolean[K];
            Cabbage[] cabbages = new Cabbage[K];

            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                Cabbage cabbage = new Cabbage(i,X,Y);
                cabbages[i] = cabbage;
                map[X][Y] = cabbage;
            }
            int cnt = 0;
            for(int i = 0; i < K; i++){
                Queue<Cabbage> queue = new LinkedList<>();
                if(isChecked[i]){
                    continue;
                }
                queue.add(cabbages[i]);
                isChecked[i] = true;
                cnt++;
                while (!queue.isEmpty()){
                    Cabbage now = queue.poll();
                    for(int d = 0; d < 4; d++){
                        int dx = now.x + delta[d][0];
                        int dy = now.y + delta[d][1];
                        if(dx < 0 || dx >= M || dy < 0 || dy >= N){
                            continue;
                        }
                        if(map[dx][dy] != null && !isChecked[map[dx][dy].no]){
                            queue.add(map[dx][dy]);
                            isChecked[map[dx][dy].no] = true;
                        }
                    }
                }
            }
            sb.append(cnt).append("\n");
        }


        System.out.println(sb);
    }
}
