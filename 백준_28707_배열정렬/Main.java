package 백준_28707_배열정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] input = new int[N];
        for(int i = 0; i < N; i++){
            input[i] = Integer.parseInt(st.nextToken()) - 1;
        }
        String start = "";
        for(int i = 0; i < N; i++){
            start += input[i];
        }

        Arrays.sort(input);
        String end = "";
        for(int i = 0; i < N; i++){
            end += input[i];
        }

        int M = Integer.parseInt(br.readLine());
        int[][] lines = new int[M][3];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            lines[i][0] = s;
            lines[i][1] = e;
            lines[i][2] = c;
        }

        Map<String, Integer> dist = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        dist.put(start, 0);

        int min = Integer.MAX_VALUE;
        char[] temp = new char[N + 1];
        while (!queue.isEmpty()){
            String now = queue.poll();

            for(int i = 0; i < N; i++){
                temp[i+1] = now.charAt(i);
            }

            if(end.equals(now)){
                min = Math.min(min, dist.get(now));
                continue;
            }

            for(int i = 0; i < M; i++){
                String next = "";
                for(int j = 1; j <= N; j++){
                    if(j == lines[i][0]){
                        next += temp[lines[i][1]];
                    }else if(j == lines[i][1]){
                        next += temp[lines[i][0]];
                    }else{
                        next += temp[j];
                    }
                }

                if(dist.containsKey(next)){
                    if(dist.get(next) > dist.get(now) + lines[i][2]){
                        dist.put(next, dist.get(now) + lines[i][2]);
                        queue.add(next);
                    }
                }else{
                    dist.put(next, dist.get(now) + lines[i][2]);
                    queue.add(next);
                }
            }
        }

        if(min == Integer.MAX_VALUE){
            sb.append(-1).append("\n");
        }else{
            sb.append(min).append("\n");
        }

        System.out.println(sb);
    }
}
