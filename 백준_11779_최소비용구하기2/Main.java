package 백준_11779_최소비용구하기2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node>{
        int no;
        int dist;
        String route;
        int cnt;

        public Node(int no, int dist, String route, int cnt){
            this.no = no;
            this.dist = dist;
            this.route = route;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o){
            return this.dist - o.dist;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<List<Node>> list = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(s).add(new Node(e, c, "", 0));
        }

        boolean[] isVisited = new boolean[N+1];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        Node node = new Node(start, 0, "", 1);
        pq.add(node);

        while (!pq.isEmpty()){
            Node now = pq.poll();
            if(isVisited[now.no]){
                continue;
            }
            if(now.no == end){
                sb.append(now.dist).append("\n");
                sb.append(now.cnt).append("\n");
                sb.append(now.route + now.no).append("\n");
                break;
            }
            isVisited[now.no] = true;
            now.route += now.no + " ";

            int size = list.get(now.no).size();
            for(int i = 0; i < size; i++){
                if(isVisited[list.get(now.no).get(i).no]){
                    continue;
                }
                pq.add(new Node(list.get(now.no).get(i).no, now.dist + list.get(now.no).get(i).dist, now.route, now.cnt + 1));
            }
        }

        System.out.println(sb);
    }
}
