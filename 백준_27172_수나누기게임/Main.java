package 백준_27172_수나누기게임;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            input[i] = num;
            map.put(num, 0);
        }

        int[] check = new int[1000001];

        for(int i = 0; i < N; i++){
            int num = input[i] * 2;
            int cnt = 2;
            while (num < 1000001){
                if(map.containsKey(num)){
                    map.put(input[i], map.get(input[i]) + 1);
                }
                check[num]++;
                cnt++;
                num = input[i] * cnt;
            }
        }

        for(int i = 0; i < N; i++){
            sb.append(map.get(input[i]) - check[input[i]]).append(" ");
        }

        System.out.println(sb);
    }
}
