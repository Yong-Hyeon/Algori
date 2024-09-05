package 백준_4999_아;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int size1 = br.readLine().length();
        int size2 = br.readLine().length();

        if(size1 < size2){
            sb.append("no").append("\n");
        }else{
            sb.append("go").append("\n");
        }

        System.out.println(sb);
    }
}
