package 백준_1005_ACMCraft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());


        for(int tc = 1; tc <= T; tc++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] nodes = new int[N+1];
            int[] indegree = new int[N+1];
            int[] dp = new int[N+1];


            st = new StringTokenizer(br.readLine());
            List<List<Integer>> graph = new ArrayList<>();
            graph.add(new ArrayList<>());
            for(int i = 1; i <= N; i++){
                nodes[i] = Integer.parseInt(st.nextToken());
                graph.add(new ArrayList<>());
            }

            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                graph.get(s).add(e);
                indegree[e]++;
            }

            int W = Integer.parseInt(br.readLine());

            Queue<Integer> queue = new LinkedList<>();
            for(int i = 1; i <= N; i++){
                if(indegree[i] == 0){
                    queue.add(i);
                    dp[i] = nodes[i];
                }
            }

            while (!queue.isEmpty()){
                int now = queue.poll();

                if(now == W){
                    break;
                }

                int size = graph.get(now).size();
                for(int i = 0; i < size; i++){
                    if(dp[graph.get(now).get(i)] < dp[now] + nodes[graph.get(now).get(i)]){
                        dp[graph.get(now).get(i)] = dp[now] + nodes[graph.get(now).get(i)];
                    }
                    indegree[graph.get(now).get(i)]--;
                    if(indegree[graph.get(now).get(i)] == 0){
                        queue.add(graph.get(now).get(i));
                    }
                }
            }

            sb.append(dp[W]).append("\n");
        }

        System.out.println(sb);
    }

}
