package 백준_2143_두배열의합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        long[] A = new long[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Long.parseLong(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        long[] B = new long[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            B[i] = Long.parseLong(st.nextToken());
        }

        result = 0;

        int aSize = N * (N + 1) / 2;
        int bSize = M * (M + 1) / 2;
        long[] aSum = new long[aSize];
        long[] bSum = new long[bSize];

        int idx = 0;
        for(int i = 0; i < N; i++){
            long sum = 0;
            for(int j = i; j < N; j++){
                sum += A[j];
                aSum[idx++] = sum;
            }
        }

        idx = 0;
        for(int i = 0; i < M; i++){
            long sum = 0;
            for(int j = i; j < M; j++){
                sum += B[j];
                bSum[idx++] = sum;
            }
        }

        Arrays.sort(aSum);
        Arrays.sort(bSum);

        int i = 0;
        int j = bSize - 1;
        long sum = 0;
        long result = 0;
        while (i < aSize && j >= 0){
            long a = aSum[i];
            long b = bSum[j];
            sum = a + b;
            if(sum == T) {
                long ac = 0;
                long bc = 0;

                while (i < aSize && a == aSum[i]){
                    ac++;
                    i++;
                }

                while (j >= 0 && b == bSum[j]){
                    bc++;
                    j--;
                }

                result += ac * bc;
            }else if(sum < T){
                i++;
            }else{
                j--;
            }
        }

        sb.append(result).append("\n");
        System.out.println(sb);
    }
}
