package 백준_1865_웜홀;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            int[][] graph = new int[N+1][N+1];
            for(int i = 0; i <= N; i++){
                Arrays.fill(graph[i], 20001);
            }
            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());

                if(graph[start][end] > time){
                    graph[start][end] = time;
                    graph[end][start] = time;
                }
            }
            for(int i = 0; i < W; i++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int time = -Integer.parseInt(st.nextToken());

                if(graph[start][end] > time){
                    graph[start][end] = time;
                }
            }

            int[] dist = new int[N+1];

            boolean isEnd = false;
            for(int i = 1; i <= 1; i++){
                Arrays.fill(dist, 111111111);
                dist[i] = 0;
                boolean update = false;

                for(int n = 1; n < N; n++){
                    update = false;

                    for(int j = 1; j <= N; j++){
                        for(int k = 1; k <= N; k++){
                            if(graph[j][k] < 20000 && dist[k] > dist[j] + graph[j][k]){
                                update = true;
                                dist[k] = dist[j] + graph[j][k];
                            }
                        }
                    }

                    if(!update){
                        break;
                    }
                }

                if(update){
                    for(int j = 1; j <= N; j++){
                        for(int k = 1; k <= N; k++){
                            if(graph[j][k] < 20000 && dist[k] > dist[j] + graph[j][k]){
                                isEnd = true;
                                break;
                            }
                        }
                        if(isEnd){
                            break;
                        }
                    }
                }
                if(isEnd){
                    break;
                }
            }

            if (isEnd){
                sb.append("YES").append("\n");
            }else{
                sb.append("NO").append("\n");
            }

        }

        System.out.println(sb);
    }
}
