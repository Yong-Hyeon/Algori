package 백준_1991_트리순회;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        Map<Character, char[]> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken().charAt(0), new char[]{st.nextToken().charAt(0), st.nextToken().charAt(0)});
        }

        pre(map, 'A', sb);
        sb.append("\n");
        in(map, 'A', sb);
        sb.append("\n");
        post(map, 'A', sb);
        sb.append("\n");

        System.out.println(sb);
    }

    private static void post(Map<Character, char[]> map, char node, StringBuilder sb) {
        char[] now = map.get(node);

        if (now[0] != '.') {
            post(map, now[0], sb);
        }
        if (now[1] != '.') {
            post(map, now[1], sb);
        }
        sb.append(node);
    }

    private static void in(Map<Character, char[]> map, char node, StringBuilder sb) {
        char[] now = map.get(node);

        if (now[0] != '.') {
            in(map, now[0], sb);
        }
        sb.append(node);
        if (now[1] != '.') {
            in(map, now[1], sb);
        }
    }

    private static void pre(Map<Character, char[]> map, char node, StringBuilder sb) {
        char[] now = map.get(node);
        sb.append(node);
        if (now[0] != '.') {
            pre(map, now[0], sb);
        }
        if (now[1] != '.') {
            pre(map, now[1], sb);
        }

    }
}
