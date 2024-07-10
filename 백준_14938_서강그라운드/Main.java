package 백준_14938_서강그라운드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

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
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        List<List<Node>> list = new ArrayList<>();

        int[] cost = new int[n + 1];
        st = new StringTokenizer(br.readLine());

        list.add(new ArrayList<>());
        for(int i = 1; i <= n; i++){
            cost[i] = Integer.parseInt(st.nextToken());
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b,l));
            list.get(b).add(new Node(a,l));
        }

        int max = 0;
        for(int i = 1; i <= n; i++){
            PriorityQueue<Node> pq = new PriorityQueue<>();
            boolean[] isVisited = new boolean[n+1];
            pq.add(new Node(i, 0));
            int sum = 0;

            while (!pq.isEmpty()){
                Node now = pq.poll();

                if(now.dist > m){
                    break;
                }
                if(isVisited[now.no]){
                    continue;
                }
                isVisited[now.no] = true;
                sum += cost[now.no];

                int size = list.get(now.no).size();
                for(int j = 0; j < size; j++){
                    if(isVisited[list.get(now.no).get(j).no]){
                        continue;
                    }
                    pq.add(new Node(list.get(now.no).get(j).no, now.dist + list.get(now.no).get(j).dist));
                }
            }
            max = Math.max(max, sum);
        }

        sb.append(max).append("\n");
        System.out.println(sb);
    }
}
