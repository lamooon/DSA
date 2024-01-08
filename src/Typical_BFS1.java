import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Typical_BFS1 {

    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int n;
    static ArrayList<Integer> sizeOfLand = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                int x = str.charAt(j) - '0';
                grid[i][j] = x;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == false && grid[i][j] == 1) {
                    int count = BFS(i, j);
                    sizeOfLand.add(count);
                }
            }
        }

        Collections.sort(sizeOfLand);
        System.out.println(sizeOfLand.size());
        for (int i : sizeOfLand) {
            System.out.println(i);
        }
    }

    private static int BFS(int x, int y) {

        Queue<int []> q = new LinkedList<>();
        q.add(new int[] {x, y});

        visited[x][y] = true;
        int count = 0;
        while (!q.isEmpty()) {

            int[] current = q.poll();
            int currentX = current[0];
            int currentY = current[1];
            count++;
            for (int i = 0; i < 4; i++) {

                int nX = currentX + dx[i];
                int nY = currentY + dy[i];

                if (nX >= 0 && nX < n && nY >= 0 && nY < n) {
                    if (visited[nX][nY] == false && grid[nX][nY] == 1){
                        q.add(new int[] {nX, nY});
                        visited[nX][nY] = true;
                    }
                }
            }
        }

        return count;
    }

}
