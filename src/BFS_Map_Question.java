import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BFS_Map_Question {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        boolean[][] visited = new boolean[row][col];
        int[][] map = new int[row][col];

        for (int i = 0; i < row; i++) {
            String str = br.readLine();
            for (int j = 0; j < col; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        visited[0][0] = true;
        BFS(map, visited, 0, 0);
        System.out.println(map[row - 1][col - 1]);

        //for visualization of the BFS map
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(map[i][j] + "    ");
            }
            System.out.println();
        }
    }

    public static void BFS(int[][] map, boolean[][] visited, int x, int y) {

        Queue<int []> q = new LinkedList<>();
        q.add(new int[] {x, y});

        while (!q.isEmpty()) {

            int[] current = q.poll();
            int currentX = current[0];
            int currentY = current[1];

            for (int i = 0; i < 4; i++) {

                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if (nextX < 0 || nextX >= map.length || nextY < 0 || nextY >= map[0].length) continue;
                if (visited[nextX][nextY] == true) continue;
                if (map[nextX][nextY] == 0) continue;

                q.add(new int[] {nextX, nextY});
                map[nextX][nextY] = map[currentX][currentY] + 1;
                visited[nextX][nextY] = true;
            }
        }
    }

}
