package 백준_1167_트리의지름;

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
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        List<List<Node>> graph = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            while (true){
                int num = Integer.parseInt(st.nextToken());
                if(num == -1){
                    break;
                }
                int dist = Integer.parseInt(st.nextToken());
                graph.get(now).add(new Node(num, dist));
            }
        }

        int result = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 0));
        boolean[] isVisited = null;

//        for(int j = 1; j <= N; j++){
//            int maxIdx = 0;
//            int max = 0;
//            isVisited = new boolean[N+1];
//            queue.add(new Node(j, 0));
//            isVisited[j] = true;
//            while (!queue.isEmpty()){
//                Node now = queue.poll();
//
//                int size = graph.get(now.no).size();
//                for(int i = 0; i < size; i++){
//                    if(isVisited[graph.get(now.no).get(i).no]){
//                        continue;
//                    }
//                    int dist = now.dist + graph.get(now.no).get(i).dist;
//                    if(max < dist){
//                        max = dist;
//                        maxIdx = graph.get(now.no).get(i).no;
//                    }
//                    queue.add(new Node(graph.get(now.no).get(i).no, dist));
//                    isVisited[graph.get(now.no).get(i).no] = true;
//                }
//            }
//            if(result < max){
//                result = max;
//            }
//        }
        while (true){
            int maxIdx = 0;
            int max = 0;
            isVisited = new boolean[N+1];
            isVisited[queue.peek().no] = true;
            while (!queue.isEmpty()){
                Node now = queue.poll();

                int size = graph.get(now.no).size();
                for(int i = 0; i < size; i++){
                    if(isVisited[graph.get(now.no).get(i).no]){
                        continue;
                    }
                    int dist = now.dist + graph.get(now.no).get(i).dist;
                    if(max < dist){
                        max = dist;
                        maxIdx = graph.get(now.no).get(i).no;
                    }
                    queue.add(new Node(graph.get(now.no).get(i).no, dist));
                    isVisited[graph.get(now.no).get(i).no] = true;
                }
            }
            if(result < max){
                result = max;
                queue.add(new Node(maxIdx, 0));
            }else{
                break;
            }
        }
        sb.append(result).append("\n");
        System.out.println(sb);
    }
}
