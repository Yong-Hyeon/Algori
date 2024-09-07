package 백준_15824_너봄에는캡사이신이맛있단다;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static final int mod = 1000000007;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        long[] input = new long[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            input[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(input);

        long sum = 0;
        Map<Integer, Long> map = new HashMap<>();
        map.put(0, 1l);
        for(int i = 0; i < N; i++){
            sum += input[i] * pow(i, map);
            sum -= input[i] * pow(N - 1 - i, map);
            sum = sum % mod;
        }

        sum = (sum + mod) % mod;
        sb.append(sum).append("\n");
        System.out.println(sb);
    }

    private static long pow(int cnt, Map<Integer, Long> map) {
        if(map.containsKey(cnt)){
            return map.get(cnt);
        }
        if(cnt == 1){
            return 2;
        }
        long pow = pow(cnt / 2, map);
        pow = pow * pow % mod;
        if(cnt % 2 == 1){
            pow = pow * 2 % mod;
        }
        map.put(cnt, pow);

        return pow;
    }
}
