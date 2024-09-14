package 백준_14428_수열과쿼리16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int idx;
    static int min;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] input = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        int[][] segmentTree = new int[4*N][2];
        init(input, segmentTree, 1, 1, N);

        int M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(num == 1){
                update(input, segmentTree, 1, 1, N, a, b);
            }else{
                idx = 0;
                min = 1000000001;
                search(segmentTree, 1, 1, N, a, b);
                sb.append(idx).append("\n");
            }

        }

        System.out.println(sb);
    }

    private static void update(int[] input, int[][] segmentTree, int node, int left, int right, int target, int change) {
        if(left > target || right < target){
            return;
        }

        if(left == right){
            input[left] = change;
            segmentTree[node][0] = change;
            return;
        }

        int mid = (left + right) / 2;
        update(input, segmentTree, node * 2, left, mid, target, change);
        update(input, segmentTree, node * 2 + 1, mid + 1, right, target, change);

        if(segmentTree[node * 2][0] > segmentTree[node * 2 + 1][0]){
            segmentTree[node][0] = segmentTree[node * 2 + 1][0];
            segmentTree[node][1] = segmentTree[node * 2 + 1][1];
        }else if(segmentTree[node * 2][0] < segmentTree[node * 2 + 1][0]){
            segmentTree[node][0] = segmentTree[node * 2][0];
            segmentTree[node][1] = segmentTree[node * 2][1];
        }else if(segmentTree[node * 2][0] == segmentTree[node * 2 + 1][0]){
            segmentTree[node][0] = segmentTree[node * 2][0];
            if(segmentTree[node * 2][1] > segmentTree[node * 2 + 1][1]){
                segmentTree[node][1] = segmentTree[node * 2 + 1][1];
            }else{
                segmentTree[node][1] = segmentTree[node * 2][1];
            }
        }

    }

    private static void search(int[][] segmentTree, int node, int left, int right, int start, int end) {
        if(start > right || end < left){
            return;
        }

        if(left == right){
            if(min > segmentTree[node][0]){
                min = segmentTree[node][0];
                idx = left;
            }else if(min == segmentTree[node][0]){
                if(idx > left){
                    idx = left;
                }
            }
            return;
        }

        if(start <= left && end >= right){
            if(min > segmentTree[node][0]){
                min = segmentTree[node][0];
                idx = segmentTree[node][1];
            }else if(min == segmentTree[node][0]){
                if(idx > segmentTree[node][1]){
                    idx = segmentTree[node][1];
                }
            }
            return;
        }
        int mid = (left + right) / 2;
        search(segmentTree, node * 2, left, mid, start, end);
        search(segmentTree, node * 2 + 1, mid + 1, right, start, end);
    }
    private static void init(int[] input, int[][] segmentTree, int node, int left, int right) {
        if(left == right){
            segmentTree[node][0] = input[left];
            segmentTree[node][1] = left;
            return;
        }
        int mid = (left + right) / 2;
        init(input, segmentTree, node * 2, left, mid);
        init(input, segmentTree, node * 2 + 1, mid + 1, right);

        if(segmentTree[node * 2][0] > segmentTree[node * 2 + 1][0]){
            segmentTree[node][0] = segmentTree[node * 2 + 1][0];
            segmentTree[node][1] = segmentTree[node * 2 + 1][1];
        }else if(segmentTree[node * 2][0] < segmentTree[node * 2 + 1][0]){
            segmentTree[node][0] = segmentTree[node * 2][0];
            segmentTree[node][1] = segmentTree[node * 2][1];
        }else if(segmentTree[node * 2][0] == segmentTree[node * 2 + 1][0]){
            segmentTree[node][0] = segmentTree[node * 2][0];
            if(segmentTree[node * 2][1] > segmentTree[node * 2 + 1][1]){
                segmentTree[node][1] = segmentTree[node * 2 + 1][1];
            }else{
                segmentTree[node][1] = segmentTree[node * 2][1];
            }
        }
    }
}
