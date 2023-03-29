package 백준_13023_ABCDE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean isEnd = false;
    static int result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list.get(from).add(to);
            list.get(to).add(from);
        }
        result = 0;

        for(int i = 0; i < N; i++){
            dfs(list, i, 0, new boolean[N]);
        }


        System.out.println(result);
    }
    static void dfs(List<List<Integer>> list, int now, int cnt, boolean[] isVisited){
        if(isEnd){
            return;
        }
        if (cnt == 4){
            isEnd = true;
            result = 1;
            return;
        }
        isVisited[now] = true;
        for(int k = 0; k < list.get(now).size(); k++){
            if(isVisited[list.get(now).get(k)]){
                continue;
            }
            isVisited[list.get(now).get(k)] = true;
            dfs(list, list.get(now).get(k), cnt + 1, isVisited);
            isVisited[list.get(now).get(k)] = false;
        }

    }
}
