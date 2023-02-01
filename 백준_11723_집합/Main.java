package 백준_11723_집합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        boolean[] S = new boolean[21];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String oper = st.nextToken();


            if(oper.equals("all")){
                Arrays.fill(S, true);
                continue;
            }
            if(oper.equals("empty")){
                Arrays.fill(S, false);
                continue;
            }

            int num = Integer.parseInt(st.nextToken());
            if(oper.equals("add")){
                S[num] = true;
            }
            if(oper.equals("remove")){
                S[num] = false;
            }
            if(oper.equals("check")){
                if(S[num]){
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }
            if(oper.equals("toggle")){
                S[num] = !S[num];
            }

        }
        System.out.println(sb);

    }
}
