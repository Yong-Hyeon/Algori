package 백준_6996_애너그램;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String oStr1 = st.nextToken();
            String oStr2 = st.nextToken();
            char[] charArr1 = oStr1.toCharArray();
            char[] charArr2 = oStr2.toCharArray();
            Arrays.sort(charArr1);
            Arrays.sort(charArr2);
            String str1 = new String(charArr1);
            String str2 = new String(charArr2);
            if(str1.equals(str2)){
                sb.append(oStr1).append(" & ").append(oStr2).append(" are ").append("anagrams.").append("\n");
            }else{
                sb.append(oStr1).append(" & ").append(oStr2).append(" are ").append("NOT anagrams.").append("\n");
            }
        }

        System.out.println(sb);
    }
}
