package 백준_1264_모음의개수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] a=new boolean['z'+1];
        a['a'] = a['e'] = a['i'] = a['o'] = a['u'] = a['A'] = a['E'] = a['I'] = a['O'] = a['U'] = true;
        while (true){
            String str = br.readLine();
            if("#".equals(str)){
                break;
            }
            int size = str.length();
            int cnt = 0;
            for(int i = 0; i < size; i++){
                if(a[str.charAt(i)]){
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
