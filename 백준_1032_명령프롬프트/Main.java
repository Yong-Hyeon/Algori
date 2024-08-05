package 백준_1032_명령프롬프트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        String[] input = new String[N];
        for(int i = 0; i < N; i++){
            input[i] = br.readLine();
        }

        boolean isSame = true;
        int size = input[0].length();
        if(N == 1){
            sb.append(input[0]).append("\n");
        }else{
            for(int i = 0; i < size; i++){
                isSame = true;
                for(int j = 1; j < N; j++){
                    if(input[j].charAt(i) != input[j-1].charAt(i)){
                        isSame = false;
                        break;
                    }
                }
                if(isSame){
                    sb.append(input[0].charAt(i));
                }else{
                    sb.append("?");
                }
            }
        }


        System.out.println(sb);
    }

}
