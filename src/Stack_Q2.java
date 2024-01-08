import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//https://www.acmicpc.net/problem/4949
public class Stack_Q2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack;
        StringBuilder sb = new StringBuilder();
        boolean flag;

        while (true) {
            stack = new Stack<>();
            flag = true;
            if (str.equals(".")) break;

            for (int i = 0; i < str.length(); i++) {

                if (str.charAt(i) == '(' || str.charAt(i) == '[') {
                    stack.push(str.charAt(i));
                }

                else if (str.charAt(i) ==')') {

                    if (stack.isEmpty() || stack.peek() != '(') {
                        flag = false;
                        break;
                    }
                    else stack.pop();
                }

                else if (str.charAt(i) == ']') {

                    if (stack.isEmpty() || stack.peek() != '[') {
                        flag = false;
                        break;
                    }
                    else stack.pop();
                }
            }

            if (stack.isEmpty() && flag) sb.append("yes" + System.getProperty("line.separator"));
            else sb.append("no" + System.getProperty("line.separator"));
            str = br.readLine();
        }
        System.out.println(sb.toString().trim());
    }
}