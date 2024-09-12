package 백준_11505_구간곱구하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final long mod = 1000000007;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] input = new long[N+1];
        for(int i = 1; i <= N; i++){
            input[i] = Long.parseLong(br.readLine());
        }

        long[] segmentTree = new long[4*N];
        init(input, segmentTree, 1, 1, N);

        for(int i = 0; i < M + K; i++){
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1){
                update(input, segmentTree, 1, 1, N, (int)b, c);
            }else{
                sb.append(search(segmentTree, 1, 1, N, (int)b, (int)c)).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static long search(long[] segmentTree, int node, int left, int right, int start, int end) {
        if(start > right || end < left){
            return 1L;
        }

        if(left == right){
            return segmentTree[node];
        }

        if(start <= left && end >= right){
            return segmentTree[node];
        }
        int mid = (left + right) / 2;
        return (search(segmentTree, node * 2, left, mid, start, end) * search(segmentTree, node * 2 + 1, mid + 1, right, start, end)) % mod;
    }

    private static void update(long[] input, long[] segmentTree, int node, int left, int right, int target, long change) {
        if(left > target || right < target){
            return;
        }

        if(left == right){
            input[left] = change;
            segmentTree[node] = change;
            return;
        }

        int mid = (left + right) / 2;
        update(input, segmentTree, node * 2, left, mid, target, change);
        update(input, segmentTree, node * 2 + 1, mid + 1, right, target, change);

        segmentTree[node] = (segmentTree[node * 2] * segmentTree[node * 2 + 1]) % mod;
    }

    private static long init(long[] input, long[] segmentTree, int node, int left, int right) {
        if(left == right){
            segmentTree[node] = input[left];
            return segmentTree[node];
        }
        int mid = (left + right) / 2;
        segmentTree[node * 2] = init(input, segmentTree, node * 2, left, mid);
        segmentTree[node * 2 + 1] = init(input, segmentTree, node * 2 + 1, mid + 1, right);

        return segmentTree[node] = (segmentTree[node * 2] * segmentTree[node * 2 + 1]) % mod;
    }
}
