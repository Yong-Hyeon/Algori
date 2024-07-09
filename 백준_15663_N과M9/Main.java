package 백준_15663_N과M9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] input = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        Map<String, Boolean> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        Arrays.sort(input);

        combi(input, N, M, new boolean[N], new int[M], 0, map, list);

        for(int i = 0; i < list.size(); i++){
            sb.append(list.get(i)).append("\n");
        }


        System.out.println(sb);
    }

    private static void combi(int[] input, int N, int M, boolean[] isVisited, int[] select, int cnt, Map<String, Boolean> map, List<String> list) {
        if(cnt == M){
            String str = "";
            for(int i = 0; i < M; i++){
                str = str + input[select[i]] + " ";
            }
            if(!map.containsKey(str)) {
                map.put(str, true);
                list.add(str);
            }
            return;
        }

        for(int i = 0; i < N; i++){
            if(isVisited[i]){
                continue;
            }
            select[cnt] = i;
            isVisited[i] = true;
            combi(input, N, M, isVisited, select, cnt + 1, map, list);
            isVisited[i] = false;
        }
    }

}
