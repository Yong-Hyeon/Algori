package 백준_11689_GCDnk는1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long N = Long.parseLong(br.readLine());

        sb.append(gcp(N));

        System.out.println(sb);
    }

    private static long gcp(long N) {
        Map<Long, Boolean> primes = new HashMap<>();
        List<Long> list = new ArrayList<>();

        boolean isPrime = true;

        long num = N;
        for(long i = 2; i * i <= num; i++){
            if(N == 1){
                break;
            }
            if(N % i == 0){
                isPrime = false;
                if(!primes.containsKey(i)){
                    primes.put(i, true);
                    list.add(i);
                }
                N = N / i;
                i = 1;
            }
        }
        if(isPrime){
            if(num == 1){
                return num;
            }
            return num - 1;
        }else{
            if(N != 1){
                list.add(N);
            }
            long cnt = num;

            for(int i = 0; i < list.size(); i++){
                cnt = cnt / list.get(i) * (list.get(i) - 1);
            }

            return cnt;
        }
    }
}
