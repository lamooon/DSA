import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class TowerOfHanoi {

    static Stack<Integer> tower1 = new Stack<>();
    static Stack<Integer> tower2 = new Stack<>();
    static Stack<Integer> tower3 = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());



        for (int i = n; i >= 1; i--) {
            tower1.push(i);
        }

        hanoi(tower1.peek(), 3);
    }

    private static void hanoi(int disc, int towerNum) {

        sb.append(disc + " " + towerNum + '\n');


    }


}
