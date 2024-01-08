import java.io.*;
import java.util.*;

public class Floyd_Warshall_BFS {

    static Map<Integer, ArrayList<Integer>> adjacencyList = new HashMap();
    static int V;
    static int E;
    static int start;
    static int end;
    static boolean[] visited;
    static int[] ans;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        visited = new boolean[V + 1];
        ans = new int[V + 1];
        for (int i = 0; i < V + 1; i++) {
            ans[i] = -1;
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        E = Integer.parseInt(br.readLine());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            adjacencyList.putIfAbsent(v1, new ArrayList<>());
            adjacencyList.putIfAbsent(v2, new ArrayList<>());
            adjacencyList.get(v1).add(v2);
            adjacencyList.get(v2).add(v1);
        }

        //System.out.println(adjacencyList.toString());
        BFS();
    }

    private static void BFS() {

        ans[start] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {

            int currentNode = q.poll();
            if (currentNode == end) break;
            List<Integer> adjacentNodes = adjacencyList.get(currentNode);

            for (int x : adjacentNodes) {
                if (visited[x] == false) {
                    visited[x] = true;
                    q.add(x);
                    ans[x] = ans[currentNode] + 1;
                }
            }
        }

        System.out.println(ans[end]);
    }

}
