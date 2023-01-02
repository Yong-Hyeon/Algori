package 백준_1476_날짜계산;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 1;;i++){
            int modE = i % 15 == 0? 15:i % 15;
            int modS = i % 28 == 0? 28:i % 28;
            int modM = i % 19 == 0? 19:i % 19;

            if(E == modE && S == modS && M == modM){
                System.out.println(i);
                break;
            }
        }

    }
}