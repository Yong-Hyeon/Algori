package 백준_2357_최솟값과최댓값;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int max;
    static int min;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] input = new int[N+1];
        for(int i = 1; i <= N; i++){
            input[i] = Integer.parseInt(br.readLine());
        }

        int[][] segmentTree = new int[4*N][2];
        init(input, segmentTree, 1, 1, N);

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            max = 0;
            min = 1000000001;
            search(segmentTree, 1, 1, N, a, b);

            sb.append(min).append(" ").append(max).append("\n");
        }

        System.out.println(sb);
    }

    private static void search(int[][] segmentTree, int node, int left, int right, int start, int end) {
        if(start > right || end < left){
            return;
        }

        if(left == right){
            max = Math.max(max, segmentTree[node][0]);
            min = Math.min(min, segmentTree[node][1]);
            return;
        }

        if(start <= left && end >= right){
            max = Math.max(max, segmentTree[node][0]);
            min = Math.min(min, segmentTree[node][1]);
            return;
        }
        int mid = (left + right) / 2;
        search(segmentTree, node * 2, left, mid, start, end);
        search(segmentTree, node * 2 + 1, mid + 1, right, start, end);
    }
    private static void init(int[] input, int[][] segmentTree, int node, int left, int right) {
        if(left == right){
            segmentTree[node][0] = input[left];
            segmentTree[node][1] = input[left];
            return;
        }
        int mid = (left + right) / 2;
        init(input, segmentTree, node * 2, left, mid);
        init(input, segmentTree, node * 2 + 1, mid + 1, right);

        segmentTree[node][0] = Math.max(segmentTree[node * 2][0], segmentTree[node * 2 + 1][0]);
        segmentTree[node][1] = Math.min(segmentTree[node * 2][1], segmentTree[node * 2 + 1][1]);
    }
}
