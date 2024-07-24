package 백준_9466_텀프로젝트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static boolean isCycle;
    static int result;
    static int end;
    static Map<Integer, Boolean> nowCycle;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        int[] graph = new int[100001];
        boolean[] isVisited = new boolean[100001];
        boolean[] isCycles = new boolean[100001];
        nowCycle = new HashMap<>();
        for(int tc = 1; tc <= T; tc++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            result = 0;
            for(int i = 1; i <= N; i++){
                int num = Integer.parseInt(st.nextToken());
                isVisited[i] = false;
                isCycles[i] = false;
                graph[i] = num;
                if(num == i){
                    isVisited[i] = true;
                    isCycles[i] = true;
                    result++;
                }
            }

            for(int i = 1; i <= N; i++){
                isCycle = false;
                end = 0;
                nowCycle.clear();
                if(isCycles[i] || isVisited[i]){
                    continue;
                }
                search(i, i, graph, isVisited, isCycles);
                isVisited[i] = true;
            }
            result = N - result;
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
    private static void search(int start, int now, int[] graph, boolean[] isVisited, boolean[] isCycles) {
        if(isCycles[graph[now]] || isVisited[graph[now]]){
            return;
        }
        result++;
//        isVisited[now] = true;
        nowCycle.put(now, true);
        if(graph[now] == start || nowCycle.containsKey(graph[now])){
            isCycle = true;
            isCycles[now] = true;
            end = graph[now];
            return;
        }
        search(start, graph[now], graph, isVisited, isCycles);
        if(end != start && graph[now] == end){
            isCycle = false;
        }
        if(isCycle){
            isCycles[now] = true;
            return;
        }
        isVisited[now] = true;
        result--;
    }
}
