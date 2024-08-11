package 백준_2263_트리의순회;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] inOderIdx = new int[N+1];
        int[] postOder = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            inOderIdx[num] = i;
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            postOder[i] = Integer.parseInt(st.nextToken());
        }

        search(inOderIdx, 0, N - 1, postOder, 0, N - 1, sb);

        System.out.println(sb);
    }

    private static void search(int[] inOderIdx, int inStart, int inEnd, int[] postOder, int postStart, int postEnd, StringBuilder sb) {
        if(inStart > inEnd || postStart > postEnd){
            return;
        }

        int root = postOder[postEnd];
        sb.append(root).append(" ");

        int rootIdx = inOderIdx[root];

        search(inOderIdx, inStart, rootIdx - 1, postOder, postStart, postStart + rootIdx - inStart - 1, sb);
        search(inOderIdx, rootIdx + 1, inEnd, postOder, postStart + rootIdx - inStart, postEnd - 1, sb);
    }
}
