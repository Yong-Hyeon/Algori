package 백준_1501_특정한최단경로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
    static boolean isFail1;
    static boolean isFail2;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N+1][N+1];

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            graph[start][end] = dist;
            graph[end][start] = dist;
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int case1 = 0;
        isFail1 = false;
        case1 += dijkstra(1, v1, N, graph, 1);
        case1 += dijkstra(v1, v2, N, graph, 1);
        case1 += dijkstra(v2, N, N, graph, 1);

        int case2 = 0;
        isFail2 = false;
        case2 += dijkstra(1, v2, N, graph, 2);
        case2 += dijkstra(v2, v1, N, graph, 2);
        case2 += dijkstra(v1, N, N, graph, 2);

        if(isFail1 && isFail2){
            sb.append(-1).append("\n");
        }else if(isFail1){
            sb.append(case2).append("\n");
        }else if(isFail2){
            sb.append(case1).append("\n");
        }else{
            sb.append(case1 > case2 ? case2 : case1).append("\n");
        }

        System.out.println(sb);
    }

    private static int dijkstra(int start, int end, int N, int[][] graph, int cnt) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] isVisited = new boolean[N+1];

        pq.add(new Node(start, 0));
        while (!pq.isEmpty()){
            Node now = pq.poll();

            if(now.no == end){
                return now.dist;
            }
            isVisited[now.no] = true;

            for(int i = 1; i <= N; i++){
                if(graph[now.no][i] > 0 && !isVisited[i]){
                    pq.add(new Node(i, now.dist + graph[now.no][i]));
                }
            }
        }
        if(cnt == 1){
            isFail1 = true;
        }
        if(cnt == 2){
            isFail2 = true;
        }
        return 0;
    }

}
