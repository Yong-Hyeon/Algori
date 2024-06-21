package 백준_1238_파티;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node>{
        int no;
        int dist;

        public Node(int no, int dist){
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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N+1][N+1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            graph[start][end] = time;
        }

        int max = 0;
        for(int i = 1; i <= N; i++){
            boolean[] isVisited = new boolean[N+1];
            int partyDist = 0;
            int homeDist = 0;
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(i, 0));
            while (!pq.isEmpty()){
                Node now = pq.poll();
                isVisited[now.no] = true;

                if(now.no == X){
                    partyDist = now.dist;
                    break;
                }

                for(int j = 1; j <= N; j++){
                    if(graph[now.no][j] > 0 && !isVisited[j]){
                        pq.add(new Node(j, now.dist + graph[now.no][j]));
                    }
                }
            }

            isVisited = new boolean[N+1];
            pq = new PriorityQueue<>();
            pq.add(new Node(X, 0));
            while (!pq.isEmpty()){
                Node now = pq.poll();
                isVisited[now.no] = true;

                if(now.no == i){
                    homeDist = now.dist;
                    break;
                }

                for(int j = 1; j <= N; j++){
                    if(graph[now.no][j] > 0 && !isVisited[j]){
                        pq.add(new Node(j, now.dist + graph[now.no][j]));
                    }
                }
            }

            max = Math.max(max, partyDist + homeDist);
        }
        sb.append(max).append("\n");
        System.out.println(sb);
    }

}
