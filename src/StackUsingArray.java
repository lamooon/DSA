import java.io.*;
import java.util.StringTokenizer;

public class StackUsingArray {
    public static void main (String[] args) throws IOException
    {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] stack = new int[n];
        int top_pointer = 0;

        for (int i = 0; i < n; i++)
        {
            stack[i] = -1;
        }

        for (int i = 0; i < n; i++)
        {
            st = new StringTokenizer(br.readLine(), " ");
            int command = Integer.parseInt(st.nextToken());

            //equivalent to stack.push
            if (command == 1) {
                int x = Integer.parseInt(st.nextToken());
                stack[top_pointer] = x;
                top_pointer++; //this points to null currently
            }
            //equivalent to pop
            else if (command == 2) {
                if (stack[0] == -1) sb.append(-1);
                else {
                    sb.append(stack[top_pointer - 1]);
                    stack[top_pointer - 1] = -1;
                    top_pointer--;
                }
                sb.append(System.getProperty("line.separator"));
            }
            //equivalent to getting the stack size
            else if (command == 3)

            {
                sb.append(top_pointer);
                sb.append(System.getProperty("line.separator"));
            }

            //check if stack is empty
            else if (command == 4)
            {
                if (stack[0] == -1) sb.append(1);
                else sb.append(0);
                sb.append(System.getProperty("line.separator"));
            }

            //showing what top ptr is showing
            else if (command == 5)
            {
                if (stack[0] == -1) sb.append(-1);
                else {
                    sb.append(stack[top_pointer - 1]);
                }
                sb.append(System.getProperty("line.separator"));
            }

        }
        System.out.println(sb.toString().trim());
    }
}