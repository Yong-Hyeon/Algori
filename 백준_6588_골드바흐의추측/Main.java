package 백준_6588_골드바흐의추측;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; ;i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                break;
            }
            list.add(num);
        }

        boolean[] isPrime = new boolean[1000001];
        List<Integer> primeList = new ArrayList<>();
        for(int i = 2; i < 1000001; i++){
            if(isPrime[i]){
                continue;
            }
            primeList.add(i);
            for(int j = 2; j < 500000; j++){
                if(i * j > 1000000){
                    break;
                }
                isPrime[i*j] = true;
            }
        }

        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < primeList.size(); j++){
                int b = list.get(i) - primeList.get(j);
                if(!isPrime[b]){
                    sb.append(list.get(i)).append(" = ").append(primeList.get(j)).append(" + ").append(b).append("\n");
                    break;
                }
                if(list.get(i) < primeList.get(j)){
                    sb.append("Goldbach's conjecture is wrong.\n");
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}
