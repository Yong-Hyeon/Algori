package 백준_11444_피보나치수6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long N = Long.parseLong(br.readLine());
        long mod = 1000000007l;

        Map<Long, Long> map = new HashMap<>();

        map.put(0l, 0l);
        map.put(1l, 1l);
        map.put(2l, 1l);


        for(long i = 3; i < 11; i++){
            map.put(i, map.get(i - 1) + map.get(i - 2));
        }


        for(long i = 8l; i < N; i = i * 2){
            map.put(i * 2 - 1, (((map.get(i-1) * map.get(i-1)) % mod) + ((map.get(i) * map.get(i)) % mod) % mod));
            map.put(i * 2, (((map.get(i-1) * map.get(i)) % mod) + ((map.get(i) * map.get(i + 1)) % mod) % mod));
            map.put(i * 2 + 1, (((map.get(i) * map.get(i)) % mod) + ((map.get(i+1) * map.get(i + 1)) % mod) % mod));
        }

        long result = 0;
        long check = 1l << 59;

        while (check  > 0){
            if((N & check) > 0){
                if(result > check){
                    map.put(result + check - 1, (((map.get(check - 1) * map.get(result - 1)) % mod) + ((map.get(check) * map.get(result)) % mod)) % mod);
                    map.put(result + check, (((map.get(check - 1) * map.get(result)) % mod) + ((map.get(check) * map.get(result + 1)) % mod)) % mod);
                    map.put(result + check + 1, (((map.get(check) * map.get(result)) % mod) + ((map.get(check + 1) * map.get(result + 1)) % mod)) % mod);
                }
                result += check;
            }
            check = check >> 1;
        }

        sb.append(map.get(N)).append("\n");

        System.out.println(sb);
    }
}
