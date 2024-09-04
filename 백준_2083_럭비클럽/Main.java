package 백준_2083_럭비클럽;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        while (true){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();

            if("#".equals(name)){
                break;
            }

            int age = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if(age > 17 || weight >= 80){
                sb.append(name).append(" ").append("Senior").append("\n");
            }else{
                sb.append(name).append(" ").append("Junior").append("\n");
            }

        }

        System.out.println(sb);
    }
}
