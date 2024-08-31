package 백준_14725_개미굴;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node{
        List<String> nodes;
        Map<String, Node> child;

        public Node(){
            nodes = new ArrayList<>();
            child = new HashMap<>();
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        Node root = new Node();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            makeTree(K, st, root, 0);
        }

        search(root, sb, 0, "--");

        System.out.println(sb);
    }

    private static void search(Node now, StringBuilder sb, int cnt, String mark) {
        Collections.sort(now.nodes);
        int size = now.nodes.size();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < cnt; j++){
                sb.append(mark);
            }
            sb.append(now.nodes.get(i)).append("\n");
            search(now.child.get(now.nodes.get(i)), sb, cnt + 1, mark);
        }
    }

    private static void makeTree(int K, StringTokenizer st, Node parent, int cnt) {
        if(cnt == K){
            return;
        }

        String now = st.nextToken();
        Node child;
        if(parent.child.containsKey(now)){
            child = parent.child.get(now);
        }else{
            child = new Node();
            parent.nodes.add(now);
            parent.child.put(now, child);
        }

        makeTree(K, st, child, cnt + 1);
    }
}
