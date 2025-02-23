package 백준_7656_만능오라클;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = "";
        while (st.hasMoreTokens()) {
            String now = st.nextToken();
            if ("What".equals(now)) {
                str = "What";
            } else if ("is".equals(now)) {
                if ("What".equals(str)) {
                    str = "What is";
                }else{
                    str = str + " " + now;
                }
            } else {
                str = str + " " + now;
                if (str.charAt(str.length() - 1) == '?' && str.startsWith("What is")) {
                    sb.append("Forty-two").append(str, 4, str.length() - 1).append(".\n");
                }
            }
        }

        System.out.println(sb);
    }
}
