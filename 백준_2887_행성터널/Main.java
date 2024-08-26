package 백준_2887_행성터널;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Line implements Comparable<Line>{
        int s;
        int e;
        int c;

        public Line(int s, int e, int c){
            this.s = s;
            this.e = e;
            this.c = c;
        }

        @Override
        public int compareTo(Line o){
            return this.c - o.c;
        }

        @Override
        public String toString() {
            return "Line{" +
                    "s=" + s +
                    ", e=" + e +
                    ", c=" + c +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        int[] parent = new int[N+1];
        int[][] inputs = new int[N][4];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            parent[i] = i;
            inputs[i-1][0] = i;
            for(int j = 1; j < 4; j++){
                inputs[i-1][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<Line> lines = new ArrayList<>();

        Arrays.sort(inputs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for(int i = 1; i < N; i++){
            lines.add(new Line(inputs[i-1][0], inputs[i][0], inputs[i][1] - inputs[i-1][1]));
        }

        Arrays.sort(inputs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        for(int i = 1; i < N; i++){
            lines.add(new Line(inputs[i-1][0], inputs[i][0], inputs[i][2] - inputs[i-1][2]));
        }

        Arrays.sort(inputs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[3] - o2[3];
            }
        });
        for(int i = 1; i < N; i++){
            lines.add(new Line(inputs[i-1][0], inputs[i][0], inputs[i][3] - inputs[i-1][3]));
        }

        Collections.sort(lines);

        int size = lines.size();
        int a,b;
        int dist = 0;
        for(int i = 0; i < size; i++){
            a = find(parent, lines.get(i).s);
            b = find(parent, lines.get(i).e);

            if(a != b){
                union(a, b, parent);
                dist += lines.get(i).c;
            }

        }

        sb.append(dist).append("\n");
        System.out.println(sb);
    }

    private static void union(int a, int b, int[] parent) {
        int max,min;
        if(a > b){
            max = a;
            min = b;
        }else{
            max = b;
            min = a;
        }

        parent[max] = min;
    }

    private static int find(int[] parent, int node) {
        if(parent[node] == node){
            return node;
        }

        return parent[node] = find(parent, parent[node]);
    }
}
