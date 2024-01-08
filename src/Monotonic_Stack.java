import java.io.*;
import java.util.*;

public class Monotonic_Stack {

    //solution adapted from https://steady-coding.tistory.com/15
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Stack<Top> s = new Stack<>();

        for (int i = 1; i <= n; i++) {
            int x = Integer.parseInt(st.nextToken());

            while (true) {
                if (s.isEmpty()) {
                    sb.append("0 ");
                    s.push(new Top(x, i));
                    break;
                }

                Top top = s.peek();

                if (top.height > x) {
                    sb.append(top.num + " ");
                    s.push(new Top(x, i));
                    break;
                }
                else s.pop();
            }

        }

        System.out.println(sb.toString().trim());
    }
}

class Top {
    int num;
    int height;

    Top (int height, int num) {
        this.num = num;
        this.height = height;
    }
}