package 백준_11404_플로이드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node>{
        int no;
        int dist;

        Node(int no, int dist){
            this.no = no;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] graph = new int[N+1][N+1];


        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(graph[a][b] == 0){
                graph[a][b] = c;
            }else{
                graph[a][b] = Math.min(graph[a][b], c);
            }
        }

        boolean[] isVisited = new boolean[N+1];
        int[][] result = new int[N+1][N+1];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i = 1; i <= N; i++){
            int cnt = 0;
            isVisited = new boolean[N+1];
            pq = new PriorityQueue<>();
            pq.add(new Node(i, 0));
            while (!pq.isEmpty()){
                Node now = pq.poll();
                if(cnt == N){
                    break;
                }
                if(isVisited[now.no]){
                    continue;
                }
                isVisited[now.no] = true;
                result[i][now.no] = now.dist;
                cnt++;

                for(int j = 1; j <= N; j++){
                    if(graph[now.no][j] != 0 && !isVisited[j]){
                        pq.add(new Node(j, now.dist + graph[now.no][j]));
                    }
                }
            }
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
