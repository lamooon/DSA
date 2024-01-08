import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//https://www.acmicpc.net/problem/9012
public class Stack_Q1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String str;

        for (int i = 0; i < n; i++)
        {
            str = br.readLine();
            sb.append(solve(str).toString());
            sb.append(System.getProperty("line.separator"));
        }

        System.out.println(sb.toString().trim());
    }

    //solution referred from https://st-lab.tistory.com/178
    public static String solve(String str) {

        Stack<Character> stack = new Stack<>();

        final int N = str.length();
        for (int i = 0; i < N; i++)
        {

            if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            }

            else if (stack.isEmpty()) {
                //case where ) but there's nothing to pop so the answer's wrong
                return "NO";
            }

            else {
                stack.pop();
            }
        }

        // if stack is not empty, it has more ( than ) and it's not fully enclosed, so it's not VPS
        if (stack.isEmpty()) {
            return "YES";
        }
        else
        {
            return "NO";
        }
    }
}

