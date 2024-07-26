package 백준_20303_할로윈의양아치;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Friendship{
        int cnt;
        int candies;

        public Friendship(int cnt, int candies){
            this.cnt = cnt;
            this.candies = candies;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] kids = new int[N + 1];
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(new ArrayList<>());

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            graph.add(new ArrayList<>());
            kids[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        List<Friendship> list = new ArrayList<>();

        boolean[] isVisited = new boolean[N+1];
        for(int i = 1; i <= N; i++){
            if(isVisited[i]){
                continue;
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            isVisited[i] = true;
            int sum = kids[i];
            int cnt = 1;
            while (!queue.isEmpty()){
                int now = queue.poll();

                int size = graph.get(now).size();
                for(int j = 0; j < size; j++){
                    if(isVisited[graph.get(now).get(j)]){
                        continue;
                    }
                    queue.add(graph.get(now).get(j));
                    isVisited[graph.get(now).get(j)] = true;
                    sum += kids[graph.get(now).get(j)];
                    cnt++;
                }
            }
            list.add(new Friendship(cnt, sum));
        }

        int[] dp = new int[K+1];

        int size = list.size();

        for(int i = 0; i < size; i++){
            int nowCnt = list.get(i).cnt;
            int nowCandies = list.get(i).candies;

            for(int k = K - nowCnt; k >= 0; k--){
                if(dp[k + nowCnt] < dp[k] + nowCandies){
                    dp[k + nowCnt] = dp[k] + nowCandies;
                }
            }
        }

        sb.append(dp[K-1]).append("\n");
        System.out.println(sb);
    }
}
