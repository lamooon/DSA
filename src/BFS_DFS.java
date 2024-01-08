import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_DFS {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        boolean[][] adjMatrix = new boolean[n + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adjMatrix[x][y] = true;
            adjMatrix[y][x] = true;
        }
        DFS(start, adjMatrix, n);
        BFS(start, adjMatrix, n);
    }

    public static void DFS(int start, boolean[][] adjMatrix, int n) {

        StringBuilder dfs = new StringBuilder();
        boolean[] visited = new boolean[n + 1];

        DFSUtil(start, visited, adjMatrix, dfs);
        System.out.println(dfs.toString().trim());
    }

    public static void DFSUtil(int n, boolean[] visited, boolean[][] adjMatrix, StringBuilder dfs) {

        visited[n] = true;
        dfs.append(n + " ");
        for (int i = 1; i <= visited.length - 1; i++) {
            if (visited[i] == false && adjMatrix[n][i] == true) {
                DFSUtil(i, visited, adjMatrix, dfs);
            }
        }
    }


    public static void BFS(int start, boolean[][] adjMatrix, int n) {

        StringBuilder bfs = new StringBuilder();
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        int u;

        while (!q.isEmpty()) {
            u = q.poll();
            bfs.append(u + " ");
            for (int i = 1; i <= n; i++) {
                if (visited[i] == false && adjMatrix[u][i] == true) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }

        System.out.println(bfs.toString().trim());
    }

}