package 백준_30805_사전순최대공통부분수열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> result = new ArrayList<>();
        boolean isEnd = false;
        int max = 0;
        int aMaxIdx = -1;
        int bMaxIdx = -1;

        while (!isEnd){
            isEnd = true;
            max = 0;
            int temp = bMaxIdx;
            for(int i = aMaxIdx + 1; i < N; i++){
                for(int j = temp + 1; j < M; j++){
                    if(A[i] == B[j]){
                        if(max < B[j]){
                            max = B[j];
                            aMaxIdx = i;
                            bMaxIdx = j;
                            isEnd = false;
                            break;
                        }
                    }
                }
            }
            if(max > 0){
                result.add(max);
            }
        }

        int size = result.size();
        sb.append(size).append("\n");
        for(int i = 0; i < size; i++){
            sb.append(result.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}
