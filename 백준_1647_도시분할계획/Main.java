package 백준_1647_도시분할계획;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Line implements Comparable<Line>{
        int start;
        int end;
        int weight;

        public Line(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Line o){
            return this.weight - o.weight;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Line[] lines = new Line[M];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            lines[i] = new Line(s,e,w);
        }

        int[] parent = new int[N+1];
        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }

        Arrays.sort(lines);

        int cnt = 0;
        int sum = 0;

        for(int i = 0; i < M; i++){
            if(cnt == N - 2){
                break;
            }
            int a = find(parent, lines[i].start);
            int b = find(parent, lines[i].end);
            if(a != b){
                cnt++;
                sum += lines[i].weight;
                union(parent, a, b);
            }
        }

        sb.append(sum).append("\n");

        System.out.println(sb);
    }

    static int find(int[] parent, int node){
        if(parent[node] == node){
            return node;
        }
        return parent[node] = find(parent, parent[node]);
    }

    static void union(int[] parent, int a, int b){
        int aParent = find(parent, a);
        int bParent = find(parent, b);

        if(aParent < bParent){
            parent[bParent] = aParent;
        }else{
            parent[aParent] = bParent;
        }
    }
}
