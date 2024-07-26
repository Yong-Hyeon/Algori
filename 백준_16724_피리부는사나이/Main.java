package 백준_16724_피리부는사나이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[]graph = new int[N*M];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                char ch =  str.charAt(j);
                if(ch == 'U'){
                    graph[i * M + j] = (i - 1) * M + j;
                }else if(ch == 'D'){
                    graph[i * M + j] = (i + 1) * M + j;
                }else if(ch == 'L'){
                    graph[i * M + j] = i * M + j - 1;
                }else if(ch == 'R'){
                    graph[i * M + j] = i * M + j + 1;
                }
            }
        }

        boolean[] isEnd = new boolean[N*M];
        boolean[] isVisited = new boolean[N*M];

        result = 0;
        for(int i = 0; i < N * M; i++){
            if(isEnd[i]){
                continue;
            }
            search(graph, i, isEnd, isVisited);
        }

        sb.append(result).append("\n");
        System.out.println(sb);
    }

    private static void search(int[] graph, int now, boolean[] isEnd, boolean[] isVisited) {
        if(isVisited[now]){
            result++;
            return;
        }
        if(isEnd[now]){
            return;
        }
        isEnd[now] = true;
        isVisited[now] = true;
        search(graph, graph[now], isEnd, isVisited);
        isVisited[now] = false;
    }
}
