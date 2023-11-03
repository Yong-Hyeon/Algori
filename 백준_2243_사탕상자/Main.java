package 백준_2243_사탕상자;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int max = 1000001;
        int[] sumTree = new int[4 * max];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());

            if(A == 1){
                int B = Integer.parseInt(st.nextToken());

                int result = check(1, 1, max, B, sumTree);
                sb.append(result).append("\n");
            }else if(A == 2){
                int B = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());

                update(1, 1, max, B, C, sumTree);
            }
        }
        System.out.println(sb);
    }

    private static int check(int node, int left, int right, int value, int[] sumTree) {
        if(left == right){
            sumTree[node]--;
            return left;
        }
        sumTree[node]--;
        int mid = (left + right) / 2;

        if(sumTree[node * 2] >= value){
            return check(node * 2, left, mid, value, sumTree);
        }else{
            return check(node * 2 + 1, mid + 1, right, value - sumTree[node * 2], sumTree);
        }

    }

    private static void update(int node, int left, int right, int index, int value, int[] sumTree) {
        if(index < left || index > right){
            return;
        }

        if(left == right){
            sumTree[node] = sumTree[node] + value;
            return;
        }

        int mid = (left + right) / 2;

        update(node * 2, left, mid, index, value, sumTree);
        update(node * 2 + 1, mid + 1, right, index, value, sumTree);

        sumTree[node] = sumTree[node * 2] + sumTree[node * 2 + 1];
    }


}
