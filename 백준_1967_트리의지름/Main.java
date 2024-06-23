package 백준_1967_트리의지름;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node{
        int no;
        int dist;

        public Node(int no, int dist){
            this.no = no;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        List<List<Node>> graph = new ArrayList<>();

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end, w));
            graph.get(end).add(new Node(start, w));
        }

        boolean isEnd = false;
        int start = 1;
        int max = 0;
        int result = 0;
        while (!isEnd){
            Queue<Node> queue = new LinkedList<>();
            boolean[] isVisited = new boolean[N+1];
            queue.add(new Node(start, 0));
            isVisited[start] = true;

            while (!queue.isEmpty()){
                Node now = queue.poll();

                int size = graph.get(now.no).size();
                for(int i = 0; i < size; i++){
                    if(isVisited[graph.get(now.no).get(i).no]){
                        continue;
                    }
                    isVisited[graph.get(now.no).get(i).no] = true;
                    int newDist = now.dist + graph.get(now.no).get(i).dist;
                    queue.add(new Node(graph.get(now.no).get(i).no, newDist));
                    if(max < newDist){
                        max = newDist;
                        start = graph.get(now.no).get(i).no;
                    }
                }
            }
            if(result < max){
                result = max;
            }else{
                isEnd = true;
            }
        }
        sb.append(result).append("\n");

        System.out.println(sb);

    }
}
