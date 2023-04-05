package 백준_1707_이분그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int num;
        int divide;
        // 0,1 로 나누고 2는 초기 상태

        public Node(int num, int divide) {
            this.num = num;
            this.divide = divide;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < K; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            List<Node> nodes = new ArrayList<>();
            List<List<Integer>> list = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                list.add(new ArrayList<>());
                nodes.add(new Node(i, 2));
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                list.get(from).add(to);
                list.get(to).add(from);
            }

            boolean[] isVisited = new boolean[V + 1];
            Queue<Node> queue = new LinkedList<>();
            boolean isEnd = false;
            boolean result = true;

            for (int i = 1; i <= V; i++) {

                Node node = nodes.get(i);
                if(node.divide != 2){
                    continue;
                }
                node.divide = 0;
                queue.add(nodes.get(i));
                while (!queue.isEmpty()) {
                    Node now = queue.poll();

                    for (int j = 0; j < list.get(now.num).size(); j++) {
                        Node temp = nodes.get(list.get(now.num).get(j));
                        if (temp.divide == 2) {
                            temp.divide = (now.divide + 1) % 2;
                            queue.add(temp);
                        } else {
                            if (now.divide == temp.divide) {
                                isEnd = true;
                                result = false;
                                break;
                            }
                        }
                    }
                    if (isEnd) {
                        break;
                    }
                }
                if (isEnd) {
                    break;
                }
            }

            if (result) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        System.out.println(sb);
    }
}
