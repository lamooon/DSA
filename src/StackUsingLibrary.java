import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class StackUsingLibrary {

    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Stack<Integer> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            if (command == 1) {
                stack.push(Integer.parseInt(st.nextToken()));
            }

            else if (command == 2) {
                if (!stack.isEmpty())
                {
                    answer.append(stack.peek());
                    stack.pop();
                }
                else
                {
                    answer.append(-1);
                }
                answer.append(System.getProperty("line.separator"));
            }

            else if (command == 3) {
                answer.append(stack.size()).append(System.getProperty("line.separator"));
            }

            else if (command == 4) {
                if (stack.isEmpty()) answer.append(1);
                else answer.append(0);

                answer.append(System.getProperty("line.separator"));
            }

            else if (command == 5) {
                if (!stack.isEmpty()) {
                    answer.append(stack.peek());
                }
                else answer.append(-1);

                answer.append(System.getProperty("line.separator"));
            }

        }
        System.out.println(answer.toString().trim());
        br.close();
    }
}
