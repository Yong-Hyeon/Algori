package 백준_1543_문서검색;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String N = br.readLine();
        String M = br.readLine();

        int n = N.length();
        int m = M.length();

        int start = 0;
        int check = 0;
        int result = 0;

        while (start + check < n){
            if(check == m){
                start += check;
                check = 0;
                result++;
            }
            if(N.charAt(start+check) == M.charAt(check)){
                check++;
            }else{
                start++;
                check = 0;
            }
        }
        if(check == m){
            result++;
        }

        sb.append(result);
        System.out.println(sb);
    }
}
