package 백준_1644_소수의연속합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[N+1];
        int cnt = 0;
        for(int i = 2; i <= N; i++){
            for(int j = 2; i * j <= N; j++){
                isPrime[i * j] = true;
                cnt++;
            }
        }

        List<Integer> primes = new ArrayList<>();
        primes.add(0);
        for(int i = 2; i <= N; i++){
            if(!isPrime[i]){
                primes.add(i);
            }
        }

        int i = 0;
        int j = 1;
        int size = primes.size();
        int sum = 0;
        int result = 0;
        while (j < size){
            if(sum > N){
                sum = sum - primes.get(i++);
            }else{
                if(sum == N){
                    result++;
                }
                sum = sum + primes.get(j++);
            }
        }
        if(primes.get(size-1) == N){
            result++;
        }

        sb.append(result);
        System.out.println(sb);
    }
}
