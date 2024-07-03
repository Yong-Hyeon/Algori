package 백준_11725_트리의부모찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }
        int[] parent = new int[N+1];

        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.get(s).add(e);
            list.get(e).add(s);
        }

        boolean[] isVisited = new boolean[N+1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        isVisited[1] = true;

        while (!queue.isEmpty()){
            int now = queue.poll();

            int size = list.get(now).size();
            for(int i = 0; i < size; i++){
                if(isVisited[list.get(now).get(i)]){
                    continue;
                }
                queue.add(list.get(now).get(i));
                isVisited[list.get(now).get(i)] = true;
                parent[list.get(now).get(i)] = now;
            }
        }

        for(int i = 2; i <= N; i++){
            sb.append(parent[i]).append("\n");
        }

        System.out.println(sb);
    }
}
