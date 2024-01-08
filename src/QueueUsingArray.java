import java.io.*;
import java.util.StringTokenizer;

public class QueueUsingArray {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String command;
        int[] queue = new int[n];
        int number;
        int frontPtr = 0;
        int backPtr = 0;
        int currentSize = 0;
        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine(), " ");
            command = st.nextToken();

            switch (command) {
                case "push":
                    number = Integer.parseInt(st.nextToken());
                    queue[backPtr] = number;
                    backPtr++;
                    currentSize++;
                    if (backPtr == n) backPtr = 0;
                    break;

                case "front":
                    if (queue[frontPtr] == 0) {
                        bw.write(String.valueOf(-1));
                    }
                    else bw.write(String.valueOf(queue[frontPtr]));
                    bw.write('\n');
                    break;

                case "back":
                    int tempBackPtr = backPtr;
                    if (currentSize == 0)
                    {
                        bw.write(String.valueOf(-1));
                    }
                    else
                    {
                        if (backPtr == 0) tempBackPtr = n;
                        if (queue[tempBackPtr - 1] == 0) bw.write(String.valueOf(-1));
                        else bw.write(String.valueOf(queue[tempBackPtr - 1]));
                    }


                    bw.write('\n');
                    break;

                case "empty":

                    if (frontPtr == backPtr) {
                        bw.write(String.valueOf(1));
                    }
                    else {
                        bw.write(String.valueOf(0));
                    }
                    bw.write('\n');
                    break;

                case "size":
                    bw.write(String.valueOf(currentSize) + '\n');
                    break;

                case "pop":
                    //check empty

                    if (frontPtr == backPtr) {
                        bw.write(String.valueOf(-1));
                    }
                    else {
                        bw.write(String.valueOf(queue[frontPtr]));
                        queue[frontPtr] = 0;
                        frontPtr++;
                        if (frontPtr == n) {
                            frontPtr = 0;
                        }
                        currentSize--;
                    }
                    bw.write('\n');
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
