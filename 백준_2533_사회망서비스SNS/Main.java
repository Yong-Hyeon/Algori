package 백준_2533_사회망서비스SNS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        int[][] dp = new int[N+1][2];

        dfs(dp, graph, 1, new boolean[N+1]);

        sb.append(Math.min(dp[1][0], dp[1][1])).append("\n");

        System.out.print(sb);
    }

    private static void dfs(int[][] dp, List<List<Integer>> graph, int node, boolean[] isVisited) {
        isVisited[node] = true;
        dp[node][1] = 1;

        int size = graph.get(node).size();
        for(int i = 0; i < size; i++){
            if(isVisited[graph.get(node).get(i)]){
                continue;
            }
            dfs(dp, graph, graph.get(node).get(i), isVisited);
            dp[node][0] += dp[graph.get(node).get(i)][1];
            dp[node][1] += Math.min(dp[graph.get(node).get(i)][1], dp[graph.get(node).get(i)][0]);
        }

    }
}