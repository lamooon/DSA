import java.io.*;
import java.util.*;
public class DequeUsingLibrary {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> d = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            switch (command) {

                case "1":
                    int numF = Integer.parseInt(st.nextToken());
                    d.addFirst(numF);
                    break;
                case "2":
                    int numL = Integer.parseInt(st.nextToken());
                    d.addLast(numL);
                    break;
                case "3":
                    if (d.isEmpty()) {
                        bw.write(String.valueOf(-1) + '\n');
                        break;
                    }
                    bw.write(String.valueOf(d.removeFirst()) + '\n');
                    break;
                case "4":
                    if (d.isEmpty()) {
                        bw.write(String.valueOf(-1) + '\n');
                        break;
                    }
                    bw.write(String.valueOf(d.removeLast()) + '\n');
                    break;
                case "5":
                    bw.write(String.valueOf(d.size()) + '\n');
                    break;
                case "6":
                    if (d.isEmpty()) {
                        bw.write(String.valueOf(1) +'\n');
                        break;
                    }
                    bw.write(String.valueOf(0) +'\n');
                    break;
                case "7":
                    if (d.isEmpty()) {
                        bw.write(String.valueOf(-1) + '\n');
                        break;
                    }
                    bw.write(String.valueOf(d.getFirst()) + '\n');
                    break;
                case "8":
                    if (d.isEmpty()) {
                        bw.write(String.valueOf(-1) + '\n');
                        break;
                    }
                    bw.write(String.valueOf(d.getLast()) + '\n');
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}