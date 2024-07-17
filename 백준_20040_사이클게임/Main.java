package 백준_20040_사이클게임;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] parent = new int[N];
        for(int i = 0; i < N; i++){
            parent[i] = i;
        }

        int result = 0;

        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int aParent = find(parent, a);
            int bParent = find(parent, b);
            if(aParent != bParent){
                union(parent, aParent, bParent);
            }else{
                result = i;
                break;
            }
        }

        sb.append(result).append("\n");
        System.out.println(sb);
    }

    private static void union(int[] parent, int aParent, int bParent) {
        if(aParent < bParent){
            parent[bParent] = aParent;
        }else{
            parent[aParent] = bParent;
        }
    }

    private static int find(int[] parent, int a) {
        if(parent[a] == a){
            return a;
        }
        return parent[a] = find(parent,parent[a]);
    }
}
